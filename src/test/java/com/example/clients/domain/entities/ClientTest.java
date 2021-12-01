package com.example.clients.domain.entities;

import com.example.clients.domain.exceptions.InvalidMailAdressException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void testCreateClient(){
        try{
            Client client = new Client(
                    "abc123",
                    "Bruce",
                    "Wayne",
                    "bruce.wayne@gothamnet.com"
            );
        }catch (InvalidMailAdressException error){
            Assert.fail("bruce.wayne@gothamnet.com is a valid email");
        }
    }

    @Test
    public void testCreateInvalidClient(){
        try {
            new Client(
                    "abc456",
                    "Talia",
                    "Al Ghul",
                    "taliaalgul.com"
            );
        }catch (InvalidMailAdressException error){
            Assert.assertEquals("taliaalgul.com is not a valid e-mail address",error.getMessage());
        }
    }
}