package com.andresleon.spring_web_de_cero_a_experto.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void upset(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);
}
