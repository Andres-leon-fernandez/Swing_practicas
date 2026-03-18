package com.andresleon.spring_web_de_cero_a_experto.product.application.command.delete;

import com.andresleon.spring_web_de_cero_a_experto.common.mediator.RequestHandler;
import com.andresleon.spring_web_de_cero_a_experto.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductHandler implements RequestHandler<DeleteProductRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(DeleteProductRequest request) {

        productRepository.deleteById(request.getId());
        return null;
    }

    @Override
    public Class<DeleteProductRequest> getRequestType() {
        return DeleteProductRequest.class;
    }
}
