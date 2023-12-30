package pl.javastart.restoffers.category;

public class CategoryDto {
    private Long id;

    private String name;

    private String description;

    private int offersValue;

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

    public int getOffersValue() {
        return offersValue;
    }

    public void setOffersValue(int offersValue) {
        this.offersValue = offersValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}