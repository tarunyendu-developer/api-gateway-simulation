package com.gateway.service;

import com.gateway.entity.Product;
import com.gateway.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //  Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //  Get product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    //  Create product
    public Product createProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    //  Delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}