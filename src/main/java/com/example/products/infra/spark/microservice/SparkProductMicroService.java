package com.example.products.infra.spark.microservice;

import com.example.common.MicroService;
import com.example.products.infra.spark.routes.CreateProductsRouter;
import com.example.products.infra.spark.routes.SparkRouter;

import java.util.ArrayList;
import static spark.Spark.*;

public class SparkProductMicroService implements MicroService {

    ArrayList<SparkRouter> routers;

    public SparkProductMicroService(){
        routers = new ArrayList<>();
        load();
    }
    @Override
    public void start() {
        port(8081);
        routers.forEach(SparkRouter::load);
    }

    private void load(){
        routers.add(new CreateProductsRouter());
    }
}
