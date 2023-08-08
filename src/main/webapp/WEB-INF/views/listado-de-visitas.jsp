<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="h-100 translated-ltr">
<head>
<meta charset="ISO-8859-1">
<title>Listado de Visitas</title>
<!-- CSS del proyecto -->
<link rel="stylesheet" href="../css/estilos.css">
<!-- CSS Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body class="d-flex flex-column h-100">

	<!-- Incluyendo navbar menu -->
	<c:set var="navItem" value="Listar" />
	<!-- Menu activo -->
	<c:set var="navText" value="Visitas" />
	<!-- Texto Listar -->
	<%@ include file='navbar.jsp'%>

	<main class="flex-shrink-0">
		<!--  Vista para mostrar las capacitaciones -->
		<div class="container mt-4">

			<section>
				<h1>Listado de Visitas</h1>
				<c:choose>
					<c:when test="${empty listaVisitas}">
						<div class="alert alert-danger" style="text-align: center"
							role="alert">
							No hay registros de Visitas. <a href="CrearVisita"
								class="alert-link">Ir a crear Visita</a>
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
									<th>Rut Cliente</th>
									<th>Fecha y Hora</th>
									<th>Lugar</th>
									<th>Comentarios</th>
									<th>Profesional_ID</th>
									<th>Checklist</th>
								</tr>
							</thead>
							<tbody>
								<!-- Ciclo forEach con JSTL para imprimir datos de la lista -->
								<c:forEach var="vis" items="${listaVisitas}">
									<tr>
										<td><c:out value="${vis.getCliente().getRut()}"></c:out></td>
										<td><c:out value="${vis.getFecha_hora()}"></c:out></td>
										<td><c:out value="${vis.getLugar()}"></c:out></td>
										<td><c:out value="${vis.getComentarios()}"></c:out></td>
										<td><c:out value="${vis.getProfesional().getId()}"></c:out></td>
										<td>
											<!-- Enviamos el id para visualizar los chequeos de la visita -->
											<form action="responder-checklist" method="get">
												<input type="hidden" name="visitaId"
													value="${vis.getId()}">
												<button type="submit" class="btn btn-outline-dark btn-sm">
													<i class="bi bi-check2-square"></i> CheckList
												</button>
											</form>
										</td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</section>
		</div>
	</main>
	<%@ include file='footer.jsp'%>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>