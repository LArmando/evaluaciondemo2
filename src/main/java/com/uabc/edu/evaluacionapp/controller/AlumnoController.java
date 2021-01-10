package com.uabc.edu.evaluacionapp.controller;


import com.uabc.edu.evaluacionapp.entity.Alumno;
import com.uabc.edu.evaluacionapp.entity.Profesor;
import com.uabc.edu.evaluacionapp.service.impl.AlumnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(path = "/alumnos")
public class AlumnoController {
  @Autowired
  AlumnoServiceImpl service;

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping (value = "/registrar")
  public String registrarAlumno(Model model){
    model.addAttribute("alumno", new Alumno());
    return "alumnos/registrar";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping(value = "/registrar")
  public String registrarAlumno(@ModelAttribute Alumno alumno, RedirectAttributes redirectAttributes){
    service.registrarAlumno(alumno);
    redirectAttributes.addFlashAttribute("mensaje", "agregado correctamente");
    return "redirect:/alumnos/mostrar";
  }

  @GetMapping (value = "/mostrar")
  public String mostrarIntendente(Model model){
    model.addAttribute("alumnos", service.obtenerAlumnos());
    return "alumnos/mostrar";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping (value = "/eliminar/{id}")
  public String borrarProducto(@PathVariable("id") Integer id, Model model){
    model.addAttribute("alumnos",service.obtenerAlumnos());

    boolean test = service.eliminarAlumno(id);

    return "redirect:/alumnos/mostrar";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping(value = "/modificar/{matricula}")
  public String modificarAlumno(@PathVariable("matricula") Integer id, @ModelAttribute Alumno alumno, RedirectAttributes redirectAttrs, BindingResult result, Model model) {
    model.addAttribute("alumnos", service.obtenerAlumnos());
    service.modificarAlumno(alumno);
    redirectAttrs.addFlashAttribute("mensaje", "Editado correctamente");

    return "redirect:/alumnos/mostrar";
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping(value = "/editar/{id}")
  public String editarAlumno(@PathVariable("id") Optional<Integer> id, Model model) {
    if (id.isPresent()) {
      Alumno alumno = service.obtenerAlumno(id.get());
      model.addAttribute("alumno", alumno);
    }
    return "/alumnos/modificar";
  }

}
