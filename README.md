# Descripción
Esta API RESTful, desarrollada en Spring Boot, utiliza un enfoque funcional para gestionar información sobre franquicias, sucursales y productos.
Emplea MySql como base de datos y ofrece los siguientes endpoints:

POST /api/v1/franchises: Crea una nueva franquicia.

PUT /api/v1/franchises/{id}: Modifica el nombre de una franquicia.

POST /api/v1/subsidiaries: Agrega una nueva sucursal a una franquicia existente.

PUT /api/v1/subsidiaries/{id}: Modifica el nombre de una sucursal específica.

POST /api/v1/products: Agrega un nuevo producto a una sucursal existente.

PUT /api/v1/products/{id}: Modifica el stock y/o nombre de un producto específico.

## Tecnologías Utilizadas

Spring Boot: Framework Java para crear aplicaciones independientes.

Spring WebFlux: Módulo de Spring para desarrollar aplicaciones web reactivas.

MySql: Base de datos SQL.

Maven: Gestor de dependencias.

Docker Compose: Herramienta para definir y ejecutar aplicaciones multi-contenedor.

## Requisitos Previos
Java Development Kit (JDK) 17+: Asegúrate de tener instalado el JDK compatible con Spring Boot.

Maven: Instala Maven siguiendo las instrucciones oficiales.

Docker: Descarga e instala Docker según tu sistema operativo.

## Configuración de entorno local

1. Clonar repositorio
   ```bash
   git clone <url_del_repositorio>
3. Construir la aplicación
   ```bash
   cd <nombre_del_proyecto>
   mvn clean package
   ```
5. Ejecutar la aplicación
   ```bash
   java -jar target/<nombre_del_proyecto>.jar

Ejecución con Docker Compose
1. Construir las imágenes Docker
   ```bash
   docker-compose build
3. Iniciar los contenedores
   ```bash
   docker-compose up -d
