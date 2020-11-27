package com.uabc.edu.evaluacionapp.controller;

import com.uabc.edu.evaluacionapp.entity.Intendente;
import com.uabc.edu.evaluacionapp.service.impl.IntendenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(path = "/intendentes")
public class IntendenteController {
    @Autowired
    IntendenteServiceImpl service;

    @GetMapping(value = "/registrar")
    public String registrarIntendente(Model model){
        model.addAttribute("intendente", new Intendente());
        return "intendentes/registrar";
    }

    @PostMapping(value = "/registrar")
    public String registrarIntendente(@ModelAttribute Intendente intendente, RedirectAttributes redirectAttrs) {

        service.registrarIntendente(intendente);
        redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente");

        return "redirect:/intendentes/mostrar";
    }

    @GetMapping(value = "/mostrar")
    public String mostrarProfesores(Model model) {
        model.addAttribute("intendentes", service.obtenerIntendentes());
        return "intendentes/mostrar";
    }

    @GetMapping(value = "/eliminar/{id}")
    public String eliminarIntendente(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("intendentes", service.obtenerIntendentes());

        boolean test = service.eliminarIntendente(id);

        return "redirect:/intendentes/mostrar";
    }

    @PostMapping(value = "/modificar/{id}")
    public String modificarIntendente(@PathVariable("id") Integer id, @ModelAttribute Intendente intendente, RedirectAttributes redirectAttrs, BindingResult result, Model model) {
        model.addAttribute("intendentes", service.obtenerIntendentes());
        service.modificarIntendente(intendente);
        redirectAttrs.addFlashAttribute("mensaje", "Editado correctamente");

        return "redirect:/intendentes/mostrar";
    }

    @GetMapping(value = "/editar/{id}")
    public String editarIntendente(@PathVariable("id") Optional<Integer> id, Model model) {
        if (id.isPresent()) {
            Intendente intendente = service.obtenerIntendente(id.get());
            model.addAttribute("intendente", intendente);
        }
        return "/intendentes/modificar";
    }
}
