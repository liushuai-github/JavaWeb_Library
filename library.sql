/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.5.28 : Database - library
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `library`;

/*Table structure for table `huanshu` */

DROP TABLE IF EXISTS `huanshu`;

CREATE TABLE `huanshu` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `uid` int(5) NOT NULL,
  `library_id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `jieshu` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `huanshu` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hs_id` (`library_id`),
  KEY `uid1` (`uid`),
  CONSTRAINT `uid1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `huanshu` */

insert  into `huanshu`(`id`,`uid`,`library_id`,`jieshu`,`huanshu`) values 
(6,1,'s1001','2021-12-03','2021-12-03'),
(7,1,'s1001','2021-12-03','2021-12-03'),
(8,1,'s1004','2021-12-03','2021-12-03'),
(9,1,'s1001','111','2021-12-03'),
(10,1,'s1001','2021-12-03','2021-12-03'),
(11,1,'s1004','2021-12-03','2021-12-03'),
(12,1,'1007','2021-12-03','2021-12-03'),
(13,1,'1007','2021-12-03','2021-12-03'),
(14,1,'1007','2021-12-03','2021-12-03'),
(15,1,'s1002','2021-12-03','2021-12-03'),
(16,1,'s1003','2021-12-03','2021-12-03'),
(17,1,'s1006','2021-12-03','2021-12-03'),
(18,1,'s1005','2021-12-03','2021-12-03'),
(19,1,'s1001','2021-12-03','2021-12-03'),
(20,1,'1007','2021-12-03','2021-12-03'),
(21,1,'s1002','2021-12-03','2021-12-03'),
(22,1,'s1006','2021-12-03','2021-12-03'),
(23,1,'s1003','2021-12-03','2021-12-03'),
(24,1,'s1006','2021-12-03','2021-12-03'),
(25,1,'s1001','2021-12-03','2021-12-03'),
(26,1,'s1004','2021-12-03','2021-12-03'),
(27,1,'s1002','2021-12-03','2021-12-03'),
(28,1,'1007','2021-12-03','2021-12-03'),
(29,1,'s1001','2021-12-03','2021-12-03'),
(30,1,'s1002','2021-12-03','2021-12-03'),
(31,1,'s1003','2021-12-03','2021-12-03'),
(32,1,'s1005','2021-12-03','2021-12-03'),
(33,1,'s1001','2021-12-03','2021-12-03'),
(34,1,'s1001','2021-12-03','2021-12-03'),
(35,1,'s1004','2021-12-03','2021-12-03'),
(36,1,'s1001','2021-12-03','2021-12-03'),
(37,1,'s1006','2021-12-03','2021-12-03'),
(38,1,'1007','2021-12-03','2021-12-03'),
(39,2,'s1001','2021-12-04','2021-12-04'),
(40,2,'s1001','2021-12-04','2021-12-04'),
(41,2,'s1002','111','2021-12-04'),
(42,2,'s1001','2021-12-05','2021-12-05'),
(43,2,'s1001','2021-12-05','2021-12-05');

/*Table structure for table `jieshu` */

DROP TABLE IF EXISTS `jieshu`;

CREATE TABLE `jieshu` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `uid` int(5) DEFAULT '0',
  `library_id` varchar(10) COLLATE utf8_unicode_ci DEFAULT '0',
  `jieshu` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `li_id` (`library_id`),
  KEY `uid` (`uid`),
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `jieshu` */

insert  into `jieshu`(`id`,`uid`,`library_id`,`jieshu`) values 
(53,2,'s1003','2021-12-04'),
(54,2,'s1004','2021-12-04'),
(55,2,'s1005','2021-12-04'),
(57,2,'s1002','2021-12-05'),
(58,2,'s1023','2021-12-05'),
(59,2,'s1027','2021-12-05'),
(61,2,'s1008','2021-12-05'),
(62,1,'s1001','2021-12-10 12:37:56'),
(63,1,'s1004','2021-12-10 12:38:14'),
(64,1,'s1005','2021-12-10 12:38:16'),
(65,1,'s1030','2021-12-10 12:38:25'),
(66,1,'s1029','2021-12-10 12:38:29'),
(67,1,'s1018','2021-12-10 12:38:32'),
(68,1,'s1017','2021-12-10 12:38:36'),
(69,1,'s1016','2021-12-10 12:38:40'),
(70,1,'s1022','2021-12-10 12:38:43'),
(71,1,'s1011','2021-12-10 12:39:03'),
(72,1,'s1021','2021-12-10 12:39:14');

/*Table structure for table `leibie` */

DROP TABLE IF EXISTS `leibie`;

CREATE TABLE `leibie` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `leibie_id` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `library_id` (`leibie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `leibie` */

insert  into `leibie`(`id`,`name`,`leibie_id`) values 
(1,'?????????',1001),
(2,'??????',1003),
(3,'??????',1004),
(4,'??????',1005),
(5,'??????',1006),
(6,'?????????',1007);

/*Table structure for table `library` */

DROP TABLE IF EXISTS `library`;

CREATE TABLE `library` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `library_id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `leibie_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `library_id` (`library_id`),
  UNIQUE KEY `name` (`name`),
  KEY `id_leibie` (`leibie_id`),
  CONSTRAINT `leibie_id` FOREIGN KEY (`leibie_id`) REFERENCES `leibie` (`leibie_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `library` */

insert  into `library`(`id`,`library_id`,`name`,`leibie_id`) values 
(1,'s1001','C??????',1001),
(2,'s1002','Java????????????',1001),
(3,'s1003','????????????',1003),
(4,'s1004','???????????? ',1003),
(5,'s1005','????????????',1003),
(6,'s1006','??????',1003),
(9,'s1007','????????????',1003),
(10,'s1008','????????????',1004),
(44,'s1009','????????????',1004),
(45,'s1010','?????????',1004),
(46,'s1011','?????????',1004),
(47,'s1012','?????????',1004),
(48,'s1013','?????????',1004),
(49,'s1014','?????????????????????',1005),
(50,'s1015','?????????',1005),
(51,'s1016','?????????????????????',1005),
(52,'s1017','????????????',1005),
(53,'s1018','????????????',1005),
(54,'s1019','?????????',1004),
(55,'s1020','???????????????',1004),
(56,'s1021','???????????????',1004),
(57,'s1022','????????????',1004),
(58,'s1023','????????????',1004),
(61,'s1024','????????????',1004),
(62,'s1025','???????????????',1004),
(63,'s1026','????????????',1006),
(64,'s1027','????????????',1006),
(65,'s1028','???????????????',1006),
(67,'s1029','????????????',1006),
(68,'s1030','????????????',1006);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `uzh` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `upsd` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ugender` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`uid`,`uname`,`uzh`,`upsd`,`ugender`) values 
(1,'??????','1906175472','123456',''),
(2,'??????','1111111','123456',''),
(3,'?????????','4312311','123456',''),
(4,'??????','1231','12311111',''),
(5,'??????2','ceshi2','123','???'),
(6,'aaaaaa','aaaaaaaaaaaa','aaaaaa','???'),
(8,'aaaaaa','1111111a','aaaaaaaaa','???');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
