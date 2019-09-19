package pl.jpaspring.jpaspring.queries;

import org.springframework.data.repository.CrudRepository;
import pl.jpaspring.jpaspring.entity.AutorEntity;

import java.util.List;

public interface AutorRepository extends CrudRepository<AutorEntity, Long> {

    List<AutorEntity> findByLastName(String lastName);

}
