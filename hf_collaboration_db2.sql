-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: hf_collaboration_db
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `factory`
--

DROP TABLE IF EXISTS `factory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factory` (
  `factory_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `factory_name` varchar(50) NOT NULL COMMENT '用户名',
  `factory_password` varchar(100) NOT NULL COMMENT '密码',
  `score` double unsigned zerofill DEFAULT '0000000000000000000000' COMMENT '系统给的评分',
  PRIMARY KEY (`factory_id`),
  UNIQUE KEY `id_UNIQUE` (`factory_id`),
  UNIQUE KEY `factoryName_UNIQUE` (`factory_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='家庭工厂';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factory`
--

LOCK TABLES `factory` WRITE;
/*!40000 ALTER TABLE `factory` DISABLE KEYS */;
INSERT INTO `factory` VALUES (1,'北京公司','aaaa',00000000000000000005.5),(2,'湖南公司','bbbb',00000000000000000006.6),(3,'天津公司','cccc',00000000000000000007.7);
/*!40000 ALTER TABLE `factory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hf_admin`
--

DROP TABLE IF EXISTS `hf_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hf_admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `admin_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `admin_password` varchar(100) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `id_UNIQUE` (`admin_id`),
  UNIQUE KEY `adminName_UNIQUE` (`admin_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hf_admin`
--

LOCK TABLES `hf_admin` WRITE;
/*!40000 ALTER TABLE `hf_admin` DISABLE KEYS */;
INSERT INTO `hf_admin` VALUES (1,'张三','123'),(2,'李四','1234'),(3,'王五','12345');
/*!40000 ALTER TABLE `hf_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hf_order`
--

DROP TABLE IF EXISTS `hf_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hf_order` (
  `order_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `admin_id` int NOT NULL COMMENT '外键 负责的代表',
  `status` varchar(50) DEFAULT 'AdvanceOrder' COMMENT '状态',
  `deadline` datetime DEFAULT NULL COMMENT '期望交付时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `predict_time` datetime DEFAULT NULL COMMENT '预测完成时间',
  `complete_time` datetime DEFAULT NULL COMMENT '实际完成时间',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `id_UNIQUE` (`order_id`),
  KEY `fk_hf_order_hf_admin_idx` (`admin_id`),
  CONSTRAINT `fk_hf_order_hf_admin` FOREIGN KEY (`admin_id`) REFERENCES `hf_admin` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hf_order`
--

LOCK TABLES `hf_order` WRITE;
/*!40000 ALTER TABLE `hf_order` DISABLE KEYS */;
INSERT INTO `hf_order` VALUES (1,1,'AdvanceOrder',NULL,NULL,NULL,NULL),(2,2,'AdvanceOrder',NULL,NULL,NULL,NULL),(4,1,'AdvanceOrder',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `hf_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `order_item_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` int NOT NULL COMMENT '外键 订单',
  `product_id` int NOT NULL COMMENT '外键 产品',
  `product_sum` int DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`order_item_id`),
  UNIQUE KEY `id_UNIQUE` (`order_item_id`),
  KEY `fk_order_idx` (`order_id`),
  KEY `fk_order_item_product_idx` (`product_id`),
  CONSTRAINT `fk_order_item_order` FOREIGN KEY (`order_id`) REFERENCES `hf_order` (`order_id`),
  CONSTRAINT `fk_order_item_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='订单条目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (1,1,2,2),(2,1,2,3),(3,2,3,5),(4,2,5,6),(5,2,6,12);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_name` varchar(50) NOT NULL COMMENT '名字',
  `product_description` varchar(2000) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `id_UNIQUE` (`product_id`),
  UNIQUE KEY `productName_UNIQUE` (`product_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='产品/工艺';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'鞋垫','鞋垫大量应用于制鞋业、保健、特殊功用。'),(2,'鞋底','鞋底的构造相当复杂，可包括外底、中底与鞋跟等所有构成底部的材料。'),(3,'鞋帮','鞋帮xié bāng ，词语，指鞋底、靴底以上的部分 。'),(4,'手套','手套是手部保暖或劳动保护用品，也有装饰用的。'),(5,'袜子','一种穿在脚上的服饰用品。《说文》：“韤，足衣也。”起着保护脚和防脚臭的作用。'),(6,'学习桌','学习桌是一种新型、科学、人性、实用的学习辅助工具，适用于3-18岁儿童到青少年，可以用来升降调节、桌面倾斜。');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_ability`
--

DROP TABLE IF EXISTS `product_ability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_ability` (
  `product_ability_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `factory_id` int NOT NULL COMMENT '外键 家庭工厂',
  `product_id` int NOT NULL COMMENT '外键 产品',
  `ability_enable` tinyint(1) DEFAULT NULL COMMENT '使能标志',
  `willingness` int DEFAULT NULL COMMENT '意愿值',
  `stock` int DEFAULT NULL COMMENT '库存',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`product_ability_id`),
  UNIQUE KEY `id_UNIQUE` (`product_ability_id`),
  KEY `fk_factory_idx` (`factory_id`),
  KEY `fk_product_idx` (`product_id`),
  CONSTRAINT `fk_ability_factory` FOREIGN KEY (`factory_id`) REFERENCES `factory` (`factory_id`),
  CONSTRAINT `fk_ability_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='家庭工厂生产能力';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_ability`
--

LOCK TABLES `product_ability` WRITE;
/*!40000 ALTER TABLE `product_ability` DISABLE KEYS */;
INSERT INTO `product_ability` VALUES (1,1,1,1,3,45,NULL),(2,2,2,1,4,55,NULL),(3,3,2,0,3,1580,NULL),(6,2,6,0,2,5600,NULL);
/*!40000 ALTER TABLE `product_ability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `task_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `task_status` varchar(50) DEFAULT 'ToBeAssigned' COMMENT '状态',
  `factory_id` int NOT NULL COMMENT '外键 家庭工厂ID',
  `order_id` int NOT NULL COMMENT '外键 订单ID',
  `product_id` int NOT NULL COMMENT '外键 产品ID',
  `num` int DEFAULT '0' COMMENT '产品数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `predict_time` datetime DEFAULT NULL COMMENT '预测完成时间',
  `complete_time` datetime DEFAULT NULL COMMENT '实际完成时间',
  `completed_quantity` int DEFAULT '0' COMMENT '已完成数量',
  PRIMARY KEY (`task_id`),
  UNIQUE KEY `id_UNIQUE` (`task_id`),
  KEY `fk_task_factory_idx` (`factory_id`),
  KEY `fk_task_order_idx` (`order_id`),
  KEY `fk_task_product_idx` (`product_id`),
  CONSTRAINT `fk_task_factory` FOREIGN KEY (`factory_id`) REFERENCES `factory` (`factory_id`),
  CONSTRAINT `fk_task_order` FOREIGN KEY (`order_id`) REFERENCES `hf_order` (`order_id`),
  CONSTRAINT `fk_task_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='任务';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'ToBeAssigned',1,1,1,22,'2021-10-21 00:00:00',NULL,'2021-10-24 00:00:00',0),(2,'ToBeAssigned',1,2,2,33,'2021-10-21 07:07:07',NULL,'2021-11-21 07:07:07',0),(3,'ToBeAssigned',2,2,3,44,'2023-05-21 07:07:07',NULL,'2023-06-21 07:07:07',0),(4,'ToBeAssigned',2,2,5,12,'2022-06-21 07:07:07',NULL,'2022-06-21 18:58:58',0),(5,'ToBeAssigned',3,2,6,17,'2025-06-01 01:01:01',NULL,'2025-06-08 01:01:01',0);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-14 23:38:57
