DROP DATABASE IF EXISTS prevencion_riesgos;
CREATE DATABASE  IF NOT EXISTS `prevencion_riesgos` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `prevencion_riesgos`;
-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: prevencion_riesgos
-- ------------------------------------------------------
-- Server version	5.7.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Accidentes`
--

DROP TABLE IF EXISTS `Accidentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Accidentes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) DEFAULT NULL,
  `fecha_accidente` date DEFAULT NULL,
  `detalle` text,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `accidentes_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `Usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Accidentes`
--

LOCK TABLES `Accidentes` WRITE;
/*!40000 ALTER TABLE `Accidentes` DISABLE KEYS */;
/*!40000 ALTER TABLE `Accidentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Asesorias`
--

DROP TABLE IF EXISTS `Asesorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Asesorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `detalle` text,
  `profesional_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `profesional_id` (`profesional_id`),
  CONSTRAINT `asesorias_ibfk_1` FOREIGN KEY (`profesional_id`) REFERENCES `Usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Asesorias`
--

LOCK TABLES `Asesorias` WRITE;
/*!40000 ALTER TABLE `Asesorias` DISABLE KEYS */;
/*!40000 ALTER TABLE `Asesorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Asistentes`
--

DROP TABLE IF EXISTS `Asistentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Asistentes` (
  `capacitacion_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`capacitacion_id`,`usuario_id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `asistentes_ibfk_1` FOREIGN KEY (`capacitacion_id`) REFERENCES `Capacitaciones` (`id`),
  CONSTRAINT `asistentes_ibfk_2` FOREIGN KEY (`usuario_id`) REFERENCES `Usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Asistentes`
--

LOCK TABLES `Asistentes` WRITE;
/*!40000 ALTER TABLE `Asistentes` DISABLE KEYS */;
/*!40000 ALTER TABLE `Asistentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Capacitaciones`
--

DROP TABLE IF EXISTS `Capacitaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Capacitaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `detalle` varchar(120),
  `rut_cliente` int(11) DEFAULT NULL,
  `dia` varchar(11) DEFAULT NULL,
  `hora` varchar(6) DEFAULT NULL,
  `lugar` varchar(50) DEFAULT NULL,
  `duracion` varchar(70) DEFAULT NULL,
  `cantidad_asistentes` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Capacitaciones`
--

LOCK TABLES `Capacitaciones` WRITE;
/*!40000 ALTER TABLE `Capacitaciones` DISABLE KEYS */;
ALTER TABLE `Capacitaciones` AUTO_INCREMENT = 1;

INSERT INTO `Capacitaciones` (`nombre`, `detalle`, `rut_cliente`, `dia`, `hora`, `lugar`, `duracion`, `cantidad_asistentes`) 
VALUES 
('Uso adecuado de extintores', 'Aprende a identificar los tipos de incendios y cómo utilizar extintores de manera segura.', 12345678, 'Lunes', '09:00', 'Sala de conferencias A', '2 horas', 30),
('Elementos de seguridad en el trabajo', 'Conoce elementos de protección personal y cómo utilizarlos correctamente.', 11223344, 'Martes', '14:30', 'Salón de capacitaciones B', '1.5 horas', 25),
('Charla informativa sobre normativas', 'Descubre normativas y regulaciones vigentes en seguridad laboral y cómo cumplirlas.', 55667788, 'Miércoles', '11:00', 'Auditorio principal', '1 hora', 50),
('Prevención de riesgos en manejo químico', 'Identifica riesgos y medidas preventivas para manejo de sustancias químicas.', 87654321, 'Jueves', '15:30', 'Sala de conferencias C', '2 horas', 40),
('Seguridad en altura y manejo de herramientas', 'Riesgos en trabajo en altura y uso seguro de herramientas, medidas de prevención.', 15975346, 'Sábado', '10:00', 'Salón de capacitaciones A', '1.5 horas', 20),
('Primeros auxilios en el trabajo', 'Aprende primeros auxilios y cómo actuar en caso de accidentes o emergencias laborales.', 14736925, 'Domingo', '13:30', 'Auditorio principal', '1 hora', 60),
('Ergonomía y prevención de lesiones', 'Mejora la ergonomía en tu lugar de trabajo para prevenir lesiones y promover entorno saludable.', 14367496, 'Viernes', '09:00', 'Sala de conferencias B', '2 horas', 35),
('Seguridad eléctrica en el trabajo', 'Conoce peligros asociados a la electricidad y medidas de seguridad para evitar accidentes.', 12789832, 'Miércoles', '14:30', 'Salón de capacitaciones C', '1.5 horas', 30),
('Manejo seguro de maquinaria', 'Aprende procedimientos seguros para manejo de maquinaria industrial y prevén riesgos.', 14796385, 'Lunes', '11:00', 'Auditorio principal', '1 hora', 45),
('Prevención de caídas y protección', 'Prevención de caídas en el trabajo y uso adecuado de equipos de protección.', 98741236, 'Martes', '15:30', 'Sala de conferencias A', '2 horas', 25);
/*!40000 ALTER TABLE `Capacitaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Chequeos`
--

DROP TABLE IF EXISTS `Chequeos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Chequeos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visita_id` int(11) DEFAULT NULL,
  `detalle` text,
  `estado` enum('Pendiente','Completado') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `visita_id` (`visita_id`),
  CONSTRAINT `chequeos_ibfk_1` FOREIGN KEY (`visita_id`) REFERENCES `Visitas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Chequeos`
--

LOCK TABLES `Chequeos` WRITE;
/*!40000 ALTER TABLE `Chequeos` DISABLE KEYS */;
/*!40000 ALTER TABLE `Chequeos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pagos`
--

DROP TABLE IF EXISTS `Pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pagos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) DEFAULT NULL,
  `monto` decimal(10,2) DEFAULT NULL,
  `fecha_pago` timestamp,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `Usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pagos`
--

LOCK TABLES `Pagos` WRITE;
/*!40000 ALTER TABLE `Pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `Pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `rol` enum('Cliente','Administrativo','Profesional') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
ALTER TABLE `Usuarios` AUTO_INCREMENT = 1;

INSERT INTO usuarios (`nombre`, `contrasena`, `rol`) VALUES
('Juan', '$2a$10$7lgm/idmFqa7zDdxKICTyeqyEvWb/7gqyRoDFfPgyh9OHDaw4K89K', 'Cliente'),
('María', '$2a$10$7lgm/idmFqa7zDdxKICTyeqyEvWb/7gqyRoDFfPgyh9OHDaw4K89K', 'Cliente'),
('Carlos', '$2a$10$7lgm/idmFqa7zDdxKICTyeqyEvWb/7gqyRoDFfPgyh9OHDaw4K89K', 'Cliente'),
('Pedro', '$2a$10$7lgm/idmFqa7zDdxKICTyeqyEvWb/7gqyRoDFfPgyh9OHDaw4K89K', 'Administrativo'),
('Marta', '$2a$10$7lgm/idmFqa7zDdxKICTyeqyEvWb/7gqyRoDFfPgyh9OHDaw4K89K', 'Administrativo'),
('Pablo', '$2a$10$7lgm/idmFqa7zDdxKICTyeqyEvWb/7gqyRoDFfPgyh9OHDaw4K89K', 'Administrativo'),
('Gabriel', '$2a$10$7lgm/idmFqa7zDdxKICTyeqyEvWb/7gqyRoDFfPgyh9OHDaw4K89K', 'Profesional'),
('Natalia', '$2a$10$7lgm/idmFqa7zDdxKICTyeqyEvWb/7gqyRoDFfPgyh9OHDaw4K89K', 'Profesional'),
('Martín', '$2a$10$7lgm/idmFqa7zDdxKICTyeqyEvWb/7gqyRoDFfPgyh9OHDaw4K89K', 'Profesional');
UNLOCK TABLES;

--
-- Table structure for table `Administrativo`
--
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE Administrativo (
    id INT PRIMARY KEY,
    nombre_a varchar(50),
    area VARCHAR(50),
    experiencia_previa VARCHAR(100),
    FOREIGN KEY (id) REFERENCES Usuarios(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO administrativo (`id`, `nombre_a`, `area`, `experiencia_previa`) VALUES
(4, 'Pedro', 'Recursos Humanos', '3 años'),
(5, 'Marta', 'Contabilidad', '2 años'),
(6, 'Pablo', 'Administración', '4 años');
--
-- Table structure for table `Profesional`
--
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE Profesional (
    id INT PRIMARY KEY,
    nombre_p varchar(50),
    titulo VARCHAR(50),
    fecha_ingreso DATE,
    FOREIGN KEY (id) REFERENCES Usuarios(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO profesional (`id`, `nombre_p`, `titulo`, `fecha_ingreso`) VALUES
(7, 'Gabriel', 'Ingeniero', '2021-05-10'),
(8, 'Natalia', 'Arquitecta', '2020-02-15'),
(9, 'Martín', 'Contador', '2019-08-20');

--
-- Table structure for table `Cliente`
--
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE Cliente (
    id INT PRIMARY KEY,
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    telefono INT,
    direccion VARCHAR(100),
    comuna VARCHAR(50),
    edad INT,
    rut INT,
    FOREIGN KEY (id) REFERENCES Usuarios(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


INSERT INTO cliente (`id`, `nombres`, `apellidos`, `telefono`, `direccion`, `comuna`, `edad`, `rut`) VALUES
(1, 'Juan', 'Pérez', '123456789', 'Calle 123', 'Santiago', 30, '123456789'),
(2, 'María', 'González', '987654321', 'Avenida 456', 'Valparaíso', 25, '987654321'),
(3, 'Carlos', 'López', '555555555', 'Ruta 789', 'Concepción', 40, '345678901');

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `Usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Visitas`
--

DROP TABLE IF EXISTS `Visitas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Visitas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) DEFAULT NULL,
  `fecha_visita` date DEFAULT NULL,
  `detalle` text,
  `profesional_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  KEY `profesional_id` (`profesional_id`),
  CONSTRAINT `visitas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `Usuarios` (`id`),
  CONSTRAINT `visitas_ibfk_2` FOREIGN KEY (`profesional_id`) REFERENCES `Usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Visitas`
--


LOCK TABLES `Visitas` WRITE;
/*!40000 ALTER TABLE `Visitas` DISABLE KEYS */;
/*!40000 ALTER TABLE `Visitas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-06 20:31:17
