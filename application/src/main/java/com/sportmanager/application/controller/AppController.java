package com.sportmanager.application.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping
    public String iniciar(Model model){
        return "index";
    }

    @GetMapping("/controlusuario")
    public String controlusuario(Model model){
        return "control_usuarios";
    }
}
