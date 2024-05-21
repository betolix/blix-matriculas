package io.h3llo.matriculas.service.impl;

import io.h3llo.matriculas.exception.ModelNotFoundException;
import io.h3llo.matriculas.model.Student;
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
        // JAVA REFLECTIONS
        Class<?> clazz = t.getClass();
        String className = clazz.getSimpleName();
        String className_lowerCase = className.toLowerCase();
        String methodName = "setId_" + className_lowerCase;
        //setId_student

        Method setIdMethod = clazz.getMethod(methodName, id.getClass());
        setIdMethod.invoke(t, id);

        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id ));

        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id ));  // TODO TRABAJAR EXCEPCIONES
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id ));
        getRepo().deleteById(id);

    }
}