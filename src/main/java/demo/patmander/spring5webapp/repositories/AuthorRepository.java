package demo.patmander.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import demo.patmander.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

  
}
