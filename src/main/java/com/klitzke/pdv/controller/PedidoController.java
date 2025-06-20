package com.klitzke.pdv.controller;

import com.klitzke.pdv.domain.Pedido;
import com.klitzke.pdv.dto.PedidoDTO;
import com.klitzke.pdv.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDTO dto) {
        Pedido pedido = service.criarPedido(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
}
