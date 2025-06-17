package com.klitzke.pdv.controller;

import com.klitzke.pdv.domain.Client;
import com.klitzke.pdv.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client) {
        client = service.Insert(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    //PUT PARA ATUALIZAR CLIENTES

}
