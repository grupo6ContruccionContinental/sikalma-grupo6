<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../images/logo-policlinico.png">
    <title>Editar Servicio - SIKALMA</title>
    <link rel="stylesheet" href="../css/admin.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <main>
        <div class="encabezado">
            <div class="encabezado-texto">
                <div class="retorno">
                    <a href="Gestion-servicios.jsp">Servicios</a>
                    <span>›</span>
                    <span>Editar Servicio #S01</span>
                </div>
                <h1>Editar Servicio</h1>
                <p>Modifica el nombre, descripción o costo del servicio</p>
            </div>
        </div>

        <div class="formulario-card">
            <h2>Datos del Servicio — ID: #S01</h2>

            <form>
                <div class="campo">
                    <label>Nombre del servicio</label>
                    <input type="text" value="Medicina General">
                </div>
                <div class="campo">
                    <label>Descripción</label>
                    <textarea rows="3">Consulta general, diagnóstico y control de enfermedades comunes</textarea>
                </div>
                <div class="campo">
                    <label>Costo (S/)</label>
                    <input type="number" value="60">
                </div>

                <div class="form-acciones">
                    <a href="Gestion-servicios.jsp" class="btn-secundario">Cancelar</a>
                    <button type="submit" class="btn-primario">Guardar Cambios</button>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
