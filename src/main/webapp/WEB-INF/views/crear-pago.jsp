<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="h-100 translated-ltr">
<head>
<meta charset="UTF-8">
<title>Agregar pago</title>
<!-- Incluyendo estilos -->
<%@include file="css-proyecto.jsp"%>

</head>
<body class="d-flex flex-column h-100">
	<!-- Incluyendo navbar menu -->
	<%@include file="navbar.jsp"%>

	<main class="flex-shrink-0">
		<!-- Formulario de contacto -->
		<div class="container mt-4">
			<div class="row justify-content-center">
				<div class="col-lg-6 col-md-8">
					<div class="card">
						<div class="card-header bg-dark text-white">
							<h2 class="card-title text-center">Formulario agregar pago</h2>
						</div>
						<div class="card-body">
							<form action="Contacto" method="post">
								<div class="mb-3">
									<label for="nombre" class="form-label">ID Cliente:</label> <input
										type="text" class="form-control" id="cliente_id" name="cliente_id"
										required>
								</div>
								<div class="mb-3">
									<label for="email" class="form-label">Monto:</label> <input
										type="email" class="form-control" id="monto" name="monto"
										required>
								</div>
								<div class="card-header bg-dark">
									<div
										class="mx-0 mb-0 row justify-content-sm-center justify-content-start px-1">
										<input type="text" id="dp1" class="datepicker"
											placeholder="Pick Date" name="date" readonly><span
											class="fa fa-calendar"></span>
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

	<!-- JavaScript Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>

</body>
</html>