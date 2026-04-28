<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Gestión de Atenciones - SIKALMA</title>
    <link rel="stylesheet" href="../css/admin.css">
</head>

<body>

    <%@ include file="navbar.jsp" %>

    <main>

        <div class="encabezado">
            <div class="encabezado-texto">
                <h1>Ver Atención</h1>
                <p>Visualize toda la información de sus atenciones</p>
            </div>
        </div>



        <div class="formulario-card">
            <h2>Datos de la Atención — ID: #A001 / Cita origen: #001</h2>

            <form>
                <div class="fila-form">
                    <div>
                        <label>Paciente</label>
                        <input type="text" value="Adrial Gavidia" readonly>
                    </div>
                    <div>
                        <label>Doctor</label>
                        <input type="text" value="Dra. Fernández" readonly>
                    </div>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Servicio</label>
                        <input type="text" value="Medicina General" readonly>
                    </div>
                    <div>
                        <label>Fecha de atención</label>
                        <input type="date" value="2026-04-05" readonly>
                    </div>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Hora de inicio</label>
                        <input type="time" value="09:00" readonly>
                    </div>
                    <div>
                        <label>Hora de fin</label>
                        <input type="time" value="09:30" readonly>
                    </div>
                </div>

                <div class="campo">
                    <label>Diagnóstico</label>
                    <textarea rows="3" readonly>Resfriado común con congestión nasal leve.</textarea>
                </div>

                <div class="campo">
                    <label>Tratamiento indicado</label>
                    <textarea rows="3" readonly>Paracetamol 500mg cada 8 horas por 3 días. Reposo y abundante líquido.</textarea>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Costo del servicio (S/)</label>
                        <input type="text" value="60.00" readonly>
                    </div>
                    <div>
                        <label >Estado de la atención</label>
                        <input type="text" value="Completada" readonly>
                    </div>
                </div>

                <div class="campo">
                    <label>Observaciones adicionales</label>
                    <textarea rows="2" readonly>Paciente recomienda control en 7 días si persisten síntomas.</textarea>
                </div>

                <div class="form-acciones">
                    <a href="Gestion-atenciones.jsp" class="btn-secundario">Volver</a>
                </div>
            </form>
        </div>



    </main>

</body>

</html>