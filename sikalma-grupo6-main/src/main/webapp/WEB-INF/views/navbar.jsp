<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<section class="menu">

    <%-- Logo --%>
    <div class="menu-img">
        <img src="/images/logo-policlinico.png" alt="logo del policlinico">
    </div>

    <%-- Bloque de sesión activa --%>
    <div class="menu-sesion-info">
        <div class="sesion-avatar">
            <c:choose>
                <c:when test="${sessionScope.rolUsuario == 'ADMIN'}">
                    <span class="avatar-icono admin-icono">&#9812;</span>
                </c:when>
                <c:otherwise>
                    <span class="avatar-icono doctor-icono">&#9877;</span>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="sesion-datos">
            <span class="sesion-nombre"><c:out value="${sessionScope.nombreUsuario}" default="Usuario"/></span>
            <c:choose>
                <c:when test="${sessionScope.rolUsuario == 'ADMIN'}">
                    <span class="sesion-rol badge-admin">ADMIN</span>
                </c:when>
                <c:otherwise>
                    <span class="sesion-rol badge-doctor">DOCTOR</span>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <%-- Divisor --%>
    <div class="menu-divisor"></div>

    <%-- Navegación --%>
    <ul>
        <%-- Métricas: solo ADMIN --%>
        <c:if test="${sessionScope.rolUsuario == 'ADMIN'}">
            <li>
                <a href="/metricas/g-metricas" class="${paginaActiva == 'metricas' ? 'activo' : ''}">
                    <span class="nav-icono">&#128202;</span> Métricas
                </a>
            </li>
        </c:if>

        <%-- Gestión de Citas: visible para ambos roles --%>
        <li>
            <a href="/cita/g-citas" class="${paginaActiva == 'citas' ? 'activo' : ''}">
                <span class="nav-icono">&#128197;</span> Gestión de Citas
            </a>
        </li>

        <%-- Registrar Cita: solo ADMIN --%>
        <c:if test="${sessionScope.rolUsuario == 'ADMIN'}">
            <li>
                <a href="/cita/r-citas" class="${paginaActiva == 'r-citas' ? 'activo' : ''}">
                    <span class="nav-icono">&#43;</span> Registrar Cita
                </a>
            </li>
        </c:if>

        <%-- Gestión Atenciones: solo DOCTOR --%>
        <c:if test="${sessionScope.rolUsuario == 'DOCTOR'}">
            <li>
                <a href="/atencion/gestion" class="${paginaActiva == 'atencion' ? 'activo' : ''}">
                    <span class="nav-icono">&#10003;</span> Mis Atenciones
                </a>
            </li>
        </c:if>

        <%-- Solo ADMIN --%>
        <c:if test="${sessionScope.rolUsuario == 'ADMIN'}">
            <div class="menu-divisor"></div>
            <li class="menu-seccion-label">Administración</li>
            <li>
                <a href="/servicio/gestion" class="${paginaActiva == 'servicios' ? 'activo' : ''}">
                    <span class="nav-icono">&#128203;</span> Servicios
                </a>
            </li>
            <li>
                <a href="/paciente/gestion" class="${paginaActiva == 'paciente' ? 'activo' : ''}">
                    <span class="nav-icono">&#128100;</span> Pacientes
                </a>
            </li>
            <li>
                <a href="/doctor/gestion" class="${paginaActiva == 'personal' ? 'activo' : ''}">
                    <span class="nav-icono">&#128084;</span> Personal
                </a>
            </li>
            <li>
                <a href="/credenciales/gestion" class="${paginaActiva == 'credenciales' ? 'activo' : ''}">
                    <span class="nav-icono">&#128273;</span> Credenciales
                </a>
            </li>
        </c:if>
    </ul>

    <%-- Botón cerrar sesión al fondo --%>
    <div class="menu-footer">
        <a href="/logout" class="btn-logout">
            <span>&#8594;</span> Cerrar sesión
        </a>
    </div>

</section>
