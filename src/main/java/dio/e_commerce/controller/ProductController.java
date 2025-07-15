package dio.e_commerce.controller;

import dio.e_commerce.domain.model.Product;
import dio.e_commerce.domain.model.ProductDTO;
import dio.e_commerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        var product = productService.findById(id);
        return ResponseEntity.ok(product);
    }
    @PostMapping
    public ResponseEntity<ProductDTO> register(@RequestBody Product product){
        var newProduct = productService.create(product);
        return ResponseEntity.ok(newProduct);
    }
}
