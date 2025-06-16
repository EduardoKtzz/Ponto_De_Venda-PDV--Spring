package com.klitzke.pdv.config;

import com.klitzke.pdv.domain.Client;
import com.klitzke.pdv.domain.Produtos;
import com.klitzke.pdv.enums.Segmento;
import com.klitzke.pdv.repository.ClienteRepositorio;
import com.klitzke.pdv.repository.ProdutoRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataConfig {

    @Bean
    public CommandLineRunner carregarDados(ClienteRepositorio clienteRepositorio, ProdutoRepositorio produtoRepositorio) {
        return args -> {
            // Clientes para ser usado de teste, com o seguimentos deles
            clienteRepositorio.save(new Client(null, "12345678900", "João da Silva", "joao@email.com", "27999999999", Segmento.CLIENTE_FINAL));
            clienteRepositorio.save(new Client(null, "98765432100", "Maria Oliveira", "maria@email.com", "27988888888", Segmento.COLABORADOR));
            clienteRepositorio.save(new Client(null, "45678912300", "Carlos Lima", "carlos@email.com", "27987777777", Segmento.PROFISSIONAL));

            // Produtos para ser usados como teste
            produtoRepositorio.save(new Produtos(null, "Stick", new BigDecimal("49.90"), 100));
            produtoRepositorio.save(new Produtos(null, "Protetor Solar", new BigDecimal("199.90"), 50));
            produtoRepositorio.save(new Produtos(null, "Sabonete", new BigDecimal("299.00"), 20));
        };
    }
}
