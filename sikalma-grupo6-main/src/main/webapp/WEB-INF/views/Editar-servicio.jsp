<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo-policlinico.png">
    <title>Editar Servicio - SIKALMA</title>
    <link rel="stylesheet" href="/css/admin.css">
    <style>
        .error-msg {
            color: #e53e3e;
            font-size: 0.85rem;
            margin-top: 4px;
        }
        .input-error {
            border-color: #e53e3e !important;
        }
    </style>
</head>
<body>
<%@ include file="navbar.jsp" %>

<main>
    <div class="encabezado">
        <div class="encabezado-texto">
            <div class="retorno">
                <a href="/servicio/gestion">Servicios</a>
                <span>›</span>
                <span>Editar Servicio #S0${servicio.id}</span>
            </div>
            <h1>Editar Servicio</h1>
            <p>Modifica el nombre, descripción o costo del servicio</p>
        </div>
    </div>

    <div class="formulario-card">
        <h2>Datos del Servicio — ID: #S0${servicio.id}</h2>

        <form action="/servicio/editar" method="post">

            <input type="hidden" name="id" value="${servicio.id}">

            <%-- REQ-S01: Validación nombre --%>
            <div class="campo">
                <label>Nombre del servicio</label>
                <input type="text"
                       value="${servicio.nombre}"
                       name="nombre"
                       class="${not empty errorNombre ? 'input-error' : ''}">
                <% if (request.getAttribute("errorNombre") != null) { %>
                <span class="error-msg">${errorNombre}</span>
                <% } %>
            </div>

            <%-- REQ-S02: Validación descripción --%>
            <div class="campo">
                <label>Descripción</label>
                <textarea rows="3"
                          name="descripcion"
                          class="${not empty errorDescripcion ? 'input-error' : ''}">${servicio.descripcion}</textarea>
                <% if (request.getAttribute("errorDescripcion") != null) { %>
                <span class="error-msg">${errorDescripcion}</span>
                <% } %>
            </div>

            <%-- REQ-S03: Validación costo --%>
            <div class="campo">
                <label>Costo (S/)</label>
                <input type="number"
                       value="${servicio.costo}"
                       name="costo"
                       step="0.01"
                       min="0.01"
                       class="${not empty errorCosto ? 'input-error' : ''}">
                <% if (request.getAttribute("errorCosto") != null) { %>
                <span class="error-msg">${errorCosto}</span>
                <% } %>
            </div>

            <div class="form-acciones">
                <a href="/servicio/gestion" class="btn-secundario">Cancelar</a>
                <button type="submit" class="btn-primario">Guardar Cambios</button>
            </div>
        </form>
    </div>
</main>
</body>
</html>