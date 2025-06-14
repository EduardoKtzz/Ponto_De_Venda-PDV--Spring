package com.klitzke.pdv.repository;

import com.klitzke.pdv.domain.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produtos, Long> {
}
