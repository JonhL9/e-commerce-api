package dio.e_commerce.service;

import dio.e_commerce.domain.model.ShoppingCart;
import dio.e_commerce.domain.model.User;

public interface UserService extends CustomService<User, Long>{
    /*
    User findById(Long id);
    User create(User userToCreate);
     */
    ShoppingCart getShoppingCart(Long userId);
}
