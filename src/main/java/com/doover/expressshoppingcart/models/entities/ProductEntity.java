package com.doover.expressshoppingcart.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "products")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "products_seq")
    @SequenceGenerator(
            name = "products_seq",
            sequenceName = "products_product_id_seq", allocationSize = 1)
    private Long productId;

    private String name;
    private Integer price;
    private String description;
    private Integer availableQuantity;

}
