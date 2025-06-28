package com.mew.stockmanagementapi.controllers;

import com.mew.stockmanagementapi.dto.PaginatedResponseDTO;
import com.mew.stockmanagementapi.dto.ProductDto;
import com.mew.stockmanagementapi.dto.ProductUpdateDto;
import com.mew.stockmanagementapi.exceptions.ProductDoNotExist;
import com.mew.stockmanagementapi.model.Product;
import com.mew.stockmanagementapi.services.ProductService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/management")

public class ProductController {
    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<PaginatedResponseDTO<Product>> getProducts(@RequestParam(required = false) Optional<Integer> page,
                                                                     @RequestParam(required = false) Optional<Integer> size) {
        return ResponseEntity.ok(productService.getProducts(page, size));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductUpdateDto product,
                                                 @Positive @PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.updateProduct(product, id));
        } catch (ProductDoNotExist ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}