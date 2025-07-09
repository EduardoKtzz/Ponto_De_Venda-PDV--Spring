package com.klitzke.pdv.controller;

import com.klitzke.pdv.domain.Pedido;
import com.klitzke.pdv.dto.PedidoDTO;
import com.klitzke.pdv.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos/")
public class PedidoController {

    @Autowired
    private PedidoService service;

    //GET - Pegar todos os pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> todosPedidos() {
        List<Pedido> pedidos = service.todosPedidos();
        return ResponseEntity.ok().body(pedidos);
    }

    //POST PARA CRIAR PEDIDOS
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDTO dto) {
        Pedido pedido = service.criarPedido(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    //PUT - Atualizar pedido

    //DELETE - Excluir pedidoo
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        service.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

}
