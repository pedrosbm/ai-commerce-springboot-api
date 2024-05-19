# Ai commerce By NovaTechSolutions

| integrante        | rm     | funcao                              |
| ----------------- | ------ | ----------------------------------- |
| Arthur Koga       | 99503  | DataBase & Cloud                    |
| Gabriel Benjamim  | 552254 | Mobile & Quality Assurance          |
| Henry Ribeiro     | 550684 | DataBase, Cloud % Quality Assurance |
| Murilo José       | 99538  | .Net                                |
| Pedro Sena Borges | 98021  | Spring & Ia                         |

Esse repositório é dedicado ao versionamento da api do ai commerce, projeto fundado pela NovaTech solutions em parceria com a plusoft. Essa api rest se trata de um projeto spring boot, com servidor tomcat imbutido, basta clonar o repositório e executar a classe main. Nosso projeto se trata de um site de e-commerce integrado com ia, para empresas que buscam turbinar o seu site de vendas com a nossa solução tecnológica de recomendação de produtos. Essa api cuida dos protocolos padrões do e-commerce e posteriormente o intermediador entre o nosso futuro modelo de ia e o cliente.

## Diagrama de banco de dados
<img src="./markdown/Modelo de banco de dados atualizado.png">

## Compilando o projeto e Acessando documentação

Para compilar o projeto, basta você clonar esse repositório e executar a [classe principal](./src/main/java/com/pedrosbm/aicommerce/AicommerceApplication.java).

A documentação do projeto foi feita com swagger do spring doc, e ela conta com demonstrações de todos os endpoints do projeto, schemas(classes) e é uma página altamente interativa.

para acessar a documentação, basta executar a aplicação e acessar a url abaixo:

```
  http://localhost:8080/swagger-ui/index.html
```