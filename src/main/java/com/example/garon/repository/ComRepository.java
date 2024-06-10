package com.example.garon.repository;

import com.example.garon.domain.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

    public interface ComRepository extends JpaRepository<Form, Long> {
    List<Form> findByStartDateAndStartTime(Date startDate, String startTime);

    Form findByStudentId(Long studentId);
}