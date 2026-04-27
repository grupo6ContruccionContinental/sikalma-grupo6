<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Gestión de Servicios - SIKALMA</title>
    <link rel="stylesheet" href="../css/admin.css">
    <link rel="stylesheet" href="../css/gestion-servicios.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <main>
        <div class="encabezado">
            <div class="encabezado-texto">
                <h1>Gestión de Servicios</h1>
                <p>Administra los servicios médicos que ofrece el policlínico y sus costos</p>
            </div>
        </div>

        <div class="tabla-contenedor">
            <div class="tabla-encabezado">
                <div>
                    <h3>Servicios disponibles</h3>
                    <p>Total: 6 servicios registrados</p>
                </div>
            </div>

            <!-- Formulario para agregar nuevo servicio -->
            <div class="agregar-servicio">
                <div class="campo">
                    <label>Nombre del servicio</label>
                    <input type="text" placeholder="Ej: Dermatología">
                </div>
                <div class="campo">
                    <label>Descripción breve</label>
                    <input type="text" placeholder="Ej: Diagnóstico y tratamiento de enfermedades de la piel">
                </div>
                <div class="campo-corto">
                    <label>Costo (S/)</label>
                    <input type="number" placeholder="80">
                </div>
                <button class="btn-primario" style="height:38px; margin-bottom:0;">+ Agregar</button>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Servicio</th>
                        <th>Descripción</th>
                        <th>Costo</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>#S01</td>
                        <td>Medicina General</td>
                        <td>Consulta general, diagnóstico y control de enfermedades comunes</td>
                        <td>S/ 60</td>
                        <td class="td-acciones">
                            <a href="Editar-servicio.jsp" class="btn-editar">Editar</a>
                            <a href="Eliminar-servicio.jsp" class="btn-eliminar">Eliminar</a>
                        </td>
                    </tr>
                    <tr>
                        <td>#S02</td>
                        <td>Odontología</td>
                        <td>Limpieza dental, tratamiento de caries, extracciones y salud bucal</td>
                        <td>S/ 80</td>
                        <td class="td-acciones">
                            <a href="Editar-servicio.jsp" class="btn-editar">Editar</a>
                            <a href="Eliminar-servicio.jsp" class="btn-eliminar">Eliminar</a>
                        </td>
                    </tr>
                    <tr>
                        <td>#S03</td>
                        <td>Pediatría</td>
                        <td>Control de crecimiento, vacunación y seguimiento del desarrollo infantil</td>
                        <td>S/ 80</td>
                        <td class="td-acciones">
                            <a href="Editar-servicio.jsp" class="btn-editar">Editar</a>
                            <a href="Eliminar-servicio.jsp" class="btn-eliminar">Eliminar</a>
                        </td>
                    </tr>
                    <tr>
                        <td>#S04</td>
                        <td>Psicología / Terapias</td>
                        <td>Evaluación psicológica, terapia individual, manejo de ansiedad y estrés</td>
                        <td>S/ 100</td>
                        <td class="td-acciones">
                            <a href="Editar-servicio.jsp" class="btn-editar">Editar</a>
                            <a href="Eliminar-servicio.jsp" class="btn-eliminar">Eliminar</a>
                        </td>
                    </tr>
                    <tr>
                        <td>#S05</td>
                        <td>Ginecología</td>
                        <td>Control ginecológico, salud reproductiva y planificación familiar</td>
                        <td>S/ 90</td>
                        <td class="td-acciones">
                            <a href="Editar-servicio.jsp" class="btn-editar">Editar</a>
                            <a href="Eliminar-servicio.jsp" class="btn-eliminar">Eliminar</a>
                        </td>
                    </tr>
                    <tr>
                        <td>#S06</td>
                        <td>Traumatología</td>
                        <td>Lesiones óseas, dolores musculares y rehabilitación básica</td>
                        <td>S/ 90</td>
                        <td class="td-acciones">
                            <a href="Editar-servicio.jsp" class="btn-editar">Editar</a>
                            <a href="Eliminar-servicio.jsp" class="btn-eliminar">Eliminar</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>
