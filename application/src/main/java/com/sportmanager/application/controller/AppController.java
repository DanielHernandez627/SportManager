package com.sportmanager.application.controller;

import com.sportmanager.application.entity.Estudiante;
import com.sportmanager.application.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    EstudianteService estudianteService;

    @GetMapping
    public String iniciar(Model model){
        return "index";
    }

    @GetMapping("/controlusuario")
    public String controlusuario(Model model){
        List<Estudiante> estudianteList = estudianteService.listarEstudiantes();
        model.addAttribute("estudiantesSelect",estudianteList);
        return "control_usuarios";
    }

    @GetMapping("/informes")
    public String informeusuarios(Model model){

        return "informes";
    }
}
