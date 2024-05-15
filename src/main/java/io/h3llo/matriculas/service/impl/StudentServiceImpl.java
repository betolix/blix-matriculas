package io.h3llo.matriculas.service.impl;

import io.h3llo.matriculas.model.Student;
import io.h3llo.matriculas.repo.IStudentRepo;
import io.h3llo.matriculas.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // ESTE ESTEREOTIPO O ANOTACIÓN GENERA UNA INSTANCIA O BEAN DE LA CLASE EN EL IOC CONTAINER E INDICA QUE ESTA CLASE TIENE LÓGICA DE NEGOCIO
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    //@Autowired // ESTE ESTEREOTIPO O ANOTACIÓN BUSCA UNA INSTANCIA O BEAN DE LA CLASE EN EL IOC CONTAINER E INYECTA LA DEPENDENCIA
    private final IStudentRepo repo; // = new StudentRepo();

    @Override
    public Student save(Student student) throws Exception {
        return repo.save(student);
    }

    @Override
    public Student update(Student student, Integer id) throws Exception {
        student.setId_student(id);
        return repo.save(student); // SE DIFERENCIA DEL CREATE PORQUE ESTE OBJETO TIENE UN PK Y EL CREATE NO
    }

    @Override
    public List<Student> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Student readById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Student());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);

    }




    /*
    public StudentServiceImpl(IStudentRepo repo) {
        this.repo = repo;
    }*/

    /*
    @Override
    public Student saveAndValid (Student student){
        if(student.getStudent_id() == 0){

            return repo.save(student);
        }else{
            return new Student();
        }
    }*/
}
