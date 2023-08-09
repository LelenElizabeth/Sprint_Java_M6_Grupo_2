<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="h-100 translated-ltr">
<head>
<meta charset="ISO-8859-1">
<title>Crear Visita</title>
<!-- Incluyendo estilos -->
<%@include file="css-proyecto.jsp"%>
<!-- Date timepicker -->
<!-- Agrega los enlaces a las bibliotecas de Bootstrap y DateTimePicker -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">

</head>
<body class="d-flex flex-column h-100">
	<!-- Incluyendo navbar menu -->
	<!-- Incluyendo navbar menu -->
	<c:set var="navItem" value="Crear" />
	<!-- Menu activo -->
	<c:set var="navText" value="Visita" />
	<!-- Texto Crear -->
	<%@include file="navbar.jsp"%>

	<main class="flex-shrink-0">
		<div
			class="container d-flex justify-content-center align-items-center mt-4">


			<!-- Formulario para crear capacitación -->
			<div class="card" style="width: 50%;">
				<!-- Agregar la variable booleana  -->
				<c:set var="mostrarAlert" value="${mostrarAlert}" />
				<c:set var="mensaje" value="${mensaje}" />

				<!-- Utilizar la etiqueta 'c:if' para mostrar el alert solo cuando 'mostrarAlert' sea verdadero -->
				<c:if test="${mostrarAlert}">
					<div class="alert alert-info" style="text-align: center"
						role="alert">${mensaje}</div>
				</c:if>
				<div class="card-header bg-dark text-white">
					<h2 class="card-title d-flex justify-content-center">Crear
						Visita</h2>
				</div>
				<div class="card-body">
					<form action="crear-visita" class="row" method="post">
						<div class="col-md-6 mb-3">
							<label for="cliente_id" class="form-label">RUT Cliente:</label>
							<select class="form-control" id="cliente_id" name="cliente_rut" required>
							<option value="" disabled selected>Selecciona Rut</option>
							<c:forEach var="cliente" items="${listaClientes}">
							<option value="${cliente.rut}">${cliente.nombres} (Rut:${cliente.rut})</option>
							 </c:forEach>
							 </select>
						</div>
						
						<div class="col-md-6 mb-3">
							<label for="profesional_id" class="form-label">Profesional:</label>
							<select class="form-control" id="profesional_id" name="profesional_id" required>
								<option value="" disabled selected>Selecciona un Profesional</option>
								<c:forEach var="prof" items="${profesionales}">
									<option value="${prof.id}">${prof.nombrePro} (ID:${prof.id})</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="col-md-6 mb-3">
							<label id="label" for="datetimepicker">Selecciona Fecha y Hora:</label>
							<div class="input-group date" id="datetimepicker"
								data-target-input="nearest">
								<input type="text" class="form-control datetimepicker-input"
									name="fecha" data-target="#datetimepicker" />
								<div class="input-group-append" data-target="#datetimepicker"
									data-toggle="datetimepicker">
									<div class="input-group-text">
										<i class="bi bi-calendar"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 mb-3 mt">
							<label for="lugar" class="form-label">Lugar</label> <input
								type="text" class="form-control" name="lugar" required>
						</div>
						<div class="col-md-12 m3-2">
							<label for="comentarios" class="form-label">Comentarios</label>
							<textarea class="form-control" id="detalle" name="comentarios"
								rows="5" required></textarea>
						</div>
						

						<div class="col-md-12">
							<button type="submit" class="btn btn-secondary w-100 mt-4">Crear</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
	<%@ include file='footer.jsp'%>
	<!-- Script Validaciones del formulario -->
	<script src="<c:url value="/res/js/validacionVisitas.js" />"> </script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<!-- Dependencas de Bootstrap para el DateTimePicker -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.1.2/js/tempusdominus-bootstrap-4.min.js"></script>
	<script>
    // Inicializa el DateTimePicker
	    $(function () {
	        $('#datetimepicker').datetimepicker({
	            format: 'DD/MM/YYYY HH:mm', // Formato de fecha y hora
	        });
	    });
	</script>
</body>

</html>