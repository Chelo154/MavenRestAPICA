package com.example.products.infra.spring.microservice;

import com.example.common.MicroService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collections;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})
@ComponentScan("com.example.products.infra.spring.restcontroller")
public class SpringProductMicroservice implements MicroService {

    private String[] args;

    public SpringProductMicroservice(String[] args){
        this.args = args;
    }

    @Override
    public void start() {
        SpringApplication app = new SpringApplication(SpringProductMicroservice.class);
        app.setDefaultProperties(Collections.singletonMap("server.port","8081"));
        app.run(args);
    }
}
