<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Eliminar Doctor - SIKALMA</title>
    <link rel="stylesheet" href="../css/admin.css">
    <link rel="stylesheet" href="../css/eliminar.css">
</head>
<body class="modal-eliminar">
    <div class="modal-card">
        <div class="icono-alerta">⚠️</div>
        <h2>¿Eliminar este doctor?</h2>
        <p>
            Estás a punto de eliminar el registro de <strong>Aracely Ramos</strong>
            (DNI: 12345678). Si existen citas o atenciones asociadas, podrían verse afectadas.
            <br><br>
            Esta acción no puede deshacerse.
        </p>
        <div class="modal-acciones">
            <a href="Gestion-personal.jsp" class="btn-secundario">Volver</a>
            <a href="Gestion-personal.jsp" class="btn-danger">Sí, eliminar</a>
        </div>
    </div>
</body>
</html>
