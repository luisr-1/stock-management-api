package com.mew.stockmanagementapi.services;

import com.mew.stockmanagementapi.dto.PaginatedResponseDTO;
import com.mew.stockmanagementapi.dto.ProductDto;
import com.mew.stockmanagementapi.dto.ProductUpdateDto;
import com.mew.stockmanagementapi.exceptions.ProductDoNotExist;
import com.mew.stockmanagementapi.mappers.ProductMapper;
import com.mew.stockmanagementapi.model.Product;
import com.mew.stockmanagementapi.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

import static java.lang.Math.*;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    ProductService(final ProductRepository productRepository, final ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product addProduct(ProductDto productFromRequest) {
        if (productFromRequest == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        Instant timeStamp = Instant.now();

        Product product = productMapper.toProduct(productFromRequest);
        product.setCreatedAt(timeStamp);
        product.setUpdatedAt(timeStamp);

        return productRepository.save(product);
    }

    public PaginatedResponseDTO<Product> getProducts(Optional<Integer> page, Optional<Integer> size) {
        final int DEFAULT_PAGE_SIZE = 20;
        final int LIMIT_PAGE_SIZE = 100;
        final int DEFAULT_PAGE_NUMBER = 0;

        Pageable pageRequest;

        if (page.isPresent() || size.isPresent()) {
            int currentPage = page.map(p -> max(0, p)).orElse(DEFAULT_PAGE_NUMBER);
            int pageSize = size.map(s -> min(LIMIT_PAGE_SIZE, abs(s))).orElse(DEFAULT_PAGE_SIZE);
            pageRequest = PageRequest.of(currentPage, pageSize);
        } else
            pageRequest = Pageable.unpaged();

        return new PaginatedResponseDTO<>(productRepository.findAll(pageRequest));
    }

    public Product updateProduct(ProductUpdateDto updateProductFromRequest, Long productId) {
        if (updateProductFromRequest == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            Product updated = productMapper.partialUpdate(updateProductFromRequest, product);
            return productRepository.save(updated);
        }

        throw new ProductDoNotExist("Product with id: " + productId);
    }
}


