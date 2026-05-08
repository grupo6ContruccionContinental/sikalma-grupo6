<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Gestión de Citas - SIKALMA</title>
    <link rel="stylesheet" href="../css/admin.css">
    <link rel="stylesheet" href="../css/gestion-citas.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <main>
        <div class="encabezado">
            <div class="encabezado-texto">
                <h1>Gestión de Citas</h1>
                <p>Administra, organiza y controla las citas médicas del policlínico</p>
            </div>
            <a href="${pageContext.request.contextPath}/cita/r-citas" class="btn-primario">+ Nueva Cita</a>
        </div>

        <%-- Mensaje de error global (ej: "No asistió" sobre estado incorrecto) --%>
        <c:if test="${not empty error}">
            <div class="mensaje-error">
                <span>&#9888;</span> ${error}
            </div>
        </c:if>

        <div class="estadisticas">
            <div class="estadistica">
                <img src="../images/usuarios.png" alt="pacientes">
                <div>
                    <h2>${fn:length(citas)}</h2>
                    <p>Total Citas</p>
                </div>
            </div>
            <div class="estadistica">
                <img src="../images/reloj.png" alt="pendientes">
                <div>
                    <%-- Conteo de pendientes --%>
                    <c:set var="countPendiente" value="0"/>
                    <c:forEach var="c" items="${citas}">
                        <c:if test="${c.estado == 'Pendiente'}">
                            <c:set var="countPendiente" value="${countPendiente + 1}"/>
                        </c:if>
                    </c:forEach>
                    <h2>${countPendiente}</h2>
                    <p>Pendientes</p>
                </div>
            </div>
            <div class="estadistica">
                <img src="../images/check.png" alt="confirmadas">
                <div>
                    <c:set var="countConfirmada" value="0"/>
                    <c:forEach var="c" items="${citas}">
                        <c:if test="${c.estado == 'Confirmada'}">
                            <c:set var="countConfirmada" value="${countConfirmada + 1}"/>
                        </c:if>
                    </c:forEach>
                    <h2>${countConfirmada}</h2>
                    <p>Confirmadas</p>
                </div>
            </div>
            <div class="estadistica">
                <img src="../images/calendario.png" alt="no asistio">
                <div>
                    <c:set var="countNoAsistio" value="0"/>
                    <c:forEach var="c" items="${citas}">
                        <c:if test="${c.estado == 'No asistió'}">
                            <c:set var="countNoAsistio" value="${countNoAsistio + 1}"/>
                        </c:if>
                    </c:forEach>
                    <h2>${countNoAsistio}</h2>
                    <p>No asistieron</p>
                </div>
            </div>
        </div>

        <div class="tabla-contenedor">
            <div class="tabla-encabezado">
                <h3>Listado de Citas</h3>
                <p>Total: ${fn:length(citas)} registros</p>
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
                    <c:forEach var="c" items="${citas}">
                        <%-- Clase CSS dinámica según estado --%>
                        <c:set var="claseEstado" value="estado-pendiente"/>
                        <c:if test="${c.estado == 'Confirmada'}"><c:set var="claseEstado" value="estado-confirmado"/></c:if>
                        <c:if test="${c.estado == 'Cancelada'}"><c:set var="claseEstado" value="estado-cancelado"/></c:if>
                        <c:if test="${c.estado == 'No asistió'}"><c:set var="claseEstado" value="estado-no-asistio"/></c:if>
                        <tr>
                            <td>#${c.id}</td>
                            <td>${c.paciente.nombre}</td>
                            <td>${c.servicio.nombre}</td>
                            <td>${c.doctor.nombre}</td>
                            <td>${c.fecha}</td>
                            <td>${c.hora}</td>
                            <td><span class="estado ${claseEstado}">${c.estado}</span></td>
                            <td class="td-acciones">
                                <a href="${pageContext.request.contextPath}/cita/editar/${c.id}" class="btn-editar">Editar</a>
                                <a href="${pageContext.request.contextPath}/cita/eliminar/${c.id}"
                                   class="btn-cancelar"
                                   onclick="return confirm('¿Seguro que deseas eliminar esta cita?')">Cancelar</a>
                                <%-- REQ-C07: botón "No asistió" solo para citas Confirmadas --%>
                                <c:if test="${c.estado == 'Confirmada'}">
                                    <a href="${pageContext.request.contextPath}/cita/no-asistio/${c.id}"
                                       class="btn-no-asistio"
                                       onclick="return confirm('¿Marcar al paciente como No asistió?')">No asistió</a>
                                </c:if>
                                <c:if test="${c.estado != 'Cancelada' && c.estado != 'No asistió'}">
                                    <a href="${pageContext.request.contextPath}/atencion/registrar/${c.id}" class="btn-atender">Atender</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty citas}">
                        <tr>
                            <td colspan="8" style="text-align:center;">No hay citas registradas.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>