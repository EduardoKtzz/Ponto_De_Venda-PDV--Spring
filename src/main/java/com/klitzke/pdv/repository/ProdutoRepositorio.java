package com.klitzke.pdv.repository;

import com.klitzke.pdv.domain.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Repositorio para criar os métodos que vão ser usando no Controller de produtos
@Repository
public interface ProdutoRepositorio extends JpaRepository<Produtos, Long> {

    Optional<Produtos> findByCode(int codigo);
    Optional<Produtos> findByType(String tipo);
    Optional<Produtos> findByName(String nome);

}
