package io.h3llo.matriculas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record StudentRecord (

     Integer id_student,
     String name,
     String lastname,
     String dni,
     int age
){

}
