<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/images/logo-policlinico.png">
    <title>Nueva Credencial - SIKALMA</title>
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="/css/gestion-credenciales.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <main>
        <div class="encabezado">
            <div class="encabezado-texto">
                <div class="retorno">
                    <a href="/credenciales/gestion">Credenciales</a>
                    <span>›</span>
                    <span>Nueva Credencial</span>
                </div>
                <h1>Registrar Nueva Credencial</h1>
                <p>Crea un acceso al sistema para un doctor registrado</p>
            </div>
        </div>

        <div class="formulario-card">
            <h2>Datos de acceso</h2>

            <c:if test="${not empty error}">
                <div class="error" style="margin-bottom:1.2em;">
                    &#9888; ${error}
                </div>
            </c:if>

            <form action="/credenciales/guardar" method="post">

                <div class="campo">
                    <label for="nombre">Nombre del usuario</label>
                    <input type="text"
                           id="nombre"
                           name="nombre"
                           placeholder="Ej: Dr. Ramírez"
                           value="${not empty nombre ? nombre : ''}"
                           required>
                    <span class="indicacion">Nombre que se mostrará en el sistema.</span>
                </div>

                <div class="campo">
                    <label for="correo">Correo electrónico</label>
                    <input type="email"
                           id="correo"
                           name="correo"
                           placeholder="doctor@sikalma.com"
                           value="${not empty correo ? correo : ''}"
                           required>
                    <span class="indicacion">Será utilizado para iniciar sesión.</span>
                </div>

                <div class="campo">
                    <label for="contrasena">Contraseña</label>
                    <input type="password"
                           id="contrasena"
                           name="contrasena"
                           placeholder="Mínimo 6 caracteres"
                           minlength="6"
                           required>
                </div>

                <div class="campo">
                    <label for="doctorId">Doctor asociado</label>
                    <select id="doctorId" name="doctorId" required>
                        <option value="0">-- Seleccione un doctor --</option>
                        <c:forEach var="doc" items="${doctores}">
                            <option value="${doc.id}"
                                ${doctorId == doc.id ? 'selected' : ''}>
                                ${doc.nombre} — ${doc.especialidad}
                            </option>
                        </c:forEach>
                    </select>
                    <span class="indicacion">El doctor solo verá las citas asignadas a él.</span>
                </div>

                <div class="credencial-aviso">
                    <span class="aviso-icono">&#128273;</span>
                    <span>Esta credencial tendrá el rol <strong>DOCTOR</strong>. Solo podrá acceder a las citas que tenga asignadas.</span>
                </div>

                <div class="form-acciones">
                    <a href="/credenciales/gestion" class="btn-secundario">Cancelar</a>
                    <button type="submit" class="btn-primario">Crear Credencial</button>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
