<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <a href="Registrar-cita.jsp" class="btn-primario">+ Nueva Cita</a>
        </div>

        <div class="estadisticas">
            <div class="estadistica">
                <img src="../images/usuarios.png" alt="pacientes">
                <div>
                    <h2>7</h2>
                    <p>Pacientes</p>
                </div>
            </div>
            <div class="estadistica">
                <img src="../images/calendario.png" alt="citas hoy">
                <div>
                    <h2>6</h2>
                    <p>Citas para hoy</p>
                </div>
            </div>
            <div class="estadistica">
                <img src="../images/reloj.png" alt="pendientes">
                <div>
                    <h2>4</h2>
                    <p>Pendientes</p>
                </div>
            </div>
            <div class="estadistica">
                <img src="../images/check.png" alt="atendidos">
                <div>
                    <h2>15</h2>
                    <p>Confirmadas</p>
                </div>
            </div>
        </div>

        <div class="tabla-contenedor">
            <div class="tabla-encabezado">
                
                    <h3>Listado de Citas</h3>
                    <p>Total: 5 registros</p>
                
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
                    <tr>
                        <td>#001</td>
                        <td>Adrial Gavidia</td>
                        <td>Medicina General</td>
                        <td>Dra. Fernández</td>
                        <td>05/04/2026</td>
                        <td>09:00 AM</td>
                        <td><span class="estado estado-confirmado">Confirmada</span></td>
                        <td class="td-acciones">
                            <a href="Editar-cita.jsp" class="btn-editar">Editar</a>
                            <a href="Cancelar-cita.jsp" class="btn-cancelar">Cancelar</a>
                            <a href="Registrar-atencion.jsp" class="btn-atender">Atender</a>
                        </td>
                    </tr>
                    <tr>
                        <td>#002</td>
                        <td>Naya Ramos</td>
                        <td>Psicología</td>
                        <td>Dra. Aracely Ramos</td>
                        <td>06/04/2026</td>
                        <td>09:00 AM</td>
                        <td><span class="estado estado-pendiente">Pendiente</span></td>
                        <td class="td-acciones">
                            <a href="Editar-cita.jsp" class="btn-editar">Editar</a>
                            <a href="Cancelar-cita.jsp" class="btn-cancelar">Cancelar</a>
                            <a href="Registrar-atencion.jsp" class="btn-atender">Atender</a>
                        </td>
                    </tr>
                    <tr>
                        <td>#003</td>
                        <td>Elizabeth Huamán</td>
                        <td>Odontología</td>
                        <td>Dr. Viviana Sánchez</td>
                        <td>06/04/2026</td>
                        <td>10:00 AM</td>
                        <td><span class="estado estado-pendiente">Pendiente</span></td>
                        <td class="td-acciones">
                            <a href="Editar-cita.jsp" class="btn-editar">Editar</a>
                            <a href="Cancelar-cita.jsp" class="btn-cancelar">Cancelar</a>
                            <a href="Registrar-atencion.jsp" class="btn-atender">Atender</a>
                        </td>
                    </tr>
                    <tr>
                        <td>#004</td>
                        <td>Elias Chavez</td>
                        <td>Traumatología</td>
                        <td>Dr. Marcos López</td>
                        <td>07/04/2026</td>
                        <td>11:30 AM</td>
                        <td><span class="estado estado-pendiente">Pendiente</span></td>
                        <td class="td-acciones">
                            <a href="Editar-cita.jsp" class="btn-editar">Editar</a>
                            <a href="Cancelar-cita.jsp" class="btn-cancelar">Cancelar</a>
                            <a href="Registrar-atencion.jsp" class="btn-atender">Atender</a>
                        </td>
                    </tr>
                    <tr>
                        <td>#005</td>
                        <td>Luana Anaya</td>
                        <td>Pediatría</td>
                        <td>Dra. Carla Torres</td>
                        <td>07/04/2026</td>
                        <td>10:00 AM</td>
                        <td><span class="estado estado-cancelado">Cancelada</span></td>
                        <td class="td-acciones">
                            <a href="Editar-cita.jsp" class="btn-editar">Editar</a>
                            <a href="Cancelar-cita.jsp" class="btn-cancelar">Cancelar</a>
                            <a href="Registrar-atencion.jsp" class="btn-atender">Atender</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>
