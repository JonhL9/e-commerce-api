package dio.e_commerce.service;

import dio.e_commerce.domain.model.User;

public interface CustomService<T, ID> {
    T findById(ID id);
    T create(T addition);
}
