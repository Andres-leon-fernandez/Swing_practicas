package com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api;

import com.andresleon.spring_web_de_cero_a_experto.common.mediator.Mediator;
import com.andresleon.spring_web_de_cero_a_experto.product.application.query.getAll.GetAllProductsRequest;
import com.andresleon.spring_web_de_cero_a_experto.product.application.query.getAll.GetAllProductsResponse;
import com.andresleon.spring_web_de_cero_a_experto.product.domain.entity.Product;
import com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api.dto.ProductDto;
import com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private Mediator mediator;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductController productController;

    @Test
    public void getAllProducts() {

        GetAllProductsResponse getAllProductsResponse = new GetAllProductsResponse(List.of(
                Product.builder().id(1L).build(),
                Product.builder().id(2L).build()
        ));

        when(mediator.dispatch(new GetAllProductsRequest())).thenReturn(getAllProductsResponse);

        ProductDto productDto = new ProductDto();
        productDto.setId(1L);

        when(productMapper.mapToProductDto(any(Product.class))).thenReturn(productDto);

        ResponseEntity<List<ProductDto>> response = productController.getAllProduct("5");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        List<ProductDto> products = response.getBody();
        assertEquals(2, products.size());
    }
}