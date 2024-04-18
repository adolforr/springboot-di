package com.andres.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.andres.springboot.di.app.springbootdi.data.ProductRepositoryImpl;
import com.andres.springboot.di.app.springbootdi.models.Product;

public class ProductServiceImpl implements ProductService {

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p ->{
            Double priceImpl = p.getPrice() * 1.25d;            
            return new Product(p.getId(), p.getName(), priceImpl.longValue());
        }).collect(Collectors.toList());
    }
    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
