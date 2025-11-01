# ToDoApp (Java + SQLite)

Proyecto desarrollado en Java que implementa una aplicación de gestión de tareas (To-Do List) desde consola.  
Permite agregar, listar, marcar como completadas y eliminar tareas, utilizando una base de datos SQLite para el almacenamiento persistente.

---

## Características principales

- Aplicación de consola con menú interactivo.
- Persistencia de datos mediante **SQLite**.
- Operaciones CRUD completas sobre las tareas:
    - Crear nuevas tareas.
    - Listar todas las tareas.
    - Marcar tareas como completadas.
    - Eliminar tareas.
- Arquitectura basada en capas:
    - `model` → representación de entidades (clase `Tarea`).
    - `dao` → manejo de la base de datos (clase `TareaDAO`).
    - `util` → conexión a la base de datos (clase `DBConnection`).
- Código estructurado y modular, siguiendo buenas prácticas de Java.

---

## Tecnologías utilizadas

- **Java 17+**
- **SQLite (jdbc:sqlite)**
- **JDBC** para la comunicación con la base de datos.
- **IntelliJ IDEA** como entorno de desarrollo.

---

## Conocimientos aplicados

Programación orientada a objetos (POO).

Estructura modular de paquetes en Java.

Manejo de base de datos con JDBC.

Control de versiones con Git y GitHub.

Buenas prácticas de organización de código.

---

## Próximos pasos

La siguiente etapa será migrar este proyecto a Spring Boot para construir una API REST,
lo que permitirá conectarlo a un frontend web o aplicación móvil.