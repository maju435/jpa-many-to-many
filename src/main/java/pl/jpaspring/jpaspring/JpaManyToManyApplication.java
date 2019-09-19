package pl.jpaspring.jpaspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import pl.jpaspring.jpaspring.entity.AutorEntity;
import pl.jpaspring.jpaspring.entity.BookEntity;
import pl.jpaspring.jpaspring.queries.AutorRepository;

import java.time.Year;
import java.util.Date;

@SpringBootApplication
public class JpaManyToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaManyToManyApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AutorRepository repository) {
        return (args) -> {
            // save a couple of autors
            repository.save(new AutorEntity("Jack", "Bauer"));
            repository.save(new AutorEntity("Chloe", "O'Brian"));
            repository.save(new AutorEntity("Kim", "Bauer"));


            AutorEntity maciek = new AutorEntity("Maciek","Kopytko");
            maciek.getBooks().add(new BookEntity("Programowanie w PHP dla szalencow", new Date()));
            repository.save(maciek);
            

            // fetch all autors
            System.out.println("autors found with findAll():");
            System.out.println("-------------------------------");
            for (AutorEntity autor : repository.findAll()) {
                System.out.println(autor.toString());
            }
            System.out.println("");

            // fetch an individual autor by ID
            repository.findById(1L)
                    .ifPresent(autor -> {
                        System.out.println("autor found with findById(1L):");
                        System.out.println("--------------------------------");
                        System.out.println(autor.toString());
                        System.out.println("");
                    });

            // fetch autors by last name
            System.out.println("autor found with findByLastName('Bauer'):");
            System.out.println("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                System.out.println(bauer.toString());
            });

            System.out.println("");
        };
    }

}
