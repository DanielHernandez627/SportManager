package com.sportmanager.application;

import com.github.javafaker.Faker;
import com.sportmanager.application.service.EstudianteService;
import com.sportmanager.application.utilidades.ManagementPass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LoginTest {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private ManagementPass managementPass;

    @Test
    public void testOkLogin(){
        String email = "prueba@prueba.com";
        String pass = managementPass.encript("123");

        assertTrue(estudianteService.autenticar(email,pass));
    }

    @Test
    public void testFailedLogin(){
        Faker faker = new Faker();
        String email = faker.gameOfThrones().house() + "@gmail.com";
        String pass =  managementPass.encript(faker.animal().name());

        assertFalse(estudianteService.autenticar(email,pass));
    }

}
