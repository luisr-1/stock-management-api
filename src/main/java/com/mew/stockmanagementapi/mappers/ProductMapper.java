package com.mew.stockmanagementapi.mappers;

import com.mew.stockmanagementapi.dto.ProductDto;
import com.mew.stockmanagementapi.dto.ProductUpdateDto;
import com.mew.stockmanagementapi.model.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toProductDTO(Product product);

    Product toProduct(ProductDto productDTO);

    Product toEntity(ProductUpdateDto productUpdateDto);

    ProductUpdateDto toDto(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product partialUpdate(ProductUpdateDto productUpdateDto, @MappingTarget Product product);
}
