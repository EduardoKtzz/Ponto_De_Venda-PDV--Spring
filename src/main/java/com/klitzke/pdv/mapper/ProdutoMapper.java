package com.klitzke.pdv.mapper;

import com.klitzke.pdv.domain.Produtos;
import com.klitzke.pdv.dto.ProdutoDTO;

public class ProdutoMapper {

    // Converte de DTO para Entidade
    public static Produtos toEntity(ProdutoDTO dto) {
        Produtos produto = new Produtos();
        produto.setCodigo(dto.getCodigo()); // converte String para int
        produto.setTipo(dto.getTipoMaterial());
        produto.setName(dto.getName());
        produto.setPreco(dto.getPreco());
        produto.setQuantidadeEstoque(dto.getQuantidadeEstoque()); // valor inicial padrão
        produto.setCodigoDeBarras(dto.getCodigoDeBarras());
        return produto;
    }

    // Converte de Entidade para DTO
    public static ProdutoDTO toDTO(Produtos produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setCodigo(String.valueOf(produto.getCodigo())); // converte int para String
        dto.setTipoMaterial(produto.getTipo());
        dto.setName(produto.getName());
        dto.setPreco(produto.getPreco());
        dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        return dto;
    }
}

