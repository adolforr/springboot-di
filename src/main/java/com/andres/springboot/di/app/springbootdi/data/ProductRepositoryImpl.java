package com.andres.springboot.di.app.springbootdi.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.andres.springboot.di.app.springbootdi.models.Product;

@Repository
public class ProductRepositoryImpl  implements ProductRepository{

    private List<Product> data;

    
    public ProductRepositoryImpl(){
        this.data = Arrays.asList(
            new Product(1L,"Memoria corsair 32", 300L),
            new Product(2L,"CPU AMD Rayzen 9", 300L),
            new Product(3L,"Teclado raze Mini 60%", 180L),
            new Product(4L,"MotherBoard Gigabyte", 490L)

        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }
    
    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null); //código de java
    }
}
