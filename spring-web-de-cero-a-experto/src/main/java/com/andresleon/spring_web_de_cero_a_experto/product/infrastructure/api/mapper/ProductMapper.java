package com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api.mapper;

import com.andresleon.spring_web_de_cero_a_experto.product.application.command.create.CreateProductRequest;
import com.andresleon.spring_web_de_cero_a_experto.product.application.command.update.UpdateProductRequest;
import com.andresleon.spring_web_de_cero_a_experto.product.domain.Product;
import com.andresleon.spring_web_de_cero_a_experto.product.infrastructure.api.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {
    CreateProductRequest mapToCreateProductRequest(ProductDto productDto);

    UpdateProductRequest mapTUpdateProductRequest(ProductDto productDto);

    ProductDto mapToProduct(Product product);
}
