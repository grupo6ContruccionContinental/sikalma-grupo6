<h2>Editar Cita</h2>

<form action="/cita/editar" method="post">

    <input type="hidden" name="id" value="${cita.id}">

    Paciente ID: <input type="number" name="id_paciente" value="${cita.id_paciente}"><br>
    Doctor ID: <input type="number" name="id_doctor" value="${cita.id_doctor}"><br>
    Servicio ID: <input type="number" name="id_servicio" value="${cita.id_servicio}"><br>

    Fecha: <input type="date" name="fecha" value="${cita.fecha}"><br>
    Hora: <input type="time" name="hora" value="${cita.hora}"><br>

    Estado:
    <select name="estado">
        <option value="Pendiente">Pendiente</option>
        <option value="Atendida">Atendida</option>
        <option value="Cancelada">Cancelada</option>
    </select><br>

    <button type="submit">Actualizar</button>

</form>