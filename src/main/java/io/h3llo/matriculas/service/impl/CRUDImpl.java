package io.h3llo.matriculas.service.impl;

import io.h3llo.matriculas.repo.IGenericaRepo;
import io.h3llo.matriculas.service.ICRUD;

import java.lang.reflect.Method;
import java.util.List;


public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {


    protected abstract IGenericaRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElse(null );  // TODO TRABAJAR EXCEPCIONES
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().deleteById(id);

    }
}