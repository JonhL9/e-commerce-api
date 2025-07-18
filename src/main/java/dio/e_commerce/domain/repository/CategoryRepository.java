package dio.e_commerce.domain.repository;

import dio.e_commerce.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
    boolean existsById(Long id);
    Optional<Category> findByName(String name);
}
