package com.andres.springboot.di.app.springbootdi.data;

import java.util.List;

import com.andres.springboot.di.app.springbootdi.models.Product;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(Long id);
}
