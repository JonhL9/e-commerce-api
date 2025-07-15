package dio.e_commerce.service;

import dio.e_commerce.domain.model.Category;
import dio.e_commerce.domain.model.CategoryDTO;
import dio.e_commerce.domain.model.Product;
import dio.e_commerce.domain.model.User;

import java.util.List;

public interface CategoryService extends CustomService<Category, Long>{
    List<CategoryDTO> findAll();

}
