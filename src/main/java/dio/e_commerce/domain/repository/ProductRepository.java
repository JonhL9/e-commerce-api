package dio.e_commerce.domain.repository;

import dio.e_commerce.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.categories WHERE p.id = :id")
    Optional<Product> findByIdWithCategories(@Param("id") Long id);

    @Query("SELECT DISTINCT p FROM Product p JOIN FETCH p.categories c WHERE c.id = :categoryId")
    List<Product> findProductsByCategoryId(@Param("categoryId") Long categoryId);

    boolean existsByName(String name);
}
