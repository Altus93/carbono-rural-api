# Carbono Rural API

API REST desenvolvida com Spring Boot para gerenciamento de animais no contexto de cálculo de emissões de carbono rural.

---

# Descrição

Este projeto implementa um CRUD completo (Create, Read, Update, Delete) para a entidade Animal, permitindo:

* Cadastrar animais
* Listar animais
* Buscar por ID
* Atualizar informações
* Remover registros

A aplicação utiliza:

* Java 17
* Spring Boot
* Spring Data JPA
* Banco H2 (em memória)
* Docker

---

# Tecnologias utilizadas

* Java 17
* Spring Boot
* Maven
* JPA / Hibernate
* H2 Database
* Docker

---

# Como executar o projeto

Pré-requisitos:

* Docker instalado

Passo a passo:

1. Gerar o .jar

bash
./mvnw clean package


2. Build da imagem Docker

bash
docker build -t carbono-api .

3. Rodar o container

bash
docker run -p 8080:8080 carbono-api

A aplicação estará disponível em:

http://localhost:8080 (abrir no navegador web)

---

# Endpoints da API

1. Criar animal

http
POST /animais
Content-Type: application/json

json
{
  "nome": "Vaca",
  "especie": "Bovino"
}


2. Listar animais

http
GET /animais


3. Buscar por ID

http
GET /animais/{id}

4. Atualizar animal

http
PUT /animais/{id}
Content-Type: application/json


json
{
  "nome": "Vaca Atualizada",
  "especie": "Bovino Premium"
}



5. Deletar animal

http
DELETE /animais/{id}


---

# Banco de dados

A aplicação utiliza o banco H2 em memória, ou seja:

* Os dados são apagados ao reiniciar a aplicação
* Ideal para testes e desenvolvimento

---

# Console do H2

Acesse:


http://localhost:8080/h2-console


# Configurações:


JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (vazio)


---

# Estrutura do projeto


src/main/java/com/carbonorural/carbonoruralapi
├── controller
├── service
├── repository
├── model



# Observações

* A aplicação roda dentro de um container Docker
* Não é necessário instalar Java na máquina para execução (apenas Docker)
* O banco H2 é reiniciado a cada execução

---

# Status do projeto

* API REST funcional
* CRUD completo
* Persistência com JPA
* Containerização com Docker

---

# Autor

Lucas Kieffer Leal
RM 567193
Análise e Desenvolvimento de Sistemas (On-Line)
Fase 6 - DevOps