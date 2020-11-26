package com.uabc.edu.evaluacionapp.controller;


import com.uabc.edu.evaluacionapp.entity.Alumno;
import com.uabc.edu.evaluacionapp.service.impl.AlumnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/alumnos")
public class AlumnoController {
  @Autowired
  AlumnoServiceImpl service;

  @GetMapping (value = "/registrar")
  public String registrarAlumno(Model model){
    model.addAttribute("alumno", new Alumno());
    return "alumnos/registrar";
  }

  @PostMapping(value = "/registrar")
  public String registrarAlumno(@ModelAttribute Alumno alumno, RedirectAttributes redirectAttributes){
    service.registrarAlumno(alumno);
    redirectAttributes.addFlashAttribute("mensaje", "agregado correctamente");
    return"redirect: alumnos/mostrar";
  }

  @GetMapping (value = "/mostrar")
  public String mostrarIntendente(Model model){
    model.addAttribute("alumnos", service.obtenerAlumnos());
    return "alumnos/mostrar";
  }

  @GetMapping (value = "/eliminar/{id}")
  public String borrarProducto(@PathVariable("id") Integer id, Model model){
    model.addAttribute("alumnos",service.obtenerAlumnos());

    return service.borrarAlumno(id)==true?"redirect:alumnos/mostrar":"redirect:alumnos/error";
  }

}
