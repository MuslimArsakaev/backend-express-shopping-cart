package com.doover.expressshoppingcart.services;

import com.doover.expressshoppingcart.models.dtos.Product;

import java.util.List;

public interface IProductService {

    List<Product> getProducts();

    Product getProductById(Long productId);

    Product addNewProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Long productId);

}
