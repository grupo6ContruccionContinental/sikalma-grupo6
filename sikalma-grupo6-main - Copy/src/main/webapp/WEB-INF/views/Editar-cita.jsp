<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo-policlinico.png">
    <title>Editar Cita - SIKALMA</title>
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <main>
        <div class="encabezado">
            <div class="encabezado-texto">
                <div class="retorno">
                    <a href="/cita/g-citas">Gestión de Citas</a>
                    <span>›</span>
                    <span>Editar Cita #00${cita.id}</span>
                </div>
                <h1>Editar Cita</h1>
                <p>Modifica los datos de la cita de forma rápida y precisa</p>
            </div>
            <span class="estado estado-pendiente">${cita.estado}</span>
        </div>

        <%-- Bloque de error (REQ-C02..C08) --%>
        <c:if test="${not empty error}">
            <div class="mensaje-error">
                <span>&#9888;</span> ${error}
            </div>
        </c:if>

        <div class="formulario-card">
            <h2>Datos del Paciente — ID Cita: #00${cita.id}</h2>

            <form action="/cita/actualizar" method="post">

                <input type="hidden" name="id" value="${cita.id}">

                <div class="campo">
                    <label>Paciente</label>
                    <input type="text" value="${cita.paciente.nombres}" readonly>
                    <input type="hidden" name="paciente" value="${cita.paciente.id}">
                </div>

                <div class="fila-form">
                    <div>
                        <label>Servicio (Especialidad)</label>
                        <select name="servicio">
                            <option selected value="${cita.servicio.id}">${cita.servicio.nombre}</option>
                            <c:forEach var="servicio" items="${servicios}">
                                <option value="${servicio.id}">${servicio.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label>Doctor Asignado</label>
                        <select name="doctor">
                            <option selected value="${cita.doctor.id}">${cita.doctor.nombre}</option>
                            <c:forEach var="doctor" items="${doctores}">
                                <option value="${doctor.id}">${doctor.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Fecha de la Cita</label>
                        <input type="date" name="fecha" value="${cita.fecha}">
                    </div>
                    <div>
                        <label>Hora de la Cita</label>
                        <input type="time" name="hora" value="${cita.hora}">
                    </div>
                </div>

                <%-- REQ-C07: opción "No asistió" incluida en el <select> de estado --%>
                <div class="campo">
                    <label>Estado</label>
                    <select name="estado">
                        <option value="${cita.estado}" selected>${cita.estado}</option>
                        <option value="Pendiente">Pendiente</option>
                        <option value="Confirmada">Confirmada</option>
                        <option value="No asistió">No asistió</option>
                    </select>
                </div>

                <div class="form-acciones">
                    <a href="/cita/g-citas" class="btn-secundario">Cancelar</a>
                    <button type="submit" class="btn-primario">Guardar Cambios</button>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
