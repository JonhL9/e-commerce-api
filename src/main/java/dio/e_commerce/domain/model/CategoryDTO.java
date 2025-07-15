package dio.e_commerce.domain.model;

import jakarta.persistence.Column;

public class CategoryDTO {
    private String name;
    private String description;

    public CategoryDTO(Category category){
        this.name = category.getName();
        this.description = category.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
