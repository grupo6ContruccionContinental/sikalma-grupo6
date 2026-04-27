<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <a href="Gestion-citas.jsp">Gestión de Citas</a>
                    <span>›</span>
                    <span>Registrar Cita</span>
                </div>
                <h1>Registrar Nueva Cita</h1>
                <p>Complete el formulario para reservar una cita médica</p>
            </div>
        </div>

        <div class="formulario-card">
            <h2>Datos de la Cita</h2>

            <form>
                <!-- Datos del paciente -->
                <div class="campo">
                    <label>Paciente</label>
                    <select name="paciente">
                        <option value="">— Seleccione un paciente —</option>
                        <option>María García López</option>
                        <option>Juan Pérez Torres</option>
                        <option>Ana Rodríguez Silva</option>
                        <option>Carlos Mendoza Rivera</option>
                        <option>Lucía Flores Castillo</option>
                        <option>Roberto Vásquez Huanca</option>
                        <option>Patricia Quispe Mamani</option>
                    </select>
                </div>

                <!-- Servicio y especialidad -->
                <div class="fila-form">
                    <div>
                        <label>Servicio (Especialidad)</label>
                        <select name="servicio">
                            <option value="">— Seleccione un servicio —</option>
                            <option>Medicina General — S/60</option>
                            <option>Odontología — S/80</option>
                            <option>Pediatría — S/80</option>
                            <option>Psicología / Terapias — S/100</option>
                            <option>Ginecología — S/90</option>
                            <option>Traumatología — S/90</option>
                        </select>
                    </div>
                    <div>
                        <label>Doctor Asignado</label>
                        <select name="doctor">
                            <option value="">— Seleccione un doctor —</option>
                            <option>Dra. Aracely Ramos — Psicología</option>
                            <option>Dra. Viviana Sánchez — Odontología</option>
                            <option>Dr. Marcos López — Traumatología</option>
                            <option>Dra. Carla Torres — Pediatría</option>
                            <option>Dra. Fernández — Medicina General</option>
                        </select>
                    </div>
                </div>

                <!-- Fecha y hora -->
                <div class="fila-form">
                    <div>
                        <label>Fecha de la Cita</label>
                        <input type="date" name="fecha">
                    </div>
                    <div>
                        <label>Hora de la Cita</label>
                        <input type="time" name="hora">
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
                    <a href="Gestion-citas.jsp" class="btn-secundario">Cancelar</a>
                    <button type="submit" class="btn-primario">Registrar Cita</button>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
