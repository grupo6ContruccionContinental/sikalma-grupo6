<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar sesión — Sikalma</title>
    <link rel="icon" href="/images/logo-policlinico.png">
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>

    <!-- Panel izquierdo decorativo -->
    <div class="login-izquierda">
        <img src="/images/logo-policlinico.png" alt="Logo Sikalma">
        <h2>Policlínico Sikalma</h2>
        <p>Sistema de gestión médica integral. Accede con tus credenciales para continuar.</p>

        <div class="login-roles">
            <div class="rol-item">
                <span class="rol-icono">&#9812;</span>
                <div>
                    <strong>Administrador</strong>
                    <span>Gestión completa del sistema</span>
                </div>
            </div>
            <div class="rol-item">
                <span class="rol-icono">&#9877;</span>
                <div>
                    <strong>Doctor</strong>
                    <span>Acceso a sus citas asignadas</span>
                </div>
            </div>
        </div>
    </div>

    <!-- Panel derecho con formulario -->
    <div class="login-derecha">
        <div class="login">
            <div class="login-header">
                <div class="login-logo-small">
                    <img src="/images/logo-policlinico.png" alt="Logo">
                </div>
                <h1>Iniciar sesión</h1>
                <p>Ingresa tus credenciales para acceder al sistema.</p>
            </div>

            <!-- Mensaje de error -->
            <c:if test="${not empty error}">
                <div class="error-mensaje">
                    <span class="error-icono">&#9888;</span>
                    <span>${error}</span>
                </div>
            </c:if>

            <form method="post" action="/login">
                <div class="campo">
                    <label for="correo">Correo electrónico</label>
                    <div class="input-wrapper">
                        <span class="input-icono">&#64;</span>
                        <input type="email"
                               id="correo"
                               name="correo"
                               placeholder="ejemplo@sikalma.com"
                               value="${not empty correo ? correo : ''}"
                               required>
                    </div>
                </div>

                <div class="campo">
                    <label for="contrasena">Contraseña</label>
                    <div class="input-wrapper">
                        <span class="input-icono">&#128274;</span>
                        <input type="password"
                               id="contrasena"
                               name="contrasena"
                               placeholder="••••••••"
                               required>
                    </div>
                </div>

                <button type="submit" class="btn-login">
                    <span>Ingresar al sistema</span>
                    <span class="btn-flecha">&#8594;</span>
                </button>
            </form>

            <div class="login-footer">
                <span>&#128274;</span>
                <span>Acceso restringido — Solo personal autorizado</span>
            </div>
        </div>
    </div>

</body>
</html>
