package com.ebc.juegos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class HomeController {

    @GetMapping
    public String Home () {
        return "Hola soy default: Ya estoy sobre jenkins";
    }
}
