package io.h3llo.matriculas.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer id_student;

    @Size(min = 2, max = 50)
    private String nameOfStudent;

    @Size(min = 2, max = 50)
    private String lastname;

    @Size(min = 8, max = 8)
    private String dni;

    @NotNull
    private int age;

}
