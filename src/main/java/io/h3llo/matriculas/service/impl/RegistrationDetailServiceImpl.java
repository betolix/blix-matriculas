package io.h3llo.matriculas.service.impl;

import io.h3llo.matriculas.model.RegistrationDetail;
import io.h3llo.matriculas.repo.IGenericaRepo;
import io.h3llo.matriculas.repo.IRegistrationDetailRepo;
import io.h3llo.matriculas.service.IRegistrationDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // ESTE ESTEREOTIPO O ANOTACIÓN GENERA UNA INSTANCIA O BEAN DE LA CLASE EN EL IOC CONTAINER E INDICA QUE ESTA CLASE TIENE LÓGICA DE NEGOCIO
@RequiredArgsConstructor
public class RegistrationDetailServiceImpl extends CRUDImpl<RegistrationDetail, Integer> implements IRegistrationDetailService {

    private final IRegistrationDetailRepo repo; // = new RegistrationDetailRepo();

    @Override
    protected IGenericaRepo<RegistrationDetail, Integer> getRepo() {
        return repo;
    }



    /*
    @Override
    public RegistrationDetail save(RegistrationDetail student) throws Exception {
        return repo.save(student);
    }

    @Override
    public RegistrationDetail update(RegistrationDetail student, Integer id) throws Exception {
        student.setId_student(id);
        return repo.save(student); // SE DIFERENCIA DEL CREATE PORQUE ESTE OBJETO TIENE UN PK Y EL CREATE NO
    }

    @Override
    public List<RegistrationDetail> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public RegistrationDetail readById(Integer id) throws Exception {
        return repo.findById(id).orElse(new RegistrationDetail());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);

    }
    */

    /*
    public RegistrationDetailServiceImpl(IRegistrationDetailRepo repo) {
        this.repo = repo;
    }*/

    /*
    @Override
    public RegistrationDetail saveAndValid (RegistrationDetail student){
        if(student.getRegistrationDetail_id() == 0){

            return repo.save(student);
        }else{
            return new RegistrationDetail();
        }
    }*/
}
