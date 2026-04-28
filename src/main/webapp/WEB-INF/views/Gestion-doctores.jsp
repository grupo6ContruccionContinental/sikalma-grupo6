<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Gestión de Doctores - SIKALMA</title>
    <link rel="stylesheet" href="../css/admin.css">
    <link rel="stylesheet" href="../css/gestion-servicios.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <main>
        <div class="encabezado">
            <div class="encabezado-texto">
                <h1>Gestión de Personal Médico</h1>
                <p>Visualice y administre la información de los doctores registrados</p>
            </div>
            <a href="/doctor/nuevo" class="btn-primario">+ Registrar Doctor</a>
        </div>

        <div class="tabla-contenedor">
            <table class="tabla-gestion">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>DNI</th>
                        <th>Especialidad</th>
                        <th>Teléfono</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="doc" items="${doctores}">
                        <tr>
                            <td>#D${doc.id}</td>
                            <td>${doc.nombre}</td>
                            <td>${doc.dni}</td>
                            <td>${doc.especialidad}</td>
                            <td>${doc.telefono}</td>
                            <td class="td-acciones">
                                <a href="/doctor/editar?id=${doc.id}" class="btn-editar">Editar</a>
                                <a href="/doctor/advertir?id=${doc.id}" class="btn-eliminar">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>