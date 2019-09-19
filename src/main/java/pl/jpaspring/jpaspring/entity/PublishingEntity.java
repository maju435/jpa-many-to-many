package pl.jpaspring.jpaspring.entity;

import pl.jpaspring.jpaspring.DTO.PublishingDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishing")
public class PublishingEntity {

    public PublishingEntity() {};

    public PublishingEntity(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<BookEntity> books = new HashSet<>();

    public PublishingDTO toDTO() {
        PublishingDTO dto = new PublishingDTO();
        dto.setName(name);

        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(Set<BookEntity> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "PublishingEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}