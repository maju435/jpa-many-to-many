package pl.jpaspring.jpaspring.queries;

import org.springframework.data.repository.CrudRepository;
import pl.jpaspring.jpaspring.entity.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
