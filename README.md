# Ai commerce

Esse repositório é dedicado ao versionamento do ai commerce, projeto fundado pela NovaTech solutions em parceria com a plusoft. Nosso projeto se trata de um site de e-commerce integrado com ia, para empresas que buscam turbinar o seu site de vendas com a nossa solução tecnológica de recomendação de produtos.

Essa api cuida dos protocolos padrões do e-commerce, 

## Endpoints do cliente

Verbo|Tipo da requisição	|Descrição
|--|--|--|
clientes|	GET	|Obtém todos os clientes cadastrados
clientes/{id}|	GET|	Obtém os dados de um cliente específico
clientes	|POST|	Cria um novo cliente
clientes/{id}|	PUT	|Atualiza os dados de um cliente
clientes/{id}	|DELETE|	Apaga um cliente

## Demonstração/ exemplos dos endpoints

### 1-obter todos clientes

GET `cliente`

Retorno:
``` json
[
  {
    "cliente_id": 1,
    "nome": "João",
    "email": "joao@example.com",
    "telefone": "(11) 91234-5678",
    "endereco": "Rua ABC, 123"
  },

  {
    "cliente_id": 2,
    "nome": "Maria",
    "email": "maria@example.com",
    "telefone": "(11) 98765-4321",
    "endereco": "Av. XYZ, 456"
  }
]
```

Status code	|Mensagem
|--|--|
200	|Dados retornados com sucesso

---

### 2-obter cliente por id
GET `clientes/1`

```json
{
  "cliente_id": 1,
  "nome": "João",
  "email": "joao@example.com",
  "telefone": "(11) 91234-5678",
  "endereco": "Rua ABC, 123"
}
```

Status code|	Mensagem
|--|--|
200|	Dados retornados com sucesso
404	|Cliente não encontrado
---
### 3-criar cliente
POST `clientes`

Request body:
```json
{
  "nome": "Pedro",
  "email": "pedro@example.com",
  "telefone": "(11) 99876-5432",
  "endereco": "Av. QRS, 789"
}
```

Retorno:
```json
{
  "cliente_id": 3,
  "nome": "Pedro",
  "email": "pedro@example.com",
  "telefone": "(11) 99876-5432",
  "endereco": "Av. QRS, 789"
}
```
Status code	|Mensagem
|--|--|
200|	Cliente cadastrado com sucesso

---
### 4-atualizar cliente
PUT `clientes/3`

Request Body:
```json
{
  "nome": "Pedro Silva",
  "email": "pedro.silva@example.com",
  "telefone": "(11) 99876-5432",
  "endereco": "Av. QRS, 789"
}
```

Retorno:
```json
{
  "cliente_id": 3,
  "nome": "Pedro Silva",
  "email": "pedro.silva@example.com",
  "telefone": "(11) 99876-5432",
  "endereco": "Av. QRS, 789"
}
```

---
### 5-apagar cliente
DELETE clientes/3

Status code	|Mensagem
|--|--|
200	|Cliente apagado com sucesso
404	|Cliente não encontrado
