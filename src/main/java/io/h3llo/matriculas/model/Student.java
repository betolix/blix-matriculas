package io.h3llo.matriculas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer student_id;
    private String student_name;
    private String student_lastname;
    private String student_dni;
    private int student_age;


}
