package com.mew.stockmanagementapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Entity
@Table(name = "Products")
public class Product {
    private @Id
    @GeneratedValue Long sku;
    @jakarta.persistence.Id
    private Long id;
    private String name;
    private int price;
    private int dimensionsWidth;
    private int dimensionsHeight;
    private int dimensionsDepth;
    private int weight;
    private Date createdAt;
    private Date updatedAt;
    private String imageUrl;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
