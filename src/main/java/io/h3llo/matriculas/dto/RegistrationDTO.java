package io.h3llo.matriculas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationDTO {

        private Integer id_registration;

        @NotNull
        private LocalDateTime enroll_date;

        @NotNull
        private StudentDTO student;

        @NotNull
        @JsonManagedReference // ESTA ANOTACION ES PARA MAESTRO DETALLE NE EL JSON
        private List<RegistrationDetailDTO> details; // ARRAY?

        @NotNull
        private boolean status;


}
