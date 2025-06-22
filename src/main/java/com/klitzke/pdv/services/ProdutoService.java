package com.klitzke.pdv.services;

import com.klitzke.pdv.domain.Produtos;
import com.klitzke.pdv.repository.ProdutoRepositorio;
import com.klitzke.pdv.services.exception.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    //Atributos
    @Autowired
    private ProdutoRepositorio repositorio;

    //Buscar todos os produtos
    public List<Produtos> findAll() {
        return repositorio.findAll();
    }

    //Buscar produtos por codigo
    public Produtos findByCodigo(int codigo) {
        return repositorio.findByCodigo(codigo).orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado."));
    }

    //Buscar todos pelo TIPO de material
    public List<Produtos> findByTipo(String tipo) {
        List<Produtos> produtos = repositorio.findByTipo(tipo);

        if (produtos.isEmpty()) {
            throw new RuntimeException("Nenhum material encontrado!");
        }
        return produtos;
    }

    //Buscar produtos pelo nome dele
    public Produtos findByName(String name) {
        return repositorio.findByName(name).orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum produto com esse nome encontrado."));
    }

    //Criar um produto
    public Produtos insert(Produtos produtos) {
        return repositorio.save(produtos);
    }

    //Atualizar produtos
    public Produtos atualizar(int codigo, Produtos produtos) {
        Produtos prod = findByCodigo(codigo);

        prod.setTipo(produtos.getTipo());
        prod.setName(produtos.getName());
        prod.setPreco(produtos.getPreco());
        prod.setQuantidadeEstoque(produtos.getQuantidadeEstoque());

        return repositorio.save(prod);
    }

}
