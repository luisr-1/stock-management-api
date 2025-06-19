package com.mew.stockmanagementapi.mappers;

import com.mew.stockmanagementapi.dto.ProductDTO;
import com.mew.stockmanagementapi.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toProductDTO(Product product);
    Product toProduct(ProductDTO productDTO);
}
