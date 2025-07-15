package dio.e_commerce.service.impl;

import dio.e_commerce.domain.model.ShoppingCart;
import dio.e_commerce.domain.repository.ProductRepository;
import dio.e_commerce.domain.repository.ShoppingCartRepository;
import dio.e_commerce.domain.repository.UserRepository;
import dio.e_commerce.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ProductRepository productRepository, UserRepository userRepository, ShoppingCartRepository shoppingCartRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCart findById(Long id) {
        return shoppingCartRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public ShoppingCart create(ShoppingCart addition) {
        return shoppingCartRepository.save(addition);
    }

}
