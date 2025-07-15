package dio.e_commerce.controller;

import dio.e_commerce.domain.model.Category;
import dio.e_commerce.domain.model.CategoryDTO;
import dio.e_commerce.domain.model.Product;
import dio.e_commerce.domain.model.ProductDTO;
import dio.e_commerce.service.CategoryService;
import dio.e_commerce.service.ProductService;
import dio.e_commerce.service.impl.CategoryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<ProductDTO>> findByCategory(@PathVariable  Long id){
        var products = ((CategoryServiceImpl) categoryService).listProducts(id);
        return ResponseEntity.ok(products);
    }
}
