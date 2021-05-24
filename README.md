# Error Logs API

Swagger endpoint [/swagger-ui/](https://centraldeerrosjava.herokuapp.com/swagger-ui/)

Trabalho de conclusão da aceleraçao java da Trybe apoiado Pela CI&T

## **ERROR LOGS** Endpoint

`GET` /loggers

Retorna todos os logs com possibilidade de filtro e paginação pelos parâmetros do log (date, description, eventLog, level, quantity, id e source)

> date deve ser no formato: `[dd-MM-yyyy HH:mm]and[dd-MM-yyyy HH:mm]`, e retornará os valores com a data entre o intervalo especificado

Filtragem:

`GET` /loggers?filter=`parametro`&value=`valor`

> `GET` /loggers?filter=`level`&value=`WARNING`
>
> Retorna todos os valores com o campo level que tenham a palavra chave WARNING

Paginação

`GET` /loggers?page=`value`&size=`value`&sort=`parametro`,`[asc, desc]`

> `GET` /loggers?page=`0`&size=`4`&sort=`quantity`,`desc`
>
> Retorna a primeira página, exibindo 4 logs de erro por página, ordenado por quantidade de forma descendente

<details>
<summary>Retorno de uma requisição feita com sucesso</summary>
<pre>
{
  "content": [
    {
      "id": 117,
      "level": "ERROR",
      "description": "teste",
      "source": "192.168.55.55",
      "quantity": 1,
      "date": "2021-05-19T14:29:00"
    }
  ],
  "pageable": {
    "sort": {
      "sorted": false,
      "unsorted": true,
      "empty": true
    },
    "pageNumber": 0,
    "pageSize": 20,
    "offset": 0,
    "unpaged": false,
    "paged": true
  },
  "totalPages": 1,
  "totalElements": 1,
  "last": true,
  "first": true,
  "sort": {
    "sorted": false,
    "unsorted": true,
    "empty": true
  },
  "numberOfElements": 1,
  "size": 20,
  "number": 0,
  "empty": false
}
</pre>
</details>


`POST` /loggers

Cadastra um log

Request body:

```
date:			String: (dd/MM/aaaa HH:mm)
description:  	string
eventLog:		string
level:			String: (ERROR, WARNING, INFO)
quantity:		Integer: minimum: 1
source:			string
```

`GET` /loggers/{id}

Retorna um log pelo id do log

`DELETE` /loggers/{id}

Exclui um log pelo Id



## **USERS** Endpoint

`POST` /users

Cadastra um usuário

Request body: 

```
name: 		string
login: 		string (email válido)
password: 	string
```

## **AUTH TOKEN** Endpoint

`POST` /oauth/authorize

Request body: 
```
username,
password,
grant_type: 	'password',
client_id: 		'client_id',
client_secret: 	'client_secret',
```

## Tecnologias
- Java 8
- Spring boot
- Oauth
- Swagger
- JUnit
- Spock
- Maven

## Grupo
- Pedro Paulo Marques da Costa -> [Github](https://github.com/PedroMarqdev) | [Linkedin](https://www.linkedin.com/in/pedro-marques-9aaa651b4/)
- Vitor -> [Github](https://github.com/vitor-rc1) | [Linkedin](https://www.linkedin.com/in/vitorrodrig/)
- Berilo -> [Github](https://github.com/wberilo) | [Linkedin](https://www.linkedin.com/in/berilo/)

