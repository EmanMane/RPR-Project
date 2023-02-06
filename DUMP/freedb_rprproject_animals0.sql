-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: freedb_rprproject
-- ------------------------------------------------------
-- Server version	8.0.31

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
  `animal` varchar(225) NOT NULL,
  `habitat_id` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `Habitat_id_idx` (`habitat_id`),
  CONSTRAINT `habitat` FOREIGN KEY (`habitat_id`) REFERENCES `habitats` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animals`
--

LOCK TABLES `animals` WRITE;
/*!40000 ALTER TABLE `animals` DISABLE KEYS */;
INSERT INTO `animals` VALUES ('Ostrich',5,1),('Ostrich',1,2),('Ostrich',1,3),('White stork',1,4),('White stork',1,5),('White stork',1,6),('Eland',1,7),('Eland',1,8),('Greater flamingo',1,9),('Greater flamingo',1,10),('Greater flamingo',1,11),('Greater flamingo',1,12),('Chilean flamingo',1,13),('African spoonbill',1,14),('Giraffe',2,15),('Giraffe',2,16),('Giraffe',2,17),('Lion',2,18),('Lion',2,19),('Zebra',2,20),('Zebra',2,21),('Zebra',2,22),('Zebra',2,23),('Zebra',2,24),('Rhinoceros',2,25),('Rhinoceros',2,26),('Zebra',2,27),('Rhinoceros',2,28),('Grizzly bear',3,29),('Bald eagle',3,30),('Bald eagle',3,31),('Donkey',3,32),('Beaver',3,33),('Beaver',3,34),('Polar bear',4,35),('Polar bear',4,36),('Southern Sea Otter',4,37),('Southern Sea Otter',4,38),('Southern Sea Otter',4,39),('Camel',5,40),('Camel',5,41),('Red panda',5,42),('Red panda',5,43),('Red panda',5,44),('Red panda',5,45),('Tiger',5,46),('Tiger',5,47),('Tiger',5,48),('Wallaby',6,49),('Wallaby',6,50),('Kangaroo',6,51),('Kangaroo',6,52),('Kangaroo',6,53),('Wolf',7,54),('Wolf',7,55),('Wolf',7,56),('Wolf',7,57),('Wolf',7,58),('Wolf',7,59),('North American River Otter',8,60),('North American River Otter',8,61),('North American River Otter',8,62),('North American River Otter',8,63),('North American River Otter',8,64),('North American River Otter',8,65),('Chimpanzee',9,66),('Chimpanzee',9,67),('Chimpanzee',9,68),('Chimpanzee',9,69),('Chimpanzee',9,70),('Gorilla',9,71),('Gorilla',9,72),('Reticulated python',10,73),('Reticulated python',10,74),('Reticulated python',10,75),('Chinese alligator',10,76),('Chinese alligator',10,77),('Matamata turtle',10,78),('Western Pond Turtle',10,79),('Green tree python',10,80),('Green tree python',10,81),('Red-billed leiothrix',11,82),('Spur-winged lapwing',11,83),('Speckled mousebird',11,84),('Speckled mousebird',11,85),('Scarlet ibis',11,86),('Aquatic caecilian',12,87),('Aquatic caecilian',12,88),('Wyoming toad',12,89),('Wyoming toad',12,90),('Wyoming toad',12,91),('Wyoming toad',12,92),('Wyoming toad',12,93),('Poison frog',12,94),('Poison frog',12,95),('Penguin — chinstrap',13,96),('Penguin — chinstrap',13,97),('Penguin — macaroni',13,98),('Kokodak',5,99),('Penguin — king',13,100),('GoluP',13,101);
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

-- Dump completed on 2023-02-06 12:39:48
