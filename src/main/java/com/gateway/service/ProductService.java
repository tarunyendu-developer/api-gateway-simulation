package com.gateway.service;

import com.gateway.dto.ProductDTO;
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

    //  Entity → DTO
    private ProductDTO mapToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }

    //  DTO → Entity
    private Product mapToEntity(ProductDTO dto) {
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .createdAt(LocalDateTime.now())
                .build();
    }

    //  Get all products
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    //  Get product by ID
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return mapToDTO(product);
    }

    //  Create product
    public ProductDTO createProduct(ProductDTO dto) {
        Product product = mapToEntity(dto);
        return mapToDTO(productRepository.save(product));
    }

    //  Delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}