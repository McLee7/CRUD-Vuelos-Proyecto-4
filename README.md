 Spring Boot – CRUD de Vuelos
 Descripción del proyecto

Este proyecto consiste en una aplicación Spring Boot que implementa un CRUD completo de vuelos sin uso de base de datos.
La información se gestiona en memoria mediante listas, exponiendo una API REST que permite crear, consultar, actualizar, eliminar y filtrar vuelos.

El objetivo principal es aplicar buenas prácticas en:

Diseño de APIs REST

Estructuración de proyectos Spring Boot

Separación de responsabilidades

Manejo de fechas con LocalDate

Uso de DTOs

Validaciones básicas

 Tecnologías utilizadas

Java 17+

Spring Boot

Spring Web

Jackson (serialización JSON)

Postman (testing de la API)

No se utiliza base de datos ni JPA, tal como indica el enunciado.

Estructura del proyecto
src/main/java/com/turnero/vuelos
│
├── controllers
│   └── VueloController.java
│
├── services
│   └── VueloService.java
│
├── repositories
│   └── VueloRepository.java
│
├── models
│   └── Vuelo.java
│
├── dtos
│   └── VueloDTO.java
│
├── utils
│   └── FechaUtils.java
│
└── VuelosApplication.java

Descripción de paquetes

models: entidad principal Vuelo

dtos: objetos de transferencia para exponer datos en la API

repositories: gestión del CRUD en memoria

services: lógica de negocio, filtros y validaciones

controllers: exposición de endpoints REST

utils: utilidades para el manejo de fechas

Modelo Vuelo
int id;
String nombreVuelo;
String empresa;
String lugarSalida;
String lugarLlegada;
LocalDate fechaSalida;
LocalDate fechaLlegada;


Incluye un campo calculado duracionDias que se devuelve en la respuesta JSON.

 Endpoints disponibles
Obtener todos los vuelos
GET /vuelos


Devuelve la lista ordenada por fecha de salida

Soporta filtros opcionales

Obtener vuelo por ID
GET /vuelos/{id}

Crear vuelo
POST /vuelos

Actualizar vuelo
PUT /vuelos/{id}

Eliminar vuelo
DELETE /vuelos/{id}

Filtros disponibles

Se pueden combinar mediante parámetros de consulta:

/vuelos?empresa=Iberia
/vuelos?lugarLlegada=New York
/vuelos?fechaSalida=2025-03-10

 Validaciones implementadas

No se permiten campos obligatorios nulos o vacíos

La fecha de salida no puede ser posterior a la fecha de llegada

Control de errores mediante respuestas HTTP adecuadas

Datos de ejemplo

La aplicación se inicializa con una lista de 10 vuelos predefinidos, utilizando aerolíneas y ciudades reales.

Testing con Postman

El repositorio incluye una colección de Postman con todas las peticiones necesarias para probar el CRUD completo.

Archivo incluido:

postman/VuelosCRUD.postman_collection.json

Ejecución del proyecto

Clonar el repositorio

Ejecutar la clase VuelosApplication

Acceder a:

http://localhost:8080/vuelos


No es necesario configurar Tomcat ni base de datos.

Notas finales

Este proyecto cumple con los requisitos funcionales y estructurales solicitados en la práctica, priorizando claridad, organización y separación de responsabilidades.
