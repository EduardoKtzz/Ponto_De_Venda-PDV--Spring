package com.klitzke.pdv.mapper;

import com.klitzke.pdv.domain.Client;
import com.klitzke.pdv.dto.ClientDTO;

    public class ClientMapper {

        public static Client toEntity(ClientDTO dto) {
            Client client = new Client();
            client.setName(dto.getName());
            client.setEmail(dto.getEmail());
            client.setDocument(dto.getDocument());
            client.setDataDeNascimento(dto.getDataDeNascimento());
            client.setTelefone(dto.getTelefone());
            client.setCEP(dto.getCEP());
            client.setEstado(dto.getEstado());
            client.setCidade(dto.getCidade());
            client.setBairro(dto.getBairro());
            client.setRua(dto.getRua());
            client.setNumeroCasa(dto.getNumeroCasa());
            client.setComplemento(dto.getComplemento());
            client.setNotificacoes(dto.getNotificacoes());
            client.setSegmento(dto.getSegmento());
            client.setTipoPessoa(dto.getTipoPessoa());
            return client;
        }
    }

