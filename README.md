# API de Gerenciamento de Produtos

![Java](https://img.shields.io/badge/Java-21+-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=spring)
![JPA](https://img.shields.io/badge/JPA%2FHibernate-orange?style=for-the-badge&logo=hibernate)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-blue?style=for-the-badge&logo=swagger)

Uma API RESTful simples, construída com **Spring Boot**, para realizar operações de CRUD (Criar, Ler, Deletar) em uma entidade de `Produto`.

O projeto utiliza **Spring Data JPA** para persistência de dados e **Springdoc-OpenAPI** para gerar uma documentação interativa com Swagger UI, facilitando o teste e a visualização dos endpoints.

***

## 💻 Tecnologias Utilizadas

* **Java 21**: Linguagem de programação principal.
* **Spring Boot 3.x**: Framework para criação rápida de aplicações.
* **Spring Web**: Para construção dos endpoints RESTful.
* **Spring Data JPA**: Para persistência de dados de forma simplificada.
* **Hibernate**: Implementação padrão do JPA.
* **H2 Database** (ou outro de sua preferência): Banco de dados em memória para desenvolvimento e testes.
* **Springdoc-OpenAPI**: Para geração automática da documentação Swagger.
* **Maven**: Gerenciador de dependências.

***

## ▶️ Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/Gabriel-Gravena/crud-produtos.git
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd crud-produto
    ```

3.  **Execute a aplicação com o Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```

4.  A API estará disponível em `http://localhost:8080`.

***

## 📖 Documentação da API (Swagger)

Com a aplicação em execução, a documentação interativa gerada pelo Swagger pode ser acessada através da seguinte URL:

* **`http://localhost:8080/swagger-ui.html`**

Lá, você pode visualizar todos os endpoints em detalhes e executá-los diretamente pelo navegador.

***

## Endpoints Disponíveis

A URL base para todos os endpoints é **`/api/produtos`**.

(A lista de endpoints que já fizemos entra aqui...)

***

## 🚀 Próximos Passos e Melhorias (Roadmap)

Este projeto é uma base sólida, mas está em constante evolução. As próximas funcionalidades planejadas para torná-lo mais robusto e completo incluem:

- [ ] **Validação de Dados:** Implementar validações para os dados de entrada (ex: nome não pode ser nulo, preço deve ser positivo).
- [ ] **Tratamento de Exceções:** Criar um handler global para exceções, padronizando as respostas de erro da API.
- [ ] **Endpoint de Atualização:** Adicionar a operação de `PUT` ou `PATCH` para atualizar produtos existentes.
- [ ] **Paginação e Ordenação:** Melhorar o endpoint de listagem para suportar paginação e ordenação dos resultados.
- [ ] **Segurança:** Implementar segurança nos endpoints usando Spring Security e JWT.
- [ ] **Uso de DTOs:** Adotar o padrão DTO (Data Transfer Object) para desacoplar a API da entidade de persistência.
