package com.andresleon.spring_web_de_cero_a_experto.product.domain.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("the product with id " + id + "was not found");
    }
}
