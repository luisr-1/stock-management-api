package com.mew.stockmanagementapi.exceptions;

public class ProductDoNotExist extends RuntimeException {
    public ProductDoNotExist(String message) {
        super(message);
    }
}
