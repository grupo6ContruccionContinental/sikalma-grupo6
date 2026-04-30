<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo-policlinico.png">
    <title>Editar Atención - SIKALMA</title>
    <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <main>
        <div class="encabezado">
            <div class="encabezado-texto">
                <div class="retorno">
                    <a href="/atencion/gestion">Gestión de Atenciones</a>
                    <span>›</span>
                    <span>Editar Atención #A0${atencion.id}</span>
                </div>
                <h1>Editar Atención</h1>
                <p>Modifica los datos clínicos de la atención registrada</p>
            </div>
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
        </div>

        <div class="formulario-card">
            <h2>Datos de la Atención — ID: #A0${atencion.id} / Cita origen: #${atencion.idCita}</h2>

            <form action="/atencion/actualizar" method="post">

                <!-- ID oculto para identificar el registro en el POST -->
                <input type="hidden" name="id" value="${atencion.id}">

                <!-- Campos readonly heredados de la Cita (se mandan como hidden para no perderlos) -->
                <div class="fila-form">
                    <div>
                        <label>Paciente</label>
                        <input type="text" value="${atencion.nombrePaciente}"
                               readonly style="background-color:#f5f0f0; color:#9a8a88;">
                        <input type="hidden" name="nombrePaciente" value="${atencion.nombrePaciente}">
                    </div>
                    <div>
                        <label>Doctor</label>
                        <input type="text" value="${atencion.nombreDoctor}"
                               readonly style="background-color:#f5f0f0; color:#9a8a88;">
                        <input type="hidden" name="nombreDoctor" value="${atencion.nombreDoctor}">
                    </div>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Servicio</label>
                        <input type="text" value="${atencion.nombreServicio}"
                               readonly style="background-color:#f5f0f0; color:#9a8a88;">
                        <input type="hidden" name="nombreServicio" value="${atencion.nombreServicio}">
                    </div>
                    <div>
                        <label>Fecha de atención</label>
                        <input type="date" name="fechaAtencion" value="${atencion.fechaAtencion}">
                    </div>
                </div>

                <!-- Campos editables -->
                <div class="fila-form">
                    <div>
                        <label>Hora de inicio</label>
                        <input type="time" name="horaInicio" value="${atencion.horaInicio}">
                    </div>
                    <div>
                        <label>Hora de fin</label>
                        <input type="time" name="horaFin" value="${atencion.horaFin}">
                    </div>
                </div>

                <div class="campo">
                    <label>Diagnóstico</label>
                    <textarea name="diagnostico" rows="3"
                              placeholder="Describa el diagnóstico del paciente...">${atencion.diagnostico}</textarea>
                </div>

                <div class="campo">
                    <label>Tratamiento indicado</label>
                    <textarea name="tratamiento" rows="3"
                              placeholder="Indique el tratamiento o medicación recetada...">${atencion.tratamiento}</textarea>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Costo del servicio (S/)</label>
                        <input type="number" step="0.01" name="costo" value="${atencion.costo}">
                    </div>
                    <div>
                        <label>Estado de la atención</label>
                        <select name="estado">
                            <option value="Pendiente"  ${atencion.estado == 'Pendiente'  ? 'selected' : ''}>Pendiente</option>
                            <option value="En curso"   ${atencion.estado == 'En curso'   ? 'selected' : ''}>En curso</option>
                            <option value="Completada" ${atencion.estado == 'Completada' ? 'selected' : ''}>Completada</option>
                        </select>
                    </div>
                </div>

                <div class="campo">
                    <label>Observaciones adicionales</label>
                    <textarea name="observaciones" rows="2"
                              placeholder="Notas adicionales (opcional)...">${atencion.observaciones}</textarea>
                </div>

                <!-- FK ocultas para que el Repository pueda preservarlas -->
                <input type="hidden" name="idCita"     value="${atencion.idCita}">
                <input type="hidden" name="idPaciente" value="${atencion.idPaciente}">
                <input type="hidden" name="idDoctor"   value="${atencion.idDoctor}">
                <input type="hidden" name="idServicio" value="${atencion.idServicio}">

                <div class="form-acciones">
                    <a href="/atencion/gestion" class="btn-secundario">Cancelar</a>
                    <button type="submit" class="btn-primario">Guardar Cambios</button>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
