# java-spring-h2-regex

java 17
build gradle
git clone https://github.com/ZoneGatune/java-spring-h2-regex.git

Proyecto con base de datos h2, Sring y Regex

servicio web localhost:8080//v1/usuario/guardar
request
{
"name": "Juan Rodriguez",
"email": "user@invalid.com",
"password": "HUNTERabcd",
"phones": [
{
"number": "1234567",
"citycode": "1",
"contrycode": "57"
}
]
}


response
respuesta cuando el coorreo ya existe
{
"mensaje": "EL correo ya esta registrado",
"data": null,
"created": null,
"modified": null,
"last_login": null,
"token": null,
"isactive": null
}

respuesta cuando se crea un registro

{
"mensaje": "registro grabado",
"data": {
"id": 1,
"name": "Juan Rodriguez",
"email": "user1@invalid.com",
"password": "HUNTERabcd",
"phones": [
{
"id": null,
"number": "1234567",
"citycode": "1",
"contrycode": "57"
}
]
},
"created": "2024-05-25 19:35:40",
"modified": "2024-05-25 19:35:40",
"last_login": null,
"token": null,
"isactive": true
}


respuesta cuando la contraseña o el email no cumple con el formato
{
"mensaje": "EL email o clave incorrecto",
"data": null,
"created": null,
"modified": null,
"last_login": null,
"token": null,
"isactive": null
}

git clone 
unica rama es master

