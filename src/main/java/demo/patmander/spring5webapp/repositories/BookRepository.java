package demo.patmander.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import demo.patmander.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

  
}
