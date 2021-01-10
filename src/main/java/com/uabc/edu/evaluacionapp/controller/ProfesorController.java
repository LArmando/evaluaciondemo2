package com.uabc.edu.evaluacionapp.controller;

import com.uabc.edu.evaluacionapp.entity.Profesor;
import com.uabc.edu.evaluacionapp.service.impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping(path = "/profesores")
public class ProfesorController {
    @Autowired
    ProfesorServiceImpl service;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/registrar")
    public String registrarProfesor(Model model){
        model.addAttribute("profesor", new Profesor());
        return "profesores/registrar";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/registrar")
    public String registrarProfesor(@ModelAttribute Profesor profesor, RedirectAttributes redirectAttrs) {

        service.registrarProfesor(profesor);
        redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente");

        return "redirect:/profesores/mostrar";
    }


    @GetMapping(value = "/mostrar")
    public String mostrarProfesores(Model model) {
        model.addAttribute("profesores", service.obtenerProfesores());
        return "profesores/mostrar";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/eliminar/{id}")
    public String eliminarProfesor(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("profesores", service.obtenerProfesores());

        boolean test = service.eliminarProfesor(id);

        return "redirect:/profesores/mostrar";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/modificar/{id}")
    public String modificarProfesor(@PathVariable("id") Integer id, @ModelAttribute Profesor profesor, RedirectAttributes redirectAttrs, BindingResult result, Model model) {
        /*if(result.hasErrors()){
            profesor.setId(id);
            return "/profesores/modificar";
        }*/
        model.addAttribute("profesores", service.obtenerProfesores());
        service.modificarProfesor(profesor);
        redirectAttrs.addFlashAttribute("mensaje", "Editado correctamente");

        return "redirect:/profesores/mostrar";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/editar/{id}")
    public String editarProfesor(@PathVariable("id") Optional<Integer> id, Model model) {
        if (id.isPresent()) {
            Profesor profesor = service.obtenerProfesor(id.get());
            model.addAttribute("profesor", profesor);
        }
        return "/profesores/modificar";
    }
}
