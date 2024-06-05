package io.h3llo.matriculas.service;

import io.h3llo.matriculas.dto.QueryDTO;
import io.h3llo.matriculas.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer> {

    List<Student> findByOrderByAgeAsc();

}
