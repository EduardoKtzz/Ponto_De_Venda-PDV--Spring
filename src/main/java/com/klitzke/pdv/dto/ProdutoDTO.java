package com.klitzke.pdv.dto;

import jakarta.validation.constraints.DecimalMin;
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

    //Campo obrigatorio
    @NotBlank(message = "Digite o tipo de material.")
    private String tipoMaterial;

    //Campo obrigatorio
    @NotBlank(message = "O nome do material é obrigatório")
    private String name;

    //Campo obrigatorio e com valor minimo definido
    @DecimalMin(value = "0,01", message = "O valor precisa ser maior que zero")
    @NotNull(message = "O preco é obrigatório.")
    private BigDecimal preco;

}
