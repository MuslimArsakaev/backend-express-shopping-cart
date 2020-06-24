package com.doover.expressshoppingcart.models.dtos;

import lombok.Data;

@Data
public class Product {

    private Long productId;
    private String name;
    private Integer price;
    private String description;
    private Integer availableQuantity;

}
