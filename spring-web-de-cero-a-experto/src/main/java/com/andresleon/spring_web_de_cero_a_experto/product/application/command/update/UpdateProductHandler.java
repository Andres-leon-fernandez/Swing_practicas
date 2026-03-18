package com.andresleon.spring_web_de_cero_a_experto.product.application.command.update;

import com.andresleon.spring_web_de_cero_a_experto.common.mediator.RequestHandler;
import com.andresleon.spring_web_de_cero_a_experto.product.domain.Product;
import com.andresleon.spring_web_de_cero_a_experto.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductHandler implements RequestHandler<UpdateProductRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(UpdateProductRequest request) {
        Product product = Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(request.getImage())
                .build();

        
        productRepository.upset(product);
        return null;
    }

    @Override
    public Class<UpdateProductRequest> getRequestType() {
        return UpdateProductRequest.class;
    }
}
