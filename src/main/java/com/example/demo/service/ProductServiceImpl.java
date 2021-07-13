package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepo;

    @Override
    public Product creteProduct(Product product) {
        return this.productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productDb = this.productRepo.findById(product.getId());
        if(productDb.isPresent()) {
            Product productUpdate = productDb.get();
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setPrice(product.getPrice());
            productRepo.save(productUpdate);
            return productUpdate;
        }else{
            throw new ResourceNotFoundException("Record not found with id:: "+product.getId());
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> productDb = this.productRepo.findById(productId);
        if(productDb.isPresent()) {
            return this.productRepo.getById(productId);
        } else{
             throw new ResourceNotFoundException("Record not found with id:: "+productId);
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> productDb = this.productRepo.findById(productId);
        if(productDb.isPresent()) {
            this.productRepo.deleteById(productId);
        } else{
            throw new ResourceNotFoundException("Record not found with id:: "+productId);
        }
    }
}
