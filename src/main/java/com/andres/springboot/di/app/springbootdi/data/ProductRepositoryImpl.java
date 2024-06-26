package com.andres.springboot.di.app.springbootdi.data;

import java.util.Arrays;
import java.util.List;

// import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
// import org.springframework.web.context.annotation.RequestScope;

import com.andres.springboot.di.app.springbootdi.models.Product;

// @Primary
// @RequestScope
// @Repository("productList")
@Repository("productList")
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
