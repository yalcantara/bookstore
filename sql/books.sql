CREATE DATABASE  IF NOT EXISTS `bookstore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bookstore`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `books` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `pages` int(10) unsigned NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `publication_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Est Conclusionemque Ultricies','Shaffer, Denny',70,'Webb','1879-05-08'),(2,'An Invidunt Errem','Hurley, Allison',437,'Farley','1963-01-19'),(3,'Civibus Hinc Numquam Penatibus','Donovan, Hannah',395,'Nelson','1938-06-05'),(4,'Sapien Solet Vivendo Unum','Rogers, Alba',143,'Miranda','1932-09-17'),(5,'Mea Inimicus','Horne, Monique',156,'Michael','1947-03-25'),(6,'Ignota Vulputate Scripserit Posse Expetenda eum','Sykes, Helena',246,'Luna','1925-09-30'),(7,'Electram Consectetuer Laoreet Ornatus Dicat','Giles, Lena',310,'Hays','1924-06-14'),(8,'Quaestio Ornare Eleifend Dissentiunt','Head, Helena',73,'Robinson','1922-07-12'),(9,'Alienum Maiestatis Unum Odio','Knowles, Taylor',192,'Walter','1994-07-06'),(10,'Persecuti cum Inani','Marsh, Frank',176,'Henry','1940-01-07'),(11,'Iriure Quod Omnesque Efficiantur','Charles, Joan',22,'Winters','1897-05-16'),(12,'Taciti Viderer Consetetur Eius','Serrano, Clarence',440,'Abbott','1955-10-22'),(13,'Graece Detraxit Homero Sollicitudin Nunc','Adams, Jewell',35,'Graham','1987-10-29'),(14,'Cubilia Accumsan Principes Ridiculus mei','Summers, Xavier',182,'Kline','1881-04-07'),(15,'Alia ut Facilisis Quis Delicata Interdum','Hughes, Frankie',202,'Stevens','1973-01-19'),(16,'Antiopam Nullam nam','Hale, Renee',257,'Barlow','1887-06-19'),(17,'Torquent Tibique Tamquam Principes','Townsend, Shannon',392,'Hurst','1943-03-05'),(18,'Senserit Ridens Nominavi','Randall, Raquel',105,'Bryant','2005-03-06'),(19,'Numquam Antiopam','Houston, Cedric',288,'Knox','1878-09-08'),(20,'Augue Vestibulum dui Possim Dictas','Callahan, Ralph',111,'Snow','1995-05-26'),(21,'Mattis Pellentesque','Barber, Melisa',388,'Shaw','1870-07-11'),(22,'Ceteros Felis Sale Solet','Snider, Araceli',222,'Shelton','2007-10-10'),(23,'Delenit Wisi Suas mei Sodales Integer','Montgomery, Eugenio',131,'Lott','1900-03-24'),(24,'Postea qui Postulant','Ryan, Misty',166,'David','1947-01-06'),(25,'Arcu Tellus Integer Definitiones Suscipiantur Iuvaret','Finley, Morgan',192,'Tanner','1931-08-14'),(26,'Pellentesque Deserunt Deterruisset','Wilson, Patricia',443,'Hewitt','1908-04-02'),(27,'Regione Voluptatibus Senserit Meliore hac','Navarro, Samuel',85,'Solomon','1882-02-02'),(28,'Vitae Dico Molestiae Quidam Accommodare Orci','O\'Neill, Adan',391,'Dyer','1975-08-24'),(29,'Nulla Mollis Inimicus Nisl Tellus Sententiae','Bass, Suzanne',52,'Sexton','1996-04-23'),(30,'Lectus Intellegebat Unum Suas','Giles, Seymour',391,'Burt','1908-10-08'),(31,'Iudicabit Iisque Iriure','Mejia, Wendi',246,'Farmer','1881-09-09'),(32,'Aptent Intellegebat Enim Lorem','Willis, Lara',77,'Macias','1900-09-07'),(33,'Suscipiantur Viderer Hinc','Larsen, Jayne',86,'Murphy','1961-09-01'),(34,'Recteque Dolorem Facilisi Qualisque Mandamus','Dixon, Angelique',84,'Dyer','1893-01-18'),(35,'Cu Rutrum Scripta','Black, Jesus',289,'Gregory','2006-09-05'),(36,'Honestatis Mauris Meliore Eloquentiam','Gibson, Mack',333,'Kirby','1987-03-04'),(37,'Tibique Placerat Potenti','Melton, Emerson',360,'Alexander','1944-12-18'),(38,'Luptatum Tale Habitant Neglegentur Sapien ne','Morin, Jordan',140,'McLaughlin','1876-08-16'),(39,'Fabulas Legimus','Walls, Demetrius',375,'Burton','1966-06-09'),(40,'Disputationi Dolorum Facilisi Habeo Quot Vocibus','Gilmore, Lora',280,'May','1915-07-23'),(41,'Feugiat Nisi Disputationi Ullamcorper Ipsum Tincidunt','Vazquez, Hunter',272,'Ball','1916-12-20'),(42,'Referrentur Lobortis Odio Suscipit','Richmond, Kristine',447,'O\'Connor','1955-07-31'),(43,'Propriae Fringilla','Garrison, Tamra',24,'Rowe','1890-12-29'),(44,'Expetenda Mucius Etiam Class Integer Natoque','O\'Connor, Betty',15,'Farley','1960-05-27'),(45,'Delicata Tale Evertitur','Glover, Clarissa',288,'Robles','1965-02-13'),(46,'Ne Consectetuer','Sloan, Cary',108,'Valenzuela','1957-11-03'),(47,'Vituperatoribus Nostra Omnesque Equidem','Guy, Kenya',229,'Barr','1930-06-06'),(48,'Suavitate Invenire','Zimmerman, Aron',164,'Madden','1938-02-07'),(49,'Aperiri Ponderum Ultricies Harum Persecuti Qualisque','Stanton, Queen',297,'Meyers','1987-07-21'),(50,'Adolescens Vitae','Whitaker, Martina',56,'Shepherd','1901-05-08'),(51,'Altera vel Varius Dolores Corrumpit','Buckley, Norma',424,'Hernandez','1925-09-18'),(52,'Liber Natum Appetere Quem','Watson, Gale',375,'Aguirre','1897-12-23'),(53,'Viverra Veniam Scripta Pellentesque Definitiones','Rice, Darcy',14,'Lindsay','1898-06-25'),(54,'Has Nascetur eam Verear an','Robinson, Randy',271,'Knox','1986-10-18'),(55,'Ignota Graece','Fry, Elliott',91,'Roman','1998-01-30'),(56,'Melius Intellegebat Inimicus Dictum Tantas Eripuit','Nielsen, Maryanne',382,'Sandoval','1978-08-30'),(57,'Venenatis Animal Affert Suscipiantur Mnesarchum Cetero','Downs, Caroline',337,'Sexton','1973-02-19'),(58,'Tantas Viris Ligula Tortor','O\'Connor, Erica',429,'McCarthy','1919-04-14'),(59,'Fuisset Ferri ne','Gilmore, Fred',347,'Joseph','1918-02-16'),(60,'Salutatus sit','Blackwell, Aline',270,'Brewer','1972-03-15'),(61,'Fabulas Libero Neque','Estrada, Billie',447,'Crane','1976-01-15'),(62,'Ornare Posidonium Quaerendum Constituto Urna Omnesque','Roberson, Ellen',161,'Warren','1902-10-24'),(63,'Suspendisse ex Sapientem Esse Habitasse','Payne, Bryon',126,'Ferguson','1948-04-07'),(64,'Taciti Varius duo','Kramer, Meghan',370,'McConnell','1892-02-20'),(65,'Eleifend Consetetur Placerat Integer Dicunt','Bishop, Cora',77,'Hinton','1960-07-09'),(66,'Phasellus Periculis hac has Molestiae','Burton, Adele',410,'Dominguez','1884-05-13'),(67,'Mauris Aeque Diam Nonumy','Sheppard, Emil',285,'Peterson','1882-07-15'),(68,'Habitant an Prompta his','Taylor, Reva',247,'Fulton','1968-08-03'),(69,'Laudem Quaerendum','Whitney, Jan',48,'Buck','1979-03-19'),(70,'Aptent Quot Vituperatoribus Assueverit','Guzman, Tamra',307,'Wood','1980-04-02'),(71,'Aliquip Graece Dicam Lectus Definitiones Mediocritatem','Jennings, Ethan',104,'Garrett','1896-05-20'),(72,'Ignota Morbi Rhoncus Semper Finibus Eius','Curry, Earlene',318,'Hyde','1973-05-28'),(73,'Maximus Nulla Sanctus Ubique','Herman, Michelle',90,'Evans','2005-06-15'),(74,'Persequeris Gloriatur Sociosqu Gubergren','Foster, Marcus',155,'Huff','1976-05-24'),(75,'Novum Mandamus Sanctus Lorem','Palmer, Gonzalo',21,'Tate','1965-09-10'),(76,'Vix Mauris Lobortis Lorem','Santana, Gabriel',191,'Murray','1971-07-11'),(77,'Inani Aliquip Risus Etiam','Burnett, Samantha',29,'Nolan','1873-11-01'),(78,'Fastidii Evertitur Dictum','Richards, Angela',259,'Gates','1936-06-19'),(79,'Iudicabit ei Risus Ocurreret','Jefferson, Lawrence',95,'Cortez','1919-03-21'),(80,'Expetenda Malorum Varius','Grant, David',112,'Murray','1940-12-10'),(81,'Assueverit Alia sed Docendi','Petersen, Rosie',141,'Brown','1984-06-04'),(82,'Adolescens Cursus Pretium','Cantrell, Antwan',72,'Berg','1917-01-13'),(83,'Cum Mandamus Aenean Possim Dictas Auctor','Foley, Wayne',334,'Ball','1911-06-16'),(84,'Vituperatoribus Diam Vivendo','Boyer, Pearl',119,'Macias','1882-12-31'),(85,'Cursus Viverra Utinam Enim','Flynn, Dominique',119,'Cline','1879-10-22'),(86,'Delicata Solet qui','Patrick, Salvatore',49,'McKay','1977-04-14'),(87,'Viverra Reprimique Partiendo','Mason, Bernardo',189,'West','1924-02-27'),(88,'Vituperatoribus Elementum Ferri','Roy, Katelyn',147,'Clemons','1937-03-22'),(89,'Volumus Vehicula Mattis','Randall, Tanya',405,'Wong','1976-08-30'),(90,'Hac Quot Semper no Suavitate','Brock, Heath',292,'Burks','1902-06-25'),(91,'Latine Equidem Scripta Evertitur Oratio Vulputate','Crane, Matt',258,'Brewer','1903-10-07'),(92,'Nullam Mucius vix Semper Nisi','Whitley, Jimmie',306,'Johnston','1880-07-09'),(93,'Nulla Menandri Porta Praesent Fabulas','Flynn, Evelyn',162,'Schneider','1934-05-06'),(94,'Molestie Hendrerit Morbi Sociosqu Imperdiet','Pope, Vance',217,'Salinas','1874-11-28'),(95,'His Tantas','Stark, Roxie',448,'Rowe','1939-06-27'),(96,'Mentitum Dictum Utinam Graecis','Harvey, Darla',278,'Lang','1929-05-09'),(97,'Nonumes Interesset Efficiantur','Gillespie, Archie',257,'Cortez','1891-11-14'),(98,'Orci Ridens Aptent','Mooney, Gail',267,'O\'Connor','1903-12-24'),(99,'Hinc at Blandit Voluptatibus Ludus Aliquet','French, Andy',409,'Decker','1902-02-13'),(100,'Brute Evertitur Quaestio Persecuti Assueverit','Kerr, Elbert',112,'Hickman','1895-02-21');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-22  1:20:30
