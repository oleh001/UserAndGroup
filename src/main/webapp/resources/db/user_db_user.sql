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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `id_group` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `iduser_UNIQUE` (`id_user`),
  KEY `fk_group_index` (`id_group`),
  CONSTRAINT `fk_user_group` FOREIGN KEY (`id_group`) REFERENCES `group` (`id_group`) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'log1','fn1','ln1','ps','1895-01-02 00:00:00',1),(2,'log2','fn2','ln2','p2','1994-05-27 00:00:00',3),(3,'log3','fn3','ln3','p3','1895-04-04 00:00:00',4),(4,'lkhg','fn4','ln4','ps4','1895-04-04 00:00:00',2),(5,'kjhgf','fn55','ln54','555','2005-05-05 00:00:00',1),(6,'ujhgf','fn6','ln6','ps6','2014-02-26 00:00:00',3),(99,'kmnbf','Oleh','Kostiuk','123','1993-10-02 00:00:00',5),(106,'qw','user100','us100','usssse','2014-02-26 00:00:00',4),(107,'rffssdfsd',';kl;jk','sdffghfj','khjkjl','2017-07-18 00:00:00',22),(108,'newww','wwww','wwwww','wwwww','2017-07-01 00:00:00',1),(109,'def','jp;l','hj','klk;,\'','2017-07-25 00:00:00',20),(110,'edrftguyhujk','ftgyhjnmk','dftgyhjmk,','drftghjnmkl','2017-07-04 00:00:00',1),(111,'555','555','555','555','2017-07-04 00:00:00',24),(112,'rfv555','qaz555','edc555','wsx555','2017-08-01 00:00:00',20),(113,'tyu','wer','ghj','bnm','2017-08-10 00:00:00',24),(114,'tyuiop;f',',mnbvc','lkjhbgvcx','cvbnm,.','2017-08-05 00:00:00',2),(115,'qqqq','qqqq','qqqq','qqqq','2017-08-07 00:00:00',56),(116,'eeeeee','eeeeee','eeeeee','eeeee','2017-08-07 00:00:00',3),(117,'999','999','999','999','2017-08-01 00:00:00',9),(118,'qwedsazxcv888','vcds888','cxzsdf888','gvcxsdfg888','2017-08-20 00:00:00',17),(119,'qwerty','rty6','qasxcv','erthbvc','2017-08-22 00:00:00',6),(120,'fgb','dfg','vfg','hbvc','2017-08-15 00:00:00',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
