
# btgtest-Final Sistema de Contas Digitais - Documentação

Este é um sistema de contas digitais que visa armazenar informações de clientes, contas e movimentações financeiras, permitindo o gerenciamento e consulta desses dados.

## Funcionalidades

O sistema possui as seguintes funcionalidades:

- Cadastro e atualização de contas e clientes.
- Cadastro de movimentações financeiras (depósitos e saques).
- Consulta de informações de contas e clientes.
- Consulta de movimentações de uma conta específica.

## Estrutura do Banco de Dados

O banco de dados do sistema é modelado com as seguintes entidades:

- **Cliente:** Armazena informações dos clientes.
- **Conta:** Armazena informações das contas associadas aos clientes.
- **Movimentação:** Armazena informações das movimentações financeiras (depósitos e saques).

## Diagrama Entidade Relacionamento (ERD)

Abaixo está o Diagrama Entidade-Relacionamento que representa a estrutura das entidades e seus relacionamentos no banco de dados padrão UML:

![Diagrama ERD](https://github.com/Mateuslll/images/raw/main/Uml_btg_DataBase.png)

## Scripts DDL e DML

Os scripts SQL DDL (Data Definition Language) e DML (Data Manipulation Language) para criação das tabelas e inserção de dados podem ser encontrados no arquivo `SQL_BTG.sql`.

## Banco de Dados e Ferramenta

Foram empregadas as seguintes versões em meu ambiente: MySql Workbench 8.0.34 (arquitetura 64x), MySql Server 8.0.34 (arquitetura 64x) e Connector/J 8.0.33 (arquitetura 84x).

## API

A API oferece endpoints para interagir com o sistema de contas digitais:

### Cadastro/atualização de conta/cliente

- **POST /clientes:** Cria um novo cliente.
- **PUT /clientes/{id}:** Atualiza os dados de um cliente existente.

- **POST /contas:** Cria uma nova conta associada a um cliente.
- **PUT /contas/{id}:** Atualiza os dados de uma conta existente.

### Cadastro de movimentações

- **POST /movimentacoes:** Registra uma nova movimentação financeira (depósito ou saque) em uma conta.

### Consulta por conta/cliente

- **GET /clientes/{id}:** Retorna os dados de um cliente pelo seu ID.
- **GET /contas/{id}:** Retorna os dados de uma conta pelo seu ID.

### Consulta por movimentações de uma conta

- **GET /movimentacoes/conta/{id}:** Retorna as movimentações financeiras de uma conta pelo seu ID.
