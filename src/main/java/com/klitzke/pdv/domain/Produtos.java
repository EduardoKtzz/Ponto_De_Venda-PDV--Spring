package com.klitzke.pdv.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produtos {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long id;
    private String name;
    private Double preco;
    private int quantidadeEstoque;

}
