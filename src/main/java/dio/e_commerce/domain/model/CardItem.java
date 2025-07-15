package dio.e_commerce.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
public class CardItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1)
    private Integer quantity;

    @CreationTimestamp
    private Timestamp additionDate;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    @JsonBackReference
    private ShoppingCart cart;

    //@ManyToOne(fetch = FetchType.LAZY) // não carrega o Product automaticamente
    //@JoinColumn(name = "product_id", nullable = false)
    private Long product_id; // associação com produto

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Timestamp getAdditionDate() { return additionDate; }

    public void setAdditionDate(Timestamp additionDate) { this.additionDate = additionDate; }

    public ShoppingCart getCart() { return cart; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public void setCart(ShoppingCart cart) { this.cart = cart; }

}
