# API REST - Gestión de Eventos

## 👥 Autor
**Diego Forteza Benito y Javier Escudero**  
Programación de Servicios y Procesos (PSP)

---

## 🎯 Objetivo del Proyecto

Desarrollar una API REST sencilla para gestionar eventos y categorías, implementando:
- Operaciones CRUD completas (Crear, Leer, Actualizar, Eliminar)
- Relación 1:N entre Categorías y Eventos (una categoría puede tener muchos eventos)
- Arquitectura en capas: Controller → Service → Repository
- Validaciones de datos
- Manejo de excepciones

---

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA** (acceso a base de datos)
- **MapStruct** (mapeo Entity ↔ DTO)
- **Lombok** (reducir código boilerplate)
- **Maven** (gestor de dependencias)

---

## 🚀 Instrucciones de Ejecución

### Requisitos previos:
- Tener instalado **Java 17 o superior**
- Tener instalado **Maven** (o usar el wrapper `mvnw` incluido)

### Ejecutar la aplicación:

**Opción 1 - Usando Maven Wrapper (recomendado):**
```bash
./mvnw spring-boot:run
```

**Opción 2 - Usando Maven instalado:**
```bash
mvn spring-boot:run
```

La aplicación se iniciará en: **http://localhost:8080**

---

## 📊 Modelo de Datos

### Category (Categoría)
- `id`: Identificador único
- `name`: Nombre de la categoría (ej: "Conciertos", "Deportes")
- `description`: Descripción

### Event (Evento)
- `id`: Identificador único
- `name`: Nombre del evento
- `date`: Fecha del evento
- `location`: Ubicación
- `category`: Categoría a la que pertenece (relación ManyToOne)

**Relación:** Una categoría puede tener muchos eventos (1:N)

---

## 📦 Datos de Prueba

Al iniciar la aplicación, se cargan automáticamente:
- **3 categorías** (Conciertos, Deportes, Conferencias)
- **3 eventos** de ejemplo

---

## 📁 Estructura del Proyecto

```
src/main/java/com/Psp/ApiEventos/
├── controller/      # Endpoints REST
├── service/         # Lógica de negocio
├── repository/      # Acceso a datos (JPA)
├── domain/          # Entidades (Event, Category)
├── dto/             # Objetos de transferencia
├── mapper/          # Conversión Entity ↔ DTO (MapStruct)
├── exception/       # Manejo de errores
└── data/            # Carga de datos iniciales
```

---
## 🔗 Endpoints Disponibles

### Categorías
- `GET /api/categories` - Listar todas
- `GET /api/categories/{id}` - Obtener por ID
- `POST /api/categories` - Crear nueva
- `PUT /api/categories/{id}` - Actualizar
- `DELETE /api/categories/{id}` - Eliminar

### Eventos
- `GET /api/events` - Listar todos
- `GET /api/events/{id}` - Obtener por ID
- `POST /api/events` - Crear nuevo
- `PUT /api/events/{id}` - Actualizar
- `DELETE /api/events/{id}` - Eliminar

---

## 🧪 Probar la API - Con Postman:
1. Importar el archivo `ApiEventos_Postman_Collection.json` (en Postman Ctrl + O)
2. Ejecutar los tests distribuidos en 2 carpetas. (Click derecho + Run -> Start run)
  * Puedes dejar por defecto la configuración de Start run



## 🗄️ Base de Datos H2 (Consola)

Puedes acceder a la consola de H2 en: **http://localhost:8080/h2-console**

- **JDBC URL:** `jdbc:h2:mem:eventosdb`
- **Username:** `sa`
- **Password:** *(dejar en blanco)*

---

## ✅ Validaciones Implementadas

### Al crear/actualizar eventos:
- El nombre es obligatorio (mínimo 3 caracteres)
- La fecha es obligatoria y debe ser presente o futura
- La ubicación es obligatoria
- Debe existir la categoría especificada

### Al crear/actualizar categorías:
- El nombre es obligatorio (entre 3 y 50 caracteres)
- La descripción es opcional (máximo 50 caracteres)

---

## 📝 Ejemplo de Uso

### Crear una categoría:
```bash
POST http://localhost:8080/api/categories
Content-Type: application/json

{
  "name": "Música",
  "description": "Eventos musicales"
}
```

### Crear un evento:
```bash
POST http://localhost:8080/api/events
Content-Type: application/json

{
  "name": "Concierto de Jazz",
  "date": "2026-07-15",
  "location": "Auditorio Nacional",
  "categoryId": 1
}
```

---

## 📄 Documentación Adicional

- **Colección de Postman:** `ApiEventos_Postman_Collection.json`
- **Documentación de endpoints:** `Documentacion_Postman.md`
