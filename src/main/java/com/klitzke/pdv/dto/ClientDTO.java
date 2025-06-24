package com.klitzke.pdv.dto;

import com.klitzke.pdv.enums.Segmento;
import com.klitzke.pdv.enums.TipoPessoa;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    //Atributos
    @NotNull(message = "O tipo de pessoa é obrigatório.")
    private TipoPessoa tipoPessoa;

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
    private Integer CEP;

    @NotBlank(message = "O estado do cliente é obrigatório")
    private String estado;

    @NotBlank(message = "A cidade do cliente é obrigatório")
    private String cidade;

    @NotBlank(message = "O bairro do cliente é obrigatório")
    private String bairro;

    @NotBlank(message = "A rua do cliente é obrigatório")
    private String rua;

    private Integer numeroCasa;
    private String complemento;
    private String notificacoes;

    @NotNull(message = "O segmento do cliente é obrigatório")
    private Segmento segmento;

}
