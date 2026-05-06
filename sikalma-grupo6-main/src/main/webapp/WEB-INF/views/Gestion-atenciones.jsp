<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
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
                <h1>Gestión de Atenciones</h1>
                <p>Registro de atenciones médicas realizadas a partir de citas confirmadas</p>
            </div>
            
        </div>

        <div class="tabla-contenedor">
            <div class="tabla-encabezado">
                <div>
                    <h3>Listado de Atenciones</h3>
                    <p>Total: 5 registros</p>
                </div>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>ID Atención</th>
                        <th>Cita Origen</th>
                        <th>Paciente</th>
                        <th>Servicio</th>
                        <th>Doctor</th>
                        <th>Fecha</th>
                        <th>Diagnóstico</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>#A001</td>
                        <td>#001</td>
                        <td>Adrial Gavidia</td>
                        <td>Medicina General</td>
                        <td>Dra. Fernández</td>
                        <td>05/04/2026</td>
                        <td>Resfriado común</td>
                        <td><span class="estado estado-atendido">Completada</span></td>
                        <td class="td-acciones">
                            
                            <div class="acciones">

                                <a href="Ver-atencion.jsp" class="btn-ver">Ver</a>
                                <a href="Editar-atencion.jsp" class="btn-editar">Editar</a>

                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>#A002</td>
                        <td>#003</td>
                        <td>Elizabeth Huamán</td>
                        <td>Odontología</td>
                        <td>Dra. Viviana Sánchez</td>
                        <td>06/04/2026</td>
                        <td>Limpieza dental</td>
                        <td><span class="estado estado-atendido">Completada</span></td>
                        <td class="td-acciones">
                            
                            <div class="acciones">

                                <a href="Ver-atencion.jsp" class="btn-ver">Ver</a>
                                <a href="Editar-atencion.jsp" class="btn-editar">Editar</a>

                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>#A003</td>
                        <td>#004</td>
                        <td>Elias Chavez</td>
                        <td>Traumatología</td>
                        <td>Dr. Marcos López</td>
                        <td>07/04/2026</td>
                        <td>Esguince de tobillo</td>
                        <td><span class="estado estado-confirmado">En curso</span></td>
                        <td class="td-acciones">
                            
                            <div class="acciones">

                                <a href="Ver-atencion.jsp" class="btn-ver">Ver</a>
                                <a href="Editar-atencion.jsp" class="btn-editar">Editar</a>

                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>#A004</td>
                        <td>#002</td>
                        <td>Naya Ramos</td>
                        <td>Psicología</td>
                        <td>Dra. Aracely Ramos</td>
                        <td>06/04/2026</td>
                        <td>Terapia de ansiedad</td>
                        <td><span class="estado estado-atendido">Completada</span></td>
                        <td class="td-acciones">
                            
                            <div class="acciones">

                                <a href="Ver-atencion.jsp" class="btn-ver">Ver</a>
                                <a href="Editar-atencion.jsp" class="btn-editar">Editar</a>

                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>#A005</td>
                        <td>#006</td>
                        <td>Lucía Flores Castillo</td>
                        <td>Pediatría</td>
                        <td>Dra. Carla Torres</td>
                        <td>07/04/2026</td>
                        <td>Control de crecimiento</td>
                        <td><span class="estado estado-pendiente">Pendiente</span></td>
                        <td class="td-acciones">
                            <div class="acciones">

                                <a href="Ver-atencion.jsp" class="btn-ver">Ver</a>
                                <a href="Editar-atencion.jsp" class="btn-editar">Editar</a>

                            </div>
                            
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>
