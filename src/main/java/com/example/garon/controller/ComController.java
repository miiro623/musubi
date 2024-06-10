package com.example.garon.controller;


import com.example.garon.domain.Booth;
import com.example.garon.domain.Form;
import com.example.garon.dto.AddFormRequest;
import com.example.garon.dto.FormResponse;
import com.example.garon.service.ComService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class ComController {

    private final ComService comService;

    @PostMapping("/form")
    public ResponseEntity<?> addForm(@RequestBody AddFormRequest request) {
        try {
            Form savedForm = comService.save(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedForm);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }



    @GetMapping("/form/{studentId}")
    public ResponseEntity<FormResponse> findForm(@PathVariable long studentId) {
        Form form = comService.findByStudentId(studentId);

        return ResponseEntity.ok()
                .body(new FormResponse(form));
    }

}