<div align="center">

# 🔧 TecManager

### Sistema de Gestión y Asignación de Tareas Técnicas

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-green?style=flat-square&logo=springboot)
![React](https://img.shields.io/badge/React-19-blue?style=flat-square&logo=react)
![MongoDB](https://img.shields.io/badge/MongoDB-Atlas-brightgreen?style=flat-square&logo=mongodb)
![JWT](https://img.shields.io/badge/Auth-JWT-purple?style=flat-square&logo=jsonwebtokens)

> Proyecto académico de grado — Ingeniería de Sistemas · Quinto Semestre

</div>

---

## 📋 Descripción

**TecManager** es una plataforma web diseñada para gestionar y asignar tareas técnicas dentro de organizaciones. Centraliza el flujo de trabajo, define responsabilidades por rol y permite hacer seguimiento en tiempo real al estado de cada actividad.

El sistema resuelve una problemática común en áreas técnicas: la falta de herramientas especializadas que coordinen la asignación, ejecución y reporte de tareas entre administradores, asignadores y técnicos.

---

## 🏗️ Arquitectura

El proyecto sigue una arquitectura **cliente-servidor** desacoplada:

```
TecManager/
├── tecmanager/                  # Backend — Spring Boot
│   └── src/main/java/com/demo/tecmanager/
│       ├── config/              # Seguridad, CORS, Seeder
│       ├── controller/          # Endpoints REST
│       ├── document/            # Documentos MongoDB
│       ├── dto/                 # Objetos de transferencia
│       ├── enums/               # Roles, estados, prioridades
│       ├── exception/           # Manejo global de errores
│       ├── repository/          # Interfaces MongoDB
│       ├── security/            # JWT + Spring Security
│       └── service/             # Lógica de negocio
│
└── TecManager-Front/            # Frontend — React + Vite
    └── src/
        ├── api/                 # Configuración Axios
        ├── components/          # Componentes reutilizables
        │   ├── dashboard/       # Gráficas y métricas
        │   ├── layout/          # Navbar, rutas privadas
        │   ├── tareas/          # Cards, formularios, modales
        │   └── usuarios/        # Tabla y formulario de usuarios
        ├── context/             # AuthContext (JWT)
        ├── pages/               # Páginas principales
        └── styles/              # CSS por módulo
```

---

## ⚙️ Stack Tecnológico

### Backend
| Tecnología | Versión | Uso |
|---|---|---|
| Java | 17 | Lenguaje principal |
| Spring Boot | 3.2 | Framework backend |
| Spring Security | 6 | Autenticación y autorización |
| JWT (jjwt) | 0.12.3 | Tokens de acceso |
| MongoDB | Atlas | Base de datos principal |
| Spring Data MongoDB | — | ODM para MongoDB |
| Lombok | — | Reducción de boilerplate |
| MapStruct | 1.5.5 | Mapeo de objetos |
| Maven | 3.9 | Gestión de dependencias |

### Frontend
| Tecnología | Versión | Uso |
|---|---|---|
| React | 19 | Framework UI |
| Vite | 7 | Bundler y dev server |
| React Router DOM | 7 | Enrutamiento SPA |
| Axios | 1.13 | Cliente HTTP |
| Recharts | 3.7 | Gráficas del dashboard |
| Lucide React | 0.577 | Iconografía |
| Nunito / Nunito Sans | — | Tipografía |

---

## 👥 Roles del Sistema

El sistema implementa control de acceso basado en **3 roles diferenciados**:

| Rol | Descripción | Acceso |
|---|---|---|
| `ADMIN` | Administrador del sistema | Dashboard, Tareas, Usuarios, Historial |
| `ASIGNADOR` | Crea y asigna tareas al equipo | Dashboard, Tareas, Historial |
| `TECNICO` | Ejecuta las tareas asignadas | Mis Tareas (lectura + cambio de estado) |

---

## 🔄 Flujo de Trabajo

```
Usuario se autentica
        │
        ├── ADMIN ──────► Gestión de usuarios + todas las funciones
        │
        ├── ASIGNADOR ──► Crea tarea → Asigna técnico → Define prioridad
        │                       │
        │                       ▼
        │               [Notificación automática al técnico]
        │
        └── TECNICO ───► Ve sus tareas → Actualiza estado → Genera reporte
                                │
                                ▼
                        PENDIENTE → EN_PROCESO → FINALIZADA
                                         │
                                    EN_ESPERA (si aplica)
```

---

## 🗂️ Módulos Principales

### 🔐 Autenticación
- Login con JWT Bearer token
- Redirección automática según rol
- Sesión persistida en `localStorage`
- Interceptor Axios para headers automáticos

### 📊 Dashboard *(ADMIN / ASIGNADOR)*
- Métricas en tiempo real: total, pendientes, en proceso, finalizadas, vencidas, en espera
- Panel de KPIs: porcentaje a tiempo, tiempo promedio, alta prioridad
- Gráfica de barras: tareas por estado
- Gráfica donut: distribución por prioridad
- Ranking de técnicos con barra de progreso proporcional

### 📋 Gestión de Tareas *(ADMIN / ASIGNADOR)*
- CRUD completo de tareas
- Filtros por estado, prioridad y búsqueda por título
- Indicador visual de tareas vencidas
- Cambio de estado con comentario obligatorio
- Historial completo de cambios por tarea

### 🔧 Mis Tareas *(TECNICO)*
- Vista personalizada de tareas asignadas
- Filtros rápidos por estado
- Cambio de estado con reporte técnico
- Notificaciones de nuevas asignaciones

### 👤 Gestión de Usuarios *(ADMIN)*
- CRUD completo de usuarios
- Asignación de roles
- Activación / desactivación de cuentas
- Filtros por rol y búsqueda

### 📜 Historial y Reportes
- Timeline completo de cambios por tarea
- Reportes técnicos por cambio de estado
- Trazabilidad: creación, edición, cambio de estado, reasignación

### 🔔 Notificaciones
- Notificaciones automáticas al asignar tareas
- Alertas al cambiar estado de una tarea
- Badge contador en tiempo real (polling cada 30 s)

---

## 🚀 Instalación y Configuración

### Prerrequisitos
- Java 17+
- Node.js 20+
- MongoDB Atlas (o local)
- Maven 3.9+

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/tecmanager.git
cd tecmanager
```

### 2. Configurar el Backend

Edita `tecmanager/src/main/resources/application-dev.properties`:

```properties
spring.data.mongodb.uri=mongodb+srv://<usuario>:<password>@cluster0.xxxxx.mongodb.net/
spring.data.mongodb.database=tecmanager

app.jwt.secret=TuClaveSecretaBase64AquiDebeSerLarga
app.jwt.expiration=86400000
```

Ejecuta el backend:

```bash
cd tecmanager
./mvnw spring-boot:run
```

El servidor arranca en `http://localhost:8080`

Al iniciar por primera vez se crea automáticamente el usuario administrador:
- **Email:** `admin@sistema.com`
- **Password:** `Admin1234`

### 3. Configurar el Frontend

```bash
cd TecManager-Front/tecmanager-frontend
npm install
npm run dev
```

La aplicación queda disponible en `http://localhost:5173`

---

## 🔌 API REST — Endpoints Principales

### Autenticación
```
POST   /api/auth/login                    → Login y obtención de token
```

### Usuarios
```
GET    /api/usuarios                      → Listar todos (ADMIN)
POST   /api/usuarios                      → Crear usuario (ADMIN)
PUT    /api/usuarios/{id}                 → Editar usuario (ADMIN)
PATCH  /api/usuarios/{id}/estado          → Activar/desactivar (ADMIN)
DELETE /api/usuarios/{id}                 → Eliminar (ADMIN)
GET    /api/usuarios/rol/{rol}            → Por rol (ADMIN/ASIGNADOR)
```

### Tareas
```
GET    /api/tareas                        → Listar todas (ADMIN/ASIGNADOR)
POST   /api/tareas                        → Crear tarea (ADMIN/ASIGNADOR)
GET    /api/tareas/mis-tareas             → Tareas del técnico autenticado
PUT    /api/tareas/{id}                   → Editar tarea
PATCH  /api/tareas/{id}/estado            → Cambiar estado + comentario
DELETE /api/tareas/{id}                   → Eliminar tarea
```

### Dashboard
```
GET    /api/dashboard                     → Métricas generales (ADMIN/ASIGNADOR)
GET    /api/dashboard/tecnico/{id}        → Métricas por técnico
```

### Historial y Reportes
```
GET    /api/historial/tarea/{tareaId}     → Historial de cambios
GET    /api/reportes/tarea/{tareaId}      → Reportes técnicos
```

### Notificaciones
```
GET    /api/notificaciones/mis-notificaciones   → Notificaciones del usuario
GET    /api/notificaciones/no-leidas/count      → Conteo de no leídas
PATCH  /api/notificaciones/{id}/leer            → Marcar como leída
```

---

## 📦 Estados de una Tarea

```
PENDIENTE ──► EN_PROCESO ──► FINALIZADA
     │              │
     └──► EN_ESPERA ◄┘
```

| Estado | Descripción |
|---|---|
| `PENDIENTE` | Tarea creada, sin iniciar |
| `EN_PROCESO` | Técnico trabajando activamente |
| `EN_ESPERA` | Bloqueada esperando algo externo |
| `FINALIZADA` | Completada con reporte técnico |

---

## 🧪 Prueba de Flujo Completo

```bash
# 1. Login como ADMIN
POST /api/auth/login
{"email": "admin@sistema.com", "password": "Admin1234"}

# 2. Crear un técnico
POST /api/usuarios
{"nombre": "Carlos López", "email": "carlos@sistema.com", "password": "Tecnico123", "rol": "TECNICO"}

# 3. Crear una tarea asignada a Carlos
POST /api/tareas
{"titulo": "Instalar servidor web", "prioridad": "ALTA", "tecnicoId": "<id_carlos>", "fechaLimite": "2026-12-31T23:59:59"}

# 4. Login como técnico Carlos
POST /api/auth/login
{"email": "carlos@sistema.com", "password": "Tecnico123"}

# 5. Carlos ve sus tareas
GET /api/tareas/mis-tareas

# 6. Carlos inicia la tarea
PATCH /api/tareas/{id}/estado
{"nuevoEstado": "EN_PROCESO", "comentario": "Iniciando instalación del servidor"}

# 7. Carlos finaliza la tarea
PATCH /api/tareas/{id}/estado
{"nuevoEstado": "FINALIZADA", "comentario": "Servidor instalado y configurado correctamente"}

# 8. Ver el historial generado
GET /api/historial/tarea/{id}

# 9. Ver métricas actualizadas
GET /api/dashboard
```

---

## 🔒 Seguridad

- Autenticación mediante **JWT Bearer Token**
- Contraseñas encriptadas con **BCrypt**
- Control de acceso por rol en cada endpoint con `@PreAuthorize`
- Sesiones **stateless** (sin cookies ni sesiones en servidor)
- CORS configurado para `localhost:5173` y `localhost:3000`
- Usuarios desactivados no pueden autenticarse

---

## 📁 Variables de Entorno

| Variable | Descripción | Ejemplo |
|---|---|---|
| `spring.data.mongodb.uri` | URI de conexión MongoDB | `mongodb+srv://user:pass@cluster/` |
| `spring.data.mongodb.database` | Nombre de la base de datos | `tecmanager` |
| `app.jwt.secret` | Clave secreta JWT en Base64 | `VGVjTWFuYWdlci...` |
| `app.jwt.expiration` | Expiración del token en ms | `86400000` (24h) |

---

## 🎓 Contexto Académico

| Campo | Detalle |
|---|---|
| **Institución** | Proyecto de grado universitario |
| **Programa** | Ingeniería de Sistemas |
| **Semestre** | Quinto |
| **Tipo** | Proyecto de aula |
| **Año** | 2025 |

### Objetivos académicos cubiertos
- ✅ Diseño e implementación de APIs REST con Spring Boot
- ✅ Gestión de base de datos NoSQL (MongoDB Atlas)
- ✅ Autenticación y seguridad con JWT + Spring Security
- ✅ Desarrollo frontend con React y gestión de estado
- ✅ Arquitectura cliente-servidor desacoplada
- ✅ Control de acceso basado en roles (RBAC)
- ✅ Patrones de diseño: Repository, DTO, Service Layer

---

## 📄 Licencia

Proyecto académico — uso educativo.

---

<div align="center">
  <sub>Desarrollado como proyecto de aula · Ingeniería de Sistemas</sub>
</div>