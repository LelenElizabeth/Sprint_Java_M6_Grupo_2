<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="h-100 translated-ltr">
<head>
<meta charset="ISO-8859-1">
<title>Responder Checklist</title>
<!-- CSS del proyecto -->
<%@ include file='css-proyecto.jsp'%>

</head>
<body class="d-flex flex-column h-100">

	<!-- Incluyendo navbar menu -->
	<c:set var="navItem" value="Listar" />
	<!-- Menu activo -->
	<c:set var="navText" value="Usuarios" />
	<!-- Texto Listar -->
	<%@ include file='navbar.jsp'%>

	<main class="flex-shrink-0">
		<!--  Vista para mostrar las capacitaciones -->
		<div class="container mt-4">
			<div class="row">
				<div class="col-md-8">
					<section>
						<h1>Lista de Chequeos</h1>
						<c:choose>
							<c:when test="${empty listaChequeos}">
								<div class="alert alert-danger" style="text-align: center"
									role="alert">
									No hay registros de chequeos.
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
		
								<table class="table table-striped table-bordered ">
									<thead class="table-dark">
										<tr>
											<th># Chequeo</th>
											<th>Detalle</th>
											<th>Estado</th>
										</tr>
									</thead>
									<tbody>
										<!-- Ciclo forEach con JSTL para imprimir datos de la lista -->
										<c:forEach var="cheq" items="${listaChequeos}">
											<tr>
												<td><c:out value="${cheq.id}"></c:out></td>
												<td><c:out value="${cheq.detalle}"></c:out></td>
												<td><c:out value="${cheq.estado}"></c:out></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:otherwise>
						</c:choose>
					</section>
				</div>
				<div class="col-md-4">
					<section class="card text-center">
						<div class="card-body">
							<h2 class="card-title">
								<i class="bi bi-check2-square"></i> Agregar Chequeo 
								<button type="button" class="btn btn-secondary" id="agregarFila">
									<i class="bi bi-plus-square"></i>
								</button>
							</h2>
							
							<form id="nuevoChequeoForm" action="crear-chequeo" method="post">
								<!-- ID de la visita para el formulario  -->
								<input type="hidden" name="visitaId" value="${visitaId}">
								<div id="nuevasFilas">
									<!-- Aquí se agregarán las filas dinámicamente -->
								</div>
								<div id="contenedorGuardar" style="display: none;">
									<button type="submit" class="btn btn-dark w-75">Guardar</button>
								</div>
							</form>
						</div>
					</section>
				</div>
			</div>
		</div>
	</main>
	<!-- Script propio de la vista -->
	<script src="<c:url value="/res/js/chequeos.js" />">
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	
</body>
</html>