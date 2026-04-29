<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Doctor - SIKALMA</title>
    <link rel="stylesheet" href="../css/admin.css">
</head>
<body>
<%@ include file="navbar.jsp" %>
<main>
    <div class="encabezado">
        <div class="encabezado-texto">
            <h1>Registrar Nuevo Doctor</h1>
            <p>Complete el perfil profesional del médico</p>
        </div>
    </div>
    <div class="formulario-card">
        <form action="/doctor/guardar" method="post">
            <div class="campo">
                <label>Nombre Completo</label>
                <input type="text" name="nombre" required>
            </div>
            <div class="fila-form">
                <div class="campo">
                    <label>DNI</label>
                    <input type="text" name="dni" maxlength="8" required>
                </div>
                <div class="campo">
                    <label>Especialidad</label>
                    <input type="text" name="especialidad" required>
                </div>
            </div>
            <div class="fila-form">
                <div class="campo">
                    <label>Teléfono</label>
                    <input type="text" name="telefono" required>
                </div>
                <div class="campo">
                    <label>Fecha de Nacimiento</label>
                    <input type="date" name="fechaNacimiento" required>
                </div>
            </div>
            <div class="form-acciones">
                <a href="/doctor/gestion" class="btn-secundario">Cancelar</a>
                <button type="submit" class="btn-primario">Registrar Doctor</button>
            </div>
        </form>
    </div>
</main>
</body>
</html>