package com.pesexpo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @GetMapping
    public Student getStudent() {
        return new Student("001", "Matra", "Male", 20);
    }
}
