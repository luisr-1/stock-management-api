package com.mew.stockmanagementapi.services;

import com.mew.stockmanagementapi.model.Product;
import com.mew.stockmanagementapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product productFromRequest) {
        if (productFromRequest == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        Instant timeStamp = Instant.now();

        Product product = Product.builder()
                .sku(productFromRequest.getSku())
                .name(productFromRequest.getName())
                .price(productFromRequest.getPrice())
                .dimensionsDepth(productFromRequest.getDimensionsDepth())
                .dimensionsHeight(productFromRequest.getDimensionsHeight())
                .dimensionsWidth(productFromRequest.getDimensionsWidth())
                .weight(productFromRequest.getWeight())
                .imageUrl(productFromRequest.getImageUrl())
                .createdAt(timeStamp)
                .updatedAt(timeStamp)
                .build();

        return productRepository.save(product);
    }
}
