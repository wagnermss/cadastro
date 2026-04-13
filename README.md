# 🏠 API de Cadastro de Imóveis

Bem-vindo ao repositório da **API de Cadastro de Imóveis**! Esta é uma aplicação backend RESTful desenvolvida em Java utilizando o framework Spring Boot. O objetivo do sistema é gerenciar o cadastro e a listagem de imóveis, servindo dados para aplicações frontend (configurado com suporte a CORS para `http://localhost:4200`).

---

## 🛠️ Tecnologias Utilizadas

Este projeto foi desenvolvido com as seguintes tecnologias:

* **Java** (Versão 25)
* **Spring Boot** (v4.0.5)
* **Spring Data JPA** (Persistência de dados)
* **Spring Security** (Configurado para permitir acessos públicos aos endpoints)
* **H2 Database** (Banco de dados relacional em memória)
* **Lombok** (Redução de código boilerplate)
* **Maven** (Gerenciador de dependências via Maven Wrapper)

---

## ⚙️ Pré-requisitos

Antes de começar, você vai precisar ter a seguinte ferramenta instalada em sua máquina:
* JDK (Java Development Kit) 17 ou superior.

*Nota: Não é necessário ter o Maven instalado, pois o projeto utiliza o `Maven Wrapper` (`mvnw`).*

---

## 🚀 Como Executar o Projeto

Siga as etapas abaixo para rodar a aplicação no seu ambiente local:

### 1. Acesse a pasta do projeto
Abra o seu terminal e navegue até a pasta raiz do projeto (onde fica o arquivo `pom.xml`).

### 2. Execute a aplicação
Você pode rodar o projeto diretamente pelo terminal com os seguintes comandos:

**No Windows:**
> .\mvnw.cmd spring-boot:run

**No Linux ou Mac:**
> ./mvnw spring-boot:run

*(Se der erro de permissão no Linux/Mac, rode `chmod +x mvnw` antes).*

### 3. Aplicação Rodando
Aguarde a inicialização. A aplicação estará rodando na porta **8080**.

---

## 🗄️ Acesso ao Banco de Dados (H2 Console)

O projeto utiliza o banco de dados em memória H2. Você pode acessar a interface pelo navegador:

* **URL:** http://localhost:8080/h2-console
* **JDBC URL:** jdbc:h2:mem:imobiliariadb
* **User Name:** sa
* **Password:** *(deixe em branco)*

---

## 📡 Endpoints da API

A API possui os seguintes endpoints disponíveis na rota `/api/imoveis`:

### 1. Listar todos os imóveis (GET)
* **URL:** `http://localhost:8080/api/imoveis`
* **Método:** `GET`

### 2. Cadastrar um novo imóvel (POST)
* **URL:** `http://localhost:8080/api/imoveis`
* **Método:** `POST`
* **Corpo da Requisição (JSON):**

{
  "titulo": "Apartamento com Vista",
  "endereco": "Avenida Principal, 123",
  "bairro": "Centro",
  "zona": "Sul",
  "valor": 550000.00
}
