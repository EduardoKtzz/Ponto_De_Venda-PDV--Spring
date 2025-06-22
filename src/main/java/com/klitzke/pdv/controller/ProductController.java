package com.klitzke.pdv.controller;

import com.klitzke.pdv.domain.Produtos;
import com.klitzke.pdv.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//Aqui temos o http principal para os produtos, com os seus métodos (GET, POST, DELETE, PUT)
@RestController
@RequestMapping("/produtos/")
public class ProductController {

    //Injeção de dependência na classe de serviço
    @Autowired
    public ProdutoService service;

    //GET - Buscar todos os produtos
    @GetMapping
    public ResponseEntity<List<Produtos>> findAll() {
        List<Produtos> prod = service.findAll();
        return ResponseEntity.ok().body(prod);
    }

    //GET - Buscar produto especifico pelo codigo
    @GetMapping(value = "/codigo/{codigo}")
    public ResponseEntity<Produtos> findByCode(@PathVariable int codigo) {
        Produtos produtos = service.findByCodigo(codigo);
        return ResponseEntity.ok(produtos);
    }

    //GET - Buscar todos os produtos do mesmo tipo
    @GetMapping(value = "/tipo/{tipo}")
    public ResponseEntity<List<Produtos>> findByTipo(@PathVariable String tipo) {
        List<Produtos> tipoMaterial = service.findByTipo(tipo);
        return ResponseEntity.ok().body(tipoMaterial);
    }

    //GET - Buscar produtos pelo nome dele
    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Produtos> findByName(@PathVariable String nome) {
        Produtos produtos = service.findByName(nome);
        return ResponseEntity.ok(produtos);
    }

    //POST - Criar produtos
    @PostMapping
    public ResponseEntity<Produtos> insert(@RequestBody Produtos produtos) {
        produtos = service.insert(produtos);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produtos.getId()).toUri();
        return ResponseEntity.created(uri).body(produtos);
    }

    //PUT -  Atualizar produtos
    @PutMapping(value = "/atualizar/{codigo}")
    public ResponseEntity<Produtos> atualizar(@PathVariable int codigo, @RequestBody Produtos produtos) {
        produtos = service.atualizar(codigo, produtos);
        return ResponseEntity.ok().body(produtos);
    }

}
