package br.com.lf.sprint.repository;

import br.com.lf.sprint.model.OpenLight;
import org.springframework.data.repository.CrudRepository;

public interface OpenLightRepository extends CrudRepository<OpenLight, Long> {
    OpenLight findById(long i);
}
