package com.klitzke.pdv.repository;

import com.klitzke.pdv.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Client, Long> {

}
