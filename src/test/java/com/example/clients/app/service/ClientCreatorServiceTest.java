package com.example.clients.app.service;

import com.example.clients.app.dto.CreateClientDTO;
import com.example.clients.app.dto.CreateClientResponseDTO;
import com.example.clients.app.interfaces.ClientSaver;
import com.example.clients.app.interfaces.ClientIdGenerator;
import com.example.clients.domain.exceptions.InvalidMailAdressException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
public class ClientCreatorServiceTest {

    private ClientCreatorService service;

    @Before
    public void setUp(){
        ClientIdGenerator idGenerator = mock(ClientIdGenerator.class);

        ClientSaver saver = mock(ClientSaver.class);

        when(idGenerator.generateId()).thenReturn("abc123");

        doNothing().when(saver).save(any());

        service = new ClientCreatorService(idGenerator,saver);
    }

    @Test
    public void testCreation(){
        CreateClientResponseDTO result = service.createClient(new CreateClientDTO(
                "Bruce",
                "Wayne",
                "bruce.wayne@gothamnet.com"
        ));

        Assert.assertEquals("abc123",result.getId());
        Assert.assertEquals("Bruce Wayne",result.getName()+" "+result.getSurname());
        Assert.assertEquals("bruce.wayne@gothamnet.com",result.getEmail());
    }

    @Test
    public void testInvalidEmail(){
        try{
            service.createClient(new CreateClientDTO(
                    "Bruce",
                    "Wayne",
                    "joker.com"
            ));
            Assert.fail("joker.com is an invalid email");
        }catch (InvalidMailAdressException ignored){}
    }

}