package com.klitzke.pdv.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.*;
import java.math.BigDecimal;

//Usando o Lombok para não repetir códigos, e definindo que essa classe vai fazer parte da tabela de produtos, e definindo o nome da tabela
@Entity
@Table(name = "tb_produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produtos {

    //Atributos
    //Definindo o tipo de 'ID' e como ele seja gerado
    //A terceira anotação define que vamos comparar o hackCode somente com o 'ID'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long id;

    @Column(unique = true, nullable = false)  //Definir coluna como unica, não pode ter repetição
    private String codigo;

    @Column(nullable = false)
    private String tipo;

    @Column(unique = true, nullable = false) //Definir coluna como unica, não pode ter repetição
    private String name;

    @Column(nullable = false)
    @DecimalMin(value = "0.1", message = "O valor precisa ser maior do que zero")
    private BigDecimal preco;

    @Column(nullable = false)
    @Min(value = 0, message = "O estoque não pode ser negativo")
    private int quantidadeEstoque;

    @Column(nullable = false)
    private String codigoDeBarras;

}
