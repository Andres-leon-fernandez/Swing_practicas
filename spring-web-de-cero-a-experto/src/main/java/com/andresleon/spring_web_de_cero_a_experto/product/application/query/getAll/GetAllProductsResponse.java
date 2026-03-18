package com.andresleon.spring_web_de_cero_a_experto.product.application.query.getAll;

import com.andresleon.spring_web_de_cero_a_experto.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetAllProductsResponse {
    private List<Product> products;
}
