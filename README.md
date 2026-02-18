# 🚀 API de Gestão de Clientes com Spring Boot & Design Patterns

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

> Projeto desenvolvido como desafio do Bootcamp da **DIO (Digital Innovation One)**, focado na aplicação prática de Padrões de Projeto (Design Patterns) utilizando o ecossistema Spring.

## 🎯 Objetivo do Projeto

O objetivo inicial era explorar os padrões **Singleton**, **Strategy** e **Facade**. No entanto, este projeto foi **evoluído** para simular um cenário real de mercado (Enterprise Ready), implementando boas práticas de arquitetura, tratamento de erros e segurança de dados.

A aplicação permite o cadastro de clientes e **integração automática com a API do ViaCEP** para preenchimento de endereços.

## 🛠 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3**
* **Spring Data JPA** (Persistência)
* **H2 Database** (Banco em memória para testes rápidos)
* **OpenFeign** (Consumo da API externa ViaCEP)
* **ModelMapper** (Mapeamento inteligente entre Entity e DTO)
* **SpringDoc OpenAPI** (Documentação automática com Swagger)

## ✨ Diferenciais e Melhorias Implementadas

Além do escopo básico do desafio, foram adicionadas as seguintes implementações profissionais:

1.  **Padrão DTO (Data Transfer Object):**
    * Separação completa entre a camada de persistência (Entity) e a camada de apresentação (JSON).
    * Proteção contra *Mass Assignment* e vazamento de dados sensíveis.
2.  **Global Exception Handling:**
    * Tratamento centralizado de erros com `@RestControllerAdvice`.
    * Retorno de mensagens amigáveis (JSON padronizado) para erros 404 (Recurso não encontrado) e 500 (Erro interno).
3.  **ModelMapper:**
    * Automatização da conversão de objetos, evitando código repetitivo de `get/set` nos Controllers.
4.  **Clean Controller:**
    * Os controladores não possuem regras de negócio, apenas delegam chamadas para os serviços.

## 🔌 Endpoints da API

A documentação completa pode ser acessada via Swagger UI após rodar o projeto:
`http://localhost:8080/swagger-ui/index.html`

### Exemplos de Requisição

#### 1. Criar Cliente (POST)
**URL:** `/clientes`
**Body:**
```json
{
  "nome": "Moisés",
  "cep": "01001000",
  "numero": "123"
}
```
#### 2. Resposta de Sucesso (200 OK)
O sistema consulta o ViaCEP e retorna o endereço enriquecido, com o número inserido corretamente no objeto de endereço:
```json
{
  "nome": "Moisés",
  "endereco": {
    "logradouro": "Praça da Sé",
    "bairro": "Sé",
    "localidade": "São Paulo",
    "uf": "SP",
    "cep": "01001-000",
    "numero": "123"
  }
}
```
#### 3. Tratamento de Erro (404 Not Found)
Caso tente buscar um ID inexistente, a API retorna um erro tratado e amigável, em vez de um erro genérico:

```json
{
  "timestamp": "2026-02-17T20:30:00",
  "status": 404,
  "error": "Recurso não encontrado",
  "message": "Cliente não encontrado com o ID: 99",
  "path": "/clientes/99"
}
```
## 🚀 Como Executar

### Pré-requisitos
* **Java 17** ou superior.
* **Maven** instalado.

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/moiseslemosz/dio-gof.git
    ```

2.  **Entre na pasta do projeto:**
    ```bash
    cd nome-do-repo
    ```

3.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```

4.  **Acesse a Documentação (Swagger):**
    Abra o seu navegador e acesse:
    [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 👨‍💻 Autor

Desenvolvido por **Moisés Lemos**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/moises-lemos-dev)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/moiseslemosz)
