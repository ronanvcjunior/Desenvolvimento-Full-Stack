package br.com.ronan.semana04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ola")
public class HelloController {
    
    @GetMapping
    public String getMethodName() {
        return "Olá mundo!";
    }
}
