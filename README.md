# Franquicias API

API RESTful desarrollada con Spring Boot y WebFlux para la gestión de franquicias, sucursales y productos. Implementa un enfoque reactivo y funcional para manejar las operaciones CRUD de estos recursos.

## Características

- **Arquitectura Reactiva**: Utiliza Spring WebFlux para manejo asíncrono de peticiones.
- **Base de Datos**: PostgreSQL con R2DBC para acceso reactivo a la base de datos.
- **Documentación**: Documentación interactiva con Swagger/OpenAPI.
- **Contenedores**: Configuración lista para Docker.

## Requisitos Previos

- Java Development Kit (JDK) 21+
- Gradle 8.0+
- Docker y Docker Compose (opcional, para ejecutar en contenedores)
- PostgreSQL 15+

## Tecnologías Utilizadas

- **Spring Boot 3.5.0**: Framework para aplicaciones Java empresariales.
- **Spring WebFlux**: Para aplicaciones web reactivas.
- **R2DBC**: Acceso reactivo a bases de datos relacionales.
- **PostgreSQL**: Base de datos relacional.
- **MapStruct**: Para mapeo entre objetos DTO y entidades.
- **Lombok**: Para reducir el código boilerplate.
- **SpringDoc OpenAPI**: Documentación de la API.

## Configuración del Entorno

### Variables de Entorno
Crea un archivo `.env` en la raíz del proyecto con las siguientes variables:

```env
POSTGRES_DB=franchises_db
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
```

### Base de Datos
Puedes levantar la base de datos con Docker Compose:

```bash
docker-compose up -d
```

## Ejecución

### Desarrollo

1. Clona el repositorio:
   ```bash
   git clone <url-del-repositorio>
   cd reto-nequi
   ```

2. Ejecuta la aplicación:
   ```bash
   ./gradlew bootRun
   ```

### Construir y Ejecutar con Docker

1. Construir la imagen:
   ```bash
   docker build -t franchises-api .
   ```

2. Ejecutar los contenedores:
   ```bash
   docker-compose -f compose.yaml up -d
   ```

La aplicación estará disponible en `http://localhost:8080`

## Documentación de la API

Una vez que la aplicación esté en ejecución, puedes acceder a:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

## Estructura del Proyecto

```
src/main/java/dev/interview/jholkin/franchises/
├── application/         # Lógica de negocio
├── domain/              # Modelos de dominio
├── infrastructure/      # Implementaciones concretas
│   ├── adapters/        # Adaptadores de entrada/salida
│   └── persistence/     # Repositorios y entidades
└── FranchisesApplication.java  # Punto de entrada
```

## Pruebas

Para ejecutar las pruebas:

```bash
./gradlew test
```

## Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.
