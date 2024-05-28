package io.h3llo.matriculas.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {

        private Integer id_registration;

        @NotNull
        private LocalDateTime enroll_date;

        @NotNull
        private StudentDTO studentDTO;

        @NotNull
        private List<RegistrationDetailDTO> details; // ARRAY?

        @NotNull
        private boolean status;


}
