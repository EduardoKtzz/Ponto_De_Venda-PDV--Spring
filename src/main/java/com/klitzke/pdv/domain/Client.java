package com.klitzke.pdv.domain;

import com.klitzke.pdv.enums.Segmento;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long id;
    private String document;
    private String name;
    private String email;
    private String numero;

    //Associações
    @Enumerated(EnumType.STRING)  //EnumType.‘STRING’ é mais seguro, pois evita problemas quando a ordem do enum mudar.
    private Segmento segmento;

}
