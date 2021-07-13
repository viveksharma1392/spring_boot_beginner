package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(1L,
                        "Vivek Sharma",
                        "Test@test.com",
                        LocalDate.of(1996, Month.JANUARY,13),
                        21
                )
        );
    }
}
