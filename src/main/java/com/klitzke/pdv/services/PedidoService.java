package com.klitzke.pdv.services;

import com.klitzke.pdv.domain.Client;
import com.klitzke.pdv.domain.ItemPedido;
import com.klitzke.pdv.domain.Pedido;
import com.klitzke.pdv.domain.Produtos;
import com.klitzke.pdv.dto.PedidoDTO;
import com.klitzke.pdv.repository.ClienteRepositorio;
import com.klitzke.pdv.repository.PedidoRepositorio;
import com.klitzke.pdv.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public Pedido criarPedido(PedidoDTO dto) {
        Client client = clienteRepositorio.findByDocument(dto.getClienteDocument()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setClient(client);
        pedido.setData(LocalDateTime.now());

        BigDecimal total = BigDecimal.ZERO;

        for(PedidoDTO.ItemDTO itemDTO : dto.getItens()) {
            Produtos produtos = produtoRepositorio.findByCodigo(itemDTO.getProdutoCodigo()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            ItemPedido item = new ItemPedido();
            item.setProdutos(produtos);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPrecoUnitario(produtos.getPreco());
            item.setPedido(pedido);

            pedido.getItens().add(item);

            BigDecimal subtotal = produtos.getPreco().multiply(BigDecimal.valueOf(itemDTO.getQuantidade()));
            total = total.add(subtotal);
        }

        pedido.setTotal(total);
        return pedidoRepositorio.save(pedido);

    }
}
