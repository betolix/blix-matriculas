package io.h3llo.matriculas.service.impl;

import io.h3llo.matriculas.model.Registration;
import io.h3llo.matriculas.repo.IGenericaRepo;
import io.h3llo.matriculas.repo.IRegistrationRepo;
import io.h3llo.matriculas.service.IRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // ESTE ESTEREOTIPO O ANOTACIÓN GENERA UNA INSTANCIA O BEAN DE LA CLASE EN EL IOC CONTAINER E INDICA QUE ESTA CLASE TIENE LÓGICA DE NEGOCIO
@RequiredArgsConstructor
public class RegistrationServiceImpl extends CRUDImpl<Registration, Integer> implements IRegistrationService {

    private final IRegistrationRepo repo; // = new RegistrationRepo();

    @Override
    protected IGenericaRepo<Registration, Integer> getRepo() {
        return repo;
    }

    
}
