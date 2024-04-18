package com.andres.springboot.di.app.springbootdi.data;

import java.util.Collections;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.andres.springboot.di.app.springbootdi.models.Product;


@Repository("productFoo")
public class ProductRepositoryFooImpl implements ProductRepository {

    @Override
    public List<Product> findAll(){
        return Collections.singletonList(new Product(1L,"Monitor Asus 27", 600L));
    }

    @Override
    public Product findById(Long id){
        return new Product(1L,"Monitor Asus 27", 600L);
    }
}
