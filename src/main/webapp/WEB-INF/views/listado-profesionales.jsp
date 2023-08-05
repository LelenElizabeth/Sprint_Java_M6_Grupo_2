<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="h-100 translated-ltr">
<head>
<meta charset="ISO-8859-1">
<title>Listado de usuarios</title>
<!-- CSS del proyecto -->
<link rel="stylesheet" href="../css/estilos.css">
<!-- CSS Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
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

		<section>
			<h1>Listado de Profesionales</h1>
			<c:choose>
				<c:when test="${empty listaProf}">
					<div class="alert alert-danger" style="text-align: center"
						role="alert">
						No hay registros de Profesionales. <a href="CrearUsuario"
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
								<th>Nombre de Usuario</th>
								<th>nombre</th>
								<th>Título</th>
								<th>Fecha de Ingreso</th>
							</tr>
						</thead>
						<tbody>
							<!-- Ciclo forEach con JSTL para imprimir datos de la lista -->
							<c:forEach var="usu" items="${listaProf}">
								<tr>
									<td><c:out value="${usu.id}"></c:out></td>
									<td><c:out value="${usu.nombre}"></c:out></td>
									<td><c:out value="${usu.nombrePro}"></c:out></td>
									<td><c:out value="${usu.titulo}"></c:out></td>
									<td><c:out value="${usu.fechaIngreso}"></c:out></td>
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>
