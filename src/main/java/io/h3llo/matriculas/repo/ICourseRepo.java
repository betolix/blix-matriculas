package io.h3llo.matriculas.repo;

import io.h3llo.matriculas.dto.QueryDTO;
import io.h3llo.matriculas.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICourseRepo extends IGenericaRepo<Course, Integer> {



    @Query(value = "SELECT c.id_course, c.name AS course_name, s.id_student, s.name AS student_name,s.lastname AS student_lastname FROM course c JOIN registration_detail rd ON c.id_course = rd.id_course JOIN registration r ON rd.id_registration = r.id_registration JOIN student s ON r.id_student = s.id_student ORDER BY c.id_course, s.id_student;", nativeQuery = true)
    List<Object[]> callQuery();

}
