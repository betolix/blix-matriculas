package io.h3llo.matriculas.repo;

import io.h3llo.matriculas.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student, Integer> {



}
