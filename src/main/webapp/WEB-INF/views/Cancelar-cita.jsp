<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Cancelar Cita - SIKALMA</title>
    <link rel="stylesheet" href="../css/admin.css">
    <link rel="stylesheet" href="../css/eliminar.css">
</head>
<body class="modal-eliminar">
    <div class="modal-card">
        <div class="icono-alerta">⚠️</div>
        <h2>¿Cancelar esta cita?</h2>
        <p>
            Estás a punto de cancelar la cita de <strong>Naya Ramos</strong>
            programada para el <strong>06/04/2026 a las 09:00 AM</strong>
            con <strong>Dra. Aracely Ramos</strong>.
            <br><br>
            Esta acción no puede deshacerse.
        </p>
        <div class="modal-acciones">
            <a href="Gestion-citas.jsp" class="btn-secundario">Volver</a>
            <a href="Gestion-citas.jsp" class="btn-danger">Sí, cancelar cita</a>
        </div>
    </div>
</body>
</html>
