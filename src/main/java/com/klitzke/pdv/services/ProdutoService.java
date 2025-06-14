package com.klitzke.pdv.services;

import com.klitzke.pdv.domain.Produtos;
import com.klitzke.pdv.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    //Atributos
    @Autowired
    private ProdutoRepositorio repositorio;

    public List<Produtos> findAll() {
        return repositorio.findAll();
    }
}
