# Ejemplo Inicial con Spring.Boot - Sistema de Turnos para Veterinaria

El ejemplo se basa en un Sistema de gestión de turnos para una veterinaria. El sistema permite gestionar la reserva y administración de turnos, así como la información de los clientes y sus mascotas. En esta primera instancia solo gestiona la Entidad Turno. 

## Tecnologías Utilizadas

- **Java 17**  
- **Spring Boot 3**  
- **Spring Data JPA** (para interacción con la base de datos)  
- **H2** (base de datos en memoria para pruebas, puede ser configurada para usar MySQL o PostgreSQL)  
- **Maven** (gestor de dependencias)  
- **Lombok** (para reducir el código boilerplate)

## Estructura del Proyecto

El código fuente del proyecto está organizado de la siguiente manera:

```plaintext
src/
 └── main/
     └── java/
         └── com/
             └── example/
                 └── springboot/
                     ├── controllers/      # Controladores REST
                     ├── dtos/             # Data Transfer Object
                     ├── exceptions/       # Manejo de Excepciones
                     ├── mappers/          # Mapeadores de DTOs a Entidades
                     ├── models/           # Entidades y Repositorios
                     ├── services/         # Servicios
                     └── Application.java  # Clase principal
```

### Directorios Principales:

- **controllers/**: Contiene los controladores que exponen las APIs REST para interactuar con los turnos.
- **models/**: Contiene las clases que representan las entidades del sistema como `Turno`.
- **repositories/**: Contiene las interfaces que extienden `JpaRepository` para realizar consultas a la base de datos.
- **services/**: Contiene la lógica de negocio para gestionar las Entidades.
- **Application.java**: Clase principal que inicia la aplicación Spring Boot.

## Configuración de la Base de Datos

Por defecto, se utiliza una base de datos H2 en memoria para pruebas. Si deseas utilizar una base de datos diferente, puedes modificar las propiedades en `src/main/resources/application.properties`:

```properties
# Configuración para base de datos H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

Para cambiar a MySQL o PostgreSQL, ajusta estas propiedades según sea necesario.
