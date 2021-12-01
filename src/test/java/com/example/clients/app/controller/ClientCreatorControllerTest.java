package com.example.clients.app.controller;

import com.example.clients.app.dto.CreateClientDTO;
import com.example.clients.app.dto.CreateClientResponseDTO;
import com.example.clients.app.exceptions.MissingCreateClientParams;
import com.example.clients.app.service.ClientCreatorService;
import com.example.clients.domain.entities.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ClientCreatorControllerTest {

    private ClientCreatorController controller;

    @Before
    public void setUp(){
        ClientCreatorService service = mock(ClientCreatorService.class);

        when(service.createClient(any())).thenReturn(
                new CreateClientResponseDTO(
                        new Client(
                                "abc123",
                                "Bruce",
                                "Wayne",
                                "bruce.wayne@gothamnet.com"
                        )));

        controller = new ClientCreatorController(service);
    }

    @Test
    public void testClientCreation(){
        CreateClientResponseDTO result = controller.createProduct(
                new CreateClientDTO(
                        "Bruce",
                        "Wayne",
                        "bruce.wayne@gothamnet.com"
                ));

        Assert.assertEquals("abc123",result.getId());
        Assert.assertEquals("Bruce Wayne",result.getName()+" "+result.getSurname());
        Assert.assertEquals("bruce.wayne@gothamnet.com",result.getEmail());
    }

    @Test
    public void testNullName(){
        try{
            controller.createProduct(new CreateClientDTO(
                    null,
                    "Wayne",
                    "bruce.wayne@gothamnet.com"
            ));
        }catch (MissingCreateClientParams error){
            Assert.assertEquals("name was not given for creating a client",error.getMessage());
        }
    }

    @Test
    public void testNullSurname(){
        try{
            controller.createProduct(new CreateClientDTO(
                    "Bruce",
                    null,
                    "bruce.wayne@gothamnet.com"
            ));
        }catch (MissingCreateClientParams error){
            Assert.assertEquals("surname was not given for creating a client",error.getMessage());
        }
    }

    @Test
    public void testNullEmail(){
        try{
            controller.createProduct(new CreateClientDTO(
                    "Bruce",
                    "Wayne",
                    null
            ));
        }catch (MissingCreateClientParams error){
            Assert.assertEquals("email was not given for creating a client",error.getMessage());
        }
    }

}