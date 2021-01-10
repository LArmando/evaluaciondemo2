package com.uabc.edu.evaluacionapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class MenuController {
    @GetMapping(value = "/")
    public String menu(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/forbidden")
    public String forbidden(){
        return "forbidden";
    }
}