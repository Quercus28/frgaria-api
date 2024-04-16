package com.fragaria.fragariaStoreApi.controller;

import com.fragaria.fragariaStoreApi.entity.Product;
import com.fragaria.fragariaStoreApi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list-products")
    Iterable<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable Integer id) {
        return productService.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-product")
    public Product createProduct(@Validated @RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @Validated @RequestBody Product product) {
        return productService.update(id, product);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
    }
}
