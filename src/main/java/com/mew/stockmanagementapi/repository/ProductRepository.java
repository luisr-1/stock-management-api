package com.mew.stockmanagementapi.repository;

import com.mew.stockmanagementapi.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {}