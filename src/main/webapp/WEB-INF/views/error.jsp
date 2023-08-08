<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<!-- Incluyendo estilos -->
<%@include file="css-proyecto.jsp"%>

</head>
<body>

	<!-- Mensaje de exito -->
	<div class="container">
    	<div class="alert alert-danger mt-4">
	    	<h4 class="alert-heading text-center fs-1">¡Error!</h4>
			<p class="text-center">${mensaje}  
		</div>
	</div>

	<!-- JavaScript Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>