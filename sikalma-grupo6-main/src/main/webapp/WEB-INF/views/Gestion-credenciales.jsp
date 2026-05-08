<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo-policlinico.png">
    <title>Credenciales - SIKALMA</title>
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="/css/gestion-credenciales.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <main>
        <%-- ── Encabezado ─────────────────────────────────────────────────── --%>
        <div class="encabezado">
            <div class="encabezado-texto">
                <h1>Gestión de Credenciales</h1>
                <p>Administra los accesos de los doctores al sistema</p>
            </div>
            <a href="/credenciales/nueva" class="btn-primario">+ Nueva Credencial</a>
        </div>

        <%-- ── Mensaje de éxito tras crear credencial --%>
        <c:if test="${not empty param.ok}">
            <div class="mensaje-exito">
                &#10003; Credencial registrada correctamente.
            </div>
        </c:if>

        <%-- ── Tabla de credenciales ───────────────────────────────────────── --%>
        <div class="tabla-contenedor">
            <div class="tabla-encabezado">
                <h3>Listado de Credenciales de Doctores</h3>
                <p>Total: ${credenciales.size()} registros</p>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Correo</th>
                        <th>Doctor asociado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${empty credenciales}">
                            <tr>
                                <td colspan="5" style="text-align:center; color:#9a8a88; padding:2em;">
                                    No hay credenciales de doctores registradas aún.
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="cred" items="${credenciales}">
                                <tr>
                                    <td>#U0${cred.id}</td>
                                    <td>${cred.nombre}</td>
                                    <td>${cred.correo}</td>
                                    <td>
                                        <c:set var="nombreDoctor" value="Sin asignar"/>
                                        <c:forEach var="doc" items="${doctores}">
                                            <c:if test="${doc.id == cred.doctorId}">
                                                <c:set var="nombreDoctor" value="${doc.nombre}"/>
                                            </c:if>
                                        </c:forEach>
                                        <span class="badge-doctor-nombre">${nombreDoctor}</span>
                                    </td>
                                    <td class="td-acciones">
                                        <a href="/credenciales/eliminar?id=${cred.id}"
                                           class="btn-eliminar"
                                           onclick="return confirm('¿Eliminar la credencial de ${cred.nombre}?')">
                                            Eliminar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>

        <%-- ── Aviso informativo ───────────────────────────────────────────── --%>
        <div class="aviso-info">
            <span class="aviso-icono">&#8505;</span>
            <p>Las credenciales de doctores permiten el acceso al sistema con rol <strong>DOCTOR</strong>.
               Cada doctor solo puede tener una credencial activa y únicamente verá las citas que le correspondan.</p>
        </div>
    </main>
</body>
</html>
