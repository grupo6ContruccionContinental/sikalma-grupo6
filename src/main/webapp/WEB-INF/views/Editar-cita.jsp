<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <a href="Gestion-citas.jsp">Gestión de Citas</a>
                    <span>›</span>
                    <span>Editar Cita #002</span>
                </div>
                <h1>Editar Cita</h1>
                <p>Modifica los datos de la cita de forma rápida y precisa</p>
            </div>
            <span class="estado estado-pendiente">Pendiente</span>
        </div>

        <div class="formulario-card">
            <h2>Datos del Paciente — ID Cita: #002</h2>

            <form>
                <div class="campo">
                    <label>Paciente</label>
                    <select name="paciente">
                        <option selected>Naya Ramos</option>
                        <option>María García López</option>
                        <option>Juan Pérez Torres</option>
                        <option>Ana Rodríguez Silva</option>
                        <option>Carlos Mendoza Rivera</option>
                        <option>Lucía Flores Castillo</option>
                        <option>Roberto Vásquez Huanca</option>
                    </select>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Servicio (Especialidad)</label>
                        <select name="servicio">
                            <option selected>Psicología / Terapias — S/100</option>
                            <option>Medicina General — S/60</option>
                            <option>Odontología — S/80</option>
                            <option>Pediatría — S/80</option>
                            <option>Ginecología — S/90</option>
                            <option>Traumatología — S/90</option>
                        </select>
                    </div>
                    <div>
                        <label>Doctor Asignado</label>
                        <select name="doctor">
                            <option selected>Dra. Aracely Ramos — Psicología</option>
                            <option>Dra. Viviana Sánchez — Odontología</option>
                            <option>Dr. Marcos López — Traumatología</option>
                            <option>Dra. Carla Torres — Pediatría</option>
                            <option>Dra. Fernández — Medicina General</option>
                        </select>
                    </div>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Fecha de la Cita</label>
                        <input type="date" name="fecha" value="2026-04-06">
                    </div>
                    <div>
                        <label>Hora de la Cita</label>
                        <input type="time" name="hora" value="09:00">
                    </div>
                </div>

                <div class="campo">
                    <label>Estado</label>
                    <select name="estado">
                        <option selected>Pendiente</option>
                        <option>Confirmada</option>
                        <option>Cancelada</option>
                    </select>
                </div>

                <div class="form-acciones">
                    <a href="Gestion-citas.jsp" class="btn-secundario">Cancelar</a>
                    <button type="submit" class="btn-primario">Guardar Cambios</button>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
