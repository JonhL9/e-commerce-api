package dio.e_commerce.service.impl;

import dio.e_commerce.domain.model.Category;
import dio.e_commerce.domain.model.CategoryDTO;
import dio.e_commerce.domain.model.Product;
import dio.e_commerce.domain.model.ProductDTO;
import dio.e_commerce.domain.repository.CategoryRepository;
import dio.e_commerce.domain.repository.ProductRepository;
import dio.e_commerce.service.CustomService;
import dio.e_commerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO findById(Long id) {
        var product = productRepository.findByIdWithCategories(id).orElseThrow(NoSuchElementException::new);
        return new ProductDTO(product);
    }

    @Override
    public ProductDTO create(Product addition) {
        if(productRepository.existsByName(addition.getName())){
            throw new IllegalArgumentException("This Product name already exists.");
        }
        else{
            Set<Category> categoriesFromRequest = addition.getCategories();
            Set<Category> attachedCategories = new HashSet<>();

            for (Category c : categoriesFromRequest) {
                Category category;
                Optional<Category> existing = categoryRepository.findByName(c.getName());
                if (existing.isPresent()) {
                    category = existing.get();
                } else {
                    category = categoryRepository.save(c);
                }
                attachedCategories.add(category);
            }
            addition.setCategories(attachedCategories);

            return new ProductDTO(productRepository.save(addition));
        }
    }

}
