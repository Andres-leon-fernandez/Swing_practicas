package com.andresleon.spring_web_de_cero_a_experto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    public List<Product> products;

    public ProductController() {

        this.products = new ArrayList<>();

        products.add(Product.builder()
                .id(1L).name("product 1").description("desciption 1").price(100.0).image("image").build());
        products.add(Product.builder()
                .id(2L).name("product 2").description("desciption 2").price(200.0).image("image").build());
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProduct(@RequestParam(required = false) String pageSize) {
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> productOptional = products.stream().filter(p -> p.getId().equals(id))
                .findFirst();

        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productOptional.get());
    }

    @PostMapping("")
    public ResponseEntity<Void> saveProduct(@RequestBody Product product) {
        products.add(product);

        return ResponseEntity.created(URI.create("/api/v1/products/".concat(product.getId().toString()))).build();
    }

    @PutMapping("")
    public ResponseEntity<Product> updateProductById(@RequestBody Product product) {
        Product productSelected = products.stream()
                .filter(p -> p.getId().equals(product.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productSelected.setName(product.getName());
        productSelected.setDescription(product.getDescription());
        productSelected.setPrice(product.getPrice());
        productSelected.setImage(productSelected.getImage());

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        products.removeIf(p -> p.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}
