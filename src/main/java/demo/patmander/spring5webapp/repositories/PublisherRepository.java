package demo.patmander.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import demo.patmander.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

  
}
