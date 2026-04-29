<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo-policlinico.png">
    <title>Usuarios - SIKALMA</title>
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="/css/gestion-pacientes.css">
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <main>
        <div class="encabezado">
            <div class="encabezado-texto">
                <h1>Gestión de Usuarios</h1>
                <p>Consulta, edita o elimina los registros de los usuarios del sistema</p>
            </div>
            <button onclick="document.getElementById('modalRegistrar').style.display='flex'" class="btn-primario">+ Nuevo Usuario</button>
        </div>

        <div class="tabla-contenedor">
            <div class="tabla-encabezado">
                <div>
                    <h3>Listado de Usuarios</h3>
                    <p>Total: ${usuarios.size()} registros</p>
                </div>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Usuario</th>
                        <th>Rol</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="usuario" items="${usuarios}">
                        <tr>
                            <td>${usuario.id}</td>
                            <td>${usuario.username}</td>
                            <td>${usuario.rol}</td>
                            <td>
                                <a href="/usuario/eliminar?id=${usuario.id}" class="btn-eliminar">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>

    <!-- Modal Registrar Usuario -->
    <div id="modalRegistrar" class="modal">
        <div class="modal-contenido">
            <span class="cerrar" onclick="document.getElementById('modalRegistrar').style.display='none'">&times;</span>
            <h2>Registrar Nuevo Usuario</h2>
            <form action="/usuario/registrar" method="post">
                <div class="campo">
                    <label>Usuario</label>
                    <input type="text" name="username" required>
                </div>
                <div class="campo">
                    <label>Contraseña</label>
                    <input type="password" name="password" required>
                </div>
                <div class="campo">
                    <label>Rol</label>
                    <select name="rol" required>
                        <option value="">Seleccionar rol</option>
                        <option value="Administrador">Administrador</option>
                        <option value="Doctor">Doctor</option>
                        <option value="Secretario">Secretario</option>
                    </select>
                </div>
                <button type="submit" class="btn-primario">Guardar</button>
            </form>
        </div>
    </div>

    <style>
        .modal {
            display: none;
            position: fixed;
            z-index: 1000;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0,0,0,0.5);
            justify-content: center;
            align-items: center;
        }
        .modal-contenido {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            width: 400px;
            max-width: 90%;
        }
        .cerrar {
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }
        .campo {
            margin-bottom: 15px;
        }
        .campo label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .campo input, .campo select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
    </style>
</body>
</html>