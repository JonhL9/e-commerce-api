package dio.e_commerce.service.impl;

import dio.e_commerce.domain.model.*;
import dio.e_commerce.domain.repository.ProductRepository;
import dio.e_commerce.domain.repository.ShoppingCartRepository;
import dio.e_commerce.domain.repository.UserRepository;
import dio.e_commerce.service.CustomService;
import dio.e_commerce.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    //CustomService<User, Long>
    private final UserRepository userRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;
    public UserServiceImpl(UserRepository userRepository, ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        userToCreate.setShoppingCart(new ShoppingCart());
        return userRepository.save(userToCreate);
    }

    @Override
    public ShoppingCart getShoppingCart(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        ShoppingCart shoppingCart = user.getShoppingCart();
        return shoppingCart;
    }

    public ShoppingCart putItemOnCart(Long userId, CardItemRequestDTO cardItemDTO) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        Product product = productRepository.findById(cardItemDTO.getProductId()).orElseThrow(NoSuchElementException::new);
        CardItem newCardItem = new CardItem();
        newCardItem.setQuantity(cardItemDTO.getQuantity());
        newCardItem.setProduct_id(cardItemDTO.getProductId());
        ShoppingCart shoppingCart = user.getShoppingCart();
        newCardItem.setCart(shoppingCart);
        shoppingCart.addCartItem(newCardItem);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }
}
