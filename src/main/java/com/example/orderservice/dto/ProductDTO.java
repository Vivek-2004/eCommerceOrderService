package com.example.orderservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private long id;
    private String title;
    private Long categoryId;
    private String brand;
    private boolean popular;
}