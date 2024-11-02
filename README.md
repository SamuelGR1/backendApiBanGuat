# ParcialPractico

Este proyecto es una aplicación en **Spring Boot** creada en **Java** con **Maven** y desarrollada en **NetBeans**. El objetivo es consumir un servicio SOAP del Banco de Guatemala para obtener el tipo de cambio de la moneda en quetzales.

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instaladas las siguientes herramientas:

- **Java Development Kit (JDK) 17** o superior
- **Apache Maven**
- **MySQL** (o el sistema de bases de datos que estés usando)
- **NetBeans IDE** (opcional, si deseas ejecutarlo en este entorno)

## Clona el repositorio en tu máquina local:

https://github.com/SamuelGR1/backendApiBanGuat.git
cd ParcialPractico

## Compila el proyecto con Maven:
mvn clean install



## Configuración de la base de datos

1. Abre MySQL y crea una base de datos con el siguiente nombre:

   ```sql
   CREATE DATABASE tipocambio2db;
   USE tipocambio2db;
   CREATE TABLE solicitudes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_cambio VARCHAR(1000),
    fecha_solicitud TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

## Configura las credenciales en el archivo src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/tipocambio2db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

## Ejecuta 
mvn spring-boot:run



