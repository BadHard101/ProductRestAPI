package com.example.practice5.Services;

import com.example.practice5.models.Product;
import com.example.practice5.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public boolean update(Long id, Product product) {
        var oldProduct = productRepository.findById(id);
        if (oldProduct.isEmpty()) return false;
        product.setId(id);

        productRepository.save(product);
        return true;
    }

    public boolean delete(Long id) {
        var product = productRepository.findById(id);
        if (product.isEmpty()) return false;

        productRepository.deleteById(id);
        return true;
    }
}
