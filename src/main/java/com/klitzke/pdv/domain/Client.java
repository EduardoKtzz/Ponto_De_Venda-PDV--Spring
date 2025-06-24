package com.klitzke.pdv.domain;

import com.klitzke.pdv.enums.Segmento;
import com.klitzke.pdv.enums.tipoPessoa;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    @Column(nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)  //Definir coluna como unica, não pode ter repetição=
    private String document;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String dataDeNascimento;
    private String telefone;

    @Column(nullable = false)
    private Integer CEP;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String rua;

    private Integer numeroCasa;
    private String complemento;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    private String notificacoes;

    //Associações e anotação para definir o tipo de ENUM
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)  //EnumType.‘STRING’ é mais seguro, pois evita problemas quando a ordem do enum mudar.
    private Segmento segmento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private tipoPessoa tipoPessoa;

}
