package com.uabc.edu.evaluacionapp.controller;

import com.uabc.edu.evaluacionapp.entity.Profesor;
import com.uabc.edu.evaluacionapp.service.impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/profesores")
public class ProfesorController {
    @Autowired
    ProfesorServiceImpl service;

    @GetMapping(value = "/registrar")
    public String registrarProfesor(Model model){
        model.addAttribute("profesor", new Profesor());
        return "profesores/registrar";
    }


}
