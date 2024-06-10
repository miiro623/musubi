package com.example.garon.dto;

import com.example.garon.domain.Booth;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddBoothRequest {
    private String department;
    private String content;

    public Booth toEntity(){
        return Booth.builder()
                .department(department)
                .content(content)
                .build();
    }
}
