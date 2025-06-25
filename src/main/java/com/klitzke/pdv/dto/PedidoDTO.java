package com.klitzke.pdv.dto;

import lombok.*;
import java.util.List;

@Data // @Data já inclui @Getter, @Setter, toString(), equals() e hashCode().
public class PedidoDTO {

    //Atributos
    private String clienteDocument;
    private List<ItemDTO> itens;

    @Data
    public static class ItemDTO {
        private String produtoCodigo;
        private int quantidade;
    }
}
