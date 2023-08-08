<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="h-100 translated-ltr">
<head>
<meta charset="ISO-8859-1">
<title>Listado de usuarios</title>
<!-- CSS del proyecto -->
<link rel="stylesheet" href="../css/estilos.css">
<!-- CSS Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>

	<!-- Incluyendo navbar menu -->
	<c:set var="navItem" value="Listar" />
	<!-- Menu activo -->
	<c:set var="navText" value="Usuarios" />
	<!-- Texto Listar -->
	<%@ include file='navbar.jsp'%>

	<!--  Vista para mostrar las capacitaciones -->
	<main class="flex-shrink-0">
		<div class="container mt-4 overflow-auto">

			<section>
				<h1>Listado de Usuarios</h1>
				<c:choose>
					<c:when test="${empty listarUsuarios}">
						<div class="alert alert-danger" style="text-align: center"
							role="alert">
							No hay registros de Usuarios. <a href="CrearUsuario"
								class="alert-link">Ir a crear Usuario</a>
						</div>
					</c:when>
					<c:otherwise>
						<!-- Agregar la variable booleana  -->
						<c:set var="mostrarAlert" value="${mostrarAlert}" />
						<c:set var="mensaje" value="${mensaje}" />

						<!-- Utilizar la etiqueta 'c:if' para mostrar el alert solo cuando 'mostrarAlert' sea verdadero -->
						<c:if test="${mostrarAlert}">
							<div class="alert alert-info" style="text-align: center"
								role="alert">${mensaje}</div>
						</c:if>
							
						<table class="table table-striped table-bordered">
							<thead class="table-dark">
								<tr>
									<th>Id</th>
									<th>Nombre</th>
									<th>Rol</th>
									<th class="w-10">Modificar</th>
									<th class="w-10">Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<!-- Ciclo forEach con JSTL para imprimir datos de la lista -->
								<c:forEach var="usu" items="${listarUsuarios}">
									<tr>
										<td><c:out value="${usu.getId()}"></c:out></td>
										<td><c:out value="${usu.getNombre()}"></c:out></td>
										<td><c:out value="${usu.getRol()}"></c:out></td>
										<td>
											<!-- Enviar el ID del usuario al servlet EditarUsuario al hacer clic en el botÃ³n "Editar" -->
											<form action="Editar${usu.getRol()}" method="get">
												<input type="hidden" name="idRescatado"
													value="${usu.getId()}">
												<button type="submit" class="btn btn-outline-dark btn-sm">
													<i class="bi bi-pencil-square"></i> Editar
												</button>
											</form>
										</td>
										<!-- boton modal -->
										<td>
											<button type="button" class="btn btn-outline-danger btn-sm eliminar-usuario-btn" data-user-id="${usu.getId()}" data-bs-toggle="modal" data-bs-target="#eliminarModal">
									        	<i class="bi bi-trash"></i> Eliminar
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</section>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="eliminarModal" tabindex="-1" aria-labelledby="eliminarModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <h5 class="modal-title" id="eliminarModalLabel">Confirmar Eliminación</h5>
		                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
		            </div>
		            <div class="modal-body">
		                ¿Estás seguro de que deseas eliminar este usuario?
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
		                <form id="eliminarUsuarioForm" action="EliminarUsuario" method="get">
		                    <input type="hidden" name="idRescatado" value="">
		                    <button type="submit" class="btn btn-danger">Eliminar</button>
		                </form>
		            </div>
		        </div>
		    </div>
		</div>
	</main>

	<%@ include file='footer.jsp'%>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
		<!-- Script propio de la vista -->
	<script src="<c:url value="/res/js/modalEliminarUsuario.js" />">
	</script>
</body>
</html>
