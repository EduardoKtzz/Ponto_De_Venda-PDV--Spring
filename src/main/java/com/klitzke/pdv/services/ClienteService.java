package com.klitzke.pdv.services;

import com.klitzke.pdv.domain.Client;
import com.klitzke.pdv.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    //Atributos
    @Autowired
    private ClienteRepositorio repositorio;

    //Buscar todos os clientes
    public List<Client> findAll() {
        return repositorio.findAll();
    }


}
