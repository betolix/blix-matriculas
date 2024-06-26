package io.h3llo.matriculas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {

    // TEST
    // TEST A
    // TEST B
    private int status;
    private String message;
    private List<T> data;
}
