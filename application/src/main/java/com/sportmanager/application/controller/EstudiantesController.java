package com.sportmanager.application.controller;

import com.sportmanager.application.entity.Estudiante;
import com.sportmanager.application.service.EstudianteService;
import com.sportmanager.application.utilidades.ManagementPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstudiantesController {

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    ManagementPass managementPass;

    @PostMapping("/insertUser")
    public String registrar(@ModelAttribute("estudiante")Estudiante estudiante){
        String pass;
        String redirectFailed = "redirect:/insertUser?error";

        pass = managementPass.encript(estudiante.getPassword());;
        estudiante.setPassword(pass);

        if (!estudianteService.registrar(estudiante)){
            return redirectFailed;
        }

        return "control_usuarios";
    }


}
