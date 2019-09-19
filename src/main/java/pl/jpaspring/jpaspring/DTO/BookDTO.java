package pl.jpaspring.jpaspring.DTO;

import java.time.Year;
import java.util.Date;

public class BookDTO {
    private String title;
    private Date year;

    public BookDTO() {
    }
    public BookDTO(String title, Date year) {
        this.title = title;
        this.year = year;
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

    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
