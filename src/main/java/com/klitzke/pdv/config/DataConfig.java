package com.klitzke.pdv.config;

import com.klitzke.pdv.domain.Client;
import com.klitzke.pdv.domain.Produtos;
import com.klitzke.pdv.enums.Segmento;
import com.klitzke.pdv.enums.TipoPessoa;
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
            // Clientes para ser usado de teste, com o seguimento deles
            clienteRepositorio.save(new Client(null, "12345678900", "João da Silva", "joao@email.com", "12/12/2004", "27999999999", 29160123, "ES", "Serra", "Carapina Grande", "Antonio Rangel", 98, "portão azul", null, "Deseja receber notificações", Segmento.CLIENTE_FINAL, TipoPessoa.Pessoa_Fisica_PF));
            clienteRepositorio.save(new Client(null, "12345678922232322", "Pedro Silva", "joo@email.com", "12/12/2004", "27999999999", 29160123, "ES", "Serra", "Carapina Grande", "Antonio Rangel", 98, "portão azul", null, "Não deseja receber notificações", Segmento.PROFISSIONAL, TipoPessoa.Pessoa_Juridica_PJ));
            clienteRepositorio.save(new Client(null, "12345678933", "Bernado da Silva", "joa@email.com", "12/12/2004", "27999999999", 29160123, "ES", "Serra", "Carapina Grande", "Antonio Rangel", 98, "portão azul", null, "Deseja receber notificações", Segmento.COLABORADOR, TipoPessoa.Pessoa_Fisica_PF));
            clienteRepositorio.save(new Client(null, "12345678933", "Bernado da Silva", "joa@email.com", "12/12/2004", "27999999999", 29160123, "ES", "Serra", "Carapina Grande", "Antonio Rangel", 98, "portão azul", null, "Deseja receber notificações", Segmento.COLABORADOR, TipoPessoa.Pessoa_Fisica_PF));
            clienteRepositorio.save(new Client(null, "12345678933", "Bernado da Silva", "joa@email.com", "12/12/2004", "27999999999", 29160123, "ES", "Serra", "Carapina Grande", "Antonio Rangel", 98, "portão azul", null, "Deseja receber notificações", Segmento.COLABORADOR, TipoPessoa.Pessoa_Fisica_PF));
            clienteRepositorio.save(new Client(null, "12345678933", "Bernado da Silva", "joa@email.com", "12/12/2004", "27999999999", 29160123, "ES", "Serra", "Carapina Grande", "Antonio Rangel", 98, "portão azul", null, "Deseja receber notificações", Segmento.COLABORADOR, TipoPessoa.Pessoa_Fisica_PF));
            clienteRepositorio.save(new Client(null, "12345678933", "Bernado da Silva", "joa@email.com", "12/12/2004", "27999999999", 29160123, "ES", "Serra", "Carapina Grande", "Antonio Rangel", 98, "portão azul", null, "Deseja receber notificações", Segmento.COLABORADOR, TipoPessoa.Pessoa_Fisica_PF));



            // Produtos para ser usados como teste
            produtoRepositorio.save(new Produtos(null, "9888", "HAWA", "Stick", new BigDecimal("49.90"), 100, "2834728284828"));
            produtoRepositorio.save(new Produtos(null, "9923", "FERT", "Protetor Solar", new BigDecimal("199.90"), 50, "2834728284828"));
            produtoRepositorio.save(new Produtos(null, "7362", "HALB", "Sabonete1", new BigDecimal("299.00"), 20, "2834728284828"));
            produtoRepositorio.save(new Produtos(null, "7362", "HALB", "Sabonete1", new BigDecimal("299.00"), 20, "2834728284828"));
            produtoRepositorio.save(new Produtos(null, "7362", "HALB", "Sabonete1", new BigDecimal("299.00"), 20, "2834728284828"));
            produtoRepositorio.save(new Produtos(null, "7362", "HALB", "Sabonete1", new BigDecimal("299.00"), 20, "2834728284828"));
            produtoRepositorio.save(new Produtos(null, "7362", "HALB", "Sabonete1", new BigDecimal("299.00"), 20, "2834728284828"));


        };
    }
}
