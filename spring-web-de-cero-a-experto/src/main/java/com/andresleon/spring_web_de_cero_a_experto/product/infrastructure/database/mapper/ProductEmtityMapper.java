package com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.database.mapper;

import com.andresleon.spring_web_de_cero_a_experto.product.domain.Product;
import com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.database.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductEmtityMapper {
    ProductEntity mapToProductEntity(Product product);

    Product mapToProduct(ProductEntity productEntity);
}
