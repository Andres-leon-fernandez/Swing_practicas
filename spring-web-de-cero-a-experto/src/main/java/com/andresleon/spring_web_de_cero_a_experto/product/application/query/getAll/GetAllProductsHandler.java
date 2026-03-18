package com.andresleon.spring_web_de_cero_a_experto.product.application.query.getAll;

import com.andresleon.spring_web_de_cero_a_experto.common.mediator.RequestHandler;
import com.andresleon.spring_web_de_cero_a_experto.product.domain.Product;
import com.andresleon.spring_web_de_cero_a_experto.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProductsHandler implements RequestHandler<GetAllProductsRequest, GetAllProductsResponse> {

    private final ProductRepository productRepository;

    @Override
    public GetAllProductsResponse handle(GetAllProductsRequest request) {
        List<Product> products = productRepository.findAll();
        return new GetAllProductsResponse(products);
    }

    @Override
    public Class<GetAllProductsRequest> getRequestType() {
        return GetAllProductsRequest.class;
    }
}
