package com.andres.springboot.di.app.springbootdi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.springboot.di.app.springbootdi.models.Product;
import com.andres.springboot.di.app.springbootdi.services.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductServiceImpl service = new ProductServiceImpl();

    @GetMapping("/products")
    public List<Product> list(){
        return service.findAll();
    }

    @GetMapping("/products/{id}")
    public Product show(@PathVariable Long id){
        return service.findById(id);
    }

}
