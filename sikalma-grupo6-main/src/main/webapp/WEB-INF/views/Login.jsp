<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar sesión — Sikalma</title>
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>

    <!-- Panel izquierdo decorativo -->
    <div class="login-izquierda">
        <img src="/images/logo-policlinico.png" alt="Logo Sikalma">
        <h2>Policlínico Sikalma</h2>
        <p>Bienvenido al sistema de gestión médica. Inicia sesión para continuar.</p>
    </div>

    <!-- Panel derecho con formulario -->
    <div class="login-derecha">
        <div class="login">
            <h1>Iniciar sesión</h1>
            <p>Ingresa tu correo y contraseña para acceder al sistema.</p>

            <!-- Mensaje de error -->
            <c:if test="${not empty error}">
                <div class="error-mensaje">
                    <span>${error}</span>
                </div>
            </c:if>

            <form method="post" action="/login">
                <div class="campo">
                    <label for="correo">Correo electrónico</label>
                    <input type="email"
                           id="correo"
                           name="correo"
                           placeholder="ejemplo@correo.com"
                           value="${not empty correo ? correo : ''}"
                           required>
                </div>

                <div class="campo">
                    <label for="contrasena">Contraseña</label>
                    <input type="password"
                           id="contrasena"
                           name="contrasena"
                           placeholder="••••••••"
                           required>
                </div>

                <button type="submit" class="btn-login">Ingresar</button>
            </form>
        </div>
    </div>

</body>
</html>
