package com.sportmanager.application.utilidades;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class ManagementPass {

    public String encript(String password){
        String encriptada = "";
        Base64.Encoder encoder = Base64.getEncoder();
        encriptada = encoder.encodeToString(password.getBytes(StandardCharsets.UTF_8));
        return encriptada;
    }

    public String decript(String password){
        String decriptada = "";
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] byt = decoder.decode(password);
        decriptada = new String(byt);
        return decriptada;
    }
}
