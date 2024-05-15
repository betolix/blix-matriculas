package io.h3llo.matriculas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericaRepo<T, ID>  extends JpaRepository<T, ID> {
}
