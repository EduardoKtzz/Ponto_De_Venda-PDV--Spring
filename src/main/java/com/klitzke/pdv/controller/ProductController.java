package com.klitzke.pdv.controller;

import com.klitzke.pdv.domain.Produtos;
import com.klitzke.pdv.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Aqui temos o http principal para os produtos, com os seus métodos (GET, POST, DELETE, PUT)
@RestController
@RequestMapping("/produtos/")
public class ProductController {

    @Autowired
    public ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produtos>> findAll() {
        List<Produtos> prod = service.findAll();
        return ResponseEntity.ok().body(prod);
    }


}
