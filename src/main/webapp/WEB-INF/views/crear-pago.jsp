<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="h-100 translated-ltr">
<head>
<meta charset="UTF-8">
<title>Crear pago</title>
<!-- Incluyendo estilos -->
<%@include file="css-proyecto.jsp"%>
<!-- Date timepicker --><!-- Agrega los enlaces a las bibliotecas de Bootstrap y DateTimePicker -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">

</head>
<body class="d-flex flex-column h-100">
	<!-- Incluyendo navbar menu -->
	<%@include file="navbar.jsp"%>

	<main class="flex-shrink-0">
		<!-- Formulario de contacto -->
		<div class="container mt-4">
			<div class="row justify-content-center">
				<div class="col-lg-6 col-md-8">
					<!-- Agregar la variable booleana  -->
					<c:set var="mostrarAlert" value="${mostrarAlert}" />
					<c:set var="mensaje" value="${mensaje}" />

					<!-- Utilizar la etiqueta 'c:if' para mostrar el alert solo cuando 'mostrarAlert' sea verdadero -->
					<c:if test="${mostrarAlert}">
						<div class="alert alert-info" style="text-align: center"
							role="alert">${mensaje}</div>
					</c:if>
					<!-- Formulario crear pago -->
					<div class="card">
						<div class="card-header bg-dark text-white">
							<h2 class="card-title text-center">Agregar pago</h2>
						</div>
						<div class="card-body">
							<form action="crear-pago" method="post">
								<div class="mb-3">
								    <label for="cliente_id" class="form-label">Cliente:</label>
								    <select class="form-control" id="cliente_id" name="cliente_id" required>
								        <option value="" disabled selected>Selecciona un cliente</option>
								        <c:forEach var="cliente" items="${clientes}">
								            <option value="${cliente.id}">${cliente.nombres} (ID: ${cliente.id})</option>
								        </c:forEach>
								    </select>
								</div>
								<div class="mb-3">
									<label for="monto" class="form-label">Monto:</label> <input
										type="number" class="form-control" id="monto" name="monto"
										required>
								</div>
								<div class="mb-3">
									<label for="datetimepicker">Selecciona Fecha y Hora:</label>
							        <div class="input-group date" id="datetimepicker" data-target-input="nearest">
							            <input type="text" class="form-control datetimepicker-input" name="fecha" data-target="#datetimepicker" />
							            <div class="input-group-append" data-target="#datetimepicker" data-toggle="datetimepicker">
							                <div class="input-group-text"><i class="bi bi-calendar"></i></div>
							            </div>
							        </div>
								</div>
								<div class="text-center">
									<button type="submit" class="btn btn-secondary w-100">Guardar</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@ include file='footer.jsp'%>

	<!-- JavaScript Bootstrap -->
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