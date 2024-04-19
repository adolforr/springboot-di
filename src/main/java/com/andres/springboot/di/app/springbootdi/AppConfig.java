package com.andres.springboot.di.app.springbootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.andres.springboot.di.app.springbootdi.data.ProducRepositoryJson;
import com.andres.springboot.di.app.springbootdi.data.ProductRepository;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {
    

    @Bean
    @Primary
    ProductRepository productRepositoryJson(){
        return new ProducRepositoryJson();
    }
}
