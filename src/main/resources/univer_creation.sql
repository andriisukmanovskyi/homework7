-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: univer
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `address`
--
create database univer;
use univer;

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(45) DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `house` varchar(45) DEFAULT NULL,
  `apartment` int(11) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'qew','qwe','qwe','eqw','qwe',23),(2,'USA','DC','Washington','Street','97a',20),(3,'USA','DC','Washington','Street','97a',20),(4,'USA','DC','Washington','Street','97a',20),(5,'USA','DC','Washington','Street','97a',20),(6,'USA','DC','Washington','Street','97a',20),(7,'USA','DC','Washington','Street','97a',20),(8,'USA','DC','Washington','Street','97a',20),(9,'USA','DC','Washington','Street','97a',20),(10,'USA','DC','Washington','Street','97a',20),(33,'USA','DC','Washington','Street','97a',20),(88,'USA','DC','Washington','Street','97a',20);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `exam` (
  `exam_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`exam_id`),
  KEY `subject_id_idx` (`subject_id`),
  KEY `student_id_idx` (`student_id`),
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupp`
--

DROP TABLE IF EXISTS `groupp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `groupp` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(45) DEFAULT NULL,
  `speciality_id` int(11) DEFAULT NULL,
  `course` int(11) DEFAULT NULL,
  PRIMARY KEY (`group_id`),
  KEY `speciality_idx` (`speciality_id`),
  CONSTRAINT `spec` FOREIGN KEY (`speciality_id`) REFERENCES `speciality` (`speciality_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupp`
--

LOCK TABLES `groupp` WRITE;
/*!40000 ALTER TABLE `groupp` DISABLE KEYS */;
INSERT INTO `groupp` VALUES (1,'sd',1,1);
/*!40000 ALTER TABLE `groupp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent`
--

DROP TABLE IF EXISTS `parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parent` (
  `parent_id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `second_name` varchar(45) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  PRIMARY KEY (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent`
--

LOCK TABLES `parent` WRITE;
/*!40000 ALTER TABLE `parent` DISABLE KEYS */;
INSERT INTO `parent` VALUES (1,'sad','sad','fa','3241234234'),(2,'lName','fName','secName','548652315478'),(3,'lName','fName','secName','548652315478'),(4,'lName','fName','secName','548652315478'),(5,'lName','fName','secName','548652315478'),(6,'lName','fName','secName','548652315478'),(7,'lName','fName','secName','548652315478'),(8,'lName','fName','secName','548652315478'),(21,'lName','fName','secName','548652315478'),(122,'lName','fName','secName','548652315478'),(222,'lName','fName','secName','548652315478');
/*!40000 ALTER TABLE `parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passport`
--

DROP TABLE IF EXISTS `passport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `passport` (
  `passport_id` int(11) NOT NULL AUTO_INCREMENT,
  `passport_series` varchar(45) DEFAULT NULL,
  `passport_number` int(11) DEFAULT NULL,
  `issue_date` varchar(45) DEFAULT NULL,
  `issue_organisation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`passport_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passport`
--

LOCK TABLES `passport` WRITE;
/*!40000 ALTER TABLE `passport` DISABLE KEYS */;
INSERT INTO `passport` VALUES (1,'fd',32,'200512-12','asdad'),(2,'HO',124756,'2002-12-02','organisation'),(3,'HO',124756,'2002-12-02','organisation'),(4,'HO',124756,'2002-12-02','organisation'),(5,'HO',124756,'2002-12-02','organisation'),(6,'HO',124756,'2002-12-02','organisation'),(7,'HO',124756,'2002-12-02','organisation'),(8,'HO',124756,'2002-12-02','organisation'),(43,'HO',124756,'2002-12-02','organisation'),(64,'HO',124756,'2002-12-02','organisation');
/*!40000 ALTER TABLE `passport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `speciality`
--

DROP TABLE IF EXISTS `speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `speciality` (
  `speciality_id` int(11) NOT NULL AUTO_INCREMENT,
  `speciality_name` varchar(45) NOT NULL,
  `speciality_description` varchar(45) NOT NULL,
  PRIMARY KEY (`speciality_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speciality`
--

LOCK TABLES `speciality` WRITE;
/*!40000 ALTER TABLE `speciality` DISABLE KEYS */;
INSERT INTO `speciality` VALUES (1,'dsadff','afafd'),(34,'speciality','spec description');
/*!40000 ALTER TABLE `speciality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `speciality_subject`
--

DROP TABLE IF EXISTS `speciality_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `speciality_subject` (
  `speciality_subject_id` int(11) NOT NULL,
  `speciality_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`speciality_subject_id`),
  KEY `speciality_idx` (`speciality_id`),
  KEY `subject_idx` (`subject_id`),
  CONSTRAINT `speciality` FOREIGN KEY (`speciality_id`) REFERENCES `speciality` (`speciality_id`),
  CONSTRAINT `subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speciality_subject`
--

LOCK TABLES `speciality_subject` WRITE;
/*!40000 ALTER TABLE `speciality_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `speciality_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `second_name` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `birthday_date` date NOT NULL,
  `address_id` int(11) NOT NULL,
  `enter_date` date NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `passport_id` int(11) NOT NULL,
  `gradebook_no` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `studying_form` varchar(45) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `passport_idx` (`passport_id`),
  KEY `mother_idx` (`parent_id`),
  KEY `address_idx` (`address_id`),
  KEY `group_idx` (`group_id`),
  CONSTRAINT `address` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `group` FOREIGN KEY (`group_id`) REFERENCES `groupp` (`group_id`),
  CONSTRAINT `mother` FOREIGN KEY (`parent_id`) REFERENCES `parent` (`parent_id`),
  CONSTRAINT `passport` FOREIGN KEY (`passport_id`) REFERENCES `passport` (`passport_id`)
) ENGINE=InnoDB AUTO_INCREMENT=559 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (2,'Jack','Brown','James','male','1995-12-11',1,'2010-11-10','380654585254',1,231458,1,'day',1),(4,'андірв','аві','пк','ва','1995-12-11',1,'2010-11-10','380654585254',1,231458,1,'day',1),(5,'Jack','XAXAXA','James','male','1995-12-11',3,'2010-11-10','380654585254',1,231458,1,'day',1),(6,'Jack','Brown','James','male','1995-12-11',4,'2010-11-10','380654585254',1,231458,1,'day',1),(7,'Jack','Brown','James','male','1995-12-11',5,'2010-11-10','380654585254',1,231458,1,'day',1),(8,'Jack','Brown','James','male','1995-12-11',7,'2010-11-10','380654585254',1,231458,1,'day',1),(11,'Jack','Brown','James','male','1995-12-11',10,'2010-11-10','380654585254',8,231458,1,'day',8),(558,'Brown','Jack','James','male','1995-12-11',33,'2010-11-10','380654585254',43,231458,1,'day',122);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(45) NOT NULL,
  `subject_description` varchar(45) NOT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3812579 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (34,'subject','sub description'),(39,'subject','sub description'),(323,'subject','sub description'),(331,'subject','sub description'),(333,'subject','sub description'),(378,'subject','sub description'),(444,'subject','sub description');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-20 15:43:27
