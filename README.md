# nuvu-api

Api de registro, consulta, edición y eliminación de personas.

| Usuario | Password |
| ---- | ----- |
| admin | qwerty |
| invitado | 123456 |

## Endpoints

| Acción | URL | Verbo | Requiere token |
| ---- | ---- | ---- | ---- |
| Inicio de session | https://nuvuapi.herokuapp.com/api/auth/signin | `POST` | ❌ |
| Consultar personas | https://nuvuapi.herokuapp.com/api/v1/persons | `GET` | ✔ |
| Consultar persona por Id | https://nuvuapi.herokuapp.com/api/v1/persons/{id} | `GET` | ✔ |
| Guardar persona | https://nuvuapi.herokuapp.com/api/v1/persons | `POST` | ✔ |
| Editar persona | https://nuvuapi.herokuapp.com/api/v1/persons | `PUT` | ✔ |
| Eliminar persona | https://nuvuapi.herokuapp.com/api/v1/persons/{id} | `DELETE` | ✔ |

## Login
```
curl --location --request POST 'https://nuvuapi.herokuapp.com/api/auth/signin' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "admin",
    "password": "qwerty"
}'
```

## Consultar personas
```
curl --location --request GET 'https://nuvuapi.herokuapp.com/api/v1/persons' \
--header 'Authorization: Bearer {{token}}'
```
