import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../context/useAuth';
import api from '../api/axiosConfig';
import {
  Mail,
  Lock,
  LogIn,
  AlertCircle,
  Loader2,
  LogInIcon,
} from 'lucide-react';
import '../styles/login.css';

export default function LoginPage() {
  const [email, setEmail]       = useState('');
  const [password, setPassword] = useState('');
  const [error, setError]       = useState('');
  const [cargando, setCargando] = useState(false);

  const { login } = useAuth();
  const navigate  = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');
    setCargando(true);

    try {
      const response = await api.post('/auth/login', { email, password });
      login(response.data);

      const rol = response.data.rol;
      if (rol === 'ADMIN' || rol === 'ASIGNADOR') {
        navigate('/dashboard');
      } else {
        navigate('/mis-tareas');
      }
    } catch (err) {
      if (err.response?.status === 401) {
        setError('Correo o contraseña incorrectos');
      } else if (err.response?.status === 403) {
        setError('Usuario desactivado. Contacta al administrador');
      } else {
        setError('Error al conectar con el servidor');
      }
    } finally {
      setCargando(false);
    }
  };

  return (
    <div className="login-fondo">
      <div className="login-card">

        {/* Ícono superior */}
        <div className="login-icon-wrap">
          <LogInIcon size={26} strokeWidth={2} />
        </div>

        {/* Título y descripción */}
        <div className="login-header">
          <h1>Iniciar sesión</h1>
          <p>Gestiona y da seguimiento a las tareas técnicas de tu equipo.</p>
        </div>

        {/* Formulario */}
        <form onSubmit={handleSubmit} className="login-form">

          {error && (
            <div className="alerta-error">
              <AlertCircle size={15} strokeWidth={2} />
              {error}
            </div>
          )}

          {/* Email */}
          <div className="form-grupo">
            <div className="input-wrap">
              <span className="input-icon">
                <Mail size={16} strokeWidth={1.8} />
              </span>
              <input
                id="email"
                type="email"
                placeholder="Correo electrónico"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
                autoFocus
              />
            </div>
          </div>

          {/* Contraseña */}
          <div className="form-grupo">
            <div className="input-wrap">
              <span className="input-icon">
                <Lock size={16} strokeWidth={1.8} />
              </span>
              <input
                id="password"
                type="password"
                placeholder="Contraseña"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
          </div>

          {/* Botón */}
          <button
            type="submit"
            className="login-btn"
            disabled={cargando}
          >
            {cargando ? (
              <>
                <Loader2 size={17} strokeWidth={2} className="spin" />
                Iniciando sesión...
              </>
            ) : (
              <>
                <LogIn size={17} strokeWidth={2} />
                Ingresar al sistema
              </>
            )}
          </button>

        </form>

        {/* Nota */}
        <p className="login-nota">acceso seguro · solo personal autorizado</p>

      </div>
    </div>
  );
}