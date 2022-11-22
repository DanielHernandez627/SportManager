package com.sportmanager.application.controller;

import com.sportmanager.application.entity.Estudiante;
import com.sportmanager.application.service.EstudianteService;
import com.sportmanager.application.utilidades.ManagementPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin("http://localhost:8080")
public class EstudianteRestController {

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    ManagementPass managementPass;


    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getStudents(@PathVariable("id") int id){
        HttpHeaders headers = new HttpHeaders();
        Estudiante estudiante = new Estudiante();

        estudiante = estudianteService.obtener_estudiantes(id);
        estudiante.setPassword(managementPass.decript(estudiante.getPassword()));

        ResponseEntity<Estudiante> entity = new ResponseEntity<>(estudiante,headers, HttpStatus.ACCEPTED);

        return entity;
    }

}
