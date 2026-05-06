<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Editar Doctor - SIKALMA</title>
    <link rel="stylesheet" href="../css/admin.css">
</head>
<body>
<%@ include file="navbar.jsp" %>

<main>
    <div class="encabezado">
        <div class="encabezado-texto">
            <div class="retorno">
                <a href="/doctor/gestion">Personal</a>
                <span>›</span>
                <span>Editar Doctor #D${doctor.id}</span>
            </div>
            <h1>Editar Doctor</h1>
            <p>Modifica los datos del doctor registrado en el sistema</p>
        </div>
    </div>

    <div class="formulario-card">
        <h2>Datos del Doctor — ID: #D${doctor.id}</h2>

        <form action="/doctor/actualizar" method="post">
            <input type="hidden" name="id" value="${doctor.id}">

            <div class="campo">
                <label>Nombre completo</label>
                <input type="text" name="nombre" value="${doctor.nombre}" required>
            </div>

            <div class="campo">
                <label>DNI</label>
                <input type="text" name="dni" value="${doctor.dni}" maxlength="8" required>
            </div>

            <div class="fila-form">
                <div>
                    <label>Especialidad</label>
                    <input type="text" name="especialidad" value="${doctor.especialidad}" required>
                </div>
                <div>
                    <label>Teléfono</label>
                    <input type="text" name="telefono" value="${doctor.telefono}" required>
                </div>
            </div>

            <div class="fila-form">
                <div>
                    <label>Fecha de nacimiento</label>
                    <input type="date" name="fechaNacimiento" value="${doctor.fechaNacimiento}" required>
                </div>
            </div>

            <div class="form-acciones">
                <a href="/doctor/gestion" class="btn-secundario">Cancelar</a>
                <button type="submit" class="btn-primario">Guardar Cambios</button>
            </div>
        </form>
    </div>
</main>
</body>
</html>