<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="menu">
    <div class="menu-img">
        <img src="/images/logo-policlinico.png" alt="logo del policlinico">
    </div>
    <ul>
        <li><a href="/metricas/g-metricas" class="${paginaActiva == 'metricas' ? 'activo' : ''}">Métricas</a></li>
        <li><a href="/cita/g-citas" class="${paginaActiva == 'citas' ? 'activo' : ''}">Gestión de Citas</a></li>
        <li><a href="/cita/r-citas" class="${paginaActiva == 'r-citas' ? 'activo' : ''}">Registrar Cita</a></li>
        <li><a href="/atencion/g-atenciones" class="${paginaActiva == 'atenciones' ? 'activo' : ''}">Gestión de Atenciones</a></li>
        <li><a href="/servicios/g-servicios" class="${paginaActiva == 'servicios' ? 'activo' : ''}">Servicios</a></li>
        <li><a href="/paciente/gestion" class="${paginaActiva == 'paciente' ? 'activo' : ''}">Pacientes</a></li>

        <li><a href="/doctor/gestion" class="${paginaActiva == 'personal' ? 'activo' : ''}">Personal</a></li>
    </ul>
</section>