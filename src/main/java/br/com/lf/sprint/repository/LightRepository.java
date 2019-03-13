package br.com.lf.sprint.repository;

import br.com.lf.sprint.model.Light;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightRepository extends CrudRepository<Light, Long> {
}
