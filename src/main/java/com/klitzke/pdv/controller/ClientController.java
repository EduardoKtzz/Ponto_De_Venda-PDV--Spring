package com.klitzke.pdv.controller;

import com.klitzke.pdv.domain.Client;
import com.klitzke.pdv.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//Aqui temos o http principal para os clientes, com os seus métodos (GET, POST, PUT)
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

    //GET - Para puxar os clientes por CPF ou CNPJ
    @GetMapping(value = "/document/{document}")
    public ResponseEntity<Client> findByDocument(@PathVariable String document) {
        return service.findByDocument(document).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //GET - Para puxar os clientes por email
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<Client> findByEmail(@PathVariable String email) {
        return service.findByEmail(email).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //POST - Realizar criação de novos usurious
    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client) {
        client = service.Insert(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    //DELETE - Deletar usuários do nosso banco de dados
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarContato(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    //PUT - Atualizar todas as informações dos clientes
    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> atualizarCliente(@PathVariable Long id, @RequestBody Client client) {
        client = service.atualizarCliente(id, client);
        return ResponseEntity.ok().body(client);
    }

}
