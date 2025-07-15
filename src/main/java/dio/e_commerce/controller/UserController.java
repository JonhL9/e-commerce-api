package dio.e_commerce.controller;

import dio.e_commerce.domain.model.CardItem;
import dio.e_commerce.domain.model.CardItemRequestDTO;
import dio.e_commerce.domain.model.ShoppingCart;
import dio.e_commerce.domain.model.User;
import dio.e_commerce.service.UserService;
import dio.e_commerce.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate){
        var userCreated = userService.create(userToCreate);
        return ResponseEntity.ok(userCreated);
    }
    @PostMapping("/{id}/shoppingcart/{product_id}")
    public ResponseEntity<ShoppingCart> shoppingCartAddItem(@PathVariable Long id, @RequestBody CardItemRequestDTO cardItem, @PathVariable Long product_id){
        ShoppingCart shoppingCart = ((UserServiceImpl) userService).putItemOnCart(id, cardItem);
        return ResponseEntity.ok(shoppingCart);
    }
    @GetMapping("/{id}/shoppingcart")
    public ResponseEntity<ShoppingCart> shoppingCartView(@PathVariable Long id){
        ShoppingCart shoppingCart = userService.getShoppingCart(id);
        return ResponseEntity.ok(shoppingCart);
    }
}
