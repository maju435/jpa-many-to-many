package pl.jpaspring.jpaspring.entity;

import pl.jpaspring.jpaspring.DTO.BookDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class BookEntity {

    public BookEntity() {};

    public BookEntity(String title, Date year) {
        this.title = title;
        this.year = year;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private Date year;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<AutorEntity> autors= new HashSet<>();

    public BookDTO toDTO(String title, Date year) {
        BookDTO dto = new BookDTO();
        dto.setTitle(title);
        dto.setYear(year);

        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Set<AutorEntity> getAutors() {
        return autors;
    }

    public void setAutors(Set<AutorEntity> autors) {
        this.autors = autors;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", autors=" + autors +
                '}';
    }
}
