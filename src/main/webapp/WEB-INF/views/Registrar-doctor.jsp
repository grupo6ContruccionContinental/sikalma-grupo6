<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Registrar Paciente - SIKALMA</title>
    <link rel="stylesheet" href="../css/admin.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <main>
        <div class="encabezado">
            <div class="encabezado-texto">
                <div class="retorno">
                    <a href="Gestion-personal.jsp">Personal</a>
                    <span>›</span>
                    <span>Registrar Doctor</span>
                </div>
                <h1>Registrar Nuevo Doctor</h1>
                <p>Complete el formulario para agregar un nuevo doctor al sistema</p>
            </div>
        </div>

        <div class="formulario-card">
            <h2>Datos del Doctor</h2>

            <form>
                <div class="campo">
                    <label>Nombre completo</label>
                    <input type="text" placeholder="Ej: María García López">
                </div>

                <div class="campo">
                    <label>DNI</label>
                    <input type="text" placeholder="12345678" maxlength="8">
                    <span class="indicacion">Debe contener exactamente 8 dígitos.</span>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Especialiad</label>
                        <input type="number" placeholder="Medicina General" >
                    </div>
                    <div>
                        <label>Teléfono</label>
                        <input type="text" placeholder="987 654 321">
                    </div>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Correo electrónico</label>
                        <input type="email" placeholder="ejemplo@correo.com">
                    </div>
                    <div>
                        <label>Fecha de nacimiento</label>
                        <input type="date">
                    </div>
                </div>

                <div class="form-acciones">
                    <a href="Gestion-personal.jsp" class="btn-secundario">Cancelar</a>
                    <button type="submit" class="btn-primario">Registrar Doctor</button>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
