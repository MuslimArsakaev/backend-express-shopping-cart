package com.doover.expressshoppingcart.services.impl;

import com.doover.expressshoppingcart.models.dtos.Product;
import com.doover.expressshoppingcart.models.entities.ProductEntity;
import com.doover.expressshoppingcart.repositories.ProductRepository;
import com.doover.expressshoppingcart.services.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepo;
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepo, ModelMapper modelMapper) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        productRepo.findAll()
                .forEach(entity -> products.add(modelMapper.map(entity, Product.class)));

        return products;
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepo.findById(productId)
                .map(entity -> modelMapper.map(entity, Product.class))
                .orElse(null);
    }

    @Override
    public Product addNewProduct(Product product) {

        ProductEntity productEntity = productRepo.save(modelMapper.map(product, ProductEntity.class));
        return modelMapper.map(productEntity, Product.class);
    }

    @Override
    public void editProduct(Product product) {

        ProductEntity productEntity =modelMapper.map(product, ProductEntity.class);
        productRepo.save(productEntity);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }

}
