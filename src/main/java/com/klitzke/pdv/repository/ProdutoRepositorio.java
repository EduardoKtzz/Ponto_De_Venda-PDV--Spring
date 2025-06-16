package com.klitzke.pdv.repository;

import com.klitzke.pdv.domain.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio para criar os métodos que vão ser usando no Controller de produtos
@Repository
public interface ProdutoRepositorio extends JpaRepository<Produtos, Long> {
}
