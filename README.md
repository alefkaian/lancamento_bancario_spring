# API de Lançamentos Bancários

Projeto de uma pequena API REST para lançamentos bancários usando Spring Boot. O usuário pode fazer lançamentos
bancários tanto de despesas
quanto de receitas para controle
financeiro e associá-los a pessoas e categorias específicas, que também são gerenciados por meio dos endpoints.

![Captura de tela da interface Swagger UI mostrando os endpoints]("https://github.com/user-attachments/assets/028c4af9-be4f-4ccc-a564-46758c759410")

## Tecnologias Utilizadas

* **Java:** Versão 21
* **Spring Boot** Versão 3.5.0
* **Banco de Dados:** H2 pronto para uso, MySQL disponível
* **Depdendências Chave:** Spring Web, Spring Data JPA, Spring Security, Lombok, Flyway, MySQL Connector, Auth0
  Java-JWT, SpringDoc OpenAPI (Swagger UI)
* **Ferramenta de Build:** Maven

## Configuração e Execução Local

### Pré-requisitos

* JDK - 21.0.8
* Maven

### Rodando via CLI

1. **Clone o repositório e acesse a pasta raíz do projeto:**

```bash
git clone https://github.com/alefkaian/lancamento_bancario_spring.git
cd lancamento_bancario_spring/API
```

2. **Execute a aplicação:**

```bash
mvn spring-boot:run
```

### Rodando via IDE

1. **Certifique-se de ter o plugin do Maven instalado na sua IDE**
2. **Abra a pasta do repositório na sua IDE:**

* A depender da IDE, vá em `File -> Open` ou `File -> Open Folder` e selecione a pasta raíz do repositório `lancamento_bancario_spring/`
3. **Execute o Arquivo Principal:**

* Localize a classe principal em lancamento_bancario_spring/ATM/src/main/java/AtmApplication.java
* Rode a classe com o botão `run` da sua IDE

A aplicação será iniciada e estará rodando em `http://localhost:8080`

## Principais Endpoints da API

| Método HTTP | Endpoint (URI)      | Descrição                                                 | Seguranca      |
|:-----------:|:--------------------|:----------------------------------------------------------|----------------|
|   `POST`    | `/cadastro`         | Cria um novo usuário no sistema.                          | **Público**    |
|   `POST`    | `/login`            | Rota para autenticação e obtenção do JWT.                 | **Público**    |
|   `POST`    | `/categorias`       | Cria uma nova categoria de lançamentos no sistema.        | **Bearer Key** |
|    `GET`    | `/categorias`       | Retorna uma lista paginada com as categorias cadastradas. | **Bearer Key** |
|   `POST`    | `/pessoas`          | Cria uma nova pessoa no sistema.                          | **Bearer Key** |
|    `GET`    | `/pessoas`          | Retorna uma lista paginada das pessoas cadastradas.       | **Bearer Key** |
|    `GET`    | `/pessoas/{id}`     | Retorna detalhes de uma pessoa específica.                | **Bearer Key** |
|   `POST`    | `/lancamentos`      | Cria um novo lançamento no sistema.                       | **Bearer Key** |
|    `GET`    | `/lancamentos`      | Retorna uma lista paginada dos lançamentos cadastrados.   | **Bearer Key** | 
|  `DELETE`   | `/lancamentos/{id}` | Remove um lançamento específico do sistema.               | **Bearer Key** |
|     ...     | ...                 | ...                                                       | ...            | 


### Documentação

A documentação completa está presente na interface do Swagger UI, em `http://localhost:8080/swagger-ui.html` após rodar a aplicação. 

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [License](LICENSE) para mais detalhes
