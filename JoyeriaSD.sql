CREATE DATABASE  IF NOT EXISTS `joyeriasd` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `joyeriasd`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: joyeriasd
-- ------------------------------------------------------
-- Server version	9.0.1

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
-- Table structure for table `aval`
--

DROP TABLE IF EXISTS `aval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aval` (
  `IdAval` int NOT NULL AUTO_INCREMENT,
  `IdVendedor` int DEFAULT NULL,
  `NombreCompleto` varchar(200) NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `Parentesco` varchar(50) DEFAULT NULL,
  `Empleo` varchar(100) DEFAULT NULL,
  `NumeroSeguroSocial` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`IdAval`),
  KEY `IdVendedor` (`IdVendedor`),
  CONSTRAINT `aval_ibfk_1` FOREIGN KEY (`IdVendedor`) REFERENCES `vendedor` (`IdVendedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aval`
--

LOCK TABLES `aval` WRITE;
/*!40000 ALTER TABLE `aval` DISABLE KEYS */;
INSERT INTO `aval` VALUES (1,1,'Leticia Guzman','buenos Ares 485','12345678','Tia','Farmacia','345678901224');
/*!40000 ALTER TABLE `aval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Anillo'),(2,'Collar'),(3,'Pulsera'),(4,'Aretes'),(5,'Pendientes'),(6,'Broche'),(7,'Cadena'),(8,'Brazalete');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalledevolucion`
--

DROP TABLE IF EXISTS `detalledevolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalledevolucion` (
  `DetalleDevolucionID` int NOT NULL AUTO_INCREMENT,
  `DevolucionID` int NOT NULL,
  `IdProducto` int NOT NULL,
  `Cantidad` int NOT NULL,
  PRIMARY KEY (`DetalleDevolucionID`),
  KEY `DevolucionID` (`DevolucionID`),
  KEY `IdProducto` (`IdProducto`),
  CONSTRAINT `detalledevolucion_ibfk_1` FOREIGN KEY (`DevolucionID`) REFERENCES `devolucion` (`DevolucionID`),
  CONSTRAINT `detalledevolucion_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalledevolucion`
--

LOCK TABLES `detalledevolucion` WRITE;
/*!40000 ALTER TABLE `detalledevolucion` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalledevolucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleprestamo`
--

DROP TABLE IF EXISTS `detalleprestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleprestamo` (
  `detalleprestamoid` int NOT NULL AUTO_INCREMENT,
  `IdPrestamo` int DEFAULT NULL,
  `IdProducto` int NOT NULL,
  `Cantidad` int NOT NULL,
  `Subtotal` decimal(10,2) NOT NULL,
  PRIMARY KEY (`detalleprestamoid`),
  KEY `VentaPrestamoID` (`IdPrestamo`),
  KEY `IdProducto` (`IdProducto`),
  CONSTRAINT `detalleprestamo_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleprestamo`
--

LOCK TABLES `detalleprestamo` WRITE;
/*!40000 ALTER TABLE `detalleprestamo` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleprestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleventa`
--

DROP TABLE IF EXISTS `detalleventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleventa` (
  `DetalleVentaID` int NOT NULL AUTO_INCREMENT,
  `VentaID` int NOT NULL,
  `IdProducto` int NOT NULL,
  `Cantidad` int NOT NULL,
  `Subtotal` decimal(10,2) NOT NULL,
  PRIMARY KEY (`DetalleVentaID`),
  KEY `VentaID` (`VentaID`),
  KEY `IdProducto` (`IdProducto`),
  CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`VentaID`) REFERENCES `venta` (`VentaID`),
  CONSTRAINT `detalleventa_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleventa`
--

LOCK TABLES `detalleventa` WRITE;
/*!40000 ALTER TABLE `detalleventa` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleventaprestamo`
--

DROP TABLE IF EXISTS `detalleventaprestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleventaprestamo` (
  `DETALLEPRESTAMO` int NOT NULL AUTO_INCREMENT,
  `CANTIDAD` int DEFAULT NULL,
  `IDPRESTAMO` int DEFAULT NULL,
  `IDPRODUCTO` int DEFAULT NULL,
  `SUBTOTAL` float DEFAULT NULL,
  PRIMARY KEY (`DETALLEPRESTAMO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleventaprestamo`
--

LOCK TABLES `detalleventaprestamo` WRITE;
/*!40000 ALTER TABLE `detalleventaprestamo` DISABLE KEYS */;
INSERT INTO `detalleventaprestamo` VALUES (1,1,7,3,530),(2,1,8,7,2800),(3,1,9,8,4500),(4,1,10,1,380);
/*!40000 ALTER TABLE `detalleventaprestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devolucion`
--

DROP TABLE IF EXISTS `devolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `devolucion` (
  `DevolucionID` int NOT NULL AUTO_INCREMENT,
  `IdPrestamo` int NOT NULL,
  `UsuarioID` int NOT NULL,
  `Fecha_venta` date NOT NULL,
  PRIMARY KEY (`DevolucionID`),
  KEY `IdPrestamo` (`IdPrestamo`),
  KEY `UsuarioID` (`UsuarioID`),
  CONSTRAINT `devolucion_ibfk_1` FOREIGN KEY (`IdPrestamo`) REFERENCES `prestamo` (`IdPrestamo`),
  CONSTRAINT `devolucion_ibfk_2` FOREIGN KEY (`UsuarioID`) REFERENCES `usuario` (`UsuarioID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devolucion`
--

LOCK TABLES `devolucion` WRITE;
/*!40000 ALTER TABLE `devolucion` DISABLE KEYS */;
/*!40000 ALTER TABLE `devolucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `EmpleadoID` int NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Apellidos` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Direccion` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Telefono` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `FechaNacimiento` date NOT NULL,
  `FechaIngreso` date NOT NULL,
  PRIMARY KEY (`EmpleadoID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (3,'Julia Eugenia','Guzman','Arroyo Buenos Aires 480','6441508815','1961-07-23','2024-11-09'),(5,'Jessica','Dorame Guzman','123 Abcde','1234567890','2017-12-31','2024-12-04');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialingresos`
--

DROP TABLE IF EXISTS `historialingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historialingresos` (
  `HistorialID` int NOT NULL AUTO_INCREMENT,
  `IdProducto` int DEFAULT NULL,
  `UsuarioID` int DEFAULT NULL,
  `FechaIngreso` date DEFAULT NULL,
  PRIMARY KEY (`HistorialID`),
  KEY `IdProducto` (`IdProducto`),
  KEY `UsuarioID` (`UsuarioID`),
  CONSTRAINT `historialingresos_ibfk_1` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`),
  CONSTRAINT `historialingresos_ibfk_2` FOREIGN KEY (`UsuarioID`) REFERENCES `usuario` (`UsuarioID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialingresos`
--

LOCK TABLES `historialingresos` WRITE;
/*!40000 ALTER TABLE `historialingresos` DISABLE KEYS */;
/*!40000 ALTER TABLE `historialingresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagos` (
  `PagoID` int NOT NULL AUTO_INCREMENT,
  `IdUsuario` int DEFAULT NULL,
  `IdPrestamo` int DEFAULT NULL,
  `Monto` decimal(10,2) DEFAULT NULL,
  `FechaPago` date DEFAULT NULL,
  `MetodoPago` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PagoID`),
  KEY `IdPrestamo` (`IdPrestamo`),
  CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`IdPrestamo`) REFERENCES `prestamo` (`IdPrestamo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamo` (
  `IdPrestamo` int NOT NULL AUTO_INCREMENT,
  `IdVendedor` int NOT NULL,
  `IdUsuario` int NOT NULL,
  `Folio` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `FechaEntrega` date NOT NULL,
  `FechaLiquidacion` date NOT NULL,
  `comision` decimal(10,2) DEFAULT NULL,
  `TotalGeneral` decimal(10,2) DEFAULT NULL,
  `Estado` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`IdPrestamo`),
  KEY `IdVendedor` (`IdVendedor`),
  CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`IdVendedor`) REFERENCES `vendedor` (`IdVendedor`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `IdProducto` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Codigo` varchar(15) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Imagen` varchar(255) DEFAULT NULL,
  `Precio` decimal(10,2) DEFAULT NULL,
  `Stock` int DEFAULT NULL,
  `EstadoP` varchar(25) DEFAULT NULL,
  `idCategoria` int DEFAULT NULL,
  PRIMARY KEY (`IdProducto`),
  KEY `idCategoria` (`idCategoria`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Anillo Abeja','A15M92','Anillo ajustable dama 1.5 cm .925','C:\\Users\\jessi\\Documents\\JoyeriaSD_V0\\Imagen Producto\\A15M92.png',380.00,5,'S',1),(2,'Anillo Colibri','A10M93','Anillo ajustable Dama 1 cm .925','C:\\Users\\jessi\\Documents\\JoyeriaSD_V0\\Imagen Producto\\A10M93.png',410.00,6,'S',1),(3,'Aretes 3 Hojas','AR4M90','Arete 3 hojas manglar Dama 4 cm .925','C:\\Users\\jessi\\Documents\\JoyeriaSD_V0\\Imagen Producto\\AR4M90.png',530.00,6,'S',4),(4,'Aretes Abeja','AR2M91','Arete Abeja reina Dama 2 cm .925','C:\\Users\\jessi\\Documents\\JoyeriaSD_V0\\Imagen Producto\\AR2M91.png',600.00,6,'S',4),(5,'Collar Ajolote','CO47M90','Collar Ajolote Dama 47 cm Ext 5 cm .925','C:\\Users\\jessi\\Documents\\JoyeriaSD_V0\\Imagen Producto\\CO47M90.png',1200.00,6,'S',2),(6,'Brazalete 2 cierre','BZ159H1','Brazalete cierre doble Hombre 15.9 cm .925','C:\\Users\\jessi\\Documents\\JoyeriaSD_V0\\Imagen Producto\\BZ159H1.png',3000.00,6,'S',8),(7,'Cadena eslabon largo','CA457U1','Cadena eslabon largo 18k 45.7 cm .925','C:\\Users\\jessi\\Documents\\JoyeriaSD_V0\\Imagen Producto\\CA457U1.png',2800.00,6,'S',7),(8,'Brazalete Angosta','BZ157U2','Brazalete Tifany Mediana Angosta 15 cm .925','C:\\Users\\jessi\\Documents\\JoyeriaSD_V0\\Imagen Producto\\BZ157U2.png',4500.00,6,'S',8);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referencias`
--

DROP TABLE IF EXISTS `referencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `referencias` (
  `IdReferencia` int NOT NULL AUTO_INCREMENT,
  `IdVendedor` int DEFAULT NULL,
  `NombreCompleto` varchar(200) NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `Parentesco` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdReferencia`),
  KEY `IdVendedor` (`IdVendedor`),
  CONSTRAINT `referencias_ibfk_1` FOREIGN KEY (`IdVendedor`) REFERENCES `vendedor` (`IdVendedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referencias`
--

LOCK TABLES `referencias` WRITE;
/*!40000 ALTER TABLE `referencias` DISABLE KEYS */;
INSERT INTO `referencias` VALUES (1,1,'Joaquin Jimenez','Constitucion 203 col Prados','12345677','Amigo');
/*!40000 ALTER TABLE `referencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `RolID` int NOT NULL AUTO_INCREMENT,
  `NombreRol` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`RolID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador'),(2,'Vendedor');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN',0);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `UsuarioID` int NOT NULL AUTO_INCREMENT,
  `EmpleadoID` int NOT NULL,
  `Usuario` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Contrasena` varchar(64) NOT NULL,
  PRIMARY KEY (`UsuarioID`),
  UNIQUE KEY `Usuario` (`Usuario`),
  KEY `EmpleadoID` (`EmpleadoID`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`EmpleadoID`) REFERENCES `empleado` (`EmpleadoID`)
) ENGINE=InnoDB AUTO_INCREMENT=1052 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (901,3,'Jeugenia','21ef9899d20a60216c6d0cb7222aff25716e81055d3078af1fe89535e6ec684b'),(1051,5,'jdorame','03245be9818f88828af68c25c99c3b246845951d8e6bbf6e61ec15e10f0d2cb9');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariorol`
--

DROP TABLE IF EXISTS `usuariorol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuariorol` (
  `UsuarioRolID` int NOT NULL AUTO_INCREMENT,
  `UsuarioID` int NOT NULL,
  `RolID` int NOT NULL,
  PRIMARY KEY (`UsuarioRolID`),
  KEY `UsuarioID` (`UsuarioID`),
  KEY `RolID` (`RolID`),
  CONSTRAINT `usuariorol_ibfk_1` FOREIGN KEY (`UsuarioID`) REFERENCES `usuario` (`UsuarioID`),
  CONSTRAINT `usuariorol_ibfk_2` FOREIGN KEY (`RolID`) REFERENCES `rol` (`RolID`)
) ENGINE=InnoDB AUTO_INCREMENT=1053 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariorol`
--

LOCK TABLES `usuariorol` WRITE;
/*!40000 ALTER TABLE `usuariorol` DISABLE KEYS */;
INSERT INTO `usuariorol` VALUES (902,901,2),(1052,1051,1);
/*!40000 ALTER TABLE `usuariorol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `IdVendedor` int NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  `Colonia` varchar(100) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `NumeroSeguroSocial` varchar(15) DEFAULT NULL,
  `LimitePrestamo` decimal(10,0) NOT NULL,
  `Empleo` varchar(100) DEFAULT NULL,
  `Comision` decimal(10,2) DEFAULT NULL,
  `FechaIngreso` date DEFAULT NULL,
  `EstadoCivil` varchar(50) DEFAULT NULL,
  `NombreConyuge` varchar(100) DEFAULT NULL,
  `ApellidosConyuge` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdVendedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (1,'Jazmin','Dorame','2024-12-01','centro 123','Norte','6441509934','12345678910',3000,'Cajera Ley',0.15,'2024-12-01','Soltera','','');
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `VentaID` int NOT NULL AUTO_INCREMENT,
  `UsuarioID` int NOT NULL,
  `Folio` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `Fecha_venta` date NOT NULL,
  `Descuento` decimal(10,0) DEFAULT NULL,
  `Nombre_Cliente` varchar(25) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `Total` decimal(10,0) NOT NULL,
  PRIMARY KEY (`VentaID`),
  KEY `UsuarioID` (`UsuarioID`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`UsuarioID`) REFERENCES `usuario` (`UsuarioID`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'joyeriasd'
--

--
-- Dumping routines for database 'joyeriasd'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-05 10:56:32
