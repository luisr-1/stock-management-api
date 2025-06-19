package com.mew.stockmanagementapi.services;

import com.mew.stockmanagementapi.dto.ProductDTO;
import com.mew.stockmanagementapi.mappers.ProductMapper;
import com.mew.stockmanagementapi.model.Product;
import com.mew.stockmanagementapi.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.max;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    ProductService(final ProductRepository productRepository, final ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product addProduct(ProductDTO productFromRequest) {
        if (productFromRequest == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        Instant timeStamp = Instant.now();

        Product product = productMapper.toProduct(productFromRequest);
        product.setCreatedAt(timeStamp);
        product.setUpdatedAt(timeStamp);

        return productRepository.save(product);
    }

    public List<Product> getProducts(int page, int size) {
        Pageable pageRequest = PageRequest.of(max(0, page), abs(size));
        return productRepository.findAll(pageRequest);
    }
}


