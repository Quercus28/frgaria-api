package com.fragaria.fragariaStoreApi.service;

import com.fragaria.fragariaStoreApi.entity.Product;
import com.fragaria.fragariaStoreApi.exception.ResourceNotFoundException;
import com.fragaria.fragariaStoreApi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Integer id,Product product) {
        Product productUpdate = findById(id);
        if (productUpdate != null) {
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setStock(product.getStock());
            return productRepository.save(productUpdate);
        }else{
            return null;
        }
    }

    public void delete(Integer id) {
        Product productDelete = findById(id);
        assert productDelete != null;
        productRepository.delete(productDelete);
    }
}
