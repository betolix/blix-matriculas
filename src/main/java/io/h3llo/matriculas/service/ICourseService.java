package io.h3llo.matriculas.service;

import io.h3llo.matriculas.dto.QueryDTO;
import io.h3llo.matriculas.model.Course;

import java.util.List;

public interface ICourseService extends ICRUD<Course, Integer> {

    
    List<QueryDTO> callQuery();


}
