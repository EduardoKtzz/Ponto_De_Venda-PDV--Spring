package com.klitzke.pdv.controller;

import com.klitzke.pdv.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Clientes/")
public class clientesControlers {

    //Atributos
    @Autowired
    private ClienteService service;

    //GET - Puxar todos os clientes do sistema

}
