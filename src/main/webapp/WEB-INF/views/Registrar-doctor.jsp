<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Registrar Doctor - SIKALMA</title>
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
                <span>Registrar Doctor</span>
            </div>
            <h1>Registrar Nuevo Doctor</h1>
            <p>Complete el formulario para agregar un nuevo doctor al sistema</p>
        </div>
    </div>

    <div class="formulario-card">
        <h2>Datos del Doctor</h2>

        <form action="/doctor/registrar" method="post">
            <div class="campo">
                <label>Nombre completo</label>
                <input type="text" name="nombre" placeholder="Ej: María García López" required>
            </div>

            <div class="campo">
                <label>DNI</label>
                <input type="text" name="dni" placeholder="12345678" maxlength="8" required>
                <span class="indicacion">Debe contener exactamente 8 dígitos.</span>
            </div>

            <div class="fila-form">
                <div>
                    <label>Especialidad</label>
                    <input type="text" name="especialidad" placeholder="Ej: Pediatría" required>
                </div>
                <div>
                    <label>Teléfono</label>
                    <input type="text" name="telefono" placeholder="987 654 321" maxlength="9" required>
                </div>
            </div>

            <div class="fila-form">
                <div>
                    <label>ID de Usuario (Asignación)</label>
                    <input type="number" name="id_usuario" placeholder="ID de sistema" required>
                </div>
                <div>
                    <label>Fecha de nacimiento</label>
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