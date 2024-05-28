package io.h3llo.matriculas.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {  // FALTA TERMINAR DE IMPLEMENTAR

    private Integer id_course;
    private String name;
    private String abbr;
    private boolean status;

}
