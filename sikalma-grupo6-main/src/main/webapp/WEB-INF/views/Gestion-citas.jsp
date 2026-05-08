<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo-policlinico.png">
    <title>Gestión de Citas - SIKALMA</title>
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="/css/gestion-citas.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <main>
        <div class="encabezado">
            <div class="encabezado-texto">
                <h1>Gestión de Citas</h1>
                <p>Administra, organiza y controla las citas médicas del policlínico</p>
            </div>
            <a href="/cita/r-citas" class="btn-primario">+ Nueva Cita</a>
        </div>

        <%-- REQ-A04: mensaje cuando se intenta atender una cita no Confirmada --%>
        <c:if test="${not empty errorAtender}">
            <div class="mensaje-error">
                <span>&#9888;</span> ${errorAtender}
            </div>
        </c:if>

        <div class="estadisticas">
            <div class="estadistica">
                <img src="/images/usuarios.png" alt="pacientes">
                <div>
                    <h2>7</h2>
                    <p>Pacientes</p>
                </div>
            </div>
            <div class="estadistica">
                <img src="/images/calendario.png" alt="citas hoy">
                <div>
                    <h2>6</h2>
                    <p>Citas para hoy</p>
                </div>
            </div>
            <div class="estadistica">
                <img src="/images/reloj.png" alt="pendientes">
                <div>
                    <h2>4</h2>
                    <p>Pendientes</p>
                </div>
            </div>
            <div class="estadistica">
                <img src="/images/check.png" alt="atendidos">
                <div>
                    <h2>15</h2>
                    <p>Confirmadas</p>
                </div>
            </div>
        </div>

        <div class="tabla-contenedor">
            <div class="tabla-encabezado">
                <h3>Listado de Citas</h3>
                <p>Total: ${citas.size()} registros</p>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Paciente</th>
                        <th>Servicio</th>
                        <th>Doctor</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cita" items="${citas}">
                    <tr>
                        <td>#00${cita.id}</td>
                        <td>${cita.paciente.nombres}</td>
                        <td>${cita.servicio.nombre}</td>
                        <td>${cita.doctor.nombre}</td>
                        <td>${cita.fecha}</td>
                        <td>${cita.hora}</td>
                        <td>
                            <%-- REQ-C07: badge diferenciado para "No asistió" --%>
                            <c:choose>
                                <c:when test="${cita.estado == 'Confirmada'}">
                                    <span class="estado estado-confirmado">${cita.estado}</span>
                                </c:when>
                                <c:when test="${cita.estado == 'No asistió'}">
                                    <span class="estado estado-cancelado">${cita.estado}</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="estado estado-pendiente">${cita.estado}</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td class="td-acciones">
                            <a href="/cita/editar?id=${cita.id}" class="btn-editar">Editar</a>
                            <a href="/cita/cancelar?id=${cita.id}" class="btn-cancelar">Cancelar</a>
                            <%-- REQ-A04: botón Atender siempre visible; el controller valida el estado --%>
                            <a href="/cita/atender?id=${cita.id}" class="btn-atender">Atender</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>
