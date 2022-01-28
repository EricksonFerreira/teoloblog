# Teoloblog

[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=Teoloblog&uri=https%3A%2F%2Fraw.githubusercontent.com%2FEricksonFerreira%2Fteoloblog%2Fmaster%2Fexport.json)

Disponibilizamos uma API REST que permite o acesso a postagens, comentarios, etc.

As dúvidas e solicitações, relacionadas ao acesso da API, devem ser enviadas para o e-mail erickson.ferreira@outlook.com.br

Recursos disponíveis para acesso via API:

- [**Autor**](#autor)
- [**Etiqueta**](#etiqueta)
- [**Comentario**](#comentario)
- [**Função**](#funcao)
- [**Publicação**](#publicaco)
- [**Referência**](#referencia)
- [**Usuario**](#usuario)

## Métodos

Requisições para a API devem seguir os padrões:
| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema. |

## Respostas

| Código | Descrição                                                          |
| ------ | ------------------------------------------------------------------ |
| `200`  | Requisição executada com sucesso (success).                        |
| `400`  | Erros de validação ou os campos informados não existem no sistema. |

# Group Recursos

# Login [/login]

Login dos usuarios do sistema.

### login [POST]

- Attributes (object)

  - username: username do usuario(string) - limite 255 caracteres,
  - password: senha do usuario(string) - limite 255 caracteres

- Request (application/json)

  - Body

          {
            "username":"ERICKSON",
            "password":"123"
          }

- Response 200 (application/json)

  - Body

          {
            "login": "ERICKSON",
            "token": "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NDMzNzgwMzUsImV4cCI6MTY0MzM4MTYzNSwiYXV0aG9yaXRpZXMiOjF9.lnY_kPeztFWo7UEw7QnnUCIeAoAS1zmMEX1FIg1LCH0",
            "prefix": "Berear"
          }

### Tabela das permissões dos usuarios
| Método | URL | Permissão |
|--- |--- |--- |
| `POST` | `/api/login` | Todos tem permissão |
| `GET` | `/api/autor` | Todos tem permissão |
| `GET` | `/api/autor/{id}` | Todos tem permissão |
| `POST` | `/api/autor/` | Administrador, Gerente, Normal |
| `PUT` | `/api/autor/{id}` | Administrador, Gerente, Normal |
| `DELETE` | `/api/autor/{id}` | Administrador, Gerente, Normal |
| `GET` | `/api/comentario` | Todos tem permissão |
| `GET` | `/api/comentario/{id}` | Todos tem permissão |
| `POST` | `/api/comentario/` | Administrador, Gerente, Normal |
| `PUT` | `/api/comentario/{id}` | Administrador, Gerente, Normal |
| `DELETE` | `/api/comentario/{id}` | Administrador, Gerente, Normal |
| `GET` | `/api/etiqueta` | Todos tem permissão |
| `GET` | `/api/etiqueta/{id}` | Todos tem permissão |
| `POST` | `/api/etiqueta/` | Administrador, Gerente |
| `PUT` | `/api/etiqueta/{id}` | Administrador, Gerente |
| `DELETE` | `/api/etiqueta/{id}` | Administrador, Gerente |
| `GET` | `/api/funcao` | Todos tem permissão |
| `GET` | `/api/funcao/{id}` | Todos tem permissão |
| `POST` | `/api/funcao/` | Administrador |
| `PUT` | `/api/funcao/{id}` | Administrador |
| `DELETE` | `/api/funcao/{id}` | Administrador |
| `GET` | `/api/publicacao` | Todos tem permissão |
| `GET` | `/api/publicacao/{id}` | Todos tem permissão |
| `POST` | `/api/publicacao/` | Administrador, Gerente, Normal |
| `PUT` | `/api/publicacao/{id}` | Administrador, Gerente, Normal |
| `DELETE` | `/api/publicacao/{id}` | Administrador, Gerente, Normal |
| `GET` | `/api/referencia` | Todos tem permissão |
| `GET` | `/api/referencia/{id}` | Todos tem permissão |
| `POST` | `/api/referencia/` | Administrador, Gerente, Normal |
| `PUT` | `/api/referencia/{id}` | Administrador, Gerente, Normal |
| `DELETE` | `/api/referencia/{id}` | Administrador, Gerente, Normal |
| `GET` | `/api/usuario` | Administrador, Gerente |
| `GET` | `/api/usuario/{id}` | Administrador, Gerente |
| `POST` | `/api/usuario/` | Administrador |
| `PUT` | `/api/usuario/{id}` | Administrador |
| `DELETE` | `/api/usuario/{id}` | Administrador |

# Autor [/autor]

Os autores são as pessoas que escreveram o texto que foi publicado.

### Listar (List) [GET /autor/{id}]

- Parameters

  - id (number, optional) - Filtrar por id do colaborador

- Response 200 (application/json)

          [
            {
              "codigo": 1,
              "nome": "Calvino",
              "descricao": Teólogo Reformado,
              "imagem": calvino.svg
            }
          ]


### Novo (Create) [POST]

- Attributes (object)

  - nome: nome do autor da publicação (string) - limite 255 caracteres,
  - descricao: descrição sobre o autor(string) - limite 255 caracteres,
  - imagem: link da imagem do autor(string) - limite 255 caracteres

- Request (application/json)

  - Body

          {
            "nome":"John Frame",
            "descricao":"Professor de Teologia",
            "imagem":"john-frame.svg"
          }

- Response 200 (application/json)

  - Body

          {
            "codigo": 2,
            "nome": "John Frame",
            "descricao": "Professor de Teologia",
            "imagem": frame.svg
          }

### Editar (Update) [PUT /autor/{codigo}]

- Request (application/json)

  - Body

         {
            "nome":"John Frame",
            "descricao":"Professor de Teologia",
            "imagem":"john-frame.svg"
          }


- Response 200 (application/json)
  Todos os dados do autor

  - Body

        {
          "codigo": 2,
          "nome": "John Frame",
          "descricao": "Professor de Teologia",
          "imagem": frame.svg
        }

### Remover (Delete) [DELETE /autor/{codigo}]

- Parameters

  - id (number, required) - codigo do autor

- Response 200 (application/json)

# Comentario [/comentario]

Os autores são as pessoas que escreveram o texto que foi publicado.

### Listar (List) [GET /comentario/{codigo}]

- Parameters

  - id (number, optional) - Filtrar por id do comentario

- Response 200 (application/json)

      {
        "texto": "lorem",
        "data": "22/12/2020",
        "usuario_id": 1,
        "publicacao_id":2
      }


### Novo (Create) [POST]

- Attributes (object)

  - texto: texto do comentario(string) - limite 255 caracteres,
  - data: data da criação do comentario(string) - limite 255 caracteres,
  - usuario_id: id do usuario que criou o comentario(inteiro) - 11 numeros
  - publicacao_id: id da publicacao a quem o comentario se refere(inteiro) - 11 numeros

- Request (application/json)

  - Body

        {
          "texto": "lorem",
          "data": "22/12/2020",
          "usuario_id": 1,
          "publicacao_id":2
        }

- Response 200 (application/json)

  - Body

         {
            "codigo": 4,
            "texto": "lorem",
            "data": "22/12/2020",
            "usuario": {
              "codigo": 1,
              "nome": "ERICKSON",
              "username": "ERICKSON",
              "password": "123",
              "funcao": {
                "codigo": 1,
                "nome": "ADMINISTRADOR"
              }
            },
            "publicacao": {
              "codigo": 2,
              "titulo": "Lorem3",
              "texto": "Lorem Ipsum3",
              "data": "10/10/2010",
              "autor": {
                "codigo": 2,
                "nome": "lorem",
                "descricao": "lorem ipsum",
                "imagem": "arminiano.jpg"
              },
              "usuario": {
                "codigo": 1,
                "nome": "ERICKSON",
                "username": "ERICKSON",
                "password": "123",
                "funcao": {
                  "codigo": 1,
                  "nome": "ADMINISTRADOR"
                }
              }
            }
          }

### Editar (Update) [PUT /comentario/{codigo}]

- Request (application/json)

  - Body

        {
          "texto": "lorem",
          "data": "22/12/2020",
          "usuario_id": 1,
          "publicacao_id":2
        }

- Response 200 (application/json)
  Todos os dados do autor

  - Body
         {
            "codigo": 4,
            "texto": "lorem",
            "data": "22/12/2020",
            "usuario": {
              "codigo": 1,
              "nome": "ERICKSON",
              "username": "ERICKSON",
              "password": "123",
              "funcao": {
                "codigo": 1,
                "nome": "ADMINISTRADOR"
              }
            },
            "publicacao": {
              "codigo": 2,
              "titulo": "Lorem3",
              "texto": "Lorem Ipsum3",
              "data": "10/10/2010",
              "autor": {
                "codigo": 2,
                "nome": "lorem",
                "descricao": "lorem ipsum",
                "imagem": "arminiano.jpg"
              },
              "usuario": {
                "codigo": 1,
                "nome": "ERICKSON",
                "username": "ERICKSON",
                "password": "123",
                "funcao": {
                  "codigo": 1,
                  "nome": "ADMINISTRADOR"
                }
              }
            }
          }

### Remover (Delete) [DELETE /comentario/{codigo}]

- Parameters

  - id (number, required) - codigo do comentario

- Response 200 (application/json)

# Etiqueta [/etiqueta]

As etiquetas são pequenos rótulos das publicações.

### Listar (List) [GET /etiqueta/{codigo}]

- Parameters

  - codigo (number, optional) - Filtrar pelo codigo do etiqueta

- Response 200 (application/json)

      [
        {
          "codigo": 1,
          "nome": "Ateísmo"
        },
        {
          "codigo": 2,
          "nome": "Criacionismo"
        }
      ]

### Novo (Create) [POST]

- Attributes (object)

  - nome: nome da etiqueta(string) - limite 255 caracteres

- Request (application/json)

  - Body

        {
          "nome": "calvinismo"
        }

- Response 200 (application/json)

  - Body

        {
          "codigo": 3,
          "nome": "calvinismo"
        }

### Editar (Update) [PUT /etiqueta/{codigo}]

- Request (application/json)

  - Body

        {
          "nome": "arminianismo"
        }

- Response 200 (application/json)
  Todos os dados da etiqueta

  - Body
        {
          "codigo": 2,
          "nome": "arminianismo"
        }

### Remover (Delete) [DELETE /etiqueta/{codigo}]

- Parameters

  - codigo (number, required) - codigo do etiqueta

- Response 200 (application/json)

# Função [/funcao]

As função são as permissões que os usários terão.

### Listar (List) [GET /etiqueta/{codigo}]

- Parameters

  - codigo (number, optional) - Filtrar pelo codigo do funcao

- Response 200 (application/json)

      [
        {
          "codigo": 1,
          "nome": "ADMINISTRADOR"
        },
        {
          "codigo": 2,
          "nome": "GERENTE"
        },
        {
          "codigo": 3,
          "nome": "NORMAL"
        }
      ]

### Novo (Create) [POST]

- Attributes (object)

  - nome: nome da funcao(string) - limite 255 caracteres

- Request (application/json)

  - Body

        {
          "nome": "lorem"
        }

- Response 200 (application/json)

  - Body

        {
          "codigo": 4,
          "nome": "lorem"
        }

### Editar (Update) [PUT /funcao/{codigo}]

- Request (application/json)

  - Body

        {
          "nome": "lorem ipsum"
        }

- Response 200 (application/json)
  Todos os dados da funcao

  - Body
        {
          "codigo": 2,
          "nome": "lorem ipsum"
        }

### Remover (Delete) [DELETE /funcao/{codigo}]

- Parameters

  - codigo (number, required) - codigo do funcao

- Response 200 (application/json)

# Publicacao [/publicacao]

Os publicacaos do sistema.

### Listar (List) [GET /publicacao/{codigo}]

- Parameters

  - codigo (number, optional) - Filtrar por codigo do publicacao

- Response 200 (application/json)

      [
        {
          "codigo": 1,
          "titulo": "Lorem4",
          "texto": "Lorem Ipsum4",
          "data": "10/10/2010",
          "autor": {
            "codigo": 1,
            "nome": "Calvino",
            "descricao": "Teólogo calvinista",
            "imagem": "calvino.svg"
          },
          "usuario": {
            "codigo": 1,
            "nome": "erickson",
            "username": "erickson",
            "password": "123",
            "funcao": {
              "codigo": 2,
              "nome": "GERENTE"
            }
          }
        },
        {
          "codigo": 2,
          "titulo": "Lorem3",
          "texto": "Lorem Ipsum3",
          "data": "10/10/2010",
          "autor": {
            "codigo": 2,
            "nome": "Arminio",
            "descricao": "Teólogo arminiano",
            "imagem": "arminio.svg"
          },
          "usuario": {
            "codigo": 1,
            "nome": "erickson",
            "username": "erickson",
            "password": "123",
            "funcao": {
              "codigo": 2,
              "nome": "GERENTE"
            }
          }
        }
      ]

### Novo (Create) [POST]

- Attributes (object)

  - titulo: titulo da publicacao(string) - limite 255 caracteres,
  - texto: texto da publicacao(string) - limite 255 caracteres,
  - data: data que a publicacao foi feita(string) - limite 255 caracteres,
  - lita_etiqueta_id: id das etiquetas que fazer referencia a publicacao(array de inteiros)
  - autor_id: id do autor da publicacao(inteiro) - 11 numeros
  - usuario_id: id do usuario que fez a publicacao(inteiro) - 11 numeros

- Request (application/json)

  - Body

        {
          "titulo": "Lorem ipsum",
          "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vehicula volutpat hendrerit. Aliquam interdum eget leo vitae pellentesque. Aliquam lacinia nisi et rutrum euismod. Nam malesuada consequat urna id finibus.",
          "data": "16/09/2021",
          "lista_etiqueta_id":[1,2],
          "autor_id":1,
          "usuario_id":1
        }

- Response 200 (application/json)

  - Body

        {
          "codigo": 3,
          "titulo": "Lorem ipsum",
          "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vehicula volutpat hendrerit. Aliquam interdum eget leo vitae pellentesque. Aliquam lacinia nisi et rutrum euismod. Nam malesuada consequat urna id finibus.",
          "data": "16/09/2021",
          "autor": {
            "codigo": 1,
            "nome": "Calvino",
            "descricao": "Teólogo calvinista",
            "imagem": "calvino.svg"
          },
          "usuario": {
            "codigo": 1,
            "nome": "ERICKSON",
            "username": "ERICKSON",
            "password": "123",
            "funcao": {
              "codigo": 1,
              "nome": "ADMINISTRADOR"
            }
          }
        }

### Editar (Update) [PUT /publicacao/{codigo}]

- Request (application/json)

  - Body

        {
          "titulo": "Lorem ipsum",
          "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vehicula volutpat hendrerit. Aliquam interdum eget leo vitae pellentesque. Aliquam lacinia nisi et rutrum euismod. Nam malesuada consequat urna id finibus.",
          "data": "16/09/2021",
          "lista_etiqueta_id":[],
          "autor_id":1
        }

- Response 200 (application/json)
  Todos os dados da publicacao

  - Body
        {
          "codigo": 1,
          "titulo": "Lorem ipsum",
          "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vehicula volutpat hendrerit. Aliquam interdum eget leo vitae pellentesque. Aliquam lacinia nisi et rutrum euismod. Nam malesuada consequat urna id finibus.",
          "data": "16/09/2021",
          "autor": {
            "codigo": 1,
            "nome": "Calvino",
            "descricao": "Teólogo calvinista",
            "imagem": "calvino.svg"
          },
          "usuario": {
            "codigo": 2,
            "nome": "ERINSTON",
            "username": "ERINSTON",
            "password": "456",
            "funcao": {
              "codigo": 2,
              "nome": "GERENTE"
            }
          }
        }

### Remover (Delete) [DELETE /publicacao/{codigo}]

- Parameters

  - id (number, required) - id do publicacao

- Response 200 (application/json)

# Referencia [/referencia]

As referencias são referencias utilizadas para fazer a publicação.

### Listar (List) [GET /referencia/{codigo}]

- Parameters

  - id (number, optional) - Filtrar por id do referencia

- Response 200 (application/json)

      [
        {
          "codigo": 1,
          "texto": "Lorem4",
          "publicacao": {
            "codigo": 1,
            "titulo": "Lorem4",
            "texto": "Lorem Ipsum4",
            "data": "10/10/2010",
            "autor": {
              "codigo": 1,
              "nome": "Calvino",
              "descricao": "Teólogo calvinista",
              "imagem": "calvino.svg"
            },
            "usuario": {
              "codigo": 1,
              "nome": "ERICKSON",
              "username": "ERICKSON",
              "password": "123",
              "funcao": {
                "codigo": 1,
                "nome": "ADMINISTRADOR"
              }
            }
          }
        },
        {
          "codigo": 2,
          "texto": "Lorem3",
          "publicacao": {
            "codigo": 2,
            "titulo": "Lorem3",
            "texto": "Lorem Ipsum3",
            "data": "10/10/2010",
            "autor": {
              "codigo": 2,
              "nome": "lorem",
              "descricao": "lorem ipsum",
              "imagem": "arminiano.jpg"
            },
            "usuario": {
              "codigo": 1,
              "nome": "ERICKSON",
              "username": "ERICKSON",
              "password": "123",
              "funcao": {
                "codigo": 1,
                "nome": "ADMINISTRADOR"
              }
            }
          }
        }
      ]


### Novo (Create) [POST]

- Attributes (object)

  - nome: informacoes da referencia(string) - limite 255 caracteres,
  - texto: texto utiliado na referencia(string) - limite 255 caracteres,
  - publicacao_id: id da publicacao a quem a referencia se refere(inteiro) - 11 numeros

- Request (application/json)

  - Body

        {
          "nome": "Lorem ipsum dolor sit amet",
          "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vehicula volutpat hendrerit. Aliquam interdum eget leo vitae pellentesque. Aliquam lacinia nisi et rutrum euismod. Nam malesuada consequat urna id finibus.",
          "publicacao_id":1
        }

- Response 200 (application/json)

  - Body

         {
            "codigo": 3,
            "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vehicula volutpat hendrerit. Aliquam interdum eget leo vitae pellentesque. Aliquam lacinia nisi et rutrum euismod. Nam malesuada consequat urna id finibus.",
            "publicacao": {
              "codigo": 3,
              "titulo": "Lorem ipsum",
              "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vehicula volutpat hendrerit. Aliquam interdum eget leo vitae pellentesque. Aliquam lacinia nisi et rutrum euismod. Nam malesuada consequat urna id finibus.",
              "data": "16/09/2021",
              "autor": {
                "codigo": 1,
                "nome": "Calvino",
                "descricao": "Teólogo calvinista",
                "imagem": "calvino.svg"
              },
              "usuario": {
                "codigo": 1,
                "nome": "ERICKSON",
                "username": "ERICKSON",
                "password": "123",
                "funcao": {
                  "codigo": 1,
                  "nome": "ADMINISTRADOR"
                }
              }
            }
          }

### Editar (Update) [PUT /referencia/{codigo}]

- Request (application/json)

  - Body

        {
          "nome": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
          "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vehicula volutpat hendrerit. Aliquam interdum eget leo vitae pellentesque. Aliquam lacinia nisi et rutrum euismod. Nam malesuada consequat urna id finibus.",
          "publicacao_id":2
        }

- Response 200 (application/json)
  Todos os dados do autor

  - Body
          {
              "codigo": 1,
              "texto": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vehicula volutpat hendrerit. Aliquam interdum eget leo vitae pellentesque. Aliquam lacinia nisi et rutrum euismod. Nam malesuada consequat urna id finibus.",
              "publicacao": {
                "codigo": 2,
                "titulo": "Lorem3",
                "texto": "Lorem Ipsum3",
                "data": "10/10/2010",
                "autor": {
                  "codigo": 2,
                  "nome": "lorem",
                  "descricao": "lorem ipsum",
                  "imagem": "arminiano.jpg"
                },
                "usuario": {
                  "codigo": 1,
                  "nome": "ERICKSON",
                  "username": "ERICKSON",
                  "password": "123",
                  "funcao": {
                    "codigo": 1,
                    "nome": "ADMINISTRADOR"
                  }
                }
              }
            }

### Remover (Delete) [DELETE /referencia/{codigo}]

- Parameters

  - id (number, required) - codigo da referencia

- Response 200 (application/json)

# Usuario [/usuario]

Os usuarios do sistema.

### Listar (List) [GET /usuario/{codigo}]

- Parameters

  - codigo (number, optional) - Filtrar por codigo do usuario

- Response 200 (application/json)

      [
          {
            "codigo": 1,
            "nome": "ERICKSON",
            "username": "ERICKSON",
            "password": "123",
            "funcao": {
              "codigo": 1,
              "nome": "ADMINISTRADOR"
            }
          },
          {
            "codigo": 2,
            "nome": "ERINSTON",
            "username": "ERINSTON",
            "password": "456",
            "funcao": {
              "codigo": 2,
              "nome": "GERENTE"
            }
          },
          {
            "codigo": 3,
            "nome": "LUIGI",
            "username": "LUIGI",
            "password": "789",
            "funcao": {
              "codigo": 3,
              "nome": "NORMAL"
            }
          }
        ]

### Novo (Create) [POST]

- Attributes (object)

  - nome: nome do usuario(string) - limite 255 caracteres,
  - username: nome que será utilizado no login(string) - limite 255 caracteres,
  - password: senha que será utilizado no login(string) - limite 255 caracteres,
  - funcao_id: id da funcao do usuario(inteiro) - 11 numeros

- Request (application/json)

  - Body

        {
          "nome": "erickson",
          "username":"erickson",
          "password":"123",
          "funcao_id":1
        }

- Response 200 (application/json)

  - Body

        {
          "codigo": 4,
          "nome": "erickson",
          "username": "erickson",
          "password": "123",
          "funcao": {
            "codigo": 1,
            "nome": "ADMINISTRADOR"
          }
        }

### Editar (Update) [PUT /usuario/{codigo}]

- Request (application/json)

  - Body

        {
          "nome": "erickson",
          "username":"erickson",
          "password":"123",
          "funcao_id":2
        }

- Response 200 (application/json)
  Todos os dados do usuario

  - Body
        {
          {
            "codigo": 1,
            "nome": "erickson",
            "username": "erickson",
            "password": "123",
            "funcao": {
              "codigo": 2,
              "nome": "GERENTE"
          }
        }

### Remover (Delete) [DELETE /usuario/{codigo}]

- Parameters

  - id (number, required) - id do usuario

- Response 200 (application/json)
