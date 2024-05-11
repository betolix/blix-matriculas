package io.h3llo.matriculas.controller;

import io.h3llo.matriculas.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

     @GetMapping
        public Student getStudents() {
            return new Student(1, "Alberto", "Lazo", "12345678", 25);
        }

}
