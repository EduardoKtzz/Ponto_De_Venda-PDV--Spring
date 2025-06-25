package com.klitzke.pdv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    //Atributos
    @NotBlank(message = "O codigo do material obrigatório")
    private String codigo;

    @NotBlank(message = "Digite o tipo de material.")
    private String tipoMaterial;

    @NotBlank(message = "O nome do material é obrigatório")
    private String name;

    @NotNull(message = "O preco é obrigatório.")
    private BigDecimal preco;

}
