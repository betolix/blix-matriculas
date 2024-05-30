package io.h3llo.matriculas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {  // FALTA TERMINAR DE IMPLEMENTAR

    private Integer id_course;
    private String name;
    private String abbr;
    private boolean status;

}
