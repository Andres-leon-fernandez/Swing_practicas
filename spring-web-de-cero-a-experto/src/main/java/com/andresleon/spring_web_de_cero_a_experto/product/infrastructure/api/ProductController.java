package com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api;

import com.andresleon.spring_web_de_cero_a_experto.common.mediator.Mediator;
import com.andresleon.spring_web_de_cero_a_experto.product.application.command.create.CreateProductRequest;
import com.andresleon.spring_web_de_cero_a_experto.product.application.command.delete.DeleteProductRequest;
import com.andresleon.spring_web_de_cero_a_experto.product.application.command.update.UpdateProductRequest;
import com.andresleon.spring_web_de_cero_a_experto.product.application.query.getAll.GetAllProductsRequest;
import com.andresleon.spring_web_de_cero_a_experto.product.application.query.getAll.GetAllProductsResponse;
import com.andresleon.spring_web_de_cero_a_experto.product.application.query.getById.GetProductByIdRequest;
import com.andresleon.spring_web_de_cero_a_experto.product.application.query.getById.GetProductByIdResponse;
import com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api.dto.CreateProductDto;
import com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api.dto.ProductDto;
import com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api.dto.UpdateProductDto;
import com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api.mapper.ProductMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final Mediator mediator;
    private final ProductMapper productMapper;

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAllProduct(@RequestParam(required = false) String pageSize) {
        GetAllProductsResponse response = mediator.dispatch(new GetAllProductsRequest());
        List<ProductDto> productDtos = response.getProducts().stream().map(productMapper::mapToProduct).toList();
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {

        GetProductByIdResponse responsive = mediator.dispatch(new GetProductByIdRequest(id));

        ProductDto productDto = productMapper.mapToProduct(responsive.getProduct());


        return ResponseEntity.ok(productDto);
    }

    @PostMapping("")
    public ResponseEntity<Void> saveProduct(@ModelAttribute @Valid CreateProductDto productDto) {

        CreateProductRequest request = productMapper.mapToCreateProductRequest(productDto);

        mediator.dispatch(request);

        return ResponseEntity.created(URI.create("/api/v1/products/".concat(productDto.getId().toString()))).build();
    }

    @PutMapping("")
    public ResponseEntity<Void> updateProductById(@RequestBody @Valid UpdateProductDto productDto) {

        UpdateProductRequest request = productMapper.mapTUpdateProductRequest(productDto);
        mediator.dispatch(request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        mediator.dispatchAsync(new DeleteProductRequest(id));
        return ResponseEntity.accepted().build();
    }
}
