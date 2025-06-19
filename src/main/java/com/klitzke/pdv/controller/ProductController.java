package com.klitzke.pdv.controller;

import com.klitzke.pdv.domain.Produtos;
import com.klitzke.pdv.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return service.findByCodigo(codigo).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //GET PARA BUSCAR TODOS PELO TIPO
    @GetMapping(value = "/tipo/{tipo}")
    public ResponseEntity<List<Produtos>> findByTipo(@PathVariable String tipo) {
        List<Produtos> tipoMaterial = service.findByTipo(tipo);
        return ResponseEntity.ok().body(tipoMaterial);
    }

    //GET PARA BUSCAR PELO NOME

}
