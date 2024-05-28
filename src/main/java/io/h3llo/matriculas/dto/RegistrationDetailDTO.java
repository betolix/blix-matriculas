package io.h3llo.matriculas.dto;

import io.h3llo.matriculas.model.Course;
import io.h3llo.matriculas.model.Registration;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDetailDTO {


    private Integer id_reg_detail;

    @NotNull
    @Min(1)
    private Integer idCourse;

    @NotNull
    private String room;

    @NotNull
    private Registration registration;
}
