package com.example.garon.dto;

import com.example.garon.domain.Form;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;


//@Getter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddFormRequest {
    private Date startDate;
    private String startTime;
    private Long studentId;
    private String name;
    private String sex;
    private String phone;

    public Form toEntity(){
        return Form.builder()
                .startDate(startDate)
                .startTime(startTime)
                .studentId(studentId)
                .name(name)
                .sex(sex)
                .phone(phone)
                .build();

    }

}