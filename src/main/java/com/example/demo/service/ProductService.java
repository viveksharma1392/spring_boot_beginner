package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    Product creteProduct(Product product);
    Product updateProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    void deleteProduct(Long productId);
}
