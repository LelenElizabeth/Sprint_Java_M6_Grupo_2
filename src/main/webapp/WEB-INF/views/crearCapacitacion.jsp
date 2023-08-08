<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="h-100 translated-ltr">
<head>
<meta charset="ISO-8859-1">
<title>Crear Capacitacion</title>
<!-- Incluyendo estilos -->
<%@include file="css-proyecto.jsp"%>

</head>
<body class="d-flex flex-column h-100">
	<!-- Incluyendo navbar menu -->
	<!-- Incluyendo navbar menu -->
	<c:set var="navItem" value="Crear" />
	<!-- Menu activo -->
	<c:set var="navText" value="Capacitacion" />
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
						Capacitación</h2>
				</div>
				<div class="card-body">
					<form action="crear-capacitacion" class="row" method="post">
						<div class="col-md-6 mb-2">
							<label for="nombre" class="form-label">Nombre
								Capacitación</label> <input type="text" class="form-control"
								name="nombre" required>
						</div>
						<div class="col-md-6 mb-3">
							<label for="rut" class="form-label">RUT Cliente</label> <input
								type="text" class="form-control" name="rutCliente" required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="dia" class="form-label">Día</label> <select
								class="form-select" name="dia" required>
								<option value="" disabled selected>Seleccione un día</option>
								<option value="Lunes">Lunes</option>
								<option value="Martes">Martes</option>
								<option value="Miercoles">Miércoles</option>
								<option value="Jueves">Jueves</option>
								<option value="Viernes">Viernes</option>
								<option value="Sabado">Sábado</option>
								<option value="Domingo">Domingo</option>
							</select>
						</div>
						<div class="col-md-4 mb-3">
							<label for="hora" class="form-label">Hora</label> <input
								type="text" class="form-control" name="hora" required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="cantidadAsistentes" class="form-label">Asistentes</label>
							<input type="number" class="form-control"
								name="cantidadAsistentes" required>
						</div>
						<div class="col-md-6 mb-3">
							<label for="lugar" class="form-label">Lugar</label> <input
								type="text" class="form-control" name="lugar" required>
						</div>
						<div class="col-md-6 mb-3">
							<label for="duracion" class="form-label">Duración </label> <input
								type="text" class="form-control" name="duracion" required>
						</div>
						<div class="col-md-12 m3-2">
							<label for="detalle" class="form-label">Detalle</label>
							<textarea class="form-control" id="detalle" name="detalle"
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
	<script src="<c:url value="/res/js/formularioCapacitacion.js" />">
		
	</script>
	<!-- JavaScript Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<!-- Footer -->
</body>

</html>