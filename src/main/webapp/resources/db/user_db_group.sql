-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: user_db
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group` (
  `id_group` int(11) NOT NULL AUTO_INCREMENT,
  `name_group` varchar(255) NOT NULL,
  PRIMARY KEY (`id_group`),
  UNIQUE KEY `id_group_UNIQUE` (`id_group`),
  UNIQUE KEY `name_group_UNIQUE` (`name_group`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` VALUES (56,'543'),(3,'Åland Islands'),(6,'Albania'),(24,'American Samoa'),(2,'Bahrain'),(19,'Belgium'),(11,'Botswana'),(28,'Bouvet Island'),(18,'Brazil'),(15,'Bulgaria'),(17,'Cambodia'),(13,'Cocos (Keeling) Islands'),(23,'Comoros'),(4,'Cuba'),(58,'eeeeee777'),(48,'en1'),(12,'Eritrea'),(20,'Guinea'),(8,'Korea, North'),(29,'Kyrgyzstan'),(22,'Morocco'),(9,'Mozambique'),(1,'name1'),(21,'Nicaragua'),(51,'pl2'),(47,'qwer'),(45,'rffvrrrr'),(53,'rrr44'),(25,'Saint Pierre and Miquelon'),(5,'South Georgia and The South Sandwich Islands'),(10,'Sweden'),(16,'Thailand'),(30,'Togo'),(7,'Tonga'),(26,'Trinidad and Tobago'),(27,'Uganda'),(14,'Wallis and Futuna'),(59,'wsxcderf');
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-22 11:38:18
