# Rest API

## Descripción

Este proyecto está en desarrollo para convertirse en una API REST. Está estructurado con las carpetas necesarias, incluyendo:

- **Repository**: Contiene las interfaces que gestionan la comunicación con la base de datos.
- **Service**: Implementa la lógica de negocio y las operaciones sobre las entidades.
- **Controller**: Maneja las solicitudes HTTP y las respuestas, actuando como intermediario entre el cliente y los servicios.
- **Entidades**: Define las clases que representan las tablas de la base de datos.

Además, el proyecto está equipado con soporte para auditoría, utilizando Hibernate Envers, y todo se mapea en una base de datos MySQL.

## Características

- CRUD completo para entidades como Cliente, Domicilio, Artículo, Categoría, Factura, etc.
- Auditoría de cambios utilizando Hibernate Envers.
- Conexión a base de datos MySQL.
- Soporte para mostrar consultas SQL.
- Documentación de la API utilizando Swagger/OpenAPI.

## Tecnologías

- Java 17
- Spring Boot 3.3.3
- Hibernate 6.x
- MySQL
- Lombok
- Swagger/OpenAPI

## Requisitos

- JDK 17 o superior
- MySQL
- Maven o Gradle para la gestión de dependencias

