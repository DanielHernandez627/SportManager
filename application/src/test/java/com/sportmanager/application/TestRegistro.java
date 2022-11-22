package com.sportmanager.application;

import com.github.javafaker.Faker;
import com.sportmanager.application.entity.Estudiante;
import com.sportmanager.application.service.EstudianteService;
import com.sportmanager.application.utilidades.ManagementPass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        Date fecha = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fech_ingreso = format.format(fecha);

        String name = faker.name().firstName();

        Estudiante estudiante = new Estudiante(0,name,faker.name().lastName(),Long.parseLong(numero),"TI",name + "@gmail.com","2000-01-01",fech_ingreso,"1.61",50,"F",true,managementPass.encript(faker.gameOfThrones().dragon()));

        assertTrue(estudianteService.registrar(estudiante));
    }

    @Test
    public void testFailedRegistrar(){
        Date fecha = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fech_ingreso = format.format(fecha);

        Estudiante estudiante = new Estudiante(0,"prueba","prueba",Long.parseLong("123456789"),"TI","prueba@gmail.com","2000-01-01",fech_ingreso,"1.61",50,"M",true,"MTIz");
        try{
            estudianteService.registrar(estudiante);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
