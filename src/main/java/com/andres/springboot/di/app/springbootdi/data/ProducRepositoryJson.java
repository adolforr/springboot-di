package com.andres.springboot.di.app.springbootdi.data;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import com.andres.springboot.di.app.springbootdi.models.Product;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProducRepositoryJson implements ProductRepository{
    private List<Product> list;
    
    public ProducRepositoryJson() {
        Resource resource = new ClassPathResource("jsons/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //list = Arrays.asList(objectMapper.readValue(ressource.getFile(), Product[].class));
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> {
            return p.getId().equals(id);
        }).findFirst().orElse(null);

    }

}
