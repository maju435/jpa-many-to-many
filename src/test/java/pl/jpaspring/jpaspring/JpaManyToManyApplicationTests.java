package pl.jpaspring.jpaspring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.jpaspring.jpaspring.entity.AutorEntity;
import pl.jpaspring.jpaspring.entity.BookEntity;
import pl.jpaspring.jpaspring.queries.AutorRepository;
import pl.jpaspring.jpaspring.queries.BookRepository;

import javax.persistence.EntityManager;
import java.awt.print.Book;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JpaManyToManyApplicationTests {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
        AutorEntity maciek = new AutorEntity("Maciek","Kopytko");
        autorRepository.save(maciek);
        maciek.getBooks().add(new BookEntity("Programowanie w PHP dla szalencow", new Date()));
    }

    @Test
	public void getByLastName() {
        assert autorRepository.findByLastName("Bauer").size() == 2;
	}

}
