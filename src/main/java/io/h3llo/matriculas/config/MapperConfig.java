package io.h3llo.matriculas.config;

import io.h3llo.matriculas.dto.StudentDTO;
import io.h3llo.matriculas.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("studentMapper")
    public ModelMapper studentMapper() {
        ModelMapper mapper = new ModelMapper();

        // HANDLE MISMATECHES

        // LECTURA
        mapper.createTypeMap(Student.class, StudentDTO.class)
                .addMapping(Student::getName, (dest, v) -> dest.setNameOfStudent((String) v));

        // ESCRITURA
        mapper.createTypeMap(StudentDTO.class, Student.class)
                .addMapping(StudentDTO::getNameOfStudent, (dest, v) -> dest.setName((String) v));


        return mapper;
    }

    @Bean("courseMapper")
    public ModelMapper courseMapper() {
        return new ModelMapper();
    }

    @Bean("registrationDetailMapper")
    public ModelMapper registrationDetailMapper() {
        return new ModelMapper();
    }

    @Bean("defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

}
