package com.klitzke.pdv.domain;

import com.klitzke.pdv.enums.Segmento;
import jakarta.persistence.*;
import lombok.*;

//Usando o Lombok para não repetir códigos, e definindo que essa classe vai fazer parte da tabela de clientes, e definindo o nome da tabela
@Entity
@Table(name = "tb_clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {

    //Atributos
    //Definindo o tipo de 'ID' e como ele seja gerado
    //A terceira anotação define que vamos comparar o hackCode somente com o 'ID'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long id;

    @Column(unique = true)  //Definir coluna como unica, não pode ter repetição
    private String document;
    private String name;
    private String email;
    private String numero;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String complemento;
    private int numeroCasa;
    private int CEP;

    //Associações e anotação para definir o tipo de ENUM
    @Enumerated(EnumType.STRING)  //EnumType.‘STRING’ é mais seguro, pois evita problemas quando a ordem do enum mudar.
    private Segmento segmento;

}
