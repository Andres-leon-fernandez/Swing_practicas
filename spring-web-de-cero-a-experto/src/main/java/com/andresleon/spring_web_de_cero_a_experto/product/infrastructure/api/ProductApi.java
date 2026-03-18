package com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api;

import com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductApi {

    public ResponseEntity<List<ProductDto>> getAllProduct(@RequestParam(required = false) String pageSize);

    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id);

    public ResponseEntity<Void> saveProduct(@RequestBody ProductDto productDto);

    public ResponseEntity<Void> updateProductById(@RequestBody ProductDto productDto);

    public ResponseEntity<Void> deleteProductById(@PathVariable Long id);
}
