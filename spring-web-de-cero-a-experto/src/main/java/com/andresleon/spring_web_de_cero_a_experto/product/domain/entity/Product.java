package com.andresleon.spring_web_de_cero_a_experto.product.domain.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
}
