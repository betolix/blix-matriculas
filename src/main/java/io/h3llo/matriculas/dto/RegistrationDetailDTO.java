package io.h3llo.matriculas.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationDetailDTO {


    private Integer id_reg_detail;

    @NotNull
    @Min(1)
    private CourseDTO course;

    @NotNull
    private String room;

    //    @NotNull  //!!!!!
    @JsonBackReference // ESTA ANOTACION ES PARA MAESTRO DETALLE NE EL JSON
    private RegistrationDTO registration;
}
