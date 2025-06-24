# Sistema PDV - Ponto de Venda

Este projeto é um sistema de **Ponto de Venda (PDV)** desenvolvido com **Java e Spring Boot**, focado em simular as operações básicas de um sistema comercial: cadastro de clientes e produtos, controle de estoque e criação de pedidos com regras de negócio reais.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (para testes)
- Maven
- Lombok

---

## 🎯 Objetivo do projeto

Aplicar na prática os conhecimentos em desenvolvimento backend com foco em:

- Boas práticas REST
- Arquitetura em camadas (Controller, Service, Repository, Domain, DTO)
- Validações e regras de negócio
- Tratamento global de exceções
- Relacionamentos entre entidades (`@OneToMany`, `@ManyToOne`)
- Persistência com JPA

---

## 🧠 Funcionalidades

### 👤 Clientes
- Cadastro de cliente
- Consulta por ID, CPF ou CNPJ
- Atualização e remoção de registros

### 📦 Produtos
- Cadastro de produtos com código, nome, tipo, preço e estoque
- Atualização e consulta por código
- Controle de estoque básico

### 🛒 Pedidos
- Criação de pedidos com múltiplos itens
- Cálculo automático do valor total
- Associação com cliente e produtos

---

## ⚠️ Tratamento de erros

O sistema possui um `@RestControllerAdvice` que trata erros como:
- Recurso não encontrado (`404`)
- Dados inválidos (`400`)
- Violação de integridade (duplicidade, campos obrigatórios)

---

## 📌 Como executar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/EduardoKtzz/PDV-Spring.git

2. Execute a aplicação (PdvApplication.java).

3. Acesse o H2 Console (se estiver habilitado) ou utilize o Postman para testar as rotas.
