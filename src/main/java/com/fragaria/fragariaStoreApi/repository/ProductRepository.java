package com.fragaria.fragariaStoreApi.repository;

import com.fragaria.fragariaStoreApi.entity.Product;
import org.springframework.data.repository.CrudRepository;
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
