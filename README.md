# Teoloblog

[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=Teoloblog&uri=https%3A%2F%2Fraw.githubusercontent.com%2FEricksonFerreira%2Fteoloblog%2Fmaster%2Fexport.json)

Disponibilizamos uma API REST que permite o acesso a postagens, comentarios, etc.

As dúvidas e solicitações, relacionadas ao acesso da API, devem ser enviadas para o e-mail erickson.ferreira@outlook.com.br

Recursos disponíveis para acesso via API:
* [**Autor**](#autor)
* [**Etiqueta**](#etiqueta)
* [**Comentario**](#comentario)
* [**Função**](#funcao)
* [**Publicação**](#publicaco)
* [**Referência**](#referencia)
* [**Usuario**](#usuario)



## Métodos
Requisições para a API devem seguir os padrões:
| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema. |

## Respostas

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema.|


# Group Recursos

# Autor [/autor]

Os autores são as pessoas que escreveram o texto que foi publicado.


### Listar (List) [GET /autor/{id}]
+ Parameters
    + id (number, optional) - Filtrar por id do colaborador


+ Response 200 (application/json)

          
          [
            {
              "codigo": 1,
              "nome": "Calvino",
              "descricao": Teólogo Reformado,
              "imagem": calvino.svg
            }
          ]
         
### Novo (Create) [POST]

+ Attributes (object)

    + nome: nome do autor da publicação (string) - limite 255 caracteres,
    + descricao: descrição sobre o autor(string) - limite 255 caracteres,
    + imagem: link da imagem do autor(string) - limite 255 caracteres   

+ Request (application/json)

    + Body
    
            {
              "nome":"John Frame",
              "descricao":"Professor de Teologia",
              "imagem":"john-frame.svg"
            }


+ Response 200 (application/json)

    + Body
    
            {
              "codigo": 2,
              "nome": "John Frame",
              "descricao": "Professor de Teologia",
              "imagem": frame.svg
            }

### Editar (Update) [PUT  /autor/{codigo}]

+ Request (application/json)

   + Body
    
          {
             "nome":"John Frame",
             "descricao":"Professor de Teologia",
             "imagem":"john-frame.svg"
           }
          

+ Response 200 (application/json)
  Todos os dados do autor
 
    + Body
    
          {
            "codigo": 2,
            "nome": "John Frame",
            "descricao": "Professor de Teologia",
            "imagem": frame.svg
          }

### Remover (Delete) [DELETE  /contatos/{codigo}]

+ Request (application/json)


+ Response 200 (application/json)
