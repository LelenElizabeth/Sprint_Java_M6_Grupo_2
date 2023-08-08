<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="h-100 translated-ltr">
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Usuario</title>
<!-- CSS del proyecto -->
	<link rel="stylesheet" type="text/css" href="../css/estilos.css">
<!-- CSS Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body class="d-flex flex-column h-100">

<!-- Incluyendo navbar menu -->
	<c:set var="navItem" value="Crear" /> <!-- Menu activo -->
	<c:set var="navText" value="Usuario"/> <!-- Texto Crear -->
	<%@ include file='navbar.jsp'%>

	<main class="flex-shrink-0">
		<div
			class="container d-flex justify-content-center align-items-center mt-4">
			<!-- Formulario para crear un nuevo usuario -->
			<div class="card" style="width: 50%;">
			<!-- Agregar la variable booleana  -->
			<c:set var="mostrarAlert" value="${mostrarAlert}" />
			<c:set var="mensaje" value="${mensaje}" />
						
				<div class="card-header bg-dark text-white">
					<h2 class="card-title d-flex justify-content-center">Crear
						Usuario</h2>
						
				</div>
				<div class="card-body">
					<form action="crear-cliente" id="formulario" class="row" method="post">
						<div class="col-md-6 mb-3">
							<label for="nombre" class="form-label">Nombre</label> <input
								type="text" class="form-control" name="nombre" required>
						</div>
						<div class="col-md-6 mb-3">
							<label for="contraseña" class="form-label">Contraseña</label> <input
								type="text" class="form-control" name="contraseña" required>
						</div>
						<div class="col-md-12 mb-3">
							<label for="tipoLbl" class="form-label">Tipo</label> <select
								class="form-control" name="rol" id="rol" required>
								<option value="" disabled selected>Seleccione un tipo</option>
								<option value="Cliente">Cliente</option>
								<option value="Administrativo">Administrativo</option>
								<option value="Profesional">Profesional</option>
							</select>
						</div>
						 <!-- Formulario para el rol Cliente -->
				        <div id="formularioCliente" style="display: none;">
					        <h3>Datos del Cliente</h3>
				            <div class="row">
				            	<div class="col-md-5 mb-3">
									<label for="nombres" class="form-label">Nombres</label> 
									<input  type="text" class="form-control" name="nombreCliente" required>
								</div>
								<div class="col-md-5 mb-3">
									<label for="apellidos" class="form-label">Apellidos</label> 
									<input  type="text" class="form-control" name="apellidos" required>
								</div>
								<div class="col-md-2 mb-3">
									<label for="edad" class="form-label">Edad</label> 
									<input type="text" class="form-control" name="edad" required>
								</div>
								<div class="col-md-3 mb-3">
									<label for="rut" class="form-label">Rut</label> 
									<input  type="text"class="form-control" name="rut" required>
								</div>
								<div class="col-md-3 mb-3">
									<label for="telefono" class="form-label">Telefono</label> 
									<input  type="text" class="form-control" name="telefono" required>
								</div>
								<div class="col-md-3 mb-3">
									<label for="direccion" class="form-label">Dirección</label> 
									<input type="text" class="form-control" name="direccion" required>
								</div>
								<div class="col-md-3 mb-3">
									<label for="comuna" class="form-label">Comuna</label> 
									<input  type="text" class="form-control" name="comuna" required>
								</div>
				            </div>
				        </div>
				        
				        <!-- Formulario para el rol Administrativo -->
				        <div id="formularioAdministrativo" style="display: none;">
				        	<h3>Datos del Administrativo</h3>
				            <div class="row">
								<div class="col-md-4 mb-3">
									<label for="nombre" class="form-label">Nombre</label><input
										type="text" class="form-control" name="nombreAdministrativo" required>
								</div>
								<div class="col-md-4 mb-3">
									<label for="area" class="form-label">Area</label><input
										type="text" class="form-control" name="area" required>
								</div>
								<div class="col-md-4 mb-3">
									<label for="experienciaPrevia" class="form-label">Experiencia Previa</label><input
										type="text" class="form-control" name="experienciaPrevia" required>
								</div>
				            </div>
				        </div>
				        
				        <!-- Formulario para el rol Profesional -->
				        <div id="formularioProfesional" style="display: none;">
				       		<h3>Datos del Profesional</h3>
				        	<div class="row">
				        		<div class="col-md-4 mb-3">
									<label for="nombre" class="form-label">Nombre</label><input
										type="text" class="form-control" name="nombreProfesional" required>
								</div>
								<div class="col-md-4 mb-3">
									<label for="titulo" class="form-label">Título</label><input
										type="text" class="form-control" name="titulo" required>
								</div>
								<div class="col-md-4 mb-3">
									<label for="fechaIngreso" class="form-label">Fecha de ingreso</label>
									<div class="input-group date" id="datetimepicker" data-target-input="nearest">
							            <input type="text" class="form-control datetimepicker-input" name="fechaIngreso" data-target="#datetimepicker" />
							            <div class="input-group-append" data-target="#datetimepicker" data-toggle="datetimepicker">
							                <div class="input-group-text"><i class="bi bi-calendar"></i></div>
							            </div>
							        </div>
								</div>
				        	</div>
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
	<!-- Script propio de la vista -->
	<script src="<c:url value="/res/js/crearUsuario.js" />"></script>
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
	            format: 'DD/MM/YYYY', // Formato de fecha y hora
	        });
	    });
	</script>
		
</body>
</html>