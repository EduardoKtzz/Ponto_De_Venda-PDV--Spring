package com.klitzke.pdv.controller;

import com.klitzke.pdv.domain.Client;
import com.klitzke.pdv.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//Aqui temos o http principal para os clientes, com os seus métodos (GET, POST, DELETE, PUT)
@RestController
@RequestMapping("/clientes/")
public class ClientController {

    //Atributos - Injeção de dependência do Spring Boot
    @Autowired
    private ClienteService service;

    //GET - Puxar todos os clientes do sistema por ordem de 'ID'
    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clientes = service.findAll();
        return ResponseEntity.ok().body(clientes);
    }

    //GET - Para puxar o clint por CPF ou CNPJ
    @GetMapping(value = "/document/{document}")
    public ResponseEntity<Client> findByDocument(@PathVariable String document) {
        return service.findByDocument(document).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //GET POR EMAIL
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<Client> findByEmail(@PathVariable String email) {
        return service.findByEmail(email).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //POST PARA CRIAR CLIENTES

    //PUT PARA ATUALIZAR CLIENTES

}
