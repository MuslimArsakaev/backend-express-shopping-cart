package com.doover.expressshoppingcart.controllers;

import com.doover.expressshoppingcart.models.dtos.Product;
import com.doover.expressshoppingcart.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private IProductService productSrv;

    @Autowired
    public ProductController(IProductService productSrv) {
        this.productSrv = productSrv;
    }

    /**
     * Get all products.
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productSrv.getProducts());
    }

    /**
     * Get product by productId.
     * @return
     */
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(productSrv.getProductById(productId));
    }

}
