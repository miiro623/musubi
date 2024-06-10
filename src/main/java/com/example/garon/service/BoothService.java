package com.example.garon.service;

import com.example.garon.domain.Booth;
import com.example.garon.dto.AddBoothRequest;
import com.example.garon.repository.BoothRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoothService {

    private final BoothRepository boothRepository;

    public Booth save(AddBoothRequest request) {
        return boothRepository.save(request.toEntity());
    }

}
