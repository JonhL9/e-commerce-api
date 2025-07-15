package dio.e_commerce.service.impl;

import dio.e_commerce.domain.model.Category;
import dio.e_commerce.domain.model.CategoryDTO;
import dio.e_commerce.domain.model.Product;
import dio.e_commerce.domain.model.ProductDTO;
import dio.e_commerce.domain.repository.CategoryRepository;
import dio.e_commerce.domain.repository.ProductRepository;
import dio.e_commerce.service.CategoryService;
import dio.e_commerce.service.CustomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Category create(Category addition) {
        return categoryRepository.save(addition);
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryDTO::new).toList();
    }

    public List<ProductDTO> listProducts(Long id) {
        if (categoryRepository.existsById(id)){
            var products = productRepository.findProductsByCategoryId(id);
            return products.stream()
                    .map(ProductDTO::new)
                    .toList();
        }
        else {
            throw new NoSuchElementException();
        }
    }
}
