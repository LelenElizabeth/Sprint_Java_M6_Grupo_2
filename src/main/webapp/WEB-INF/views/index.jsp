<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="h-100 translated-ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página de Inicio - Prevent</title>
    <!-- Incluyendo estilos -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
          crossorigin="anonymous">
    <style>
        /* Estilos personalizados */
        body {
            background-color: #f8f9fa;
        }
        .container {
            padding-top: 20px;
        }
        h1 {
            color: #343a40;
        }
        h2 {
            color: #343a40;
            margin-top: 20px;
        }
        p {
            color: #6c757d;
            line-height: 1.6;
        }
    </style>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <!-- Incluyendo navbar menu -->
    <c:set var="navItem" value="Inicio" />
    <!-- Menu activo -->

    <main class="flex-shrink-0">
        <!-- Pagina de inicio -->
        <div class="container">
            <section class="mt-5">
                <h1>¡Bienvenido a Prevent!</h1>
                <p>En nuestra compañía, nos dedicamos a brindar asesorías en prevención de riesgos laborales, y hemos identificado un desafío común para muchas empresas: la falta de una solución tecnológica que facilite la administración de los procesos necesarios para cumplir con la normativa vigente y mejorar las condiciones de trabajo. Es por eso que hemos desarrollado una solución integral que aborda estas necesidades y ayuda a optimizar la gestión de la prevención de riesgos laborales.</p>
                <h2>PROBLEMA:</h2>
                <p>Una de las principales dificultades que enfrentan las empresas es la falta de un sistema de información efectivo para administrar la gran cantidad de datos generados y controlar las actividades y el personal involucrado. Además, la planificación de las visitas a los clientes suele ser problemática, ya que nuestros profesionales están frecuentemente en terreno y no siempre están disponibles para comunicar sus actividades futuras.</p>
                <p>Otro desafío es la falta de registro y seguimiento de la actividad de cada profesional, lo que dificulta la asignación de recursos y la coordinación de las capacitaciones. Esto puede resultar en multas para la empresa cuando asisten personas no relacionadas con las charlas o cuando no se coordina adecuadamente la ejecución de las capacitaciones.</p>
                <p>Además, carecemos de un sistema de control de pagos de los clientes, lo que conduce a desbalances financieros y a que algunas actividades sean asumidas por nuestra empresa. El registro de las actividades se realiza en carpetas, lo que dificulta el seguimiento de las asesorías y la recopilación de resultados por empresa. Por si fuera poco, a veces no se cumplen ciertas actividades de control e implementación de soluciones, lo que puede resultar en multas para nuestros clientes y una disminución en la calidad del servicio. También existe la falta de un registro completo de las actividades preventivas realizadas y los avances logrados.</p>
                <h2>SOLUCIÓN:</h2>
                <p>Para abordar estos desafíos, hemos desarrollado una solución tecnológica integral <b>usando las tecnologias de JSP y JSTL</b>. Nuestro sistema permite la planificación y el control de actividades, así como la gestión de clientes. Facilita la coordinación entre nuestra empresa, los profesionales y los clientes, lo que garantiza una respuesta temprana ante incidentes de seguridad.</p>
            </section>
        </div>
    </main>

    <!-- JavaScript Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    <%@include file="footer.jsp"%>
</body>
</html>
