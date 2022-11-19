package com.sportmanager.application;

import com.github.javafaker.Faker;
import com.sportmanager.application.entity.Estudiante;
import com.sportmanager.application.service.EstudianteService;
import com.sportmanager.application.utilidades.ManagementPass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestRegistro {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private ManagementPass managementPass;

    @Test
    public void testRegistroOK(){
        Faker faker = new Faker();
        String numero = "";
        for (int i = 0; i <= 9; i++){
            numero = numero + String.valueOf((int) (Math.random() * 9 + 1));
        }

        String name = faker.name().firstName();

        Estudiante estudiante = new Estudiante(0,name,faker.name().lastName(),Long.parseLong(numero),"TI",name + "@gmail.com","2000-01-01","1.61",50,"M",true,managementPass.encript(faker.gameOfThrones().dragon()));

        assertTrue(estudianteService.registrar(estudiante));
    }

    @Test
    public void testFailedRegistrar(){
        Estudiante estudiante = new Estudiante(0,"prueba","prueba",Long.parseLong("123456789"),"TI","prueba@gmail.com","2000-01-01","1.61",50,"M",true,"MTIz");
        try{
            estudianteService.registrar(estudiante);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
