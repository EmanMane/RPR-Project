-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: sql.freedb.tech    Database: freedb_RPRproject
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `animals`
--

DROP TABLE IF EXISTS `animals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animals` (
  `id` int NOT NULL,
  `animal` varchar(225) NOT NULL,
  `habitat_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Habitat_id_idx` (`habitat_id`),
  CONSTRAINT `habitat` FOREIGN KEY (`habitat_id`) REFERENCES `habitats` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animals`
--

LOCK TABLES `animals` WRITE;
/*!40000 ALTER TABLE `animals` DISABLE KEYS */;
INSERT INTO `animals` VALUES (1,'Ostrich',1),(2,'Ostrich',1),(3,'Ostrich',1),(4,'White stork',1),(5,'White stork',1),(6,'White stork',1),(7,'Eland',1),(8,'Eland',1),(9,'Greater flamingo',1),(10,'Greater flamingo',1),(11,'Greater flamingo',1),(12,'Greater flamingo',1),(13,'Chilean flamingo',1),(14,'African spoonbill',1),(15,'Giraffe',2),(16,'Giraffe',2),(17,'Giraffe',2),(18,'Lion',2),(19,'Lion',2),(20,'Zebra',2),(21,'Zebra',2),(22,'Zebra',2),(23,'Zebra',2),(24,'Zebra',2),(25,'Rhinoceros',2),(26,'Rhinoceros',2),(27,'Zebra',2),(28,'Rhinoceros',2),(29,'Grizzly bear',3),(30,'Bald eagle',3),(31,'Bald eagle',3),(32,'Donkey',3),(33,'Beaver',3),(34,'Beaver',3),(35,'Polar bear',4),(36,'Polar bear',4),(37,'Southern Sea Otter',4),(38,'Southern Sea Otter',4),(39,'Southern Sea Otter',4),(40,'Camel',5),(41,'Camel',5),(42,'Red panda',5),(43,'Red panda',5),(44,'Red panda',5),(45,'Red panda',5),(46,'Tiger',5),(47,'Tiger',5),(48,'Tiger',5),(49,'Wallaby',6),(50,'Wallaby',6),(51,'Kangaroo',6),(52,'Kangaroo',6),(53,'Kangaroo',6),(54,'Wolf',7),(55,'Wolf',7),(56,'Wolf',7),(57,'Wolf',7),(58,'Wolf',7),(59,'Wolf',7),(60,'North American River Otter',8),(61,'North American River Otter',8),(62,'North American River Otter',8),(63,'North American River Otter',8),(64,'North American River Otter',8),(65,'North American River Otter',8),(66,'Chimpanzee',9),(67,'Chimpanzee',9),(68,'Chimpanzee',9),(69,'Chimpanzee',9),(70,'Chimpanzee',9),(71,'Gorilla',9),(72,'Gorilla',9),(73,'Reticulated python',10),(74,'Reticulated python',10),(75,'Reticulated python',10),(76,'Chinese alligator',10),(77,'Chinese alligator',10),(78,'Matamata turtle',10),(79,'Western Pond Turtle',10),(80,'Green tree python',10),(81,'Green tree python',10),(82,'Red-billed leiothrix',11),(83,'Spur-winged lapwing',11),(84,'Speckled mousebird',11),(85,'Speckled mousebird',11),(86,'Scarlet ibis',11),(87,'Aquatic caecilian',12),(88,'Aquatic caecilian',12),(89,'Wyoming toad',12),(90,'Wyoming toad',12),(91,'Wyoming toad',12),(92,'Wyoming toad',12),(93,'Wyoming toad',12),(94,'Poison frog',12),(95,'Poison frog',12),(96,'Penguin — chinstrap',13),(97,'Penguin — chinstrap',13),(98,'Penguin — macaroni',13),(99,'Penguin — macaroni',13),(100,'Penguin — king',13);
/*!40000 ALTER TABLE `animals` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-05 10:11:40
