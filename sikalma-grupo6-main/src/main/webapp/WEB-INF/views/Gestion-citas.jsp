<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
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
        <%-- ── Encabezado ────────────────────────────────────────────────── --%>
        <div class="encabezado">
            <div class="encabezado-texto">
                <h1>Gestión de Citas</h1>
                <c:choose>
                    <c:when test="${sessionScope.rolUsuario == 'DOCTOR'}">
                        <p>Estas son las citas asignadas a <strong>${sessionScope.nombreUsuario}</strong></p>
                    </c:when>
                    <c:otherwise>
                        <p>Administra, organiza y controla las citas médicas del policlínico</p>
                    </c:otherwise>
                </c:choose>
            </div>
            <c:if test="${sessionScope.rolUsuario == 'ADMIN'}">
                <a href="/cita/r-citas" class="btn-primario">+ Nueva Cita</a>
            </c:if>
        </div>

        <%-- ── Banner vista doctor ───────────────────────────────────────── --%>
        <c:if test="${sessionScope.rolUsuario == 'DOCTOR'}">
            <div class="banner-doctor">
                <span class="banner-icono">&#9877;</span>
                <div>
                    <strong>Vista de Doctor — ${sessionScope.nombreUsuario}</strong>
                    <span>Solo puedes ver y atender las citas que te han sido asignadas.</span>
                </div>
            </div>
        </c:if>

        <%-- ── Error al atender ──────────────────────────────────────────── --%>
        <c:if test="${not empty errorAtender}">
            <div class="mensaje-error">
                <span>&#9888;</span> ${errorAtender}
            </div>
        </c:if>

        <%-- ── Estadísticas (solo ADMIN) ─────────────────────────────────── --%>
        <c:if test="${sessionScope.rolUsuario == 'ADMIN'}">
            <div class="estadisticas">
                <div class="estadistica">
                    <img src="/images/usuarios.png" alt="pacientes">
                    <div><h2>7</h2><p>Pacientes</p></div>
                </div>
                <div class="estadistica">
                    <img src="/images/calendario.png" alt="citas hoy">
                    <div><h2>6</h2><p>Citas para hoy</p></div>
                </div>
                <div class="estadistica">
                    <img src="/images/reloj.png" alt="pendientes">
                    <div><h2>4</h2><p>Pendientes</p></div>
                </div>
                <div class="estadistica">
                    <img src="/images/check.png" alt="confirmadas">
                    <div><h2>15</h2><p>Confirmadas</p></div>
                </div>
            </div>
        </c:if>

        <%-- ── Tabla de citas ─────────────────────────────────────────────── --%>
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
                    <c:choose>
                        <c:when test="${empty citas}">
                            <tr>
                                <td colspan="8" style="text-align:center; color:#9a8a88; padding:2em;">
                                    No hay citas registradas.
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="cita" items="${citas}">
                                <tr>
                                    <td>#00${cita.id}</td>
                                    <td>${cita.paciente.nombres}</td>
                                    <td>${cita.servicio.nombre}</td>
                                    <td>${cita.doctor.nombre}</td>
                                    <td>${cita.fecha}</td>
                                    <td>${cita.hora}</td>
                                    <td>
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

                                        <%-- ══ Acciones ADMIN ══ --%>
                                        <c:if test="${sessionScope.rolUsuario == 'ADMIN'}">
                                            <c:choose>

                                                <%-- Estado: Pendiente → Editar | Cancelar | Confirmar | No asistió --%>
                                                <c:when test="${cita.estado == 'Pendiente'}">
                                                    <a href="/cita/editar?id=${cita.id}"   class="btn-editar">Editar</a>
                                                    <a href="/cita/cancelar?id=${cita.id}" class="btn-cancelar">Cancelar</a>
                                                    <a href="/cita/confirmar?id=${cita.id}" class="btn-confirmar">Confirmar</a>
                                                    <a href="/cita/no-asistio?id=${cita.id}" class="btn-noasistio">No asistió</a>
                                                </c:when>

                                                <%-- Estado: Confirmada → No asistió | Editar | Cancelar --%>
                                                <c:when test="${cita.estado == 'Confirmada'}">
                                                    <a href="/cita/no-asistio?id=${cita.id}" class="btn-noasistio">No asistió</a>
                                                    <a href="/cita/editar?id=${cita.id}"   class="btn-editar">Editar</a>
                                                    <a href="/cita/cancelar?id=${cita.id}" class="btn-cancelar">Cancelar</a>
                                                </c:when>

                                                <%-- Otros estados (Cancelada / No asistió) → solo Eliminar --%>
                                                <c:otherwise>
                                                    <a href="/cita/eliminar?id=${cita.id}" class="btn-eliminar"
                                                       onclick="return confirm('¿Eliminar esta cita?')">Eliminar</a>
                                                </c:otherwise>

                                            </c:choose>
                                        </c:if>

                                        <%-- ══ Acción DOCTOR: solo Atender si la cita está Confirmada (REQ-A04) ══ --%>
                                        <c:if test="${sessionScope.rolUsuario == 'DOCTOR'}">
                                            <c:choose>
                                                <c:when test="${cita.estado == 'Confirmada'}">
                                                    <a href="/cita/atender?id=${cita.id}" class="btn-atender">Atender</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <%-- REQ-A04: cita no Confirmada → botón bloqueado --%>
                                                    <span class="btn-atender btn-disabled"
                                                          title="Solo se puede atender una cita en estado Confirmada"
                                                          style="opacity:0.45; cursor:not-allowed; pointer-events:none;">
                                                        Atender
                                                    </span>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:if>

                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>
