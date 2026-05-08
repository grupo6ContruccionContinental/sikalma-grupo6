<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Editar Cita - SIKALMA</title>
    <link rel="stylesheet" href="../css/admin.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <main>
        <div class="encabezado">
            <div class="encabezado-texto">
                <div class="retorno">
                    <a href="${pageContext.request.contextPath}/cita/g-citas">Gestión de Citas</a>
                    <span>›</span>
                    <span>Editar Cita #${cita.id}</span>
                </div>
                <h1>Editar Cita</h1>
                <p>Modifica los datos de la cita de forma rápida y precisa</p>
            </div>
            <span class="estado estado-${fn:toLowerCase(cita.estado)}">${cita.estado}</span>
        </div>

        <div class="formulario-card">
            <h2>Datos del Paciente — ID Cita: #${cita.id}</h2>

            <%-- Mensaje de error (REQ-C01 al REQ-C08) --%>
            <c:if test="${not empty error}">
                <div class="mensaje-error">
                    <span>&#9888;</span> ${error}
                </div>
            </c:if>

            <form action="${pageContext.request.contextPath}/cita/actualizar" method="post">
                <input type="hidden" name="id" value="${cita.id}">

                <%-- REQ-C01 --%>
                <div class="campo">
                    <label>Paciente</label>
                    <select name="paciente.id" required>
                        <option value="">— Seleccione un paciente —</option>
                        <c:forEach var="p" items="${pacientes}">
                            <option value="${p.id}" <c:if test="${cita.paciente.id == p.id}">selected</c:if>>${p.nombre}</option>
                        </c:forEach>
                    </select>
                </div>

                <%-- REQ-C03 y REQ-C02 --%>
                <div class="fila-form">
                    <div>
                        <label>Servicio (Especialidad)</label>
                        <select name="servicio.id" required>
                            <option value="">— Seleccione un servicio —</option>
                            <c:forEach var="s" items="${servicios}">
                                <option value="${s.id}" <c:if test="${cita.servicio.id == s.id}">selected</c:if>>${s.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label>Doctor Asignado</label>
                        <select name="doctor.id" required>
                            <option value="">— Seleccione un doctor —</option>
                            <c:forEach var="d" items="${doctores}">
                                <option value="${d.id}" <c:if test="${cita.doctor.id == d.id}">selected</c:if>>${d.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <%-- REQ-C04, REQ-C05, REQ-C06 --%>
                <div class="fila-form">
                    <div>
                        <label>Fecha de la Cita</label>
                        <input type="date" name="fecha" value="${cita.fecha}" required>
                    </div>
                    <div>
                        <label>Hora de la Cita</label>
                        <input type="time" name="hora" value="${cita.hora}" required>
                    </div>
                </div>

                <%-- REQ-C07: "No asistió" aparece solo si el estado actual es "Confirmada" --%>
                <div class="campo">
                    <label>Estado</label>
                    <select name="estado">
                        <option value="Pendiente"   <c:if test="${cita.estado == 'Pendiente'}">selected</c:if>>Pendiente</option>
                        <option value="Confirmada"  <c:if test="${cita.estado == 'Confirmada'}">selected</c:if>>Confirmada</option>
                        <option value="Cancelada"   <c:if test="${cita.estado == 'Cancelada'}">selected</c:if>>Cancelada</option>
                        <c:if test="${cita.estado == 'Confirmada' || cita.estado == 'No asistió'}">
                            <option value="No asistió" <c:if test="${cita.estado == 'No asistió'}">selected</c:if>>No asistió</option>
                        </c:if>
                    </select>
                </div>

                <div class="form-acciones">
                    <a href="${pageContext.request.contextPath}/cita/g-citas" class="btn-secundario">Cancelar</a>
                    <button type="submit" class="btn-primario">Guardar Cambios</button>
                </div>
            </form>
        </div>
    </main>
</body>
</html>