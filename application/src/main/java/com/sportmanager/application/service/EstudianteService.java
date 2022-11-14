package com.sportmanager.application.service;

import com.sportmanager.application.entity.Estudiante;
import com.sportmanager.application.repository.EstudianteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log4j2
@Transactional
@AllArgsConstructor
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public boolean autenticar(String email,String password){
        boolean state = false;
        var estudiante = estudianteRepository.findByEmailPass(email);
        if(estudiante != null){
            if (estudiante.getPassword().equals(password)){
                state = true;
            }
        }

        return state;
    }

}
