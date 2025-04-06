# Gerenciador de Tarefas API - Documentação

**Disciplina:** Tópicos Especiais em Programação

**Professor:** Alysson

**Equipe:** Werbton, Victor e Guilherme

---

## 📝 Descrição do Projeto

Sistema de gerenciamento de tarefas desenvolvido com:

- **Backend:** Spring Boot 3 + Java 17
- **Build:** Gradle
- **Banco de Dados:** H2 (desenvolvimento)
- **Documentação:** Swagger UI

Principais funcionalidades:
- Cadastro de usuários com autenticação
- CRUD completo de tarefas
- Organização por categorias
- Controle de status e prioridade

---

## 🔌 Endpoints da API

## 🌟 Visão Geral
API RESTful para gerenciamento de tarefas com:
- Autenticação JWT
- CRUD completo para usuários, tarefas e categorias
- Relacionamentos entre entidades
- Filtros e buscas

---

## 🔐 Autenticação

### Login
`POST /api/auth/login`

**Request:**
```json
{
  "email": "usuario@exemplo.com",
  "senha": "senha123"
}
```

**Response (Sucesso):**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

**Response (Erro):**
```json
{
  "status": 401,
  "message": "Credenciais inválidas"
}
```

> Todos os endpoints abaixo requerem o token no header:
> `Authorization: Bearer <token>`

---

## 👥 Usuários

### Criar Usuário
`POST /api/usuarios`
```json
{
  "nome": "Fulano da Silva",
  "email": "fulano@email.com",
  "senha": "senhaSegura123"
}
```

### Listar Usuários
`GET /api/usuarios`

### Obter Usuário Específico
`GET /api/usuarios/{id}`

### Atualizar Usuário
`PUT /api/usuarios/{id}`

### Remover Usuário
`DELETE /api/usuarios/{id}`

### Listar Tarefas do Usuário
`GET /api/usuarios/{id}/tarefas`

---

## ✅ Tarefas

### Criar Tarefa
`POST /api/tarefas`
```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Finalizar projeto do gerenciador de tarefas",
  "status": "PENDENTE",
  "prioridade": "ALTA",
  "responsavelId": 1,
  "categoriaId": 2
}
```

**Valores Possíveis:**  
- status: PENDENTE, EM_ANDAMENTO, CONCLUIDA, CANCELADA  
- prioridade: BAIXA, MEDIA, ALTA, URGENTE

### Listar Tarefas
`GET /api/tarefas`

### Obter Tarefa Específica
`GET /api/tarefas/{id}`

### Atualizar Tarefa
`PUT /api/tarefas/{id}`

### Remover Tarefa
`DELETE /api/tarefas/{id}`

---

## 📂 Categorias

### Criar Categoria
`POST /api/categorias`
```json
{
  "nome": "Estudos"
}
```

### Listar Categorias
`GET /api/categorias`

### Obter Categoria Específica
`GET /api/categorias/{id}`

### Atualizar Categoria
`PUT /api/categorias/{id}`

### Remover Categoria
`DELETE /api/categorias/{id}`

---

## 🖥️ Exemplos Completos

### Criação de Tarefa
```http
POST /api/tarefas
Authorization: Bearer eyJhbGci...
Content-Type: application/json

{
  "titulo": "Revisar código",
  "descricao": "Revisar PR #123",
  "status": "EM_ANDAMENTO",
  "prioridade": "ALTA",
  "responsavelId": 1,
  "categoriaId": 2
}
```

**Response:**
```json
{
  "id": 3,
  "titulo": "Revisar código",
  "descricao": "Revisar PR #123",
  "status": "EM_ANDAMENTO",
  "prioridade": "ALTA",
  "responsavel": {
    "id": 1,
    "nome": "João Silva"
  },
  "categoria": {
    "id": 2,
    "nome": "Trabalho"
  }
}
```

---

## ⚠️ Tratamento de Erros

### Formato padrão de erro:
```json
{
  "status": 500,
  "message": "Descrição do erro"
}
```

---

## 🛠️ Tecnologias Utilizadas
- Spring Boot
- JWT
- REST APIs
- JSON
