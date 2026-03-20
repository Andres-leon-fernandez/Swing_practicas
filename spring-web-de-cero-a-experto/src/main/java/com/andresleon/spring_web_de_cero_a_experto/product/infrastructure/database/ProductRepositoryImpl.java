package com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.database;

import com.andresleon.spring_web_de_cero_a_experto.product.domain.entity.Product;
import com.andresleon.spring_web_de_cero_a_experto.product.domain.port.ProductRepository;
import com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.database.entity.ProductEntity;
import com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.database.mapper.ProductEmtityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final List<ProductEntity> products;

    private final ProductEmtityMapper productEmtityMapper;

    @Override
    public void upset(Product product) {
        ProductEntity productEntity = productEmtityMapper.mapToProductEntity(product);
        products.removeIf(p -> p.getId().equals(product.getId()));
        products.add(productEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(productEmtityMapper::mapToProduct);
    }

    @Override
    public List<Product> findAll() {
        return products.stream()
                .map(productEmtityMapper::mapToProduct)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}
