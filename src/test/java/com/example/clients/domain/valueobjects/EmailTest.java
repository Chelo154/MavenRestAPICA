package com.example.clients.domain.valueobjects;

import com.example.clients.domain.exceptions.InvalidMailAdressException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {

    @Test
    public void testMailCreation(){
        try{
            Email email = new Email("example@example.com.ar");
        }catch (InvalidMailAdressException error){
            Assert.fail("This is a valid email");
        }
    }

    @Test
    public void testInvalidMailCreation(){
        try{
            new Email("abc.net");

            Assert.fail("This is not a valid email");
        }catch (InvalidMailAdressException ignored){}
    }

    @Test
    public void testEmailUpdate(){
        try{
            Email email = new Email("example@example.com.ar");

            email.update("example2@newexample.com.eu");
        }catch (InvalidMailAdressException ignored){
            Assert.fail("This is a valid email update");
        }
    }

    @Test
    public void testEmailInvalidUpdate(){
        try{
            Email email = new Email("example@example.com.ar");

            email.update("newemail.com");

            Assert.fail("This is not a valid email update");
        }catch (InvalidMailAdressException ignored){}
    }

    @Test
    public void testGetAdress(){
        Email email = new Email("bruce.wayne@gothamnet.com");

        String expected = "bruce.wayne";

        Assert.assertEquals(expected,email.getAdrress());
    }

    @Test
    public void testGetDomain(){
        Email email = new Email("jarvey.dent@gothamnet.com");

        String expected = "gothamnet.com";

        Assert.assertEquals(expected,email.getDomain());
    }

    @Test
    public void testMailService(){
        Email email = new Email("batman@gmail.com");

        String expected = "gmail";

        Assert.assertEquals(expected,email.getMailService());
    }

}