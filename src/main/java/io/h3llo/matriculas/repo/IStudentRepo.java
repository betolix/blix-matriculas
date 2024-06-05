package io.h3llo.matriculas.repo;

import io.h3llo.matriculas.dto.QueryDTO;
import io.h3llo.matriculas.model.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentRepo extends IGenericaRepo<Student, Integer> {


    List<Student> findByOrderByAgeAsc();


}


