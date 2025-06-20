package com.mew.stockmanagementapi.controllers;

import com.mew.stockmanagementapi.dto.ProductDTO;
import com.mew.stockmanagementapi.model.Product;
import com.mew.stockmanagementapi.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/management")

public class ProductController {
    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) int page,
                                                     @RequestParam(required = false) int size) {
        return new ResponseEntity<>(productService.getProducts(page, size), HttpStatus.OK);
    }
}