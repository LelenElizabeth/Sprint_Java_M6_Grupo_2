<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Usuario</title>
<!-- CSS del proyecto -->
	<link rel="stylesheet" href="../css/estilos.css">
<!-- CSS Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>

<!-- Incluyendo navbar menu -->
	<c:set var="navItem" value="Modificar" /> <!-- Menu activo -->
	<c:set var="navText" value="Usuario"/> <!-- Texto Crear -->
	<%@ include file='navbar.jsp'%>

	<div
		class="container d-flex justify-content-center align-items-center mt-4">
		<!-- Formulario para modificar un usuario -->
		<div class="card" style="width: 50%;">
			<div class="card-header bg-dark text-white">
				<c:set var="usuario" value="${usuario}" />
				<h2 class="card-title d-flex justify-content-center">Modificar
					${usuario.rol}</h2>
			</div>
			<div class="card-body">
				<form action="Editar${usuario.rol}" class="row" method="post">
					<div class="col-md-6 mb-3">
						<label for="nombre" class="form-label">Nombre</label> <input
							type="text" class="form-control" name="nombreUsuario"
							value="${usuario.nombre}" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="contraseña" class="form-label">Contraseña</label> <input
							type="text" class="form-control" name="contraseña" >
					</div>
					<div class="col-md-12 mb-3">
						<label for="tipoLbl" class="form-label">Rol</label> <select
							class="form-control" name="tipo" disabled>
							<option value="Cliente"
								<c:if test="${'Cliente' eq usuario.rol}">selected</c:if>>Cliente</option>
							<option value="Administrativo"
								<c:if test="${'Administrativo' eq usuario.rol}">selected</c:if>>Administrativo</option>
							<option value="Profesional"
								<c:if test="${'Profesional' eq usuario.rol}">selected</c:if>>Profesional</option>
						</select>
					</div>

					<c:choose>
						<c:when test="${usuario.rol eq 'Cliente'}">
							<h3>Datos del cliente</h3>
							<div>
								<label for="nombres" class="form-label">Nombres</label><input
									value="${usuario.nombres}" type="text" class="form-control" name="nombres" required>
							</div>
							<div>
								<label for="apellidos" class="form-label">Apellidos</label><input
									value="${usuario.apellidos}" type="text" class="form-control" name="apellidos" required>
							</div>
							<div>
								<label for="telefono" class="form-label">Telefono</label><input
									value="${usuario.telefono}" type="text" class="form-control" name="telefono" required>
							</div>
							<div>
								<label for="direccion" class="form-label">Dirección</label><input
									value="${usuario.direccion}" type="text" class="form-control" name="direccion" required>
							</div>
							<div>
								<label for="comuna" class="form-label">Comuna</label><input
									value="${usuario.comuna}" type="text" class="form-control" name="comuna" required>
							</div>
							<div>
								<label for="edad" class="form-label">Edad</label><input
									value="${usuario.edad}" type="text" class="form-control" name="edad" required>
							</div>
							<div>
								<label for="rut" class="form-label">Rut</label><input
									value="${usuario.rut}" type="text" class="form-control" name="rut" required>
							</div>

						</c:when>
						<c:when test="${usuario.rol eq 'Administrativo'}">
							<h3>Datos del administrativo</h3>
							<div>
								<label for="nombre" class="form-label">Nombre</label><input
									value="${usuario.nombreAdmin}" type="text" class="form-control" name="nombre" required>
							</div>
							<div>
								<label for="area" class="form-label">Area</label><input
									value="${usuario.area}" type="text" class="form-control" name="area" required>
							</div>
							<div>
								<label for="experienciaPrevia" class="form-label">Experiencia Previa</label><input
									value="${usuario.experienciaPrevia}" type="text" class="form-control" name="experienciaPrevia" required>
							</div>
						</c:when>
						<c:when test="${usuario.rol eq 'Profesional'}">
							<h3>Datos del profesional</h3>
							<div>
								<label for="nombre" class="form-label">Nombre</label><input
									value="${usuario.nombrePro}" type="text" class="form-control" name="nombre" required>
							</div>
							<div>
								<label for="titulo" class="form-label">Título</label><input
									value="${usuario.titulo}" type="text" class="form-control" name="titulo" required>
							</div>
							<div>
								<label for="fechaIngreso" class="form-label">Fecha de ingreso</label><input
									value="${usuario.obtenerFechaFormat()}" type="text" class="form-control" name="fechaIngreso" required>
							</div>							
						</c:when>
						<c:otherwise>

						</c:otherwise>
					</c:choose>

					<div class="col-md-12">
						<input type="hidden" name="idUsuario" value="${usuario.id}">
						<button type="submit" class="btn btn-secondary w-100 mt-4">Guardar cambios</button>
					</div>
				</form>
				<button onclick="volverAtras()" class="btn btn-secondary w-100 mt-4">Volver
					atrás</button>
			</div>
		</div>
	</div>
	<!-- JavaScript Bootstrap -->
	<script>
		function volverAtras() {
			window.history.back();
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>