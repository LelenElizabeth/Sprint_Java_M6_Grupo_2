<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<!-- Iconos Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<header>

	<!-- Navbar del sitio -->
	<nav class="navbar bg-dark  navbar-expand-lg bg-body-tertiary "
		data-bs-theme="dark">
		<div class="container-fluid">
			<!-- Logo y nombre del sitio -->
			<a class="navbar-brand" href="#"> <i class="bi bi-fan"></i> <span
				class="text-ligth">Prevent</span>
			</a>
			<!-- boton del menu  -->
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#menu"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- elementos del menu colapsable -->
			<div class="collapse navbar-collapse" id="menu">
				<ul class="navbar-nav me-auto">
					<li class="nav-item ms-2"><a
						class="nav-link ${navItem == 'Inicio' ? 'active' : ''}"
						href="Inicio"> <i class="bi bi-house"></i> Inicio
					</a></li>
					<sec:authorize access="hasAuthority('Cliente')">
						<li class="nav-item ms-2"><a
							class="nav-link ${navItem == 'Contacto' ? 'active' : ''}"
							href="Contacto"> <i class="bi bi-envelope-at"></i> Contacto
						</a></li>
					</sec:authorize>
					 
					<sec:authorize access="hasAuthority('Administrativo')">
					<li class="nav-item dropdown ms-2">
					<a
						class="nav-link dropdown-toggle disabled ${navItem == 'Crear' ? 'active' : ''}"
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						href="#"> <i class="bi bi-plus-circle"></i> Crear
					</a>
						<ul class="dropdown-menu bg-dark">

							<li><a class="dropdown-item" href="CrearCapacitacion"> <i
									class="bi bi-file-plus"></i> Crear Capacitación
							</a></li>
							<li>
								<a class="dropdown-item" href="CrearUsuario"> <i
									class="bi bi-file-plus"></i> Crear Usuario
								</a>
							</li>
						</ul>
						</li>
						</sec:authorize>
						<li class="nav-item dropdown ms-2">
						    <sec:authorize access="hasAnyAuthority('Administrativo', 'Cliente')">
						        <a class="nav-link dropdown-toggle ${navItem == 'Listar' ? 'active' : ''}"
						           id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						           href="#"> <i class="bi bi-card-list"></i> Listar
						        </a>
						    </sec:authorize>
						        <ul class="dropdown-menu bg-dark">
						        <sec:authorize access="hasAnyAuthority('Administrativo', 'Cliente')">
						            <li>
						                <a class="dropdown-item" href="ListarCapacitaciones">
						                    <i class="bi bi-files"></i> Listar Capacitaciones
						                </a>
						            </li>
						   		 </sec:authorize>
						   		 <sec:authorize access="hasAnyAuthority('Administrativo')">
						            <li>
						                <a class="dropdown-item disabled" href="ListadoUsuarios">
						                    <i class="bi bi-people"></i>  Listar Usuarios
						                </a>
						            </li>
						        </sec:authorize>
						        </ul>
						</li>
						<sec:authorize access="!isAuthenticated()">
								<li class="nav-item flex-row flex-wrap text-light">
						    		<a class="nav-link " href="login">
						    		<i class="bi bi-box-arrow-in-left ms-2"></i> Login</a>
						    	</li>
				    	</sec:authorize>
				</ul>
				<sec:authorize access="isAuthenticated()">
					<ul class="navbar-nav flex-row flex-wrap text-light">
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle"
							id="navbarDropdown" role="button" data-bs-toggle="dropdown"  href="#">
								<i class="bi bi-person-circle"></i>   <sec:authentication property="principal.username" />
							</a>
						    <ul class="dropdown-menu dropdown-menu-end bg-dark">
						    	<li>
						    		<a class="dropdown-item" href="logout">
						    		<i class="bi bi-box-arrow-right"></i>   Cerrar Sesión</a>
						    	</li>
						    </ul>
						</li>
				    </ul>
			    </sec:authorize>
			</div>
		</div>
	</nav>
</header>