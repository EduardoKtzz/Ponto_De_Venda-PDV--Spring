package com.klitzke.pdv.dto;

import com.klitzke.pdv.enums.Segmento;
import com.klitzke.pdv.enums.tipoPessoa;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClientDTO {

    //Atributos
    @NotNull(message = "O tipo de pessoa é obrigatório.")
    private tipoPessoa tipoPessoa;

    @NotBlank(message = "O documento (CPF/CNPJ) é obrigatório.")
    private String document;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "O email do cliente é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    private String dataDeNascimento;

    private String telefone;

    @NotNull(message = "O CEP do cliente é obrigatório")
    private int CEP;

    @NotBlank(message = "O estado do cliente é obrigatório")
    private String estado;

    @NotBlank(message = "A cidade do cliente é obrigatório")
    private String cidade;

    @NotBlank(message = "O bairro do cliente é obrigatório")
    private String bairro;

    @NotBlank(message = "A rua do cliente é obrigatório")
    private String rua;

    private int numeroCasa;
    private String complemento;
    private String notificacoes;

    @NotNull(message = "O segmento do cliente é obrigatório")
    private Segmento segmento;

    public ClientDTO(tipoPessoa tipoPessoa, String name, String document, String email, String dataDeNascimento, String telefone, Segmento segmento, int CEP, String rua, String bairro, String cidade, int numeroCasa, String estado, String complemento, String notificacoes) {
        this.tipoPessoa = tipoPessoa;
        this.name = name;
        this.document = document;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
        this.segmento = segmento;
        this.CEP = CEP;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numeroCasa = numeroCasa;
        this.estado = estado;
        this.complemento = complemento;
        this.notificacoes = notificacoes;
    }
}
