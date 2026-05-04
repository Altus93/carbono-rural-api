# Carbono Rural API

API REST desenvolvida com Spring Boot para gerenciamento de animais em um cenário de cálculo de emissões de carbono rural.

---

## Descrição

O projeto implementa um CRUD completo para a entidade **Animal**, permitindo:

- Cadastrar animais
- Listar todos os registros
- Buscar por ID
- Atualizar dados
- Remover registros

A aplicação segue a arquitetura padrão em camadas (controller, service, repository, model) e utiliza persistência com JPA.

---

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- PostgreSQL
- Docker
- GitHub Actions (CI)

---

## Como executar o projeto

### Pré-requisitos

- Docker instalado

### Execução com Docker Compose

```bash
docker-compose up --build
A aplicação estará disponível em:

http://localhost:8080
Endpoints da API
Criar animal
POST /animais
Content-Type: application/json
{
  "nome": "Vaca",
  "especie": "Bovino"
}
Listar animais
GET /animais
Buscar por ID
GET /animais/{id}
Atualizar animal
PUT /animais/{id}
Content-Type: application/json
{
  "nome": "Vaca Atualizada",
  "especie": "Bovino Premium"
}
Deletar animal
DELETE /animais/{id}
Banco de dados
A aplicação utiliza PostgreSQL via Docker:

Porta: 5432

Database: carbono

Usuário: postgres

Senha: postgres

Estrutura do projeto
src/main/java/com/carbonorural/carbonoruralapi
├── controller
├── service
├── repository
├── model

CI (GitHub Actions)

Este projeto possui um pipeline de Integração Contínua configurado com GitHub Actions.

O pipeline é executado automaticamente quando há:

push na branch main
pull request para main
Etapas do CI:
Checkout do código
Validação básica do repositório

O status pode ser visualizado na aba Actions do repositório.

Observações
A aplicação é executada em container Docker

O banco de dados é provisionado automaticamente via Docker Compose

Não é necessário instalar Java localmente para execução

Status do projeto
API REST funcional

CRUD completo implementado

Integração com banco relacional

Containerização com Docker

Autor
Lucas Kieffer Leal
RM 567193
Análise e Desenvolvimento de Sistemas
FIAP