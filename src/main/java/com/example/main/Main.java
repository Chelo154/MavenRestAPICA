package com.example.main;

import com.example.clients.infra.spring.microservice.SpringClientMicroservice;
import com.example.common.MicroService;
import com.example.products.infra.spring.microservice.SpringProductMicroservice;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        loadServices(args).forEach(MicroService::start);
    }

    public static List<MicroService> loadServices(String []args){
        ArrayList<MicroService> microServices = new ArrayList<>();

        microServices.add(new SpringClientMicroservice(args));
        microServices.add(new SpringProductMicroservice(args));

        return microServices;
    }
}
