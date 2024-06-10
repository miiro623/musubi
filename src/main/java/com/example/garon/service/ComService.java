package com.example.garon.service;

import com.example.garon.domain.Form;
import com.example.garon.dto.AddFormRequest;
import com.example.garon.repository.ComRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ComService {

    private final ComRepository comRepository;


    public Form save(AddFormRequest request) {

        return comRepository.save(request.toEntity());
    }

    public boolean canSelectTime(AddFormRequest request) {
        List<Form> formsAtTime = comRepository.findByStartDateAndStartTime(request.getStartDate(), request.getStartTime());
        long maleCount = formsAtTime.stream().filter(form -> "남성".equals(form.getSex())).count();
        long femaleCount = formsAtTime.stream().filter(form -> "여성".equals(form.getSex())).count();

        if ("남성".equals(request.getSex()) && maleCount < 2) {
            return true;
        } else if ("여성".equals(request.getSex()) && femaleCount < 2) {
            return true;
        }
        return false;
    }

    public Form findByStudentId(long studentId) {
        Form form = comRepository.findByStudentId(studentId);
        if (form == null) {
            throw new IllegalArgumentException("학번을 찾을 수 없습니다. : " + studentId);
        }
        return form;
}}
