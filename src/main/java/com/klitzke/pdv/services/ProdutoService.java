package com.klitzke.pdv.services;

import com.klitzke.pdv.domain.Produtos;
import com.klitzke.pdv.repository.ProdutoRepositorio;
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
    public Optional<Produtos> findByCodigo(int codigo) {
        return repositorio.findByCodigo(codigo);
    }

    //Buscar todos pelo TIPO de material
    public List<Produtos> findByTipo(String tipo) {
        List<Produtos> produtos = repositorio.findByTipo(tipo);

        if (produtos.isEmpty()) {
            throw new RuntimeException("Nenhum material encontrado!");
        }
        return produtos;
    }

}
