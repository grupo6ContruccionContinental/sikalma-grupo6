<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo-policlinico.png">
    <title>Gestión de Atenciones - SIKALMA</title>
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <main>
        <div class="encabezado">
            <div class="encabezado-texto">
                <h1>Gestión de Atenciones</h1>
                <p>Registro de atenciones médicas realizadas a partir de citas confirmadas</p>
            </div>
        </div>

        <div class="tabla-contenedor">
            <div class="tabla-encabezado">
                <div>
                    <h3>Listado de Atenciones</h3>
                    <p>Total: ${atenciones.size()} registros</p>
                </div>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID Atención</th>
                        <th>Cita Origen</th>
                        <th>Paciente</th>
                        <th>Servicio</th>
                        <th>Doctor</th>
                        <th>Fecha</th>
                        <th>Diagnóstico</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="atencion" items="${atenciones}">
                        <tr>
                            <td>#A0${atencion.id}</td>
                            <td>#${atencion.idCita}</td>
                            <td>${atencion.nombrePaciente}</td>
                            <td>${atencion.nombreServicio}</td>
                            <td>${atencion.nombreDoctor}</td>
                            <td>${atencion.fechaAtencion}</td>
                            <td>${atencion.diagnostico}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${atencion.estado == 'Completada'}">
                                        <span class="estado estado-atendido">${atencion.estado}</span>
                                    </c:when>
                                    <c:when test="${atencion.estado == 'En curso'}">
                                        <span class="estado estado-confirmado">${atencion.estado}</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="estado estado-pendiente">${atencion.estado}</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td class="td-acciones">
                                <div class="acciones">
                                    <a href="/atencion/ver?id=${atencion.id}" class="btn-ver">Ver</a>
                                    <a href="/atencion/editar?id=${atencion.id}" class="btn-editar">Editar</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>
