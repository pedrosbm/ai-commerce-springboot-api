# Ai commerce By NovaTechSolutions

integrante|rm|funcao|
|--|--|--|
Arthur Koga |99503|DataBase & Cloud|
Gabriel Benjamim |552254|Mobile & Quality Assurance|
Henry Ribeiro |550684|DataBase, Cloud % Quality Assurance|
Murilo José |99538|.Net|
Pedro Sena Borges |98021| Spring & Ia|

Esse repositório é dedicado ao versionamento do ai commerce, projeto fundado pela NovaTech solutions em parceria com a plusoft. Nosso projeto se trata de um site de e-commerce integrado com ia, para empresas que buscam turbinar o seu site de vendas com a nossa solução tecnológica de recomendação de produtos. Essa api cuida dos protocolos padrões do e-commerce e posteriormente o intermediador entre o nosso futuro modelo de ia e o cliente.

No momento temos apenas o dominio de cliente completo com todos os verbos http, demais entidades do nosso sistema foram reservadas para as sprints futuras. Segue mais informações da ai commerce abaixo...

[Video pitch](https://youtu.be/ftHpiM_o7Uk)

## Endpoints do cliente

Verbo|Tipo da requisição	|Descrição
|--|--|--|
cliente|	GET	|Obtém todos os clientes cadastrados
cliente/{id}|	GET|	Obtém os dados de um cliente específico
cliente	|POST|	Cria um novo cliente
cliente/{id}|	PUT	|Atualiza os dados de um cliente
cliente/{id}	|DELETE|	Apaga um cliente

## Demonstração/ exemplos dos endpoints

### 1-obter todos clientes

GET `cliente`

Retorno:
``` json
[
  {
    "clienteId": 1,
    "nome": "João",
    "email": "joao@example.com",
    "telefone": "(11) 91234-5678",
    "endereco": "Rua ABC, 123"
  },

  {
    "clienteId": 2,
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
GET `cliente/1`

```json
{
  "clienteId": 1,
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
POST `cliente`

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
  "clienteId": 3,
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
PUT `cliente`

Request Body:
```json
{
  "clienteId": 3,
  "nome": "Pedro Silva",
  "email": "pedro.silva@example.com",
  "telefone": "(11) 99876-5432",
  "endereco": "Av. QRS, 789"
}
```

Retorno:
```json
{
  "clienteId": 3,
  "nome": "Pedro Silva",
  "email": "pedro.silva@example.com",
  "telefone": "(11) 99876-5432",
  "endereco": "Av. QRS, 789"
}
```

---
### 5-apagar cliente
DELETE `cliente/3`

Status code	|Mensagem
|--|--|
200	|Cliente apagado com sucesso
404	|Cliente não encontrado
