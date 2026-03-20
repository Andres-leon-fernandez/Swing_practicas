package com.andresleon.spring_web_de_cero_a_experto.product.application.query.getById;

import com.andresleon.spring_web_de_cero_a_experto.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProductByIdResponse {
    private Product product;
}
