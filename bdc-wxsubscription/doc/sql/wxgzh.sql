-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: guyu
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `wx_logs`
--

DROP TABLE IF EXISTS `wx_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wx_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `log_type` int(11) DEFAULT NULL COMMENT '日志类型(1查询，2添加，3修改，4删除)',
  `log_content` varchar(500) DEFAULT NULL COMMENT '日志内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_man` varchar(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_man` varchar(20) DEFAULT NULL COMMENT '修改人',
  `del_flag` int(11) DEFAULT NULL COMMENT '删除标记',
  `area_code` varchar(50) DEFAULT NULL COMMENT '地区识别码',
  `request_ip` varchar(255) DEFAULT NULL COMMENT '请求ip',
  `request_url` varchar(255) DEFAULT NULL COMMENT '请求地址',
  `request_web` varchar(255) DEFAULT NULL COMMENT '请求浏览器',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wx_logs`
--

LOCK TABLES `wx_logs` WRITE;
/*!40000 ALTER TABLE `wx_logs` DISABLE KEYS */;
INSERT INTO `wx_logs` VALUES (167,1,'人员','2020-12-06 04:06:48','张三',NULL,NULL,0,NULL,'127.0.0.1','/personnel/findAll','浏览器Unknown'),(168,1,'人员','2020-12-06 04:07:25','张三',NULL,NULL,0,NULL,'127.0.0.1','/personnel/findAll','浏览器Firefox 8'),(169,1,'人员','2020-12-06 04:32:00','张三',NULL,NULL,0,NULL,'127.0.0.1','/personnel/findAll','浏览器Unknown'),(170,1,'人员','2020-12-06 04:34:51','张三',NULL,NULL,0,NULL,'127.0.0.1','/personnel/findAll','浏览器Unknown');
/*!40000 ALTER TABLE `wx_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wx_personnel`
--

DROP TABLE IF EXISTS `wx_personnel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wx_personnel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `login_name` varchar(50) DEFAULT NULL COMMENT '登录名',
  `password` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `phone` bigint(20) DEFAULT NULL COMMENT '联系方式',
  `type` int(11) DEFAULT NULL COMMENT '权限',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_man` varchar(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_man` varchar(20) DEFAULT NULL COMMENT '修改人',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `del_flag` int(11) DEFAULT NULL COMMENT '删除标记',
  `area_code` varchar(50) DEFAULT NULL COMMENT '地区识别码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='人员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wx_personnel`
--

LOCK TABLES `wx_personnel` WRITE;
/*!40000 ALTER TABLE `wx_personnel` DISABLE KEYS */;
INSERT INTO `wx_personnel` VALUES (15,'刘全','admin','716b5aac7092f2c2162e397a89cc6dd9',13672561201,1,'2019-12-09 10:01:19','Huazt','2020-12-03 15:23:32','刘全',1,0,'100000'),(20,'连州不动产','lzbdc','1514287f887d9102d24b79154dd4c307',15581633930,0,'2020-07-02 08:00:31',NULL,'2020-07-02 08:00:31',NULL,1,0,'441882'),(21,'连南不动产','lnbdc','19c01aa4ef0736c3126a02b6f4ee420b',15581633930,0,'2020-07-02 08:05:45',NULL,'2020-07-02 08:05:45',NULL,1,0,'441826'),(22,'常德不动产','cdbdc','51a6a29fb0b46757a543f39aa0007884',15581633930,0,'2020-07-02 08:06:19',NULL,'2020-07-02 08:06:19',NULL,1,0,'430702'),(23,'英德不动产','ydbdc','cc591aa33d20974b490a79c709daaf28',15581633930,0,'2020-07-02 08:06:57',NULL,'2020-07-02 08:06:57',NULL,1,0,'441881'),(24,'桃花源不动产','thybdc','6f2b7c931962e264687b5b172b9aca8d',15581633930,0,'2020-07-02 08:08:11',NULL,'2020-07-02 08:08:11',NULL,1,0,'430725'),(26,'德山不动产','dsbdc','4cbf428a427efd70715a2fcf1bccc457',15581633930,0,'2020-07-28 08:24:50',NULL,'2020-11-30 17:04:58',NULL,1,0,'430701'),(27,'1','2','6512bd43d9caa6e02c990b0a82652dca',13513131313,0,'2020-07-28 08:54:05',NULL,'2020-07-28 08:54:05',NULL,1,0,''),(28,'cdTes','cdTes','e10adc3949ba59abbe56e057f20f883e',15022228889,0,'2020-09-24 09:44:43',NULL,'2020-11-30 17:04:25',NULL,1,0,''),(29,'test','test','14e1b600b1fd579f47433b88e8d85291',15022226669,0,'2020-09-24 09:45:44',NULL,'2020-11-30 15:45:37',NULL,1,1,''),(30,'黄盼','huangp','14e1b600b1fd579f47433b88e8d85291',18890598525,1,'2020-11-30 15:55:57',NULL,'2020-11-30 16:09:43',NULL,1,1,'100000'),(31,'test1','admin1','e10adc3949ba59abbe56e057f20f883e',18890597523,1,'2020-11-30 17:25:52',NULL,'2020-11-30 17:25:52',NULL,1,1,'100000'),(33,'1111',NULL,NULL,NULL,NULL,'2020-12-04 09:19:32','张三','2020-12-05 02:46:16','张三',NULL,1,NULL),(36,'测试名',NULL,NULL,NULL,NULL,'2020-12-07 01:24:51','张三',NULL,NULL,NULL,0,NULL);
/*!40000 ALTER TABLE `wx_personnel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-07 14:39:06
