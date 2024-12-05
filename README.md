# USTJCars
Projeto A3 - Final primeiro semestre (CRUD)
# CRUD em Java

Este é um projeto básico de CRUD (Create, Read, Update, Delete) de uma empresa Locadora de veículos fictícia desenvolvido em Java com conexão ao banco de dados MySQL. Ele pode ser usado como base para aplicações que necessitam de operações básicas de gerenciamento de dados.

## Funcionalidades

- *Create*: Adicionar novos registros.
- *Read*: Consultar registros existentes.
- *Update*: Atualizar registros existentes.
- *Delete*: Excluir registros.

## Tecnologias Utilizadas

- *Linguagem*: Java 21 ou superior
- *Banco de Dados*: MySQL
- *Bibliotecas*:
  - JDBC (Java Database Connectivity)

## Requisitos

- Java Development Kit (JDK) 21 ou superior
- IDE para desenvolvimento Java (Eclipse, IntelliJ IDEA, etc.)
- Servidor de banco de dados MySQL

## Configuração do Projeto

1. Configure o banco de dados:

   - Execute o seguinte script SQL no seu servidor de banco de dados para configurar o ambiente:
     sql
     CREATE DATABASE IF NOT EXISTS locadora;

     USE locadora;

     CREATE TABLE IF NOT EXISTS veiculos (
         marca VARCHAR(50) NOT NULL,
         modelo VARCHAR(50) NOT NULL,
         ano INT NOT NULL,
         cor VARCHAR(30),
         placa VARCHAR(10) UNIQUE PRIMARY KEY,
         quilometragem INT,
         preco_diaria DOUBLE(10, 2),
         disponivel VARCHAR(10),
         categoria VARCHAR(30),
         descricao VARCHAR(300)
     );
     
   - Atualize as credenciais de conexão no arquivo ConexaoBD.java.

2. Compile e execute o projeto:

   - Importe o projeto em sua IDE.
   - Certifique-se de que as dependências estão configuradas corretamente.
   - Execute a classe principal.

## Estrutura do Projeto

- *src*: Contém os arquivos fonte do projeto.
  - *model*: Classes de modelo que representam as entidades do banco de dados.
  - *controllers*: Classes que implementam a lógica de negócios.
  - *view*: Classes para interação com o usuário (linha de comando ou interface gráfica).
  - *DAO*: Classes auxiliares, como conexão com o banco de dados.

## Como Usar

1. Execute o programa via main.
2. Navegue pelo menu para criar, visualizar, atualizar ou excluir registros.
3. As operações serão refletidas diretamente no banco de dados.

---
