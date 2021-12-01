package com.example.clients.infra.spring.microservice;

import com.example.common.MicroService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})
@ComponentScan("com.example.clients.infra.spring.rest")
@ComponentScan("com.example.clients.infra.spring.errorhandlers")
public class SpringClientMicroservice implements MicroService {

    private String []args;

    public SpringClientMicroservice(String []args){
        this.args = args;
    }

    @Override
    public void start() {
        SpringApplication.run(getClass(),args);
    }
}
