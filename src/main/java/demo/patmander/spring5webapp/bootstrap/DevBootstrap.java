package demo.patmander.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import demo.patmander.spring5webapp.model.Author;
import demo.patmander.spring5webapp.model.Book;
import demo.patmander.spring5webapp.model.Publisher;
import demo.patmander.spring5webapp.repositories.AuthorRepository;
import demo.patmander.spring5webapp.repositories.BookRepository;
import demo.patmander.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;

  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    initData();
  }

  private void initData() {

    Author cherry = new Author("Cherry", "Sanchez");
    Book ddd = new Book("Domain Driven Design", "1234", new Publisher("Harper Collins", "12345"));
    cherry.getBooks().add(ddd);
    ddd.getAuthors().add(cherry);
    authorRepository.save(cherry);
    publisherRepository.save(ddd.getPublisher());
    bookRepository.save(ddd);

    Author patrick = new Author("Patrick", "Santos");
    Book noEJB = new Book("J2EE Development Without EJB", "23444",new Publisher("Worx", "123556"));
    patrick.getBooks().add(noEJB);
    noEJB.getAuthors().add(patrick);
    authorRepository.save(patrick);
    publisherRepository.save(noEJB.getPublisher());
    bookRepository.save(noEJB);

  }


}
