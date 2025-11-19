# Prática 09 - Documentação e Hospedagem

## Descrição do Projeto

Este projeto é uma aplicação **Spring Boot** que implementa um **CRUD (Create, Read, Update, Delete)** completo para duas entidades relacionadas: `Documento` e `Categoria`. O objetivo principal é demonstrar a implementação de um relacionamento **One-to-Many** (`Categoria` para `Documento`) e a correta configuração da documentação da API utilizando **Swagger/OpenAPI**.

A aplicação utiliza **Spring Data JPA** com um banco de dados **H2 em memória** para persistência, sendo ideal para demonstrações e testes.

## Requisitos Atendidos

*   **🛠 Entidades Relacionadas:** `Documento` (ManyToOne) e `Categoria` (OneToMany).
*   **CRUD Completo:** Implementado para ambas as entidades via `RestController`.
*   **Persistência:** Utiliza Spring Data JPA.
*   **Documentação da API:** Configurada com `springdoc-openapi-starter-webmvc-ui` (Swagger).
*   **Hospedagem:** Simulação de deploy no Render.
*   **Versionamento:** Estrutura de código pronta para ser versionada no GitHub.

## Passos para Execução Local

Para executar a aplicação localmente, você precisará ter o **Java 17** (ou superior) e o **Maven** instalados.

1.  **Clone o Repositório:**
    ```bash
    git clone https://github.com/seu-usuario/pratica-hospedagem.git
    cd pratica-hospedagem
    ```

2.  **Compile e Execute:**
    ```bash
    ./mvnw spring-boot:run
    ```
    *A aplicação será iniciada na porta `8080`.*

## Endpoints da API

A API expõe os seguintes endpoints:

| Entidade | Método | Endpoint | Descrição |
| :--- | :--- | :--- | :--- |
| **Categoria** | `GET` | `/api/categorias` | Lista todas as categorias. |
| **Categoria** | `GET` | `/api/categorias/{id}` | Busca uma categoria por ID. |
| **Categoria** | `POST` | `/api/categorias` | Cria uma nova categoria. |
| **Categoria** | `PUT` | `/api/categorias/{id}` | Atualiza uma categoria existente. |
| **Categoria** | `DELETE` | `/api/categorias/{id}` | Deleta uma categoria. |
| **Documento** | `GET` | `/api/documentos` | Lista todos os documentos. |
| **Documento** | `GET` | `/api/documentos/{id}` | Busca um documento por ID. |
| **Documento** | `POST` | `/api/documentos` | Cria um novo documento (requer `categoriaId`). |
| **Documento** | `PUT` | `/api/documentos/{id}` | Atualiza um documento existente. |
| **Documento** | `DELETE` | `/api/documentos/{id}` | Deleta um documento. |


### Como Acessar e Usar a Documentação

1.  **Acesso:** Após iniciar a aplicação (localmente ou no Render), acesse o link do Swagger UI.
2.  **Visualização:** A página exibirá todos os *controllers* (`CategoriaController` e `DocumentoController`) e seus respectivos *endpoints* (GET, POST, PUT, DELETE).
3.  **Teste:** Clique em qualquer endpoint para expandir. Você pode clicar em **"Try it out"** para enviar requisições diretamente do navegador e testar a API em tempo real.
