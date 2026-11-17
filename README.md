# API REST de Gestión de Libros en la Nube (Render) - Práctica #4

API REST desarrollada con Spring Boot y Spring Data JPA conectada a PostgreSQL y desplegada en la nube mediante Render y Docker.

## Enlaces de Producción (Render)

- **URL Base de la API:** `https://aux-prac-4-joel-javier.onrender.com/api/books`
- **Documentación Swagger UI:** `https://aux-prac-4-joel-javier.onrender.com/swagger-ui/index.html`

## Variables de Entorno Requeridas

- `DB_URL`: Cadena de conexión JDBC hacia PostgreSQL (`jdbc:postgresql://host:5432/database`)
- `DB_USERNAME`: Usuario de la base de datos en Render
- `DB_PASSWORD`: Contraseña de la base de datos en Render

## Endpoints disponibles

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `POST` | `/api/books` | Registrar un nuevo libro en PostgreSQL |
| `GET` | `/api/books` | Obtener todos los libros almacenados |
| `GET` | `/api/books/{id}` | Obtener un libro específico por su ID |
| `PUT` | `/api/books/{id}` | Actualizar los datos de un libro existente |
| `DELETE` | `/api/books/{id}` | Eliminar un libro por su ID |