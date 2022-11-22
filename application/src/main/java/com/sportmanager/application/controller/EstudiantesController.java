package com.sportmanager.application.controller;

import com.sportmanager.application.entity.Estudiante;
import com.sportmanager.application.service.EstudianteService;
import com.sportmanager.application.utilidades.ManagementPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EstudiantesController {

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    ManagementPass managementPass;

    @PostMapping("/insertUser")
    public String registrar(@ModelAttribute("estudiante")Estudiante estudiante) {
        String pass;
        String redirectFailed = "redirect:/insertUser?error";

        Date fecha = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fech_ingreso = format.format(fecha);
        estudiante.setFecha_incripcion(fech_ingreso);

        pass = managementPass.encript(estudiante.getPassword());
        estudiante.setPassword(pass);

        if (!estudianteService.registrar(estudiante)) {
            return redirectFailed;
        }

        return "menu_pricipal";
    }

    @PostMapping("/updateUser")
    public String actulizar(@ModelAttribute("actulizarestudiante")Estudiante estudiante){
        String pass;
        pass = managementPass.encript(estudiante.getPassword());
        estudiante.setPassword(pass);

        if (!estudianteService.actulizar_estudiante(estudiante)){
            return "redirect:/updateUser?error";
        }

        return "menu_pricipal";
    }
}
