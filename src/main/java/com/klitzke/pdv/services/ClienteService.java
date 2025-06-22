package com.klitzke.pdv.services;

import com.klitzke.pdv.domain.Client;
import com.klitzke.pdv.repository.ClienteRepositorio;
import com.klitzke.pdv.services.exception.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    //Atributos
    @Autowired
    private ClienteRepositorio repositorio;

    //Buscar todos os clientes
    public List<Client> findAll() {
        return repositorio.findAll();
    }

    //Buscar cliente por CPF/CNPJ
    public Client findByDocument(String document) {
        return repositorio.findByDocument(document).orElseThrow(() -> new RecursoNaoEncontradoException("Cliente: " + document + " não encontrado"));
    }

    //Metodo para buscar cliente por EMAIL
    public Optional<Client> findByEmail(String email) {
        return repositorio.findByEmail(email);
    }

    //Metodo para salvar um novo cliente
    public Client Insert(Client client) {
        return repositorio.save(client);
    }

    //Metodo para deletar usuários
    public void deletar(Long id) {
        if (!repositorio.existsById(id)) throw new RuntimeException("Erro, não encontramos o usuário: " + id);
        repositorio.deleteById(id);
    }

    //Metodo para atualizar usuários
    public Client atualizarCliente(Long id, Client client) {
        Client entidade = repositorio.findById(id).orElseThrow(() -> new RuntimeException("Não foi encontrado o cliente com id: " + id));

        entidade.setName(client.getName());
        entidade.setEmail(client.getEmail());
        entidade.setTelefone(client.getTelefone());
        entidade.setCEP(client.getCEP());
        entidade.setEstado(client.getEstado());
        entidade.setCidade(client.getCidade());
        entidade.setBairro(client.getBairro());
        entidade.setRua(client.getRua());
        entidade.setNumeroCasa(client.getNumeroCasa());
        entidade.setComplemento(client.getComplemento());
        entidade.setSegmento(client.getSegmento());

        return repositorio.save(entidade);
    }


}
