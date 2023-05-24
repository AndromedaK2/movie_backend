package com.usach.movie_backend.suscription.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suscription")

public class SuscriptionController {

    @GetMapping("/")
    public String getSuscription(){
        return "Hola";
    }
}

