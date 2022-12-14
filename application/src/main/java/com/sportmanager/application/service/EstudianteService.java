package com.sportmanager.application.service;

import com.sportmanager.application.entity.Estudiante;
import com.sportmanager.application.repository.EstudianteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public boolean registrar(Estudiante estudiante){
        boolean state = false;
        estudiante.setActivo(true);
        var registro = estudianteRepository.save(estudiante);
        if (registro != null){
            state = true;
        }
        return state;
    }

    public List listarEstudiantes(){
        List<Estudiante> estudianteList = estudianteRepository.findAll();
        return estudianteList;
    }

    public Estudiante obtener_estudiantes(int id){
        return estudianteRepository.findById(id);
    }

    public boolean actulizar_estudiante(Estudiante estudiante){
        var state = estudianteRepository.save(estudiante);
        if (state != null){
            return true;
        }else{
            return false;
        }
    }
}
