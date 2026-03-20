package com.andresleon.spring_web_de_cero_a_experto.product.application.command.create;

import com.andresleon.spring_web_de_cero_a_experto.common.mediator.RequestHandler;
import com.andresleon.spring_web_de_cero_a_experto.common.util.FileUtils;
import com.andresleon.spring_web_de_cero_a_experto.product.domain.entity.Product;
import com.andresleon.spring_web_de_cero_a_experto.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductHandler implements RequestHandler<CreateProductRequest, Void> {

    private final ProductRepository productRepository;
    private final FileUtils fileUtils;

    String uniqueFileName;

    @Override
    public Void handle(CreateProductRequest request) {

        String uniqueFileName = fileUtils.saveProductImage(request.getFile());

        Product product = Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(uniqueFileName)
                .build();
        productRepository.upset(product);
        return null;
    }

    @Override
    public Class<CreateProductRequest> getRequestType() {
        return CreateProductRequest.class;
    }
}
