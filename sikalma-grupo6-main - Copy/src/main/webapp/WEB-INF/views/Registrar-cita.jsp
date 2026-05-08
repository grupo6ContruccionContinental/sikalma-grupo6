<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo-policlinico.png">
    <title>Registrar Cita - SIKALMA</title>
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
                    <span>Registrar Cita</span>
                </div>
                <h1>Registrar Nueva Cita</h1>
                <p>Complete el formulario para reservar una cita médica</p>
            </div>
        </div>

        <%-- Bloque de error (REQ-C01..C08) --%>
        <c:if test="${not empty error}">
            <div class="mensaje-error">
                <span>&#9888;</span> ${error}
            </div>
        </c:if>

        <div class="formulario-card">
            <h2>Datos de la Cita</h2>

            <form action="/cita/guardar" method="post">

                <div class="campo">
                    <label>Paciente</label>
                    <select name="paciente">
                        <option value="0">— Seleccione un paciente —</option>
                        <c:forEach var="paciente" items="${pacientes}">
                            <option value="${paciente.id}"
                                <c:if test="${param.paciente == paciente.id}">selected</c:if>>
                                ${paciente.nombres}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Servicio (Especialidad)</label>
                        <select name="servicio">
                            <option value="0">— Seleccione un servicio —</option>
                            <c:forEach var="servicio" items="${servicios}">
                                <option value="${servicio.id}"
                                    <c:if test="${param.servicio == servicio.id}">selected</c:if>>
                                    ${servicio.nombre}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label>Doctor Asignado</label>
                        <select name="doctor">
                            <option value="0">— Seleccione un doctor —</option>
                            <c:forEach var="doctor" items="${doctores}">
                                <option value="${doctor.id}"
                                    <c:if test="${param.doctor == doctor.id}">selected</c:if>>
                                    ${doctor.nombre}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Fecha de la Cita</label>
                        <input type="date" name="fecha" value="${param.fecha}">
                    </div>
                    <div>
                        <label>Hora de la Cita</label>
                        <input type="time" name="hora" value="${param.hora}">
                    </div>
                </div>

                <div class="campo">
                    <label>Estado Inicial</label>
                    <select name="estado">
                        <option>Pendiente</option>
                        <option>Confirmada</option>
                    </select>
                    <span class="indicacion">El estado puede modificarse más adelante desde Gestión de Citas.</span>
                </div>

                <div class="form-acciones">
                    <a href="/cita/g-citas" class="btn-secundario">Cancelar</a>
                    <button type="submit" class="btn-primario">Registrar Cita</button>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
