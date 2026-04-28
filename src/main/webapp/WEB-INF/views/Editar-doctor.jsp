<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Editar Paciente - SIKALMA</title>
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
                    <span>Editar Doctor #D01</span>
                </div>
                <h1>Editar Doctor</h1>
                <p>Modifica los datos del doctor registrado</p>
            </div>
        </div>

        <div class="formulario-card">
            <h2>Datos del Doctor — ID: #P01</h2>

            <form>
                <div class="campo">
                    <label>Nombre completo</label>
                    <input type="text" value="Aracely Ramos">
                </div>

                <div class="campo">
                    <label>DNI</label>
                    <input type="text" value="12345678" maxlength="8">
                    <span class="indicacion">Debe contener exactamente 8 dígitos.</span>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Especialidad</label>
                        <input type="text" value="Psicología">
                    </div>
                    <div>
                        <label>Teléfono</label>
                        <input type="text" value="987 654 321">
                    </div>
                </div>

                <div class="fila-form">
                    <div>
                        <label>Correo electrónico </label>
                        <input type="email" value="aracely.ramos@correo.com">
                    </div>
                    <div>
                        <label>Fecha de nacimiento</label>
                        <input type="date" value="1977-02-04">
                    </div>
                </div>

                <div class="form-acciones">
                    <a href="Gestion-personal.jsp" class="btn-secundario">Cancelar</a>
                    <button type="submit" class="btn-primario">Guardar Cambios</button>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
