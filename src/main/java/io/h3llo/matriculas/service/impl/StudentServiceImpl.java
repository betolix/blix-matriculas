package io.h3llo.matriculas.service.impl;

import io.h3llo.matriculas.model.Student;
import io.h3llo.matriculas.repo.IGenericaRepo;
import io.h3llo.matriculas.repo.IStudentRepo;
import io.h3llo.matriculas.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // ESTE ESTEREOTIPO O ANOTACIÓN GENERA UNA INSTANCIA O BEAN DE LA CLASE EN EL IOC CONTAINER E INDICA QUE ESTA CLASE TIENE LÓGICA DE NEGOCIO
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo repo; // = new StudentRepo();

    @Override
    protected IGenericaRepo<Student, Integer> getRepo() {
        return repo;
    }


//    @Override
//    public List<Student> findAllStudents() {
//        return repo.findAllStudents();
//    }
}
