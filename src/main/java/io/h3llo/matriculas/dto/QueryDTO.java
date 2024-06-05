package io.h3llo.matriculas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryDTO {

    private Integer id_course;
    private String course_name;
    private Integer id_student;
    private String student_name;
    private String student_lastname;

}
