package io.h3llo.matriculas.service.impl;

import io.h3llo.matriculas.dto.QueryDTO;
import io.h3llo.matriculas.model.Course;
import io.h3llo.matriculas.repo.ICourseRepo;
import io.h3llo.matriculas.repo.IGenericaRepo;
import io.h3llo.matriculas.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // ESTE ESTEREOTIPO O ANOTACIÓN GENERA UNA INSTANCIA O BEAN DE LA CLASE EN EL IOC CONTAINER E INDICA QUE ESTA CLASE TIENE LÓGICA DE NEGOCIO
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {

    //@Autowired // ESTE ESTEREOTIPO O ANOTACIÓN BUSCA UNA INSTANCIA O BEAN DE LA CLASE EN EL IOC CONTAINER E INYECTA LA DEPENDENCIA
    private final ICourseRepo repo; // = new CourseRepo();

    @Override
    protected IGenericaRepo<Course, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<QueryDTO> callQuery() {
        List<QueryDTO> queryDTOList = new ArrayList<>();
        repo.callQuery().forEach( det -> {
            QueryDTO queryDTO = new QueryDTO();
            queryDTO.setId_course((Integer) det[0]);
            queryDTO.setCourse_name((String) det[1]);
            queryDTO.setId_student((Integer) det[2]);
            queryDTO.setStudent_name((String) det[3]);
            queryDTO.setStudent_lastname((String) det[4]);
            queryDTOList.add(queryDTO);
        });

        return queryDTOList;
    }






    /*
    public CourseServiceImpl(ICourseRepo repo) {
        this.repo = repo;
    }*/

    /*
    @Override
    public Course saveAndValid (Course course){
        if(course.getCourse_id() == 0){

            return repo.save(course);
        }else{
            return new Course();
        }
    }*/
}
