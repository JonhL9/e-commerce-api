package dio.e_commerce.service;

import dio.e_commerce.domain.model.Product;
import dio.e_commerce.domain.model.ProductDTO;
import dio.e_commerce.domain.model.User;

public interface ProductService {
    ProductDTO findById(Long id);
    ProductDTO create(Product productToRegister);
}
