package com.sportmanager.application.controller;

import com.sportmanager.application.entity.Estudiante;
import com.sportmanager.application.service.EstudianteService;
import com.sportmanager.application.utilidades.ManagementPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutenticarController {

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    ManagementPass managementPass;

    @PostMapping("/autenticar")
    public String autenticar(@ModelAttribute("estudiante") Estudiante estudiante){
        String password = managementPass.encript(estudiante.getPassword());
        if (!estudianteService.autenticar(estudiante.getEmail(),password)){
            return "redirect:/autenticar?error";
        }

        return "menu_pricipal";
    }

}
