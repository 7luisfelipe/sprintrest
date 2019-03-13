package br.com.lf.sprint.repository;

import br.com.lf.sprint.model.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {
    Login findByUsername(String username);
}
