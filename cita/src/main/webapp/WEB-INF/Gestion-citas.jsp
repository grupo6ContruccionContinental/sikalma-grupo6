<h2>Gestión de Citas</h2>

<a href="/cita/nuevo">Nueva Cita</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Paciente</th>
        <th>Doctor</th>
        <th>Servicio</th>
        <th>Fecha</th>
        <th>Hora</th>
        <th>Estado</th>
        <th>Acciones</th>
    </tr>

    <c:forEach var="c" items="${citas}">
        <tr>
            <td>${c.id}</td>
            <td>${c.id_paciente}</td>
            <td>${c.id_doctor}</td>
            <td>${c.id_servicio}</td>
            <td>${c.fecha}</td>
            <td>${c.hora}</td>
            <td>${c.estado}</td>
            <td>
                <a href="/cita/editar?id=${c.id}">Editar</a>
                <a href="/cita/advertir?id=${c.id}">Eliminar</a>
            </td>
        </tr>
    </c:forEach>

</table>