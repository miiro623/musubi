package com.example.garon.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Booth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "department", nullable = false)
    private String department;
    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public Booth(String department, String content){
        this.department = department;
        this.content = content;
    }
}