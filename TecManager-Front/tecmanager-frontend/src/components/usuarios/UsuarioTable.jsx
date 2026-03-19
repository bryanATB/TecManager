import { Pencil, Trash2, CheckCircle, XCircle } from 'lucide-react';

export default function UsuarioTable({ usuarios, onEditar, onCambiarEstado, onEliminar }) {

  const getBadgeRol = (rol) => ({
    ADMIN:     'badge badge-admin',
    ASIGNADOR: 'badge badge-asignador',
    TECNICO:   'badge badge-tecnico',
  }[rol] || 'badge');

  if (!usuarios.length) return (
    <div className="vacio">No se encontraron usuarios</div>
  );

  return (
    <div className="tabla-contenedor">
      <table>
        <thead>
          <tr>
            <th>Usuario</th>
            <th>Email</th>
            <th>Rol</th>
            <th>Estado</th>
            <th>Fecha creación</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {usuarios.map(u => (
            <tr key={u.id}>

              {/* Avatar + nombre */}
              <td>
                <div style={{ display:'flex', alignItems:'center', gap:10 }}>
                  <div className="usuario-avatar">{u.nombre?.charAt(0).toUpperCase()}</div>
                  <span style={{ fontFamily:'Nunito,sans-serif', fontWeight:700, fontSize:13.5 }}>
                    {u.nombre}
                  </span>
                </div>
              </td>

              <td style={{ color:'#6b6868', fontSize:13 }}>{u.email}</td>

              <td><span className={getBadgeRol(u.rol)}>{u.rol}</span></td>

              {/* Toggle estado */}
              <td>
                <button
                  className={`estado-toggle ${u.activo ? 'activo' : 'inactivo'}`}
                  onClick={() => onCambiarEstado(u.id)}
                >
                  {u.activo
                    ? <><CheckCircle size={12} strokeWidth={2.5} /> Activo</>
                    : <><XCircle    size={12} strokeWidth={2.5} /> Inactivo</>
                  }
                </button>
              </td>

              <td style={{ color:'#6b6868', fontSize:13 }}>
                {u.fechaCreacion
                  ? new Date(u.fechaCreacion).toLocaleDateString('es-CO')
                  : '—'}
              </td>

              {/* Acciones */}
              <td>
                <div style={{ display:'flex', gap:6 }}>
                  <button className="tarea-btn-icon" onClick={() => onEditar(u)} title="Editar">
                    <Pencil size={13} strokeWidth={2} />
                  </button>
                  <button className="tarea-btn-icon tarea-btn-danger" onClick={() => onEliminar(u.id)} title="Eliminar">
                    <Trash2 size={13} strokeWidth={2} />
                  </button>
                </div>
              </td>

            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}