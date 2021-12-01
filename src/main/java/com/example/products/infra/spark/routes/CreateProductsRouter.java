package com.example.products.infra.spark.routes;
import com.example.products.app.controller.ProductCreatorController;
import com.example.products.app.dto.CreateProductDto;
import com.example.products.app.dto.CreateProductResponseDTO;
import com.example.products.app.exceptions.MissingCreateProductArgumentsException;
import com.example.products.app.service.ProductCreatorService;
import com.example.products.domain.exceptions.InvalidPriceException;
import com.example.products.infra.data.arraylist.ProductsRepository;
import com.example.products.infra.spark.response.ErrorResponse;
import com.example.products.infra.uuid.UuidGenerator;
import org.json.JSONObject;
import spark.Response;

import static spark.Spark.*;

public class CreateProductsRouter extends SparkRouter{

    private ProductCreatorController controller;

    public CreateProductsRouter(){
        this.controller = new ProductCreatorController(
                new ProductCreatorService(
                        new UuidGenerator(),
                        new ProductsRepository())
        );
    }

    @Override
    public void load() {
        post("/product", (request, response) -> {
            try{
                JSONObject body = new JSONObject(request.body());

                CreateProductDto dto = new CreateProductDto(
                        body.has("name")?body.getString("name"):null,
                        body.has("price")?body.getDouble("price"):null
                );

                CreateProductResponseDTO result = controller.createProduct(dto);

                response.body(new JSONObject(result).toString());

            }catch (MissingCreateProductArgumentsException | InvalidPriceException invalidArgumentsException){
                 handleError(400,invalidArgumentsException,response);
            } catch (Exception error){
                 handleError(500,error,response);
            }
            response.type("application/json");
            return response.body();
        });

    }

    private void handleError(int status,Exception exception, Response response){
        ErrorResponse errorResponse = new ErrorResponse(exception);

        response.status(status);

        response.body(new JSONObject(errorResponse).toString());
    }
}
