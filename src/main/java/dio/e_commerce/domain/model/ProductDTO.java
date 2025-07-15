package dio.e_commerce.domain.model;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductDTO {
    //private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private Set<CategoryDTO> categories;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
        if (product.getCategories() != null){
            this.categories = product.getCategories().stream()
                    .map(CategoryDTO::new).
                    collect(Collectors.toSet());
        }
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }
}
