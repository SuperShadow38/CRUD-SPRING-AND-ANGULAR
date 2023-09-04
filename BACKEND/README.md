# Manual de Despliegue de Proyecto

## Introducción

Este formato permitirá al encargado de conllevar el proyecto poder trabajar de manera eficiente y rápida para el desplazamiento y productividad del mismo y con ello poder acortar tiempos de desarrollo y lanzamiento a producción.

## Requisitos

- Java JDK 8 o superior.
- Servidor de aplicaciones compatibles con Spring Boot (Apache Tomcat).
- PostgreSQL 9.6 o superior.

## Configuración de Entorno

1. Instala y configura Java JDK en tu computadora.
2. Instala y configura un servidor de aplicaciones para poder implementar Spring Boot.
3. Instala y configura PostgreSQL en el servidor para la base de datos.

## EDR (Diagrama Entidad Relación)

[Inserta aquí el enlace o la descripción del EDR si es necesario]

## Proceso de Despliegue

1. Clona el repositorio desde el control de versiones Git en el servidor de despliegue:

   ```shell
   git clone "https://gitlab.com/01septiembre2023sasf/fabio-avila/-/tree/favila-teorica/PRUEBA_TEORICA/ALGORITMOS/ALGORITMO%201?ref_type=heads"

## Configuración de la Base de Datos

1. **Creación de la Base de Datos en PostgreSQL:**

   Antes de ejecutar la aplicación, asegúrese de crear una base de datos en PostgreSQL para el proyecto. Puede utilizar la interfaz de línea de comandos de PostgreSQL o una herramienta de administración como pgAdmin para crear la base de datos.

2. **Actualización de la Configuración de la Base de Datos:**

   Abra el archivo "application.properties" en su proyecto Spring Boot y actualice las configuraciones de la base de datos según corresponda. Asegúrese de configurar los siguientes valores:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nombre-de-tu-base-de-datos
   spring.datasource.username=usuario-de-la-base-de-datos
   spring.datasource.password=contraseña-de-la-base-de-datos
   spring.datasource.driver-class-name=org.postgresql.Driver

## Ejecución de la Aplicación

1. Ejecuta la aplicación en el IDE de tu elección (Eclipse, Netbeans, VSCode) para realizar una prueba de arranque y asegurarte de que todo funcione correctamente al momento de la ejecución.

   ```shell
   mvn spring-boot:run


