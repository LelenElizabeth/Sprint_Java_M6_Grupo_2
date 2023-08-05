<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="h-100 translated-ltr">
<head>
<meta charset="ISO-8859-1">
<title>Iniciar Sesión</title>
<!-- CSS del proyecto -->
<%@ include file='css-proyecto.jsp'%>
<body>

	<!-- Incluyendo navbar -->
	<c:set var="navItem" value="Login" />
	<!-- Menu activo -->
	<%@ include file='navbar.jsp'%>

	<main class="flex-shrink-0">
		<div class="container mt-4">
			<!-- Fomulario de login -->
			<div class="row justify-content-center">
				<div class="col-lg-4 col-md-6">
					<div class="card">
						<div class="card-body">
						<c:choose>
							<c:when test="${error}">
								<div class="alert alert-danger" style="text-align: center"
									role="alert">
									Error al iniciar sesión.
								</div>
							</c:when>
							<c:when test="${logoutt}">
								<div class="alert alert-warning" style="text-align: center"
									role="alert">
									Se cerró la sesión correctamente.
								</div>
							</c:when>
						</c:choose>
							<h1 class="card-title text-center">Iniciar Sesión</h1>
							<div class="row justify-content-center">
								<svg xmlns="http://www.w3.org/2000/svg" width="150" height="150"
									fill="currentColor" class="bi bi-person-circle"
									viewBox="0 0 16 16">
	  							<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
	  							<path fill-rule="evenodd"
										d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
							</svg>
							</div>
							<form action="login" method="POST">
								<div class="mb-3">
									<label for="usuario" class="form-label">Usuario</label> <input
										type="text" class="form-control" id="usuario" name="usuario"
										placeholder="Usuario" required>
								</div>
								<div class="mb-3">
									<label for="password" class="form-label">Contraseña</label> <input
										type="password" class="form-control" id="password"
										name="password" placeholder="Contraseña" required>
								</div>
								<div class="mb-3 form-check">
									<input type="checkbox" class="form-check-input" id="rememberMe"
										name="rememberMe"> <label class="form-check-label"
										for="rememberMe">Recordarme</label>
								</div>
								<div class="text-center">
									<button type="submit" class="btn btn-secondary w-75">Iniciar
										Sesión</button>
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