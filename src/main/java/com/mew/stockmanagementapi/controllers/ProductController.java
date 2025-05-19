package com.mew.stockmanagementapi.controllers;

import com.mew.stockmanagementapi.model.Product;
import com.mew.stockmanagementapi.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/management")

public class ProductController {
    private final ProductService productService;
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {

    }
}
