package com.mew.stockmanagementapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.Instant;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private Long sku;
    private String name;
    private int price;
    private int dimensionsWidth;
    private int dimensionsHeight;
    private int dimensionsDepth;
    private int weight;
    private Instant createdAt;
    private Instant updatedAt;
    private String imageUrl;
}
