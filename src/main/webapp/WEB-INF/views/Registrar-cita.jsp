<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Registrar Cita - SIKALMA</title>
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
                    <span>Registrar Cita</span>
                </div>
                <h1>Registrar Nueva Cita</h1>
                <p>Complete el formulario para reservar una cita médica</p>
            </div>
        </div>

        <div class="formulario-card">
            <h2>Datos de la Cita</h2>

            <%-- Mensaje de error (REQ-C01 al REQ-C08) --%>
            <c:if test="${not empty error}">
                <div class="mensaje-error">
                    <span>&#9888;</span> ${error}
                </div>
            </c:if>

            <form action="${pageContext.request.contextPath}/cita/guardar" method="post">

                <%-- REQ-C01: Paciente obligatorio --%>
                <div class="campo">
                    <label>Paciente</label>
                    <select name="paciente.id" required>
                        <option value="">— Seleccione un paciente —</option>
                        <c:forEach var="p" items="${pacientes}">
                            <option value="${p.id}">${p.nombre}</option>
                        </c:forEach>
                    </select>
                </div>

                <%-- REQ-C03 y REQ-C02: Servicio y Doctor obligatorios --%>
                <div class="fila-form">
                    <div>
                        <label>Servicio (Especialidad)</label>
                        <select name="servicio.id" required>
                            <option value="">— Seleccione un servicio —</option>
                            <c:forEach var="s" items="${servicios}">
                                <option value="${s.id}">${s.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label>Doctor Asignado</label>
                        <select name="doctor.id" required>
                            <option value="">— Seleccione un doctor —</option>
                            <c:forEach var="d" items="${doctores}">
                                <option value="${d.id}">${d.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <%-- REQ-C04, REQ-C05, REQ-C06: Fecha y hora obligatorias y no pasadas --%>
                <div class="fila-form">
                    <div>
                        <label>Fecha de la Cita</label>
                        <input type="date" name="fecha" required>
                    </div>
                    <div>
                        <label>Hora de la Cita</label>
                        <input type="time" name="hora" required>
                    </div>
                </div>

                <div class="campo">
                    <label>Estado Inicial</label>
                    <select name="estado">
                        <option value="Pendiente">Pendiente</option>
                        <option value="Confirmada">Confirmada</option>
                    </select>
                    <span class="indicacion">El estado puede modificarse más adelante desde Gestión de Citas.</span>
                </div>

                <div class="form-acciones">
                    <a href="${pageContext.request.contextPath}/cita/g-citas" class="btn-secundario">Cancelar</a>
                    <button type="submit" class="btn-primario">Registrar Cita</button>
                </div>
            </form>
        </div>
    </main>
</body>
</html>

