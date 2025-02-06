# E-commerce Service

Sistema básico de E-Commerce que permita o
cadastro de produtos, clientes e a realização de compras. Simula o funcionamento de uma loja virtual, com validações e manipulação de
dados.
## **Tecnologias Utilizadas**
- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## **Estrutura do Projeto**
O projeto segue uma arquitetura baseada em camadas, com as seguintes pastas principais:

- **`controller`**: Contém os endpoints REST para interagir com o sistema.
- **`service`**: Contém a lógica de negócios do sistema.
- **`repository`**: Contém a interface para comunicação com o banco de dados.
- **`model`**: Contém as entidades do sistema.
- **`dto`**: Contém os objetos de transferência de dados (Data Transfer Objects).
- **`exception`**: Contém as classes de exceção personalizadas.

## **Funcionalidades**

### **1 Cadastrar Cliente**
- Endpoint: `POST /clientes`
- Descrição: Cria um novo cliente no sistema.
- Requisição:
```json
{
  "nome": "João Silva",
  "cpf": "70451455002",
  "email": "joao.silva@example.com"
}
```
- Resposta:

````json
{
  "id": 1,
  "nome": "João Silva",
  "cpf": "70451455002",
  "email": "joao.silva@example.com"
}
````

### **2 Buscar Cliente por CPF**

- Endpoint: GET /clientes/{cpf}
- Descrição: Retorna os dados de um cliente pelo CPF.

- Resposta:

````json
{
  "id": 1,
  "nome": "João Silva",
  "cpf": "70451455002",
  "email": "joao.silva@example.com"
}
````

### **3 Atualizar Dados do Cliente**
- Endpoint: PUT /clientes/{cpf}
- Descrição: Atualiza os dados de um cliente pelo CPF.
- Requisição:
````json
{
  "nome": "Junior Santos",
  "cpf": "70451455002",
  "email": "joao.silva@example.com"
}
````
- Resposta:

````json
{
  "id": 1,
  "nome": "Junior Santos",
  "cpf": "70451455002",
  "email": "joao.silva@example.com"
}
````

### **4 Cadastrar Produto**
- Endpoint: `POST /produtos`
- Descrição: Cria um novo produto no sistema.
- Requisição:

```json
{
  "nome": "PC",
  "preco": 1000,
  "quantidade": 1
}
```

- Resposta:

```json
{
  "id": 1,
  "nome": "PC",
  "preco": 1000.0,
  "quantidade": 1
}
```
### **5 Listar Todos os Produtos**
- Endpoint: GET /produtos
- Descrição: Retorna uma lista de todos os produtos cadastrados.
- Resposta:

```json
[
  {
    "id": 1,
    "nome": "PC",
    "preco": 1000.0,
    "quantidade": 1
  }
]
```
### **6 Deletar Produto**
- Endpoint: DELETE /produtos/{id}
- Descrição: Deleta um produto pelo ID.
-  Resposta: 204 No Content

### **7 Realizar Compra**
- Endpoint: POST /compras
- Descrição: Permite que um cliente realize uma compra de produtos.
- Requisição:

````json
{
  "cpf": "70451455002",
  "produtos": [
    {"nome": "PC"}
  ]
}
````
- Resposta:

````
Compra realizada com sucesso!
````

## Swagger
O projeto possui o Swagger configurado para facilitar a documentação e o teste dos endpoints. Acesse a interface do Swagger em:

http://localhost:8080/swagger-ui.html

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone git@github.com:JorgeFVSz/ecommerce.git
   cd ecommerce
   ```

2. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
   ```
3. Acesse a aplicação no endereço:
   ```
   http://localhost:8080
   ```
