# TecManager
proyecto de aula semestre 5


login metodo post http://localhost:8080/api/auth/login
credenciales de admin 
{
  "email": "admin@sistema.com",
  "password": "Admin1234"
}

id de carlos 69a4dadc20e9e6611c5343fe
credenciales de carlos
{
  "email": "carlos@sistema.com",
  "password": "Tecnico123"
}

crear tarea
POST http://localhost:8080/api/tareas
Authorization: Bearer <token_admin>
Content-Type: application/json

{
  "titulo": "Instalar servidor web",
  "descripcion": "Instalar y configurar Apache en el servidor principal",
  "prioridad": "ALTA",
  "tecnicoId": "<id_de_carlos>",
  "fechaLimite": "2026-12-31T23:59:59",
  "tiempoEstimadoHoras": 4
}

cambiar estado 
PATCH http://localhost:8080/api/tareas/<id_tarea>/estado
Authorization: Bearer <token_tecnico>

{
  "nuevoEstado": "EN_PROCESO",
  "comentario": "Iniciando la instalación del servidor"
}

finalizar 
PATCH http://localhost:8080/api/tareas/<id_tarea>/estado
Authorization: Bearer <token_tecnico>

{
  "nuevoEstado": "FINALIZADA",
  "comentario": "Servidor instalado y configurado correctamente"
}

ver historial
GET http://localhost:8080/api/historial/tarea/<id_tarea>
Authorization: Bearer <token_admin>


prueba de flujo
1. POST /api/auth/login          → obtener token ADMIN
2. POST /api/usuarios            → crear técnico Carlos
3. POST /api/usuarios            → crear asignadora María
4. POST /api/auth/login          → obtener token ASIGNADOR (María)
5. POST /api/tareas              → crear tarea asignada a Carlos
6. POST /api/auth/login          → obtener token TECNICO (Carlos)
7. GET  /api/tareas/mis-tareas   → Carlos ve su tarea
8. PATCH /api/tareas/{id}/estado → Carlos la pasa a EN_PROCESO
9. PATCH /api/tareas/{id}/estado → Carlos la finaliza con comentario
10. GET /api/reportes/tarea/{id} → ver el reporte generado
11. GET /api/historial/tarea/{id}→ ver todos los cambios registrados
12. GET /api/notificaciones/mis-notificaciones → María ve la notificación
13. GET /api/dashboard           → métricas actualizadas