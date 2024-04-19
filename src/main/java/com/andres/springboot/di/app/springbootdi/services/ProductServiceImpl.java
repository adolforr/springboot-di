package com.andres.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.andres.springboot.di.app.springbootdi.data.ProductRepository;
import com.andres.springboot.di.app.springbootdi.models.Product;

@Service
public class ProductServiceImpl implements ProductService {
    
    // @Autowired
    // private Environment enviroment;

    @Value("${config.price.tax}")
    private Double tax;
    
    @Autowired    
    private ProductRepository repository;

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p ->{
            Double priceImpl = p.getPrice() * tax;
            //Double priceImpl = p.getPrice() * enviroment.getProperty("config.price.tax",Double.class);  ;
            p.setPrice(priceImpl.longValue());          
            return p;
            //return new Product(p.getId(), p.getName(), priceImpl.longValue()); //inmutabilidad
        }).collect(Collectors.toList());
    }
    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
