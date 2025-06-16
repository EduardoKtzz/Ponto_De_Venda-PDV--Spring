package com.klitzke.pdv.repository;

import com.klitzke.pdv.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

//Repositorio para criar os métodos que vão ser usando no Controller de clientes
@Repository
public interface ClienteRepositorio extends JpaRepository<Client, Long> {

    Optional<Client> findByDocument(String document);
    Optional<Client> findByEmail(String email);

}
