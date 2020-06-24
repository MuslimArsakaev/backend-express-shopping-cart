package com.doover.expressshoppingcart.controllers.admin;

import com.doover.expressshoppingcart.models.dtos.Product;
import com.doover.expressshoppingcart.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "admin/product")
public class AdminProductController {

    private IProductService productSrv;

    @Autowired
    public AdminProductController(IProductService productSrv) {
        this.productSrv = productSrv;
    }

    /**
     * Add new product from web-admin.
     * @param product
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productSrv.addNewProduct(product));
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
     * @param productId
     * @return
     */
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(productSrv.getProductById(productId));
    }

    /**
     * Edit/modify new product.
     * @param product
     * @return
     */
    @PutMapping("/")
    public ResponseEntity<Product> editProduct(@RequestBody Product product) {
        productSrv.editProduct(product);
        return ResponseEntity.ok().build();
    }

    /**
     * Delete product by productId.
     * @param productId
     * @return
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("productId") Long productId) {
        productSrv.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

}
