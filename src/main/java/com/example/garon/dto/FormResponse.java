package com.example.garon.dto;

import com.example.garon.domain.Form;
import lombok.Getter;

import java.sql.Date;

@Getter
public class FormResponse {

    private final Date startDate;
    private final String startTime;
    private final String name;

    public FormResponse(Form form){
        this.startDate = form.getStartDate();
        this.startTime = form.getStartTime();
        this.name = form.getName();
    }
}
