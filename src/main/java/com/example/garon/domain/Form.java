package com.example.garon.domain;


import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "startDate", nullable = false)
    private Date startDate;
    @Column(name = "startTime", nullable = false)
    private String startTime;
    @Column(name = "studentId", nullable = false, unique = true)
    private Long studentId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "sex", nullable = false)
    private String sex;
    @Column(name = "phone", nullable = false)
    private String phone;

    @Builder
    public Form(Date startDate, String startTime, Long studentId, String name, String sex, String phone){
        this.startDate = startDate;
        this.startTime = startTime;
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }
}