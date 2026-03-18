package com.andresleon.spring_web_de_cero_a_experto.product.application.command.create;

import com.andresleon.spring_web_de_cero_a_experto.common.mediator.Request;
import lombok.Data;

@Data
public class CreateProductRequest implements Request<Void> {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
}
