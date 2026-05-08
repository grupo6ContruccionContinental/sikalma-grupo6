<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Acceso denegado — Sikalma</title>
    <link rel="stylesheet" href="/css/login.css">
    <style>
        .denegado-box {
            background: white;
            border-radius: 1em;
            padding: 2.5em;
            width: 100%;
            text-align: center;
        }
        .denegado-box .icono { font-size: 3em; margin-bottom: 0.4em; }
        .denegado-box h1 { color: #b94a3e; font-size: 1.3em; margin-bottom: 0.5em; }
        .denegado-box p  { color: #9a8a88; font-size: 0.9em; margin-bottom: 1.5em; }
        .btn-volver {
            display: inline-block;
            padding: 0.75em 2em;
            background-color: #a59485;
            color: white;
            border-radius: 0.4em;
            text-decoration: none;
            font-size: 0.95em;
        }
        .btn-volver:hover { background-color: #8f7d6e; }
    </style>
</head>
<body>
    <div class="login-izquierda">
        <img src="/images/logo-policlinico.png" alt="Logo Sikalma">
        <h2>Policlínico Sikalma</h2>
        <p>Sistema de gestión médica</p>
    </div>
    <div class="login-derecha">
        <div class="denegado-box">
            <div class="icono">🚫</div>
            <h1>Acceso denegado</h1>
            <p>No tienes permisos para acceder a esta sección.<br>
               Serás redirigido a tu área correspondiente.</p>
            <a href="${not empty urlRetorno ? urlRetorno : '/login'}" class="btn-volver">Volver al inicio</a>
        </div>
    </div>
</body>
</html>
