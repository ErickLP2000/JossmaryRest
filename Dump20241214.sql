-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto_inventario
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `categorias_insumos`
--

DROP TABLE IF EXISTS `categorias_insumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias_insumos` (
  `id_catinsumos` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nombre_categoria_insumo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_catinsumos`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias_insumos`
--

LOCK TABLES `categorias_insumos` WRITE;
/*!40000 ALTER TABLE `categorias_insumos` DISABLE KEYS */;
INSERT INTO `categorias_insumos` VALUES (1,'Moresa'),(3,'aaa'),(5,'More');
/*!40000 ALTER TABLE `categorias_insumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias_productos`
--

DROP TABLE IF EXISTS `categorias_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias_productos` (
  `id_catproducto` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nombre_categoria_producto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_catproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias_productos`
--

LOCK TABLES `categorias_productos` WRITE;
/*!40000 ALTER TABLE `categorias_productos` DISABLE KEYS */;
INSERT INTO `categorias_productos` VALUES (1,'Moresas'),(2,'Luis Noguera'),(5,'Mores');
/*!40000 ALTER TABLE `categorias_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `tipo_cliente_id` bigint unsigned DEFAULT NULL,
  `tipo_documento_id` bigint unsigned DEFAULT NULL,
  `distrito_id` bigint unsigned DEFAULT NULL,
  `nombres` varchar(150) DEFAULT NULL,
  `apellido_paterno` varchar(150) DEFAULT NULL,
  `apellido_materno` varchar(150) DEFAULT NULL,
  `nro_documento` varchar(50) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `celular` varchar(9) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `fecha_editado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_distrito_cliente_idx` (`distrito_id`),
  KEY `fk_tipclo_cliente_idx` (`tipo_cliente_id`),
  KEY `fk_tipdoc_cliente_idx` (`tipo_documento_id`),
  CONSTRAINT `fk_distrito_cliente` FOREIGN KEY (`distrito_id`) REFERENCES `distritos` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_tipclo_cliente` FOREIGN KEY (`tipo_cliente_id`) REFERENCES `tipo_cliente` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_tipdoc_cliente` FOREIGN KEY (`tipo_documento_id`) REFERENCES `tipo_documento` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (2,1,2,8,'More','Martissss','MORE','169681516','Lima','919746551','2024-11-22 00:00:00','2024-11-22 11:00:08'),(3,1,1,5,'Admin','Martinez','NOMEs','69651','Lima','919746551',NULL,'2024-11-22 10:53:02'),(4,1,1,18,'Admin','Martinez','sdasdasdaaaaa','6965134','Caracas','9497416','2024-11-22 11:00:32','2024-11-22 11:00:40'),(5,1,1,3,'Admin','Marti','Martinez','69651','Callao','949151151','2024-11-22 18:21:44',NULL),(6,2,1,3,'More','asdasda','sdasdasd','69651','Caracas','949151151','2024-11-23 09:12:43',NULL);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distritos`
--

DROP TABLE IF EXISTS `distritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distritos` (
  `id` bigint unsigned NOT NULL,
  `nombre_distrito` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distritos`
--

LOCK TABLES `distritos` WRITE;
/*!40000 ALTER TABLE `distritos` DISABLE KEYS */;
INSERT INTO `distritos` VALUES (1,'Ancón'),(2,'Ate'),(3,'Barranco'),(4,'Breña'),(5,'Carabayllo'),(6,'Chaclacayo'),(7,'Chorrillos'),(8,'Cieneguilla'),(9,'Comas'),(10,'El Agustino\n'),(11,'Independencia'),(12,'Jesús María\n'),(13,'La Molina\n'),(14,'La Victoria\n'),(15,'Lima (Cercado de Lima)\n'),(16,'Lince'),(17,'Los Olivos\n'),(18,'Lurigancho-Chosica\n'),(19,'Lurín'),(20,'Magdalena del Mar\n'),(21,'Miraflores'),(22,'Pachacámac'),(23,'Pucusana'),(24,'Pueblo Libre\n'),(25,'Puente Piedra\n'),(26,'Punta Hermosa\n'),(27,'Punta Negra\n'),(28,'Rímac'),(29,'San Bartolo\n'),(30,'San Borja\n'),(31,'San Isidro\n'),(32,'San Juan de Lurigancho\n'),(33,'San Juan de Miraflores\n'),(34,'San Luis\n'),(35,'San Martín de Porres\n'),(36,'San Miguel\n'),(37,'Santa Anita\n'),(38,'Santa María del Mar\n'),(39,'Santa Rosa\n'),(40,'Santiago de Surco\n'),(41,'Surquillo'),(42,'Villa El Salvador\n'),(43,'Villa María del Triunfo\n');
/*!40000 ALTER TABLE `distritos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumos`
--

DROP TABLE IF EXISTS `insumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insumos` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `categoria_insumo_id` bigint unsigned DEFAULT NULL,
  `proveedor_id` bigint unsigned DEFAULT NULL,
  `marca_insumo_id` bigint unsigned DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cat_insumos_idx` (`categoria_insumo_id`),
  KEY `fk_prov_insumo_idx` (`proveedor_id`),
  KEY `fk_marca_insumo_idx` (`marca_insumo_id`),
  CONSTRAINT `fk_cat_insumo` FOREIGN KEY (`categoria_insumo_id`) REFERENCES `categorias_insumos` (`id_catinsumos`),
  CONSTRAINT `fk_marca_insumo` FOREIGN KEY (`marca_insumo_id`) REFERENCES `marcas_insumos` (`id_marcainsumo`),
  CONSTRAINT `fk_prov_insumo` FOREIGN KEY (`proveedor_id`) REFERENCES `proveedores` (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumos`
--

LOCK TABLES `insumos` WRITE;
/*!40000 ALTER TABLE `insumos` DISABLE KEYS */;
INSERT INTO `insumos` VALUES (2,1,2,2,'Admin','45651aaaaaaaaaaaaaaaa','Azul');
/*!40000 ALTER TABLE `insumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas_insumos`
--

DROP TABLE IF EXISTS `marcas_insumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marcas_insumos` (
  `id_marcainsumo` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nombre_marca_insumo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_marcainsumo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas_insumos`
--

LOCK TABLES `marcas_insumos` WRITE;
/*!40000 ALTER TABLE `marcas_insumos` DISABLE KEYS */;
INSERT INTO `marcas_insumos` VALUES (1,'Moree'),(2,'Moresss'),(4,'SDasdasdasd');
/*!40000 ALTER TABLE `marcas_insumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `categoria_producto_id` bigint unsigned DEFAULT NULL,
  `nombre_producto` varchar(150) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `talla` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cat_prod_idx` (`categoria_producto_id`),
  CONSTRAINT `fk_cat_prod` FOREIGN KEY (`categoria_producto_id`) REFERENCES `categorias_productos` (`id_catproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,1,'More','Azulino','M'),(3,2,'More','Azulino','M');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `id_proveedor` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nombre_proveedor` varchar(255) DEFAULT NULL,
  `ruc` varchar(11) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `celular` varchar(9) DEFAULT NULL,
  `estado_proveedor` int DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `fecha_editado` datetime DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (2,'More','21323124','Lima','919746551',1,'2024-11-22 18:53:31','2024-12-14 09:56:26'),(3,'More','6516516','Comas','919746551',1,'2024-11-22 19:00:27','2024-12-14 09:56:38'),(4,'Luis Nogueraa','16516915','Caracas','919746552',1,'2024-11-22 19:00:45','2024-12-12 01:19:53'),(5,'More','21323124','Comasaa','919746551',0,'2024-12-14 09:54:22','2024-12-14 09:56:16');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `authority` varchar(45) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_roles_usuario1` (`user_id`),
  CONSTRAINT `fk_roles_usuario1` FOREIGN KEY (`user_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROL_ADMIN',1);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicios` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `cliente_id` bigint unsigned DEFAULT NULL,
  `servicio_especifico_id` bigint unsigned DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cli_serv_idx` (`cliente_id`),
  KEY `fk_esp_serv_idx` (`servicio_especifico_id`),
  CONSTRAINT `fk_cli_serv` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`),
  CONSTRAINT `fk_esp_serv` FOREIGN KEY (`servicio_especifico_id`) REFERENCES `servicios_especificos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (2,4,2,'Prueba\r\n');
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios_especificos`
--

DROP TABLE IF EXISTS `servicios_especificos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicios_especificos` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nombre_servicio` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios_especificos`
--

LOCK TABLES `servicios_especificos` WRITE;
/*!40000 ALTER TABLE `servicios_especificos` DISABLE KEYS */;
INSERT INTO `servicios_especificos` VALUES (1,'Mores'),(2,'dasdasda'),(3,'asdasd');
/*!40000 ALTER TABLE `servicios_especificos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_cliente`
--

DROP TABLE IF EXISTS `tipo_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_cliente` (
  `id` bigint unsigned NOT NULL,
  `nombre_tipo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cliente`
--

LOCK TABLES `tipo_cliente` WRITE;
/*!40000 ALTER TABLE `tipo_cliente` DISABLE KEYS */;
INSERT INTO `tipo_cliente` VALUES (1,'Ordinario'),(2,'VIP');
/*!40000 ALTER TABLE `tipo_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documento`
--

DROP TABLE IF EXISTS `tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_documento` (
  `id` bigint unsigned NOT NULL,
  `nombre_documento` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documento`
--

LOCK TABLES `tipo_documento` WRITE;
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
INSERT INTO `tipo_documento` VALUES (1,'DNI'),(2,'RUC');
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enable` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Admin','$2a$12$RsIZNJFcxBwuT3OExtg1EuZ5sAgIKBDCsHxLyWlecVraeV6uICD/a',1),(3,'Prueba','$2a$10$/anLY6GaDCzMDRuDHUMiWeNCOTLWlxGzLAq56DTtT6BuLLhccLsna',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-14 11:40:17
