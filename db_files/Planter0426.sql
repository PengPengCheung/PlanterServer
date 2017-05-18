CREATE DATABASE  IF NOT EXISTS `PlanterDatabase` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `PlanterDatabase`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: PlanterDatabase
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
-- Table structure for table `attendance_info`
--

DROP TABLE IF EXISTS `attendance_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance_info` (
  `attendance_info_id` varchar(40) NOT NULL,
  `attendance_datetime` varchar(40) NOT NULL,
  `attendance_status` int(11) NOT NULL COMMENT '考勤状态（1=成功，0=-100，-2=失败）',
  `attendance_code` varchar(6) DEFAULT NULL COMMENT '考勤签到码',
  `attendance_valid_time` varchar(10) DEFAULT NULL,
  `attendance_bonus` int(11) DEFAULT NULL COMMENT '考勤奖惩情况，有正负之分',
  PRIMARY KEY (`attendance_info_id`),
  UNIQUE KEY `attendance_info_UNIQUE` (`attendance_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance_info`
--

LOCK TABLES `attendance_info` WRITE;
/*!40000 ALTER TABLE `attendance_info` DISABLE KEYS */;
INSERT INTO `attendance_info` VALUES ('0c8129e6-158e-4d20-aee7-a5c3facc191b','2017/04/21 14:54:26',1,'106660','05:00',5),('103dcff7-43ae-432f-8e9b-cd75472461ac','2017/04/23 19:15:07',1,'351281','05:00',5),('12','2017/3/23',-100,NULL,NULL,NULL),('123','2017/3/23',1,'12321','05:00',5),('1444','2017/3/23',-100,NULL,NULL,NULL),('14eb9dd7-d420-4e3b-bf6a-eddf6bf8243a','2017/04/23 15:34:35',-2,NULL,'05:00',-5),('240c63cc-8d68-4665-9383-bc2fc0475476','2017/04/21 15:09:06',1,'669260','05:00',5),('323d183d-76ac-4dd2-a621-ea0b532db974','2017/04/21 16:56:30',1,'835390','05:00',5),('3c437cf9-7b73-467b-8b20-065243d1addf','2017/04/23 15:34:34',-2,NULL,'05:00',-5),('3f737794-2373-4937-9ebd-b3c0c14c17ae','2017/04/21 16:39:40',1,'342724','05:00',5),('46c6e50a-1314-4d3d-821c-f774cd420b73','2017/04/21 01:13:28',1,'106660','05:00',5),('48e192be-7ce9-43f7-8899-152428be51da','2017/04/23 19:12:58',-1,NULL,'05:00',-5),('505c46ad-ca9a-4166-9d49-627f8e0da3ee','2017/04/21 14:55:42',1,'106660','05:00',5),('59f1e861-05cd-4ec2-8008-06e01f323dfa','2017/04/21 16:33:12',1,'591583','05:00',5),('5c5f5930-b7c3-448f-aa0d-59477051d5b4','2017/04/21 16:16:56',1,'401852','05:00',5),('605c37fe-49be-464b-ab3d-a0141a4c2c9a','2017/04/25 16:39:57',-2,NULL,'05:00',-5),('66209a50-d256-41c0-b971-0cf8211eb6c1','2017/04/21 00:18:12',-1,NULL,'05:00',-5),('69122e22-6204-44eb-af3e-c87d565a6b69','2017/04/23 19:08:19',-1,NULL,'05:00',-5),('747b9a27-5e6b-4799-9aa9-958d95551815','2017/04/21 14:56:15',1,'106660','05:00',5),('764410c5-f04e-4fc1-9cbe-bbe59672c527','2017/04/21 15:01:06',-1,NULL,'05:00',-5),('81d43407-f917-4ea3-9eb1-4c51305188b5','2017/04/21 15:01:39',1,'106660','05:00',5),('82469683-e66d-4879-8516-0abfe5fab7e7','2017/04/21 14:12:30',1,'106660','05:00',5),('82f48c62-9af3-4dca-9315-34665535ea4b','2017/04/21 00:57:47',-2,NULL,'05:00',-5),('8a5ebf19-e246-4671-98e0-09ccda0cc92f','2017/04/23 19:16:15',-2,NULL,'05:00',-5),('8e3f5b36-872b-4de0-9c70-8026611105f8','2017/04/21 15:01:57',-1,NULL,'05:00',-5),('95403765-b160-479b-a679-d402f9c9c6b5','2017/04/23 19:18:48',-2,NULL,'05:00',-5),('a8e4bee3-574b-49dd-aa36-dc01cbdd66ed','2017/04/21 00:51:27',-2,NULL,'05:00',-5),('aa15f049-6500-4897-ad5b-ddcc59f2c4fa','2017/04/23 15:32:05',-1,NULL,'05:00',-5),('aa984966-e0ad-4626-a2d4-461e85b36292','2017/04/21 16:30:33',1,'734905','05:00',5),('af699f95-1bdc-4a49-b39c-83260d680b58','2017/04/23 19:12:58',-1,NULL,'05:00',-5),('b14da911-4b23-4dee-a6d1-6cd919a9549c','2017/04/23 15:38:04',1,'389353','05:00',5),('b301f42e-0ca4-40d2-a5ab-8d06f41fd8d9','2017/04/21 16:48:41',1,'330195','05:00',5),('b7f556e2-b09a-472f-8fee-2edde31cb058','2017/04/23 15:34:35',-2,NULL,'05:00',-5),('b8be8b49-ce96-42a4-a347-fc960164e3f9','2017/04/21 01:27:02',-1,NULL,'05:00',-5),('ba876277-ddc9-4901-a376-7ff24dcb4e13','2017/04/21 16:19:48',-1,NULL,'05:00',-5),('baedb90a-4b88-4fc0-9dc7-bf14ca1a2c32','2017/04/21 01:24:04',-1,NULL,'05:00',-5),('c5ac0797-d9a8-49b0-9107-51749d5eb90c','2017/04/21 16:41:39',1,'684800','05:00',5),('ce8f55c0-1b21-4979-a7a9-ca010eb32d69','2017/04/21 01:11:31',-1,NULL,'05:00',-5),('dc61e76a-8edb-4ff8-a0f2-fda958c4018c','2017/04/21 16:14:31',1,'401852','05:00',5),('e1e700e6-57b9-4c25-91a3-491c47c46e2a','2017/04/20 23:48:53',-1,NULL,'05:00',-5),('ee6ee144-37a1-4e66-9f9f-81700a9d9f99','2017/04/21 16:29:28',-1,NULL,'05:00',-5),('f057911f-ccd1-4518-b01a-d33ebfee7c9e','2017/04/23 15:34:35',-2,NULL,'05:00',-5),('fac23e6b-5189-4c07-9913-6a95e7740e31','2017/04/21 00:52:41',-2,NULL,'05:00',-5);
/*!40000 ALTER TABLE `attendance_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attention_info`
--

DROP TABLE IF EXISTS `attention_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attention_info` (
  `attention_id` varchar(40) NOT NULL,
  `attention_duration` varchar(40) NOT NULL COMMENT '专注限定时长',
  `attention_type` int(11) NOT NULL COMMENT '专注类型，1=普通专注，0=小组专注',
  `attention_time` varchar(45) DEFAULT NULL COMMENT '发起专注的时刻',
  `attention_end_time` varchar(45) DEFAULT NULL COMMENT '专注结束时间',
  `attention_status` int(11) DEFAULT NULL COMMENT '专注状态，开始/结束',
  `attention_score` int(11) DEFAULT NULL,
  `attention_bonus_type` int(11) DEFAULT NULL,
  `attention_bonus_num` int(11) DEFAULT NULL,
  `attention_insist_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`attention_id`),
  UNIQUE KEY `attention_id_UNIQUE` (`attention_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生每进行专注一次则产生一条考勤记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attention_info`
--

LOCK TABLES `attention_info` WRITE;
/*!40000 ALTER TABLE `attention_info` DISABLE KEYS */;
INSERT INTO `attention_info` VALUES ('0156bc14-6866-459d-a5c5-f03184887b41','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('035f1381-8034-4d6d-9520-f1959dca2898','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('115851c2-cd3a-44ab-8a0b-64f304c9bb5a','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1ba05d57-3f47-47e2-8515-bba642cae6a0','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('209a4458-9ad6-4c4b-8112-961a1c301589','20:00',0,NULL,NULL,-3,-1,2,-5,NULL),('23b6d211-7ff4-4233-882b-f4bcf19489f0','10:00',1,'2017/04/24 15:37:57','2017/04/24 15:38:03',-3,-1,2,-5,'0:05'),('244b5173-2fc4-4328-a724-47d61b27ef3f','15:00',0,NULL,NULL,-3,-1,2,-5,NULL),('2e7a5e13-af89-49d3-b21a-4afde901ca72','15:00',0,NULL,NULL,-3,-1,2,-5,NULL),('2ea0d835-da22-46c6-a037-9abdc77100b5','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('3348f467-e4b9-457c-bfdb-0c2bb11a36cc','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('35be2e9f-dfbb-49e1-b139-1b72b1b9da3c','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('38328a40-088d-4f45-a952-7e7d4f442e42','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('45e77b21-3b22-477f-b503-35787eaf4bbb','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('4e62b091-99f4-4cb8-88fb-90956b16fa33','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('50ace11a-5b24-4ca8-ab87-7f047bc0dc16','5:00',0,NULL,NULL,-3,-1,2,-5,NULL),('58b50b11-b494-48f1-8a46-a23337556014','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('5c0b783f-4631-4980-9b06-9285e3e2a4f1','15:00',0,NULL,NULL,-3,-1,2,-5,NULL),('67d9f714-08cc-4513-b8a3-74620e19f9ca','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('6dcf6ce4-fd20-4aef-9869-557d1bb4a1d5','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('75381235-0402-4e10-9f9b-1491d1c8a5be','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('75a87e42-2f3a-4296-b9e7-ecec7214ca90','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('76a70f2e-cd43-466f-b8db-9a4b7594aa6a','20:00',0,NULL,NULL,-3,-1,2,-5,NULL),('7b4db975-7de2-4556-94f9-ac3187108ef1','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('89ef1645-6797-489c-8dfd-1ca515014777','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('9095ff23-f6cc-48e9-8043-b699ae2a5a58','0:10',0,NULL,NULL,-3,-1,2,-5,NULL),('94b16087-a43f-44b0-9d55-c39ff813d4b1','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('9dd444f5-572e-463f-9410-27c57c6226c8','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('9f0cb6ec-cead-468d-87e9-f5dcd42d0204','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('9f63c6b2-9652-4212-8e30-d5546512606b','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('a4f0483f-b04b-45e5-80b0-ae86b7edc447','15:00',0,NULL,NULL,-3,-1,2,-5,NULL),('acd76e68-f039-4fcc-b11a-751238a1c8af','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('ae06d331-73f9-4d5d-9b57-c56d122accc4','20:00',0,NULL,NULL,-3,-1,2,-5,NULL),('afc5d947-02e4-4a61-b7ed-09394449805c','15:00',0,NULL,NULL,-3,-1,2,-5,NULL),('b107af62-f0b3-4861-afc5-bbda11dd6ba8','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('b9c772fe-b1f1-48af-a92f-5fec7e8d9729','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('bb11705e-8ccb-4df0-ab62-d3d81aed9f3b','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('c0848c0a-e04a-4859-b0e1-5de819986eb2','0:10',0,NULL,NULL,-3,-1,2,-5,NULL),('c93f47ad-6e88-40a3-ba42-7f385a490914','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('ccf6a98d-3e13-4fa2-bd6d-d5880ec4cdef','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('d275142c-99fa-4bfa-9628-06f1a678949a','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('d9eab742-9728-4b4a-bb57-9c775643d182','10:00',0,NULL,NULL,-3,-1,2,-5,NULL),('e1681441-c337-45b1-92db-fc0c39dd41ca','05:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('e481f679-3176-4b62-9833-321958df2f44','10:00',1,NULL,NULL,-3,-1,2,-5,NULL),('e72b3302-f114-4e62-b601-9701bc59818a','15:00',0,NULL,NULL,-3,-1,2,-5,NULL),('ee1c1ce2-71e1-4a4c-a413-ec08bcfd1542','20:00',0,NULL,NULL,-3,-1,2,-5,NULL),('f2645064-86b7-4e35-bf31-1fee2a3fd1fc','10:00',1,NULL,NULL,-3,-1,2,-5,NULL),('f291ebd6-4d88-4664-b374-c005ce96b180','10:00',1,NULL,NULL,-3,-1,2,-5,NULL);
/*!40000 ALTER TABLE `attention_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_connection`
--

DROP TABLE IF EXISTS `base_connection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_connection` (
  `c_id` varchar(40) NOT NULL COMMENT '课程id',
  `s_id` varchar(40) NOT NULL COMMENT '学生id',
  `t_id` varchar(40) NOT NULL COMMENT '教师id',
  `base_connection_id` varchar(40) NOT NULL,
  PRIMARY KEY (`base_connection_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基础联系表，在创建课程时就添加一条记录，基本上所有查询都和这表有关联';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_connection`
--

LOCK TABLES `base_connection` WRITE;
/*!40000 ALTER TABLE `base_connection` DISABLE KEYS */;
INSERT INTO `base_connection` VALUES ('54abfb7b-a3af-4f61-8b80-3086b421720e','02230447-e12d-434f-a3ff-b9a48966397e','2480d72d-0694-4032-8f68-ae9d9bdb724a','0f57cbf0-6b24-4766-aaab-d5673223b48e'),('9','10','11','12'),('13','14','15','16'),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41','1234','1619f850-18e8-411d-ab83-30fde4aad226'),('f8a5b974-9c67-464c-940d-088f5e4b6e3a','aff9f9f2-5604-4b92-8efd-3a411c0c4c4d','6c150bf6-79a1-4cc5-abdd-d0978781e52c','179b5e16-c511-4b1e-8b40-1bd61037af08'),('013d1bfe-5d21-4b2e-b1cf-79bddd927fb5','','1234','3a14f4c5-5a6e-41bc-9800-24e98c54168e'),('1','2','3','4'),('3685ab9a-dc59-4b9f-adeb-a2edfb0cd670','060592cc-18ed-431d-96f3-db1794762f3d','1234','429ddbcd-5b74-4709-8682-d2d37fb456e7'),('d276a696-1956-4fb2-b193-f393e636d940','','1234','44e679a9-d962-4982-8b08-8c0c8bcb0ce5'),('123','234','345','456'),('102a5df5-19dd-4977-9727-aa174079d0a4','5104ebe0-5414-4fe4-acc1-12e373d01013','f5179a98-ce9c-4631-89bd-0c07d0633789','6a68c566-4414-41ff-9374-fbb190a2d1a9'),('3fc27153-07c8-43bf-8750-3195b40e6131','','1234','75c6a215-058a-48d9-b9f2-74e7b284e7ee'),('3685ab9a-dc59-4b9f-adeb-a2edfb0cd670','','1234','78dbb597-8bd7-46a4-9c5d-0c93f4f3091b'),('5','6','7','8'),('ae70ec5c-0a61-4275-ae7d-ad247154155b','060592cc-18ed-431d-96f3-db1794762f3d','1234','a4122462-ca86-436b-aa8f-cae63df7cb67'),('d276a696-1956-4fb2-b193-f393e636d940','aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41','1234','be280c98-f47a-4bd3-acfc-ad34fab8e283'),('edd87fde-5946-4b50-b50c-571910afc642','5f9d7764-6fb0-409e-aacd-ad058b202763','c2ac157c-b20c-4ee8-b154-3ecad6c099bc','d7577af1-0551-4858-b07a-3164f9c3aed9'),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','','1234','d836dadf-d24b-43c4-8c3b-c094fd0d7b8f'),('17a5b90b-0474-4f2c-bd37-f642df9ec0a4','','1234','de605767-500b-49e3-a457-e62e44db9994'),('013d1bfe-5d21-4b2e-b1cf-79bddd927fb5','f491d70c-6030-4238-864d-8a679d16e155','1234','e5655b03-1e53-4393-afbf-47c2f29b4e75'),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','35f0b8af-c269-4168-88f6-bcba9409461b','1234','fdf60e82-1cbe-4283-bc62-90a6c7713978');
/*!40000 ALTER TABLE `base_connection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_info`
--

DROP TABLE IF EXISTS `course_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_info` (
  `c_id` varchar(40) NOT NULL,
  `course_time` varchar(100) NOT NULL,
  `course_name` varchar(45) NOT NULL,
  `course_addr` varchar(100) DEFAULT NULL,
  `course_duration` varchar(45) DEFAULT NULL,
  `course_code` varchar(45) NOT NULL,
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `c_id_UNIQUE` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='JsonArray格式，需要保存以下四项：[“course_date”:”String, 开课日期”, “course_time”:”String, 开课时间”, “course_duration”:”int, 开课时长,单位是毫秒”, \n“course_name”:”课程名称”,\n“course_addr”:”String, 开课地点”]';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_info`
--

LOCK TABLES `course_info` WRITE;
/*!40000 ALTER TABLE `course_info` DISABLE KEYS */;
INSERT INTO `course_info` VALUES ('013d1bfe-5d21-4b2e-b1cf-79bddd927fb5','星期五 15:00','影视英语',NULL,NULL,'324170'),('111111','2017/3/22 10:00:00','口译','教学楼A区','02:00:00','123'),('17a5b90b-0474-4f2c-bd37-f642df9ec0a4','星期四 10:30','笔译',NULL,NULL,'157357'),('3685ab9a-dc59-4b9f-adeb-a2edfb0cd670','星期三 10:10','科技英语',NULL,NULL,'958573'),('3fc27153-07c8-43bf-8750-3195b40e6131','星期三 10:10','口译',NULL,NULL,'602115'),('573bde4f-b011-43e1-84e4-09c4488409e6','星期二 09:10','笔译',NULL,NULL,'412311'),('83eda42e-dca5-4f9c-b019-2e359adf2a8d','星期二 09:10, 10:10, 星期日 10:10, 星期三 10:10, 星期二 09:10','笔译',NULL,NULL,'312488'),('ae70ec5c-0a61-4275-ae7d-ad247154155b','星期二 08:30, 10:10, 11:10','新闻视听说',NULL,NULL,'128477'),('d276a696-1956-4fb2-b193-f393e636d940','星期二 09:10','笔译',NULL,NULL,'412511'),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','星期五 15:20','口译',NULL,NULL,'492422');
/*!40000 ALTER TABLE `course_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_info`
--

DROP TABLE IF EXISTS `group_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_info` (
  `group_id` varchar(40) NOT NULL,
  `group_date` varchar(40) NOT NULL COMMENT '小组创建时间',
  `group_name` varchar(200) DEFAULT NULL,
  `group_leader_name` varchar(40) NOT NULL COMMENT '组长对应id',
  `group_members` mediumtext COMMENT '以列表的格式保存组员的id，以逗号分隔',
  PRIMARY KEY (`group_id`),
  UNIQUE KEY `group_id_UNIQUE` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_info`
--

LOCK TABLES `group_info` WRITE;
/*!40000 ALTER TABLE `group_info` DISABLE KEYS */;
INSERT INTO `group_info` VALUES ('48c594cd-b483-4edc-8d61-5f4875c0da7d','2017/04/25 22:12:03','测试小组','小红','小智,小刚'),('60d4c2f4-b5c9-41d9-9403-1cf0cdd2925e','2017/04/26 15:13:11','科技组','孙学生','周学生,吴学生,陈学生,赵学生'),('d345bfb8-537f-4b08-815f-ed35e7cdf262','2017/04/25 20:57:21','测试小组','呵呵','jdk,乐乐');
/*!40000 ALTER TABLE `group_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_task`
--

DROP TABLE IF EXISTS `group_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_task` (
  `group_task_id` varchar(40) NOT NULL,
  `group_task_publish_date` varchar(40) DEFAULT NULL,
  `group_task_content` mediumtext NOT NULL,
  `group_task_ddl` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`group_task_id`),
  UNIQUE KEY `group_task_id_UNIQUE` (`group_task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_task`
--

LOCK TABLES `group_task` WRITE;
/*!40000 ALTER TABLE `group_task` DISABLE KEYS */;
INSERT INTO `group_task` VALUES ('d0f1c030-027b-4f29-b925-28da7e028748','2017-04-25 22:42:59','完成关于“animate”的pre展示','2017-04-28 22:41:52');
/*!40000 ALTER TABLE `group_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_task_connection`
--

DROP TABLE IF EXISTS `group_task_connection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_task_connection` (
  `group_id` varchar(40) NOT NULL,
  `group_task_id` varchar(40) DEFAULT NULL,
  `teacher_score` int(11) DEFAULT NULL,
  `class_score` mediumtext COMMENT 'Json格式，记录除pre的小组外的所有听pre的学生对该组的打分，如{“s_id”:”int, 学生对该组打的分数”, “s_id”:”int, 学生对该组打的分数”}',
  `group_bonus_num` int(11) DEFAULT NULL COMMENT '对该小组整体的奖惩情况，有正负之分',
  `group_teacher_open_id` varchar(40) DEFAULT NULL,
  `group_bonus_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_task_connection`
--

LOCK TABLES `group_task_connection` WRITE;
/*!40000 ALTER TABLE `group_task_connection` DISABLE KEYS */;
INSERT INTO `group_task_connection` VALUES ('48c594cd-b483-4edc-8d61-5f4875c0da7d','d0f1c030-027b-4f29-b925-28da7e028748',NULL,NULL,NULL,'6f90f879-bc93-43fd-a7af-e56de6a817bf',NULL),('60d4c2f4-b5c9-41d9-9403-1cf0cdd2925e',NULL,NULL,NULL,NULL,'',NULL);
/*!40000 ALTER TABLE `group_task_connection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `handup_info`
--

DROP TABLE IF EXISTS `handup_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `handup_info` (
  `handup_id` varchar(32) NOT NULL,
  `handup_status` int(11) DEFAULT NULL COMMENT '举手状态（1=成功/0=失败/-1=不在举手时间内）',
  `handup_time` datetime NOT NULL COMMENT '此举手时间需要从客户端接收并保存到数据库中，而不该由后端获取',
  PRIMARY KEY (`handup_id`),
  UNIQUE KEY `handup_id_UNIQUE` (`handup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `handup_info`
--

LOCK TABLES `handup_info` WRITE;
/*!40000 ALTER TABLE `handup_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `handup_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homework_info`
--

DROP TABLE IF EXISTS `homework_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homework_info` (
  `homework_id` varchar(40) NOT NULL,
  `homework_title` varchar(200) NOT NULL,
  `homework_content` mediumtext NOT NULL,
  `homework_status` int(11) NOT NULL COMMENT '当前作业状态（发布/未发布）',
  `homework_commit_ddl` varchar(40) DEFAULT NULL,
  `homework_publish_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`homework_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homework_info`
--

LOCK TABLES `homework_info` WRITE;
/*!40000 ALTER TABLE `homework_info` DISABLE KEYS */;
INSERT INTO `homework_info` VALUES ('0','0','0',1,NULL,NULL),('0228f8fc-18fc-4261-8dee-189fa2f9304c','作业标题','时间紧，任务重，抓紧毕设！！！',0,'2017-04-22 16:18:18',NULL),('0e5e5eda-5500-4c32-9999-916e76fe2975','第一章课后练习题','将第一章课后的练习题全部完成，提交word文档',0,'2017-04-28 20:06:45',NULL),('1f0b3bf0-0295-48ed-af7e-8b4243aaac0b','新闻视听说第二次作业','完成第二章课后习题，并构思好pre题材，准备ppt。',0,'2017-04-28 19:01:30',NULL),('1f4e2500-4e32-49b8-8ab2-c044d1260745','作业标题','时间紧，任务重，抓紧毕设！！！',0,'2017-04-22 16:18:18',NULL),('2b0376c1-d080-42bf-9073-dfa331fbf435','作业标题','时间紧，任务重，抓紧毕设！！！',0,'2017-04-22 16:18:18',NULL),('39f7d56c-5d76-4222-9423-5f5903386c9f','新闻视听说第一次作业','完成第一章课后习题，并构思好pre题材，准备ppt。',0,'2017-04-29 18:49:59',NULL),('3b1b6a8a-917a-4ab1-9720-6f54edc3e09a','作业1','完成书面阅读，并写好summary~',0,'2017-04-26 21:02:30',NULL),('679c4a70-02df-4679-9a99-3fa2b9d1c401','名著翻译练习','1.课本P10第三段文字\n2.word文档提交\n3.命名格式“学号+姓名”',0,'2017-04-27 18:37:43',NULL),('73caab8b-de4a-401c-93fc-cf52719c372d','新闻视听说第三次作业','完成第三章课后习题，并构思好pre题材，准备ppt。',0,'2017-04-27 15:41:35',NULL),('8639c31c-0eed-42e4-9a35-c90b830b8603','作品上交','录视频',0,'2017-04-22 20:42:46',NULL),('912c2b49-d7f7-477c-8449-f16d2e852228','毕业答辩','答辩ppt、设计作品完整展示。',0,'2017-04-27 20:42:46',NULL),('ae678dc6-784f-455e-9f82-7948d86e2e2f','准备好综英第一次小测','综英将在两星期后小测，请做好准备。',0,'2017-04-26 03:10:33',NULL);
/*!40000 ALTER TABLE `homework_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `random_ask_info`
--

DROP TABLE IF EXISTS `random_ask_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `random_ask_info` (
  `random_ask_id` varchar(40) NOT NULL,
  `random_ask_time` varchar(40) NOT NULL COMMENT '举手提问时间，客户端获取',
  `random_ask_status` int(11) NOT NULL COMMENT '提问状态（1=开始，0=结束）',
  PRIMARY KEY (`random_ask_id`),
  UNIQUE KEY `random_ask_id_UNIQUE` (`random_ask_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `random_ask_info`
--

LOCK TABLES `random_ask_info` WRITE;
/*!40000 ALTER TABLE `random_ask_info` DISABLE KEYS */;
INSERT INTO `random_ask_info` VALUES ('0b70382d-ece6-4a97-935d-bb22a04be032','2017-04-25 20:01:30',1),('0e2184c9-58e5-48f0-b96d-c5d6ef4a8cc7','2017-04-25 20:02:32',1),('24bf8deb-44e7-42f9-8d8e-a505ef0c181e','2017-04-25 20:01:15',1),('258bd842-4f6c-4ccb-bc58-4cda22d81dbd','2017-04-25 20:01:40',1),('27c0481d-0df7-4037-8de9-2626db4e373b','2017-04-25 20:03:10',1),('60d6f265-6579-4d7e-a058-c4be8fb5180e','2017-04-09 15:11:07',1),('69e24a5c-1e26-4388-90f3-48c7958a21e3','2017-04-09 15:11:07',1),('74003ac9-4b63-4eb1-9b8a-778b661af6be','2017-04-25 20:03:06',1),('794bf2f7-320f-486a-bb9a-3291551f23cc','2017-04-25 20:01:26',1),('8ffa1fac-1037-4ad0-8fad-3bf941bc8ae1','2017-04-25 20:01:36',1),('921d13c7-78cc-4d5a-8119-4ddc49ce8038','2017-04-25 20:01:48',1),('a5cfc4a3-8d16-40f2-9c17-03a399648814','2017-04-09 15:11:07',1),('afb7b87f-c1b6-414f-9dd3-dacd2bc72bdf','2017-04-09 15:11:07',1),('b5957f17-86a8-4c50-8f0e-cb554034117e','2017-04-25 20:03:14',1),('b6025d65-be52-43fc-ba13-8055e510ad3e','2017-04-09 15:11:07',1),('c9a74daa-2da4-4c17-afe2-d4a5d45c6e15','2017-04-25 20:01:43',1),('dc321e32-a971-4a45-8142-7df9bd2a0e7d','2017-04-25 20:03:00',1),('ea0ed9f7-88ca-45d8-b3fb-85301698016c','2017-04-25 20:02:39',1);
/*!40000 ALTER TABLE `random_ask_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource_info`
--

DROP TABLE IF EXISTS `resource_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource_info` (
  `resource_id` varchar(40) NOT NULL,
  `resource_upload_time` varchar(40) NOT NULL,
  `resource_url` varchar(200) DEFAULT NULL,
  `resource_name` varchar(100) NOT NULL,
  `resource_download_count` int(10) unsigned DEFAULT NULL,
  `resource_like_count` int(10) unsigned DEFAULT NULL,
  `resource_save_path` mediumtext,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_info`
--

LOCK TABLES `resource_info` WRITE;
/*!40000 ALTER TABLE `resource_info` DISABLE KEYS */;
INSERT INTO `resource_info` VALUES ('02ddb985-faf7-4346-8b42-6ea71375550f','2017/04/25 16:37:23','http://192.168.235.50:8080/FileUpload/fileDownload_servlet/02ddb985-faf7-4346-8b42-6ea71375550f','2014年英语六级写作：书信题的写作方法.doc',0,0,'/file/Upload/1234/20170425/2014年英语六级写作：书信题的写作方法.doc'),('0e563a95-4f0f-4062-abcf-9e74a73e614f','2017/04/25 16:37:02','http://192.168.235.50:8080/FileUpload/fileDownload_servlet/0e563a95-4f0f-4062-abcf-9e74a73e614f','英语六级作文现象分析型题目写作模板.doc',0,0,'/file/Upload/1234/20170425/英语六级作文现象分析型题目写作模板.doc'),('f9c86996-106c-4098-93b9-fc089a871f78','2017/04/24 21:26:07','http://192.168.235.50:8080/FileUpload/fileDownload_servlet/f9c86996-106c-4098-93b9-fc089a871f78','系列讲话(198题单选)（4个选项）.doc',19,0,'/file/Upload/1234/20170424/系列讲话(198题单选)（4个选项）.doc');
/*!40000 ALTER TABLE `resource_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course_homework_table`
--

DROP TABLE IF EXISTS `student_course_homework_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_course_homework_table` (
  `s_id` varchar(40) NOT NULL,
  `c_id` varchar(40) NOT NULL,
  `homework_id` varchar(40) NOT NULL,
  `homework_submit_date` varchar(40) DEFAULT NULL,
  `homework_score_status` int(11) DEFAULT NULL COMMENT '作业打分状态，1=已打分，0=未打分',
  `homework_score` int(11) DEFAULT NULL COMMENT '作业得分',
  `student_submit_homework_id` varchar(45) NOT NULL,
  `homework_download_url` mediumtext NOT NULL,
  `homework_submit_name` mediumtext NOT NULL,
  `homework_save_path` mediumtext,
  PRIMARY KEY (`student_submit_homework_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='该表记录的是学生已提交的作业';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course_homework_table`
--

LOCK TABLES `student_course_homework_table` WRITE;
/*!40000 ALTER TABLE `student_course_homework_table` DISABLE KEYS */;
INSERT INTO `student_course_homework_table` VALUES ('a6044acc-b235-457a-9c4a-9852fa719cf4','f0fd9862-c035-48f1-a2c0-6e91d618c61c','ae678dc6-784f-455e-9f82-7948d86e2e2f','4月26日',1,90,'1241231231','42131231','综英第一次作业',NULL),('aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41','ae70ec5c-0a61-4275-ae7d-ad247154155b','73caab8b-de4a-401c-93fc-cf52719c372d','2017-04-24 20:15:18',2,90,'511f116b-0fa5-4baa-956c-1915905d889d','http://192.168.235.50:8080/FileDownload/StudentHomeworkDownload/511f116b-0fa5-4baa-956c-1915905d889d','附件2：本科毕业论文（设计）指导手册（2016年12月编制）.doc','/file/Upload/aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41/20170424/附件2：本科毕业论文（设计）指导手册（2016年12月编制）.doc'),('aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41','ae70ec5c-0a61-4275-ae7d-ad247154155b','1f0b3bf0-0295-48ed-af7e-8b4243aaac0b','2017-04-24 19:55:23',1,-1,'5c1099be-0b8a-4b75-be0a-edd1ea3683c8','http://192.168.235.50:8080/FileUpload/fileDownload_servlet/5c1099be-0b8a-4b75-be0a-edd1ea3683c8','钟朋恒_20131003680_毕业设计论文.doc','/file/Upload/aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41/20170424/钟朋恒_20131003680_毕业设计论文.doc'),('aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41','ae70ec5c-0a61-4275-ae7d-ad247154155b','39f7d56c-5d76-4222-9423-5f5903386c9f','2017-04-24 19:55:55',1,-1,'6d9ec498-2f32-4997-a8b8-ed8809722c9c','http://192.168.235.50:8080/FileUpload/fileDownload_servlet/6d9ec498-2f32-4997-a8b8-ed8809722c9c','附件1：广东外语外贸大学本科毕业论文（设计）管理办法_广外校_2012_46号）.pdf','/file/Upload/aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41/20170424/附件1：广东外语外贸大学本科毕业论文（设计）管理办法_广外校_2012_46号）.pdf'),('aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41','ae70ec5c-0a61-4275-ae7d-ad247154155b','1f0b3bf0-0295-48ed-af7e-8b4243aaac0b','2017-04-24 19:50:35',1,-1,'a29410b5-8653-4428-a81d-6f931fccf37c','http://192.168.235.50:8080/FileUpload/fileDownload_servlet/a29410b5-8653-4428-a81d-6f931fccf37c','实例--丁旭春论文090519（千万不要抄袭！）.doc','/file/Upload/aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41/20170424/实例--丁旭春论文090519（千万不要抄袭！）.doc');
/*!40000 ALTER TABLE `student_course_homework_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course_tree`
--

DROP TABLE IF EXISTS `student_course_tree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_course_tree` (
  `s_id` varchar(40) NOT NULL,
  `c_id` varchar(40) NOT NULL,
  `tree_id` varchar(40) NOT NULL,
  PRIMARY KEY (`s_id`,`c_id`,`tree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='该表用于关联学生、课程和成长树';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course_tree`
--

LOCK TABLES `student_course_tree` WRITE;
/*!40000 ALTER TABLE `student_course_tree` DISABLE KEYS */;
INSERT INTO `student_course_tree` VALUES ('060592cc-18ed-431d-96f3-db1794762f3d','ae70ec5c-0a61-4275-ae7d-ad247154155b','33c2146b-10df-4373-a802-b78878397d67'),('1a6fc7af-0551-4351-8015-c3cd3b6426bf','ae70ec5c-0a61-4275-ae7d-ad247154155b','55e768fd-9b66-4999-9a2d-9ff927d166f2'),('2af2f79b-5d8c-420c-8f92-b1837324e439','111111','96d15f7e-ea74-4aa0-9f99-9011684e0749'),('35f0b8af-c269-4168-88f6-bcba9409461b','ae70ec5c-0a61-4275-ae7d-ad247154155b','6149a89f-7334-43ff-b10b-0ff2b81bc51c'),('3dccf300-f8a5-479f-a1cd-d23a8875c3d6','111111','aed3dc9a-9dad-43d0-b337-10c5117a96ac'),('3dd21301-7a43-42bc-b274-c138c90a8171','111111','bb21292d-2666-4902-8a62-e34caf362c5e'),('46e70914-a232-4d7e-bb15-9a5191a33d57','111111','ab1dfd1a-4295-4bd2-a22e-808d781abcbb'),('533d5fec-0f99-4eab-aa96-b93be20d2627','111111','f7484447-e27a-4cee-bdc9-763d382ba5c1'),('559f171c-7143-42ab-bfb1-b481b8dd7d36','ae70ec5c-0a61-4275-ae7d-ad247154155b','56e768e7-bc73-47b4-b648-cde9e3b8711c'),('691cf69e-f977-4339-81a0-1cbdb05fb680','111111','e18fca35-60c0-4892-9d31-697228936c80'),('6e55bae9-f290-4033-a52f-320bfd4f3e8e','111111','f7471cc8-4a9a-471f-af28-51b1ff19f164'),('81b67728-cd91-4a37-bd4f-dd0818ca4f84','111111','f6a09d8a-f624-412b-b353-97890595912c'),('9adde1c9-c3ba-4133-8abd-b73bdc37fc7c','111111','f335dcfc-0278-4b22-85cd-1f90ce147611'),('a2ce7b2c-c6a1-4578-8575-536e56a98494','111111','8161ac60-0554-48a8-8566-1c439d0e5f8a'),('a57b9725-6f8d-4bd1-814d-75887179afcc','ae70ec5c-0a61-4275-ae7d-ad247154155b','e052cf95-9b48-47f5-afda-6ff5c140e4da'),('aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41','111111','3b39aaa1-c44d-4c11-82c3-b8ff6ae261ef'),('b32d0bc6-1e5a-4b0b-ad6e-f1d2cc8add8d','ae70ec5c-0a61-4275-ae7d-ad247154155b','0f592242-6fee-4a64-ac65-121c06c2b285'),('b78c600d-e9af-40c3-aa7b-433a739e40fb','111111','28e1b898-b942-4c7b-b6a7-3f1758479b8b'),('bc0c9603-0ac6-4a7e-8267-513412a388e5','111111','f3ae98e5-5672-4db4-a06f-eceee93a8619'),('c2118d60-56a8-4105-a8cb-0223c3bfe7bf','111111','3f34c3af-eb67-43d3-9e61-7b193ef7d31f'),('c70007e1-4d83-4cc8-aaff-129a9884a2e2','111111','7f33716e-00e2-439d-8f32-90fd26d5b5a5'),('c800667b-281c-4134-a2ec-94f56f4226a8','111111','fb84d263-d0f8-430a-9fb5-d0568d6769dc'),('cf858750-6aa9-4c73-b4ca-7212574f0b90','111111','7f170b9d-c9a0-4068-bc7d-c6f0bc89563a'),('e03f40c9-12d4-477a-8116-5df65cad0b86','ae70ec5c-0a61-4275-ae7d-ad247154155b','100214ae-3c81-4b84-9e45-f4cc65ca13cd'),('e71784c0-5d3b-471d-a51f-d8174deb1880','111111','f860de70-ca90-4b6f-a748-348e459ab2be'),('e9753d23-cbba-4ae5-95d5-79bb1f48f21e','111111','9322de55-87f8-4bc9-b1b9-dd4656e8c548'),('ffbc51af-730a-4879-991a-e7c26a4367fe','111111','63bb22f7-3995-427e-a028-68dbc716761f');
/*!40000 ALTER TABLE `student_course_tree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course_tree_bonus`
--

DROP TABLE IF EXISTS `student_course_tree_bonus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_course_tree_bonus` (
  `s_id` varchar(40) NOT NULL,
  `c_id` varchar(40) NOT NULL,
  `bonus_reason` int(11) DEFAULT NULL COMMENT '奖惩原因，举手、专注、考勤等，具体类别待确定',
  `bonus_num` int(11) DEFAULT NULL COMMENT '对应类别的奖惩数量',
  `bonus_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`,`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course_tree_bonus`
--

LOCK TABLES `student_course_tree_bonus` WRITE;
/*!40000 ALTER TABLE `student_course_tree_bonus` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_course_tree_bonus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_info` (
  `s_id` varchar(40) NOT NULL,
  `s_name` varchar(45) NOT NULL,
  `s_head_url` varchar(200) DEFAULT NULL,
  `s_school` varchar(100) DEFAULT NULL,
  `s_no` varchar(45) DEFAULT NULL,
  `s_password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_info`
--

LOCK TABLES `student_info` WRITE;
/*!40000 ALTER TABLE `student_info` DISABLE KEYS */;
INSERT INTO `student_info` VALUES ('02230447-e12d-434f-a3ff-b9a48966397e','小朋',NULL,NULL,'194646','22222'),('060592cc-18ed-431d-96f3-db1794762f3d','江学生',NULL,NULL,'20131001011','12345678'),('174373dd-af8a-4d94-aada-0ccb176eb104','嘉杰',NULL,NULL,'164646','66666'),('1a6fc7af-0551-4351-8015-c3cd3b6426bf','周学生',NULL,NULL,'20131001007','12345678'),('1f21c0ae-4b65-42b5-a713-55edea069d9d','老老',NULL,NULL,'26854','25688'),('2af2f79b-5d8c-420c-8f92-b1837324e439','萨克斯',NULL,NULL,'464649','494645'),('35f0b8af-c269-4168-88f6-bcba9409461b','李学生',NULL,NULL,'20131001006','12345678'),('3dccf300-f8a5-479f-a1cd-d23a8875c3d6','ksjsj',NULL,NULL,'1649','4649594'),('3dd21301-7a43-42bc-b274-c138c90a8171','znzk',NULL,NULL,'4649','4946'),('46e70914-a232-4d7e-bb15-9a5191a33d57','lslsl',NULL,NULL,'46494','49769'),('5104ebe0-5414-4fe4-acc1-12e373d01013','小p',NULL,NULL,'197646','123456'),('533d5fec-0f99-4eab-aa96-b93be20d2627','呵呵',NULL,NULL,'1676','3699'),('559f171c-7143-42ab-bfb1-b481b8dd7d36','王学生',NULL,NULL,'20131001009','12345678'),('5f9d7764-6fb0-409e-aacd-ad058b202763','jdk',NULL,NULL,'1646','164646'),('691cf69e-f977-4339-81a0-1cbdb05fb680','KKK',NULL,NULL,'16464','134949'),('6e55bae9-f290-4033-a52f-320bfd4f3e8e','lala',NULL,NULL,'1946','94946'),('81b67728-cd91-4a37-bd4f-dd0818ca4f84','JS',NULL,NULL,'194946','3333'),('82b0f2c1-243d-43b3-8f6c-d5c80419cb3e','KKK',NULL,NULL,'163449','464949'),('872a4546-97bc-450c-8604-bcece7874e9e','乐乐',NULL,NULL,'16749','134649'),('9adde1c9-c3ba-4133-8abd-b73bdc37fc7c','467',NULL,NULL,'497649','46464'),('a1aec252-a701-4a47-86e7-72ac492ad902','陈学生',NULL,NULL,'20131001002','12345678'),('a2ce7b2c-c6a1-4578-8575-536e56a98494','niha',NULL,NULL,'164649','9999'),('a57b9725-6f8d-4bd1-814d-75887179afcc','孙学生',NULL,NULL,'20131001005','12345678'),('a6044acc-b235-457a-9c4a-9852fa719cf4','子卓',NULL,NULL,'16464','3333'),('a9c11405-ca8e-4e25-8759-0bdba3f1cdef','麻麻',NULL,NULL,'19767','197649'),('aa4b3bc0-e9c3-4c9d-8c5e-0c80d6ae3b41','小朋',NULL,NULL,'20131003723','12345678'),('aff9f9f2-5604-4b92-8efd-3a411c0c4c4d','小胖',NULL,NULL,'16769','123456'),('b2e40549-b1ea-4c29-ac2f-15dc08c07c13','郑学生',NULL,NULL,'20131001001','12345678'),('b32d0bc6-1e5a-4b0b-ad6e-f1d2cc8add8d','张学生',NULL,NULL,'20131001010','12345678'),('b78c600d-e9af-40c3-aa7b-433a739e40fb','nakak',NULL,NULL,'494649','484349'),('b78ca7d6-e690-46f8-b30a-5f1287e1b81d','明明',NULL,NULL,'666666','12345678'),('bc0c9603-0ac6-4a7e-8267-513412a388e5','haha',NULL,NULL,'134659','6666666'),('bf5ccb88-c68a-46d1-8c49-713f107d6197','赵学生',NULL,NULL,'20131001003','12345678'),('c2118d60-56a8-4105-a8cb-0223c3bfe7bf','花生',NULL,NULL,'164646','154549'),('c70007e1-4d83-4cc8-aaff-129a9884a2e2','dldlx',NULL,NULL,'494346','484646'),('c800667b-281c-4134-a2ec-94f56f4226a8','何乐',NULL,NULL,'464649','184356'),('cf858750-6aa9-4c73-b4ca-7212574f0b90','djsk',NULL,NULL,'194649','434949'),('dbdf44cb-2221-4440-91c2-c3b3c37a6e43','小子',NULL,NULL,'19464','33333'),('e03f40c9-12d4-477a-8116-5df65cad0b86','吴学生',NULL,NULL,'20131001008','12345678'),('e62192db-2ca9-41d3-90b4-158848a847ce','娜娜',NULL,NULL,'134946','496764'),('e71784c0-5d3b-471d-a51f-d8174deb1880','kaka',NULL,NULL,'943464','194979'),('e9753d23-cbba-4ae5-95d5-79bb1f48f21e','JS',NULL,NULL,'164649','197646'),('f4213217-0c80-49fc-b39c-cb2324112a81','科科',NULL,NULL,'4646','1346'),('f491d70c-6030-4238-864d-8a679d16e151','小明','http://www.baidu.com','广东外语外贸大学',NULL,NULL),('f491d70c-6030-4238-864d-8a679d16e152','小红','http://www.baidu.com','广东外语外贸大学',NULL,NULL),('f491d70c-6030-4238-864d-8a679d16e153','小刚','http://www.baidu.com','广东外语外贸大学',NULL,NULL),('f491d70c-6030-4238-864d-8a679d16e154','小柔','http://www.baidu.com','广东外语外贸大学',NULL,NULL),('f491d70c-6030-4238-864d-8a679d16e155','小智','http://www.baidu.com','广东外语外贸大学',NULL,NULL),('fbf4b5dc-0620-4839-9217-cc36c4f43a77','好好',NULL,NULL,'25644','26688'),('fe5126a8-e0b0-4a84-8399-cd5c4338ea02','钱学生',NULL,NULL,'20131001004','12345678'),('ffbc51af-730a-4879-991a-e7c26a4367fe','nsosjs',NULL,NULL,'194946','494949');
/*!40000 ALTER TABLE `student_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_performance_attendance_table`
--

DROP TABLE IF EXISTS `student_performance_attendance_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_performance_attendance_table` (
  `student_performance_attendance_id` varchar(40) NOT NULL,
  `open_class_id` varchar(40) NOT NULL,
  `attendance_id` varchar(40) NOT NULL,
  PRIMARY KEY (`student_performance_attendance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开课记录-考勤';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_performance_attendance_table`
--

LOCK TABLES `student_performance_attendance_table` WRITE;
/*!40000 ALTER TABLE `student_performance_attendance_table` DISABLE KEYS */;
INSERT INTO `student_performance_attendance_table` VALUES ('0bdbd1f5-fed7-420d-9fc1-b9ab37ac2da2','01948d36-42b5-46ed-ab7d-07b7aa3306cb','82469683-e66d-4879-8516-0abfe5fab7e7'),('0c766815-0432-484c-9da0-3d6f92021439','948d83ba-4921-4ada-9f1a-a7870710a25a','f057911f-ccd1-4518-b01a-d33ebfee7c9e'),('160e68fa-0a60-4e7f-bee7-4d4be9c35dc8','a2cbb4ae-d89e-4ee5-963a-c579df859d58','8a5ebf19-e246-4671-98e0-09ccda0cc92f'),('182c4ac9-70c9-426c-81b9-5264f6e3cd5f','948d83ba-4921-4ada-9f1a-a7870710a25a','af699f95-1bdc-4a49-b39c-83260d680b58'),('2c1de353-0405-4cec-834b-60ad157dd2e9','16684080-46df-4795-b3dc-b176bee3717c','ee6ee144-37a1-4e66-9f9f-81700a9d9f99'),('2c277dd2-2c18-4b0b-b16b-1cffb5088123','01948d36-42b5-46ed-ab7d-07b7aa3306cb','81d43407-f917-4ea3-9eb1-4c51305188b5'),('3d8b6957-64ce-4c20-90f1-c61018a10b49','01948d36-42b5-46ed-ab7d-07b7aa3306cb','747b9a27-5e6b-4799-9aa9-958d95551815'),('4315be1e-ae62-4114-8b3d-9d4f679f0186','16684080-46df-4795-b3dc-b176bee3717c','5c5f5930-b7c3-448f-aa0d-59477051d5b4'),('480888bf-6cdf-4a6b-99eb-4ea4d4743e41','948d83ba-4921-4ada-9f1a-a7870710a25a','3c437cf9-7b73-467b-8b20-065243d1addf'),('4ffd1fad-94be-4de2-899a-da71f3eaa717','01948d36-42b5-46ed-ab7d-07b7aa3306cb','8e3f5b36-872b-4de0-9c70-8026611105f8'),('61b85f05-cd6a-4799-8585-6939261b2951','948d83ba-4921-4ada-9f1a-a7870710a25a','b14da911-4b23-4dee-a6d1-6cd919a9549c'),('65070955-be0b-4097-98cd-e4cec002dc60','948d83ba-4921-4ada-9f1a-a7870710a25a','48e192be-7ce9-43f7-8899-152428be51da'),('6ee5660d-c7a6-4a19-85d9-f625850e7ab5','01948d36-42b5-46ed-ab7d-07b7aa3306cb','0c8129e6-158e-4d20-aee7-a5c3facc191b'),('76b6313a-9a37-46a3-ad54-6647999f840b','a77d4a4d-2b3c-44cf-8df4-9e05866c5bad','aa984966-e0ad-4626-a2d4-461e85b36292'),('8483c557-de60-42b2-a74a-aec08c2dd2e2','a2cbb4ae-d89e-4ee5-963a-c579df859d58','103dcff7-43ae-432f-8e9b-cd75472461ac'),('876ee895-95e7-4a3c-b19e-bde29488fa5d','948d83ba-4921-4ada-9f1a-a7870710a25a','14eb9dd7-d420-4e3b-bf6a-eddf6bf8243a'),('89a78bfd-4fb3-4f0b-b547-63a0717a2353','51adf8a0-747a-4896-9e64-5a78fa242cde','605c37fe-49be-464b-ab3d-a0141a4c2c9a'),('8bcaba64-5107-4b26-8771-9adc6d65555f','07075f6c-a870-4a93-94fe-cd8f69c1f8c2','59f1e861-05cd-4ec2-8008-06e01f323dfa'),('90f5f725-914c-4ab2-9fc1-a0583ded715c','49dfc225-4119-4fda-a156-ea7ba9f63ccd','323d183d-76ac-4dd2-a621-ea0b532db974'),('913f2b1f-4c98-4921-8d51-692e8c45d993','01948d36-42b5-46ed-ab7d-07b7aa3306cb','505c46ad-ca9a-4166-9d49-627f8e0da3ee'),('9af0cd66-e439-434c-b798-9cd97318aae7','43e63916-7a00-4bcc-8546-2953d2b025a2','3f737794-2373-4937-9ebd-b3c0c14c17ae'),('9e863c1e-0e48-4614-98f0-ea0732b432fe','01948d36-42b5-46ed-ab7d-07b7aa3306cb','764410c5-f04e-4fc1-9cbe-bbe59672c527'),('a164c41e-077f-463d-b265-20344189ffb1','01948d36-42b5-46ed-ab7d-07b7aa3306cb','b8be8b49-ce96-42a4-a347-fc960164e3f9'),('a51f6cb0-7386-49dc-aac9-7919df6e9374','948d83ba-4921-4ada-9f1a-a7870710a25a','b7f556e2-b09a-472f-8fee-2edde31cb058'),('ae468a3b-786e-4911-8620-0ece31e53925','d959b7bd-d787-4ec3-be11-ccf82d7bcc96','c5ac0797-d9a8-49b0-9107-51749d5eb90c'),('b65dbe62-8f58-4232-b8b4-0eb476826efc','51c3bf8c-3545-4d45-bd04-0d5cda8bfde6','aa15f049-6500-4897-ad5b-ddcc59f2c4fa'),('c8d06a5a-d86b-4c09-ba24-1ec424d9e05b','e5e7c94b-7dc8-48e9-b4d9-4adca163fec4','b301f42e-0ca4-40d2-a5ab-8d06f41fd8d9'),('c9b27c2d-79a3-4eeb-b48b-077cbdccb8ad','01948d36-42b5-46ed-ab7d-07b7aa3306cb','46c6e50a-1314-4d3d-821c-f774cd420b73'),('e322213a-fdeb-418e-afb6-59fd6dfe46fa','01948d36-42b5-46ed-ab7d-07b7aa3306cb','baedb90a-4b88-4fc0-9dc7-bf14ca1a2c32'),('e4040e42-a1cb-4157-b8ae-bdc5dcdd6d59','51c3bf8c-3545-4d45-bd04-0d5cda8bfde6','69122e22-6204-44eb-af3e-c87d565a6b69'),('e6673844-af18-4eb3-9084-b400e00f8e0a','ce2aa680-a129-43e3-9636-ae62c6743a71','240c63cc-8d68-4665-9383-bc2fc0475476'),('f1d0236a-cdc0-4e16-ad09-7c85cf1a3965','16684080-46df-4795-b3dc-b176bee3717c','ba876277-ddc9-4901-a376-7ff24dcb4e13'),('f61564bf-db80-45cc-8345-589327274383','a2cbb4ae-d89e-4ee5-963a-c579df859d58','95403765-b160-479b-a679-d402f9c9c6b5'),('f6c484fc-262c-470e-8c1b-12ce81684d07','16684080-46df-4795-b3dc-b176bee3717c','dc61e76a-8edb-4ff8-a0f2-fda958c4018c');
/*!40000 ALTER TABLE `student_performance_attendance_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_performance_attention_table`
--

DROP TABLE IF EXISTS `student_performance_attention_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_performance_attention_table` (
  `student_performance_attention_id` varchar(40) NOT NULL,
  `open_class_id` varchar(40) NOT NULL,
  `attention_id` varchar(40) NOT NULL,
  `s_id` varchar(40) NOT NULL,
  PRIMARY KEY (`student_performance_attention_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开课记录-专注';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_performance_attention_table`
--

LOCK TABLES `student_performance_attention_table` WRITE;
/*!40000 ALTER TABLE `student_performance_attention_table` DISABLE KEYS */;
INSERT INTO `student_performance_attention_table` VALUES ('062f7559-9edf-4922-8672-8a07d5299c21','d25ac351-920c-4860-aed8-c645a2deee8b','bb11705e-8ccb-4df0-ab62-d3d81aed9f3b','02230447-e12d-434f-a3ff-b9a48966397e'),('0d448e1c-29d4-4ac0-8aea-948be47a80f5','bb6d75c4-af6e-44bd-9a81-0d40b9624e36','6dcf6ce4-fd20-4aef-9869-557d1bb4a1d5','02230447-e12d-434f-a3ff-b9a48966397e'),('240a0268-fa35-4aac-a909-6a91a7523ad2','d25ac351-920c-4860-aed8-c645a2deee8b','acd76e68-f039-4fcc-b11a-751238a1c8af','02230447-e12d-434f-a3ff-b9a48966397e'),('28a4d7b3-415b-49ae-806b-15be39a6be2d','ee85d739-14ce-45fa-a855-2a10d1bbe14a','3348f467-e4b9-457c-bfdb-0c2bb11a36cc','02230447-e12d-434f-a3ff-b9a48966397e'),('33ab4ba4-4d51-4625-81f2-48b4675a9aee','ee85d739-14ce-45fa-a855-2a10d1bbe14a','4e62b091-99f4-4cb8-88fb-90956b16fa33','02230447-e12d-434f-a3ff-b9a48966397e'),('4116ae4a-b674-42d2-a375-55936b6961bc','d25ac351-920c-4860-aed8-c645a2deee8b','50ace11a-5b24-4ca8-ab87-7f047bc0dc16','02230447-e12d-434f-a3ff-b9a48966397e'),('413094cc-d795-458e-a646-cdccffadc1d7','c9d77c50-57ad-40c3-8ba6-c69db1d31089','a4f0483f-b04b-45e5-80b0-ae86b7edc447','02230447-e12d-434f-a3ff-b9a48966397e'),('4f5abe8e-464f-4c1d-b44d-111b945e4441','135ea580-21e7-465c-9b6c-bdf2daff785c','ee1c1ce2-71e1-4a4c-a413-ec08bcfd1542','02230447-e12d-434f-a3ff-b9a48966397e'),('61737b9b-6c49-40a9-9c0c-35a49501719d','bb6d75c4-af6e-44bd-9a81-0d40b9624e36','ccf6a98d-3e13-4fa2-bd6d-d5880ec4cdef','02230447-e12d-434f-a3ff-b9a48966397e'),('6b1d60bd-17d1-49b2-8c3e-44b066e9a71e','135ea580-21e7-465c-9b6c-bdf2daff785c','ae06d331-73f9-4d5d-9b57-c56d122accc4','02230447-e12d-434f-a3ff-b9a48966397e'),('7397e361-5bbc-4400-872e-2ebdc28527a5','c9d77c50-57ad-40c3-8ba6-c69db1d31089','5c0b783f-4631-4980-9b06-9285e3e2a4f1','02230447-e12d-434f-a3ff-b9a48966397e'),('8951861d-d51f-43c7-8910-f698be4ff756','418fe95b-474d-4012-a335-ef8579210140','f291ebd6-4d88-4664-b374-c005ce96b180','02230447-e12d-434f-a3ff-b9a48966397e'),('8d3bb61a-fb91-4b6b-aad4-a25729093427','571549d3-c720-4fa5-b8fa-d95e2b9f7456','f2645064-86b7-4e35-bf31-1fee2a3fd1fc','02230447-e12d-434f-a3ff-b9a48966397e'),('8e0f1381-0ab7-4d1d-aaf0-e2aa4420787f','564da9d0-8838-4eb1-8353-e42d0c04acbc','23b6d211-7ff4-4233-882b-f4bcf19489f0','02230447-e12d-434f-a3ff-b9a48966397e'),('8e152561-7c5d-44a5-b9d8-f952b0a0340c','418fe95b-474d-4012-a335-ef8579210140','e481f679-3176-4b62-9833-321958df2f44','02230447-e12d-434f-a3ff-b9a48966397e'),('9c314e57-e496-4080-a99b-ffa202d8597f','135ea580-21e7-465c-9b6c-bdf2daff785c','209a4458-9ad6-4c4b-8112-961a1c301589','02230447-e12d-434f-a3ff-b9a48966397e'),('ad866023-a24f-4006-bd93-126f6ba28f39','135ea580-21e7-465c-9b6c-bdf2daff785c','76a70f2e-cd43-466f-b8db-9a4b7594aa6a','02230447-e12d-434f-a3ff-b9a48966397e'),('b0c5741f-dcbf-489b-8a5a-89f4b4dddd59','d25ac351-920c-4860-aed8-c645a2deee8b','d9eab742-9728-4b4a-bb57-9c775643d182','02230447-e12d-434f-a3ff-b9a48966397e'),('b12ebb25-ea0a-4651-8178-9695d4b689dd','01948d36-42b5-46ed-ab7d-07b7aa3306cb','9095ff23-f6cc-48e9-8043-b699ae2a5a58','02230447-e12d-434f-a3ff-b9a48966397e'),('b446fdb3-c896-4a6f-b9a5-767160639e33','ee85d739-14ce-45fa-a855-2a10d1bbe14a','75a87e42-2f3a-4296-b9e7-ecec7214ca90','02230447-e12d-434f-a3ff-b9a48966397e'),('c26c3300-7391-4142-9683-16174f7c9821','d25ac351-920c-4860-aed8-c645a2deee8b','89ef1645-6797-489c-8dfd-1ca515014777','02230447-e12d-434f-a3ff-b9a48966397e'),('df31a892-2406-4782-a913-80ce46d77f56','d25ac351-920c-4860-aed8-c645a2deee8b','b9c772fe-b1f1-48af-a92f-5fec7e8d9729','02230447-e12d-434f-a3ff-b9a48966397e'),('e8c43b3f-e4bc-4294-8e93-495e9ea9e53e','bb6d75c4-af6e-44bd-9a81-0d40b9624e36','d275142c-99fa-4bfa-9628-06f1a678949a','02230447-e12d-434f-a3ff-b9a48966397e'),('fadc4b63-97bf-4ded-86ee-52f3750f09ce','d25ac351-920c-4860-aed8-c645a2deee8b','58b50b11-b494-48f1-8a46-a23337556014','02230447-e12d-434f-a3ff-b9a48966397e');
/*!40000 ALTER TABLE `student_performance_attention_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_performance_handup_table`
--

DROP TABLE IF EXISTS `student_performance_handup_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_performance_handup_table` (
  `open_class_id` varchar(40) NOT NULL,
  `handup_info_id` varchar(40) NOT NULL,
  `student_perfomance_handup_id` varchar(40) NOT NULL,
  PRIMARY KEY (`student_perfomance_handup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生-课堂表现-举手记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_performance_handup_table`
--

LOCK TABLES `student_performance_handup_table` WRITE;
/*!40000 ALTER TABLE `student_performance_handup_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_performance_handup_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_summary`
--

DROP TABLE IF EXISTS `student_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_summary` (
  `s_id` varchar(40) NOT NULL,
  `summary_time` varchar(50) DEFAULT NULL,
  `summary_content` mediumtext,
  `summary_evaluation` varchar(45) DEFAULT NULL,
  `summary_bonus` int(11) DEFAULT NULL,
  `summary_status` int(11) DEFAULT NULL COMMENT '反馈状态（1=已反馈但未得到回复，0=未反馈，2=已反馈切得到回复）',
  `open_class_id` varchar(45) NOT NULL,
  `student_summary_id` varchar(45) NOT NULL,
  PRIMARY KEY (`student_summary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生-反馈信息表，用于记录学生的反馈';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_summary`
--

LOCK TABLES `student_summary` WRITE;
/*!40000 ALTER TABLE `student_summary` DISABLE KEYS */;
INSERT INTO `student_summary` VALUES ('872a4546-97bc-450c-8604-bcece7874e9e','2017-04-21 16:39:18','老师你好，这是我第一次反馈','合理',5,3,'43e63916-7a00-4bcc-8546-2953d2b025a2','4141241231231');
/*!40000 ALTER TABLE `student_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_teacher_class_table`
--

DROP TABLE IF EXISTS `student_teacher_class_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_teacher_class_table` (
  `c_id` varchar(40) NOT NULL COMMENT '课程id',
  `class_begin_time` varchar(40) NOT NULL,
  `open_class_id` varchar(40) NOT NULL COMMENT '开课记录id',
  `class_status` int(11) DEFAULT NULL COMMENT '课程状态（1=开课， 0=结课）',
  `t_id` varchar(45) NOT NULL COMMENT '教师id',
  `class_end_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`open_class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开课记录表，老师每开一次课则新增一条记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_teacher_class_table`
--

LOCK TABLES `student_teacher_class_table` WRITE;
/*!40000 ALTER TABLE `student_teacher_class_table` DISABLE KEYS */;
INSERT INTO `student_teacher_class_table` VALUES ('d276a696-1956-4fb2-b193-f393e636d940','2017-04-19 19:50:42','01948d36-42b5-46ed-ab7d-07b7aa3306cb',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-24 14:22:40','05d34c01-999a-4708-aedc-fc0f56513ae3',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-21 16:32:58','07075f6c-a870-4a93-94fe-cd8f69c1f8c2',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 15:11:56','0869ebb4-8d8d-45a5-aaa8-0e1a5db820db',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 15:03:23','08b36f0e-c7ca-4c80-aac3-2daa9c435f81',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 15:36:57','0bc26755-8121-4553-9159-5fadbc87b286',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-23 14:37:45','135ea580-21e7-465c-9b6c-bdf2daff785c',1,'null',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-21 16:14:17','16684080-46df-4795-b3dc-b176bee3717c',1,'1234',NULL),('3685ab9a-dc59-4b9f-adeb-a2edfb0cd670','2017-04-23 19:17:47','219a024a-a4cc-483b-8a0a-e03eb47edfe7',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-23 19:05:24','24b6bb22-3a00-4501-b9b2-355350620d28',1,'1234',NULL),('013d1bfe-5d21-4b2e-b1cf-79bddd927fb5','2017-04-23 02:23:02','35a5b3b6-5f30-4989-aa13-cbc01642dfa3',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 14:54:17','3802397e-6d47-446c-ba57-eb8afaf30584',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-20 16:48:28','3c74069f-471f-45b5-80ab-a113d96efd06',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 14:37:45','3cdc3d76-dd0a-44b1-8f0e-dca2fbd37714',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-24 15:01:40','418fe95b-474d-4012-a335-ef8579210140',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-21 16:39:18','43e63916-7a00-4bcc-8546-2953d2b025a2',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-24 14:26:37','44ea6fe9-f09f-4821-9ad7-700a416e613f',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-21 16:56:18','49dfc225-4119-4fda-a156-ea7ba9f63ccd',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 16:39:17','51adf8a0-747a-4896-9e64-5a78fa242cde',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-23 15:18:37','51c3bf8c-3545-4d45-bd04-0d5cda8bfde6',1,'null',NULL),('3685ab9a-dc59-4b9f-adeb-a2edfb0cd670','2017-04-23 19:15:21','545559ce-3624-4105-92a5-3a648a3599f6',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 15:19:47','54a7e6d0-418b-4909-9ac4-283ba576a330',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-24 15:37:43','564da9d0-8838-4eb1-8353-e42d0c04acbc',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-24 15:10:14','571549d3-c720-4fa5-b8fa-d95e2b9f7456',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-21 20:41:40','5a18315a-9042-4403-ad0d-0a09e8f192b0',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 14:34:03','5c2ef04e-c16f-4815-bd80-cca4f1e5cf45',1,'1234',NULL),('013d1bfe-5d21-4b2e-b1cf-79bddd927fb5','2017-04-23 13:28:20','6428e02d-7140-4df1-80b7-1caf35aec7f9',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-24 14:22:03','6cf75e97-0987-40e1-9c30-9485de38ce88',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 14:13:10','6df5a7c1-51bd-4d2d-9806-2c28b6f6d403',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-23 14:17:55','72a1aa20-dd97-4bd8-8b76-32946b8448f9',1,'null',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 14:52:46','7ab13b72-5d88-4ccd-9653-a40a02845568',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-21 16:13:07','7d91c670-a09e-432f-a3da-d8e20211e1b6',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 14:35:07','7dc91fd4-a677-4eb0-a6a4-413e40844814',1,'1234',NULL),('3fc27153-07c8-43bf-8750-3195b40e6131','2017-04-21 16:29:54','8024c3eb-908b-4db0-8bb4-95e6c409c09f',1,'1234',NULL),('d276a696-1956-4fb2-b193-f393e636d940','2017-04-20 14:43:02','832fe5aa-1a6a-451c-8ac8-f5e2f8b36ce0',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-21 19:12:29','85f52b1a-42e1-4086-96b8-a6198b185bb0',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 20:01:07','865c6822-6810-4756-9cf1-16f65d8b38e3',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-24 14:50:03','87f5af69-d707-44ea-becf-03faced95c99',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-23 18:48:10','88281335-f9a4-421d-861c-8fe5eb4e92e0',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-23 15:30:52','948d83ba-4921-4ada-9f1a-a7870710a25a',1,'1234',NULL),('3685ab9a-dc59-4b9f-adeb-a2edfb0cd670','2017-04-23 19:12:20','a2cbb4ae-d89e-4ee5-963a-c579df859d58',1,'1234',NULL),('d276a696-1956-4fb2-b193-f393e636d940','2017-04-20 19:02:14','a6956c18-fd02-4509-b9dd-07715cce273f',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-21 16:30:18','a77d4a4d-2b3c-44cf-8df4-9e05866c5bad',1,'1234',NULL),('d276a696-1956-4fb2-b193-f393e636d940','2017-04-20 16:01:48','a9637757-c1eb-4df8-a90b-6e8a4838123a',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-23 04:03:53','ac3f93c0-4b1f-472a-b830-d5dedb2c340b',1,'1234',NULL),('3685ab9a-dc59-4b9f-adeb-a2edfb0cd670','2017-04-23 19:14:53','b258760d-b8bc-41cc-8bb8-69e6fad998c3',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-23 14:23:36','b8a8fa43-d4fb-432d-b260-ac19efb6ddae',1,'null',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-24 14:38:09','bb6d75c4-af6e-44bd-9a81-0d40b9624e36',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 14:37:04','c9a1b36e-c9f2-4c17-b0d5-56d8e7822be9',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-23 14:25:55','c9d77c50-57ad-40c3-8ba6-c69db1d31089',1,'null',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 14:23:38','cca94ed2-695c-4d3e-877e-5ad2bba10620',1,'1234',NULL),('013d1bfe-5d21-4b2e-b1cf-79bddd927fb5','2017-04-23 03:06:40','cd083739-dee8-4a78-9e0e-5bdc80e9625c',1,'1234',NULL),('013d1bfe-5d21-4b2e-b1cf-79bddd927fb5','2017-04-21 15:08:48','ce2aa680-a129-43e3-9636-ae62c6743a71',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-24 14:33:03','d1979474-895e-4cc5-81dd-4090b421c101',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-23 18:31:51','d25ac351-920c-4860-aed8-c645a2deee8b',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 14:16:23','d37eb595-da3a-4228-b039-03ccb7311443',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-21 16:41:30','d959b7bd-d787-4ec3-be11-ccf82d7bcc96',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-23 14:15:24','e2efc653-b379-4a7f-9c32-50c88acb0f01',1,'null',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-21 16:48:31','e5e7c94b-7dc8-48e9-b4d9-4adca163fec4',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 16:45:53','e61bdb37-bd94-477c-917c-9075fef85e60',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-23 15:06:42','ee85d739-14ce-45fa-a855-2a10d1bbe14a',1,'null',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-25 16:49:36','f40703dc-c2c8-4500-9cbe-279458b257a6',1,'1234',NULL),('f0fd9862-c035-48f1-a2c0-6e91d618c61c','2017-04-21 19:09:25','f7f08763-eeb0-41cb-bf09-a6bdef1fd3ad',1,'1234',NULL),('ae70ec5c-0a61-4275-ae7d-ad247154155b','2017-04-23 22:33:04','fecb48f9-c21c-497e-aecd-377be9d8676b',1,'1234',NULL);
/*!40000 ALTER TABLE `student_teacher_class_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_class_ask`
--

DROP TABLE IF EXISTS `teacher_class_ask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_class_ask` (
  `teacher_class_ask_id` varchar(40) NOT NULL,
  `open_class_id` varchar(40) NOT NULL,
  `ask_bonus` int(11) DEFAULT NULL COMMENT '奖惩情况，通过open_class_id找到对应学生的id',
  `s_id` varchar(45) NOT NULL,
  `bonus_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`teacher_class_ask_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='老师-课堂-提问记录，当创建了一条记录的时候，表示该学生被提问了';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_class_ask`
--

LOCK TABLES `teacher_class_ask` WRITE;
/*!40000 ALTER TABLE `teacher_class_ask` DISABLE KEYS */;
INSERT INTO `teacher_class_ask` VALUES ('38f6b67e-f270-4e6e-930d-874b85477012','865c6822-6810-4756-9cf1-16f65d8b38e3',3,'f491d70c-6030-4238-864d-8a679d16e154',2),('8b645f6e-3dc8-4e0e-a84c-af558f939d7a','832fe5aa-1a6a-451c-8ac8-f5e2f8b36ce0',3,'b77a96a7-1fa8-4211-81b0-2a2471724e33',2);
/*!40000 ALTER TABLE `teacher_class_ask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_class_random_ask_table`
--

DROP TABLE IF EXISTS `teacher_class_random_ask_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_class_random_ask_table` (
  `teacher_class_random_ask_id` varchar(40) NOT NULL,
  `open_class_id` varchar(40) NOT NULL,
  `random_ask_id` varchar(40) NOT NULL COMMENT '随机提问信息id，通过这个id可以找到对应的随机提问信息',
  PRIMARY KEY (`teacher_class_random_ask_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师-课堂-随机提问记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_class_random_ask_table`
--

LOCK TABLES `teacher_class_random_ask_table` WRITE;
/*!40000 ALTER TABLE `teacher_class_random_ask_table` DISABLE KEYS */;
INSERT INTO `teacher_class_random_ask_table` VALUES ('0d89d97e-4a20-4845-a64f-58005fc2611c','865c6822-6810-4756-9cf1-16f65d8b38e3','ea0ed9f7-88ca-45d8-b3fb-85301698016c'),('25ab7efa-b81c-4ca7-be8e-351d66d6a3b5','832fe5aa-1a6a-451c-8ac8-f5e2f8b36ce0','60d6f265-6579-4d7e-a058-c4be8fb5180e'),('33b635b6-3b24-4e21-9978-93a55284c085','54abfb7b-a3af-4f61-8b80-3086b421720e','b6025d65-be52-43fc-ba13-8055e510ad3e'),('3591e23d-4c8a-4452-833a-35834a87b191','865c6822-6810-4756-9cf1-16f65d8b38e3','794bf2f7-320f-486a-bb9a-3291551f23cc'),('5588a5e7-58e1-4380-91d7-be5637b453ed','865c6822-6810-4756-9cf1-16f65d8b38e3','74003ac9-4b63-4eb1-9b8a-778b661af6be'),('6dccb59a-7f3f-40e1-8445-0b3e833d4cbd','865c6822-6810-4756-9cf1-16f65d8b38e3','258bd842-4f6c-4ccb-bc58-4cda22d81dbd'),('79fbd2ce-a40f-4071-b86b-e999462fb9d0','865c6822-6810-4756-9cf1-16f65d8b38e3','0b70382d-ece6-4a97-935d-bb22a04be032'),('8dcff7a3-795f-4c0d-ae7c-a9a0e516c3fb','865c6822-6810-4756-9cf1-16f65d8b38e3','c9a74daa-2da4-4c17-afe2-d4a5d45c6e15'),('91328c38-f1a5-4891-b190-ed559994aceb','a9637757-c1eb-4df8-a90b-6e8a4838123a','a5cfc4a3-8d16-40f2-9c17-03a399648814'),('96687d22-4389-416e-b3bc-7be26963a4ec','865c6822-6810-4756-9cf1-16f65d8b38e3','921d13c7-78cc-4d5a-8119-4ddc49ce8038'),('9a8db375-4c33-4065-839a-e12fa4938778','865c6822-6810-4756-9cf1-16f65d8b38e3','dc321e32-a971-4a45-8142-7df9bd2a0e7d'),('a0040228-3966-4bc0-a925-6631b779f15d','865c6822-6810-4756-9cf1-16f65d8b38e3','24bf8deb-44e7-42f9-8d8e-a505ef0c181e'),('ae898d7e-74d1-4e41-b701-1c49e6895faa','865c6822-6810-4756-9cf1-16f65d8b38e3','b5957f17-86a8-4c50-8f0e-cb554034117e'),('be235d21-e8ff-434b-9d58-718965f26b25','865c6822-6810-4756-9cf1-16f65d8b38e3','27c0481d-0df7-4037-8de9-2626db4e373b'),('c305e81f-4ef3-4775-9f5c-8a19c26e69a3','a9637757-c1eb-4df8-a90b-6e8a4838123a','afb7b87f-c1b6-414f-9dd3-dacd2bc72bdf'),('e3709831-9d09-48ae-9034-0deefcc58e32','865c6822-6810-4756-9cf1-16f65d8b38e3','0e2184c9-58e5-48f0-b96d-c5d6ef4a8cc7'),('ebbda874-8846-4e69-b2a1-ae0c1589070e','865c6822-6810-4756-9cf1-16f65d8b38e3','8ffa1fac-1037-4ad0-8fad-3bf941bc8ae1');
/*!40000 ALTER TABLE `teacher_class_random_ask_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_course_attendance_table`
--

DROP TABLE IF EXISTS `teacher_course_attendance_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_course_attendance_table` (
  `teacher_attendance_id` varchar(45) NOT NULL,
  `open_class_id` varchar(45) DEFAULT NULL,
  `attendance_begin_time` varchar(45) DEFAULT NULL,
  `attendance_end_time` varchar(45) DEFAULT NULL,
  `attendance_begin_status` int(11) DEFAULT NULL COMMENT '0=考勤结束，1=考勤开始',
  `attendance_code` varchar(45) DEFAULT NULL,
  `attendance_count` int(11) DEFAULT NULL,
  `absence_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`teacher_attendance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_course_attendance_table`
--

LOCK TABLES `teacher_course_attendance_table` WRITE;
/*!40000 ALTER TABLE `teacher_course_attendance_table` DISABLE KEYS */;
INSERT INTO `teacher_course_attendance_table` VALUES ('0ca12934-66d1-4bcf-b14d-aa265ab12c23','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017/04/20 23:21:10',NULL,1,'106660',NULL,NULL),('15a656ee-5fd7-4cb5-962c-e91df6d19242','07075f6c-a870-4a93-94fe-cd8f69c1f8c2','2017/04/21 16:37:04',NULL,1,'591583',0,0),('17722c1a-ef96-483b-a1a4-30568f14cd46','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017/04/21 14:09:44',NULL,1,'106660',NULL,NULL),('1c9e04c4-5c50-463f-8ade-e879b81347d1','d959b7bd-d787-4ec3-be11-ccf82d7bcc96','2017/04/21 16:44:55',NULL,1,'684800',0,0),('1ecf7c35-7b3c-412d-80ff-41fcdc282f8a','d25ac351-920c-4860-aed8-c645a2deee8b','2017/04/23 18:31:57','2017/04/23 18:32:27',0,'436439',0,0),('2af725bc-52bb-46d1-9090-405d352d905d','43e63916-7a00-4bcc-8546-2953d2b025a2','2017/04/21 16:39:20',NULL,1,'342724',1,0),('2decf127-6f76-43fd-8394-bcee446dff16','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017/04/21 00:48:16',NULL,1,'106660',NULL,NULL),('310b9af6-4454-4999-b828-ded64b24de01','a2cbb4ae-d89e-4ee5-963a-c579df859d58','2017/04/23 19:17:51','2017/04/23 19:18:21',0,'351281',0,0),('35d8844a-aa5e-41b0-a001-70c869aa5026','a2cbb4ae-d89e-4ee5-963a-c579df859d58','2017/04/23 19:15:25','2017/04/23 19:15:55',0,'351281',0,0),('39de4153-e648-4484-82ee-15c53e53f74f','7d91c670-a09e-432f-a3da-d8e20211e1b6','2017/04/21 16:13:47',NULL,1,NULL,NULL,NULL),('40a6e556-76f3-49ff-91fd-d5aa16511725','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017/04/21 00:57:36',NULL,1,'106660',NULL,NULL),('40cdf253-937e-4b7b-a28f-b152383a9ab1','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017/04/20 23:36:47',NULL,1,'106660',NULL,NULL),('45c3dbcb-518f-4894-9910-65c094e63846','24b6bb22-3a00-4501-b9b2-355350620d28','2017/04/23 19:07:31','2017/04/23 19:08:01',0,'404246',0,0),('4864ebd5-dd06-4ccb-adfd-62058876d157','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017/04/21 14:55:23',NULL,1,'106660',NULL,NULL),('48c933b3-2353-4c86-9c98-93bc2823d097','e5e7c94b-7dc8-48e9-b4d9-4adca163fec4','2017/04/21 16:48:34',NULL,1,'330195',1,0),('49ec94ec-dc53-46e1-ad44-a38b95a9864d','a6956c18-fd02-4509-b9dd-07715cce273f','2017/04/20 19:02:21',NULL,1,'106679',NULL,NULL),('508e862c-e667-45fe-9262-c133af37bb8f','49dfc225-4119-4fda-a156-ea7ba9f63ccd','2017/04/21 16:56:23','2017/04/21 16:56:53',0,'835390',1,0),('51559b39-858f-4dac-ab1b-efe566d18d4b','d25ac351-920c-4860-aed8-c645a2deee8b','2017/04/23 18:48:16','2017/04/23 18:48:47',0,NULL,0,0),('56971527-076b-4521-99b3-cca03344088b','948d83ba-4921-4ada-9f1a-a7870710a25a','2017/04/23 15:37:45','2017/04/23 15:38:15',0,'389353',1,0),('5796deb7-db49-46fc-a5cc-dc0de79a5a04','07075f6c-a870-4a93-94fe-cd8f69c1f8c2','2017/04/21 16:33:00',NULL,1,'591583',1,0),('5bb415bf-f303-4c6c-9b1f-67aa34280873','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017/04/20 23:09:32',NULL,1,'106660',NULL,NULL),('630bbb81-c982-4ac2-aeb9-0c8341869a21','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017/04/21 15:00:53',NULL,1,'106660',NULL,NULL),('6cf00555-f3a5-4b13-a58b-ce381673c6bf','7d91c670-a09e-432f-a3da-d8e20211e1b6','2017/04/21 16:13:10',NULL,1,'851196',NULL,NULL),('7151ec4b-6a97-4a46-93bd-37a8dc860e2c','ee85d739-14ce-45fa-a855-2a10d1bbe14a','2017/04/23 15:15:39','2017/04/23 15:16:09',0,NULL,0,0),('72f2d03e-6ce5-4fcf-8f9b-8696e9a8499c','948d83ba-4921-4ada-9f1a-a7870710a25a','2017/04/23 15:31:41','2017/04/23 15:32:11',0,'389353',0,0),('73b17997-21f6-4efa-8034-96db706db329','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017/04/21 01:11:03',NULL,1,'106660',NULL,NULL),('9041deb5-985d-468a-900e-abca97ffccea','51adf8a0-747a-4896-9e64-5a78fa242cde','2017/04/25 16:39:22','2017/04/25 16:39:52',0,'613015',0,0),('ad3582d8-0e24-48ba-b1bc-0a82af57c362','16684080-46df-4795-b3dc-b176bee3717c','2017/04/21 16:14:19',NULL,1,'401852',NULL,NULL),('ae726481-8422-4fdc-a712-3888d3c7c0ed','open_class_id','2017/04/20 01:46:20',NULL,1,NULL,NULL,NULL),('af09133f-a8c4-4d8f-bc96-efd8484821c3','51c3bf8c-3545-4d45-bd04-0d5cda8bfde6','2017/04/23 15:18:53','2017/04/23 15:19:23',0,'225836',0,0),('b0f863ae-c5e1-4ade-a305-8323b4c70508','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017/04/21 14:54:00',NULL,1,'106660',NULL,NULL),('b54a6f51-68af-4dd4-b01a-1dff93d35663','a2cbb4ae-d89e-4ee5-963a-c579df859d58','2017/04/23 19:12:25','2017/04/23 19:12:55',0,'351281',0,0),('b7294d84-b34b-4192-ac92-8b5029ce797a','51adf8a0-747a-4896-9e64-5a78fa242cde','2017/04/25 16:45:38','2017/04/25 16:46:08',0,NULL,0,0),('d0fdcea5-3b1c-44a6-8e50-251c6a27d35a','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017/04/20 23:31:38',NULL,1,'106660',NULL,NULL),('db757410-7bcd-43e9-90dd-bec6db351358','a2cbb4ae-d89e-4ee5-963a-c579df859d58','2017/04/23 19:14:58','2017/04/23 19:15:28',0,'351281',1,0),('e64968ea-c15c-4102-8280-0f6b22c2ce91','a77d4a4d-2b3c-44cf-8df4-9e05866c5bad','2017/04/21 16:30:21',NULL,1,'734905',1,0),('e7c6efa1-e3e2-4750-b106-43eb4b1f0473','ce2aa680-a129-43e3-9636-ae62c6743a71','2017/04/21 15:08:52',NULL,1,'669260',NULL,NULL),('efa7ddd0-4fd4-43c1-9630-fdd38a5addb7','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017/04/20 23:11:02',NULL,1,'106660',NULL,NULL),('f4845d8a-8809-45a3-ab19-c08ecbcae7fa','d959b7bd-d787-4ec3-be11-ccf82d7bcc96','2017/04/21 16:41:32',NULL,1,'684800',1,0);
/*!40000 ALTER TABLE `teacher_course_attendance_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_course_attention_table`
--

DROP TABLE IF EXISTS `teacher_course_attention_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_course_attention_table` (
  `teacher_course_attention_id` varchar(45) NOT NULL,
  `open_class_id` varchar(45) NOT NULL,
  `attention_begin_time` varchar(45) NOT NULL,
  `attention_end_time` varchar(45) DEFAULT NULL,
  `attention_type` int(11) NOT NULL,
  `attention_duration` varchar(45) NOT NULL,
  PRIMARY KEY (`teacher_course_attention_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_course_attention_table`
--

LOCK TABLES `teacher_course_attention_table` WRITE;
/*!40000 ALTER TABLE `teacher_course_attention_table` DISABLE KEYS */;
INSERT INTO `teacher_course_attention_table` VALUES ('032b173e-7943-46fb-8a64-afb8633272d0','87f5af69-d707-44ea-becf-03faced95c99','2017-04-24 14:50:47',NULL,1,'10:00'),('03e0cf24-ca68-4f27-b181-6527bcd15d1f','87f5af69-d707-44ea-becf-03faced95c99','2017-04-24 14:50:09','2017-04-24 14:50:42',1,'10:00'),('13edd8c2-661c-4ff2-8247-c7849fa3b0ef','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'0:10'),('1e261423-9cd4-41e1-8a46-41eb77acc9b9','05d34c01-999a-4708-aedc-fc0f56513ae3','2017-04-24 14:23:07',NULL,1,'10:00'),('2692b24d-f6eb-42be-910d-02a1feab75ca','ee85d739-14ce-45fa-a855-2a10d1bbe14a','2017-04-23 15:06:48','2017-04-23 15:14:16',1,'10:00'),('2724fd90-b90c-4a25-9ac5-6c0acf7d1aa6','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'5:00'),('28a6bff6-2b4e-4c3f-bc99-d20d81c2a81c','d25ac351-920c-4860-aed8-c645a2deee8b','2017-04-23 18:49:09','2017-04-23 18:49:15',1,'10:00'),('2b545bec-a869-4cf4-9342-766add50efbd','d1979474-895e-4cc5-81dd-4090b421c101','2017-04-24 14:33:07',NULL,1,'10:00'),('2c1ba690-574f-4e80-845f-d078893bd571','6428e02d-7140-4df1-80b7-1caf35aec7f9','2017-04-23 13:28:37',NULL,1,'10:00'),('30cca60f-a883-4a01-8e87-be1015240e1d','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'0:10'),('565caed7-dfa6-468f-9c1c-352adc789bb2','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'0:10'),('5d65a1b3-dce7-4c2c-bf7c-828071b1534c','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'5:00'),('602faf95-163c-448d-bd04-00d612ec9f62','b8a8fa43-d4fb-432d-b260-ac19efb6ddae','2017-04-23 14:23:44',NULL,1,'15:00'),('6520aa21-041d-4d9a-a4cd-f8f00cbdad6e','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48','2017-04-10 22:14:45',1,'5:00'),('67fc0df9-1e3f-4b15-b8c5-f3ab1c691448','564da9d0-8838-4eb1-8353-e42d0c04acbc','2017-04-24 15:37:48',NULL,1,'10:00'),('6c6d230f-28f1-4aaa-9540-b058a70ae28e','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'5:00'),('80765c0a-2cdd-4051-b429-84b07b5d74b8','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'0:10'),('89694ee4-4e0b-443a-8ed1-480ff58a6e58','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'5:00'),('8baac4ad-9640-43f0-9a5f-fdb1d0ffb7b1','a9637757-c1eb-4df8-a90b-6e8a4838123a','2017-04-20 16:10:05',NULL,1,'10:00'),('913e1be0-9437-42dc-95a1-98e80af831bc','44ea6fe9-f09f-4821-9ad7-700a416e613f','2017-04-24 14:26:42',NULL,1,'10:00'),('937941d4-4dc9-42e5-8fa8-bfb246645490','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'0:10'),('9b269c81-8742-4acd-bc0d-9abc0db18139','571549d3-c720-4fa5-b8fa-d95e2b9f7456','2017-04-24 15:10:21',NULL,1,'10:00'),('a156c4fb-e591-4ab1-94cc-ee7b7a184588','418fe95b-474d-4012-a335-ef8579210140','2017-04-24 15:01:49',NULL,1,'10:00'),('a2070a1a-6aa0-4b80-8800-fb6c4d51bcb8','a9637757-c1eb-4df8-a90b-6e8a4838123a','2017-04-20 16:08:47','2017-04-20 16:09:17',1,'10:00'),('a6b60c1a-3fe2-444e-a121-27e2dcf5c54e','d25ac351-920c-4860-aed8-c645a2deee8b','2017-04-23 18:32:38','2017-04-23 18:32:44',1,'5:00'),('aa85e9e5-dad5-4050-a4de-acdcc7bed8a0','e2efc653-b379-4a7f-9c32-50c88acb0f01','2017-04-23 14:15:29',NULL,1,'10:00'),('b6c7eb5b-685c-4254-830e-0fa7753e7640','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'5:00'),('b865c979-8c6a-4942-9e02-62339ce51cbc','a9637757-c1eb-4df8-a90b-6e8a4838123a','2017-04-20 16:04:29','2017-04-20 16:05:40',1,'5:00'),('b8d7bc37-cf10-45eb-9811-6261f03738e4','865c6822-6810-4756-9cf1-16f65d8b38e3','2017-04-25 20:03:57',NULL,1,'10:00'),('bd5ca61e-4576-40e5-a6ab-9aa6625b763d','72a1aa20-dd97-4bd8-8b76-32946b8448f9','2017-04-23 14:18:05',NULL,1,'15:00'),('c54b0de1-3695-426c-821a-6dd4be522121','418fe95b-474d-4012-a335-ef8579210140','2017-04-24 15:04:28',NULL,1,'10:00'),('c90849e7-a916-4b56-9233-f8d41cd38f85','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'5:00'),('da16f483-d63d-4c2d-8862-35263a9be7d7','6cf75e97-0987-40e1-9c30-9485de38ce88','2017-04-24 14:22:08',NULL,1,'10:00'),('e3231668-3fa3-42fd-a72e-66b784120e24','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'0:10'),('e8b92904-17eb-4e9f-8011-2a0a12ab2ead','bb6d75c4-af6e-44bd-9a81-0d40b9624e36','2017-04-24 14:38:14',NULL,1,'10:00'),('ee176800-0b44-4b8d-8ac9-5beec5cd19e2','135ea580-21e7-465c-9b6c-bdf2daff785c','2017-04-23 14:37:51',NULL,1,'20:00'),('f9011c39-74fb-495e-8467-05dca816c853','c9d77c50-57ad-40c3-8ba6-c69db1d31089','2017-04-23 14:26:02',NULL,1,'15:00'),('fd352acd-4564-4ed7-a674-6e6ebf4e7f06','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'0:10'),('ff5be841-04f9-485e-ae6a-27bbcb8c1196','01948d36-42b5-46ed-ab7d-07b7aa3306cb','2017-04-07 22:12:48',NULL,1,'5:00');
/*!40000 ALTER TABLE `teacher_course_attention_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_course_group_table`
--

DROP TABLE IF EXISTS `teacher_course_group_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_course_group_table` (
  `t_id` varchar(40) NOT NULL,
  `c_id` varchar(40) NOT NULL,
  `group_member_limit` varchar(20) DEFAULT NULL COMMENT '分组人数限制，格式为： 每组最少人数，每组最多人数\n以逗号分隔。例：3,5',
  `group_opening` int(11) DEFAULT NULL COMMENT '开通分组的标志，标志是否教师是否已经开通分组',
  `teacher_course_group_id` varchar(40) NOT NULL,
  `group_open_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`teacher_course_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_course_group_table`
--

LOCK TABLES `teacher_course_group_table` WRITE;
/*!40000 ALTER TABLE `teacher_course_group_table` DISABLE KEYS */;
INSERT INTO `teacher_course_group_table` VALUES ('1234','3685ab9a-dc59-4b9f-adeb-a2edfb0cd670','3,6',1,'703b0a18-9e68-45d9-a163-8ad6af402ee2',NULL);
/*!40000 ALTER TABLE `teacher_course_group_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_course_homework_table`
--

DROP TABLE IF EXISTS `teacher_course_homework_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_course_homework_table` (
  `t_id` varchar(40) NOT NULL,
  `c_id` varchar(40) NOT NULL,
  `homework_id` varchar(40) NOT NULL,
  `homework_publish_status` int(11) DEFAULT NULL COMMENT '作业发布状态（发布/未发布）',
  PRIMARY KEY (`t_id`,`c_id`,`homework_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_course_homework_table`
--

LOCK TABLES `teacher_course_homework_table` WRITE;
/*!40000 ALTER TABLE `teacher_course_homework_table` DISABLE KEYS */;
INSERT INTO `teacher_course_homework_table` VALUES ('1234','ae70ec5c-0a61-4275-ae7d-ad247154155b','0e5e5eda-5500-4c32-9999-916e76fe2975',0),('1234','ae70ec5c-0a61-4275-ae7d-ad247154155b','1f0b3bf0-0295-48ed-af7e-8b4243aaac0b',0),('1234','ae70ec5c-0a61-4275-ae7d-ad247154155b','39f7d56c-5d76-4222-9423-5f5903386c9f',0),('1234','ae70ec5c-0a61-4275-ae7d-ad247154155b','679c4a70-02df-4679-9a99-3fa2b9d1c401',0),('1234','ae70ec5c-0a61-4275-ae7d-ad247154155b','73caab8b-de4a-401c-93fc-cf52719c372d',0),('1234','f0fd9862-c035-48f1-a2c0-6e91d618c61c','0228f8fc-18fc-4261-8dee-189fa2f9304c',0),('1234','f0fd9862-c035-48f1-a2c0-6e91d618c61c','3b1b6a8a-917a-4ab1-9720-6f54edc3e09a',0),('1234','f0fd9862-c035-48f1-a2c0-6e91d618c61c','ae678dc6-784f-455e-9f82-7948d86e2e2f',0);
/*!40000 ALTER TABLE `teacher_course_homework_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_course_resource_table`
--

DROP TABLE IF EXISTS `teacher_course_resource_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_course_resource_table` (
  `t_id` varchar(45) NOT NULL,
  `c_id` varchar(45) NOT NULL,
  `resource_id` varchar(45) NOT NULL,
  PRIMARY KEY (`t_id`,`c_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='该表用于关联老师、课程和资源三方关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_course_resource_table`
--

LOCK TABLES `teacher_course_resource_table` WRITE;
/*!40000 ALTER TABLE `teacher_course_resource_table` DISABLE KEYS */;
INSERT INTO `teacher_course_resource_table` VALUES ('1234','ae70ec5c-0a61-4275-ae7d-ad247154155b','02ddb985-faf7-4346-8b42-6ea71375550f'),('1234','ae70ec5c-0a61-4275-ae7d-ad247154155b','0e563a95-4f0f-4062-abcf-9e74a73e614f'),('1234','ae70ec5c-0a61-4275-ae7d-ad247154155b','f9c86996-106c-4098-93b9-fc089a871f78');
/*!40000 ALTER TABLE `teacher_course_resource_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_info`
--

DROP TABLE IF EXISTS `teacher_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_info` (
  `t_id` varchar(40) NOT NULL,
  `t_name` varchar(50) NOT NULL,
  `t_school` varchar(100) DEFAULT NULL,
  `t_password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_info`
--

LOCK TABLES `teacher_info` WRITE;
/*!40000 ALTER TABLE `teacher_info` DISABLE KEYS */;
INSERT INTO `teacher_info` VALUES ('1234','小娜','广外','12345678');
/*!40000 ALTER TABLE `teacher_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_summary`
--

DROP TABLE IF EXISTS `teacher_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_summary` (
  `summary_request_time` varchar(45) DEFAULT NULL,
  `open_class_id` varchar(45) DEFAULT NULL,
  `teacher_summary_id` varchar(45) NOT NULL,
  PRIMARY KEY (`teacher_summary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='老师-反馈记录信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_summary`
--

LOCK TABLES `teacher_summary` WRITE;
/*!40000 ALTER TABLE `teacher_summary` DISABLE KEYS */;
INSERT INTO `teacher_summary` VALUES ('2017-04-25 15:19:49','54a7e6d0-418b-4909-9ac4-283ba576a330','0280f5c4-f8d2-4add-a654-5dbca7b7ee0b'),('2017-04-25 15:03:26','08b36f0e-c7ca-4c80-aac3-2daa9c435f81','031409fa-7951-4a57-94c2-443755002702'),('2017-04-25 14:54:24','3802397e-6d47-446c-ba57-eb8afaf30584','26552228-68b2-4427-a27e-7a42b90098ed'),('2017-04-25 14:52:49','7ab13b72-5d88-4ccd-9653-a40a02845568','585f9b68-b6a6-4e90-955d-b0f91ad2bbf7'),('2017-04-25 15:11:58','0869ebb4-8d8d-45a5-aaa8-0e1a5db820db','70b10725-8585-4980-816d-f10f1746c42d');
/*!40000 ALTER TABLE `teacher_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tree_info`
--

DROP TABLE IF EXISTS `tree_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tree_info` (
  `tree_id` varchar(40) NOT NULL,
  `tree_status` int(11) NOT NULL COMMENT '成长树状态（0=种子，1=幼苗发育期，2=幼苗成熟期，3=大树发育期，4=大树成熟期）',
  `tree_soil` int(11) NOT NULL COMMENT '现在拥有的土壤数（不包括已投入种植的）',
  `tree_water` int(11) NOT NULL COMMENT '现在拥有的水因子数（不包括已投入种植的）',
  `tree_sun` int(11) NOT NULL COMMENT '现在拥有的阳光因子数（不包括已投入种植的）',
  `tree_sun_used_num` int(11) DEFAULT NULL,
  `tree_water_used_num` int(11) DEFAULT NULL,
  `tree_soil_used_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`tree_id`),
  UNIQUE KEY `tree_id_UNIQUE` (`tree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tree_info`
--

LOCK TABLES `tree_info` WRITE;
/*!40000 ALTER TABLE `tree_info` DISABLE KEYS */;
INSERT INTO `tree_info` VALUES ('0f592242-6fee-4a64-ac65-121c06c2b285',0,0,0,0,0,0,0),('100214ae-3c81-4b84-9e45-f4cc65ca13cd',0,0,0,0,0,0,0),('28e1b898-b942-4c7b-b6a7-3f1758479b8b',0,0,0,0,NULL,NULL,NULL),('2e781a3e-c56c-4d4a-b598-be467fa4e978',0,0,0,0,NULL,NULL,NULL),('309694e1-677f-492d-9a49-7a2763bae300',0,0,0,0,NULL,NULL,NULL),('33c2146b-10df-4373-a802-b78878397d67',0,0,0,0,0,0,0),('3b39aaa1-c44d-4c11-82c3-b8ff6ae261ef',0,0,0,0,NULL,NULL,NULL),('3f34c3af-eb67-43d3-9e61-7b193ef7d31f',0,0,0,0,NULL,NULL,NULL),('55e768fd-9b66-4999-9a2d-9ff927d166f2',0,0,0,0,0,0,0),('56e768e7-bc73-47b4-b648-cde9e3b8711c',0,0,0,0,0,0,0),('6149a89f-7334-43ff-b10b-0ff2b81bc51c',0,0,0,0,0,0,0),('63bb22f7-3995-427e-a028-68dbc716761f',0,0,0,0,NULL,NULL,NULL),('7f170b9d-c9a0-4068-bc7d-c6f0bc89563a',0,0,0,0,NULL,NULL,NULL),('7f33716e-00e2-439d-8f32-90fd26d5b5a5',0,0,0,0,NULL,NULL,NULL),('8161ac60-0554-48a8-8566-1c439d0e5f8a',0,0,0,0,NULL,NULL,NULL),('9322de55-87f8-4bc9-b1b9-dd4656e8c548',0,0,0,0,NULL,NULL,NULL),('96d15f7e-ea74-4aa0-9f99-9011684e0749',0,0,0,0,NULL,NULL,NULL),('ab1dfd1a-4295-4bd2-a22e-808d781abcbb',0,0,0,0,NULL,NULL,NULL),('aed3dc9a-9dad-43d0-b337-10c5117a96ac',0,0,0,0,NULL,NULL,NULL),('b6a86f79-4577-4128-92d4-cded224712f9',0,0,0,0,NULL,NULL,NULL),('bb21292d-2666-4902-8a62-e34caf362c5e',0,0,0,0,NULL,NULL,NULL),('e052cf95-9b48-47f5-afda-6ff5c140e4da',0,0,0,0,0,0,0),('e18fca35-60c0-4892-9d31-697228936c80',0,0,0,0,NULL,NULL,NULL),('f335dcfc-0278-4b22-85cd-1f90ce147611',0,0,0,0,NULL,NULL,NULL),('f3ae98e5-5672-4db4-a06f-eceee93a8619',0,0,0,0,NULL,NULL,NULL),('f512b9c2-d313-4af8-a3b5-aa8a4012b957',0,0,0,0,NULL,NULL,NULL),('f6a09d8a-f624-412b-b353-97890595912c',0,0,0,0,NULL,NULL,NULL),('f7471cc8-4a9a-471f-af28-51b1ff19f164',0,0,0,0,NULL,NULL,NULL),('f7484447-e27a-4cee-bdc9-763d382ba5c1',0,0,0,0,NULL,NULL,NULL),('f860de70-ca90-4b6f-a748-348e459ab2be',0,0,0,0,NULL,NULL,NULL),('fb84d263-d0f8-430a-9fb5-d0568d6769dc',0,0,0,0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tree_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-26 15:21:05
