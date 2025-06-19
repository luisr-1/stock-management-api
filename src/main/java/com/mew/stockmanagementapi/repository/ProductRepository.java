package com.mew.stockmanagementapi.repository;

import com.mew.stockmanagementapi.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll(Pageable pageable);
}