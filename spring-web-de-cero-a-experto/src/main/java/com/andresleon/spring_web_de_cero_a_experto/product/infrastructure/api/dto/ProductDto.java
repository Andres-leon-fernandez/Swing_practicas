package com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    @NotBlank
    private String name;
    private String description;
    private Double price;
    private String image;
}
