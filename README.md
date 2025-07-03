# API de Gerenciamento de Produtos

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=spring)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-blue?style=for-the-badge&logo=swagger)

Uma API RESTful simples, construída com **Spring Boot**, para realizar operações de CRUD em uma entidade de `Produto`.

O projeto utiliza **Spring Data JPA** para persistência de dados com **PostgreSQL** e **Springdoc-OpenAPI** para gerar uma documentação interativa com Swagger UI, facilitando o teste e a visualização dos endpoints.

---

## 💻 Tecnologias Utilizadas

* **Java 21**: Linguagem de programação principal.
* **Spring Boot 3.x**: Framework para criação rápida de aplicações.
* **Spring Web**: Para construção dos endpoints RESTful.
* **Spring Data JPA / Hibernate**: Para persistência de dados.
* **PostgreSQL**: Banco de dados relacional.
* **Springdoc-OpenAPI**: Para geração automática da documentação Swagger.
* **Maven**: Gerenciador de dependências.

---

## ⚙️ Configuração do Ambiente

### Pré-requisitos

* JDK 21 instalado.
* Maven instalado.
* Uma instância do PostgreSQL em execução.

### Configuração do Banco de Dados

Antes de executar, é necessário configurar a conexão com o banco de dados no arquivo `src/main/resources/application.properties`.

Crie um banco de dados no seu PostgreSQL (ex: `meubanco`) e atualize as seguintes propriedades com suas credenciais:

```properties
# Configuração da Conexão com o PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/meubanco
spring.datasource.username=seu_usuario_aqui
spring.datasource.password=sua_senha_aqui
spring.datasource.driver-class-name=org.postgresql.Driver

# Configuração do Hibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Configuração do Swagger UI
springdoc.swagger-ui.path=/documentacao
springdoc.group-configs.enabled=true

## ▶️ Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/Gabriel-Gravena/crud-produtos.git
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd crud-produto
    ```

3.  **Configure o arquivo `application.properties`** conforme a seção anterior.

4.  **Execute a aplicação com o Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```

5.  A API estará disponível em `http://localhost:8080`.

---

## 📖 Documentação da API (Swagger)

Com a aplicação em execução, a documentação interativa gerada pelo Swagger pode ser acessada através da seguinte URL customizada:

* `http://localhost:8080/documentacao`

Lá, você pode visualizar todos os endpoints em detalhes, seus modelos de dados e executá-los diretamente pelo navegador.

---

## 🗺️ Endpoints Disponíveis

A URL base para todos os endpoints é `/api/produtos`.

| Método HTTP | Endpoint    | Descrição                                          | Corpo da Requisição (Exemplo)                      |
| :---------- | :---------- | :--------------------------------------------------- | :------------------------------------------------- |
| `GET`       | `/`         | Retorna uma lista com todos os produtos cadastrados. | N/A                                                |
| `GET`       | `/{id}`     | Retorna um produto específico a partir do seu ID.    | N/A                                                |
| `POST`      | `/`         | Salva um novo produto no banco de dados.             | `{ "nome": "Teclado Mecânico", "preco": 350.0 }` |
| `DELETE`    | `/{id}`     | Remove um produto do banco de dados a partir do seu ID. | N/A                                                |

---

## 🚀 Próximos Passos e Melhorias (Roadmap)

Este projeto é uma base sólida, mas está em constante evolução. As próximas funcionalidades planejadas para torná-lo mais robusto e completo incluem:

-   [ ] **Validação de Dados:** Implementar validações para os dados de entrada (ex: nome não pode ser nulo, preço deve ser positivo).
-   [ ] **Tratamento de Exceções:** Criar um handler global para exceções, padronizando as respostas de erro da API.
-   [ ] **Endpoint de Atualização:** Adicionar a operação de `PUT` ou `PATCH` para atualizar produtos existentes.
-   [ ] **Paginação e Ordenação:** Melhorar o endpoint de listagem para suportar paginação e ordenação dos resultados.
-   [ ] **Segurança:** Implementar segurança nos endpoints usando Spring Security e JWT.
-   [ ] **Uso de DTOs:** Adotar o padrão DTO (Data Transfer Object) para desacoplar a API da entidade de persistência.
