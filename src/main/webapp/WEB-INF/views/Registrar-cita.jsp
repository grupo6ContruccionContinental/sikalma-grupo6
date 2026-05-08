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

        <div class="formulario-card">
            <h2>Datos de la Cita</h2>

            <c:if test="${not empty error}">
                <div style="display: flex; align-items: center; gap: 12px; background-color: #FFFFFF; color: #842029; padding: 15px 20px; border-radius: 8px; margin-bottom: 25px; border-left: 5px solid #dc3545; box-shadow: 0 2px 12px rgba(0,0,0,0.06); font-size: 0.95rem;">
                    <span style="color: #dc3545; font-size: 1.1rem; font-weight: bold;">⚠️</span>
                    <span style="font-weight: 500;">${error}</span>
                </div>
            </c:if>

            <form action="/cita/guardar" method="post">
                <!-- Datos del paciente -->
                <div class="campo">
                    <label>Paciente</label>
                    <select name="paciente">
                        <option value="0">— Seleccione un paciente —</option>
                        <c:forEach var="paciente" items="${pacientes}" >
                        <option value="${paciente.id}">${paciente.nombres}</option>
                        </c:forEach>
                    </select>
                </div>

                <!-- Servicio y especialidad -->
                <div class="fila-form">
                    <div>
                        <label>Servicio (Especialidad)</label>
                        <select name="servicio">
                            <option value="0">— Seleccione un servicio —</option>
                            <c:forEach var="servicio" items="${servicios}" >
                            <option value="${servicio.id}">${servicio.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label>Doctor Asignado</label>
                        <select name="doctor">
                            <option value="0">— Seleccione un doctor —</option>
                            <c:forEach var="doctor" items="${doctores}" >
                            <option value="${doctor.id}"> ${doctor.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <!-- Fecha y hora -->
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

                <!-- Estado inicial -->
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
