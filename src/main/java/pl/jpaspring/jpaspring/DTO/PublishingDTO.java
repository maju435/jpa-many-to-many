package pl.jpaspring.jpaspring.DTO;

public class PublishingDTO {

    private String name;

    public PublishingDTO() {
    }
    public PublishingDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PublishingDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
