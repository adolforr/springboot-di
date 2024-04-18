package com.andres.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.springboot.di.app.springbootdi.data.ProductRepository;
import com.andres.springboot.di.app.springbootdi.models.Product;

@Service
public class ProductServiceImpl implements ProductService {

    
    @Autowired
    private ProductRepository repository;

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
