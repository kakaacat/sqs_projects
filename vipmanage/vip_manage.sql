/*
SQLyog Professional v12.09 (64 bit)
MySQL - 10.4.11-MariaDB : Database - vip_manage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vip_manage` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vip_manage`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`password`) values (1,'kaka','123');

/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `action` varchar(100) NOT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

/*Data for the table `log` */

insert  into `log`(`id`,`user_name`,`action`,`time`) values (46,'kaka','查看店铺信息','2020-07-05 13:48:03');

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `boss` varchar(20) DEFAULT NULL,
  `boss_tel` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `store` */

insert  into `store`(`id`,`address`,`boss`,`boss_tel`,`remark`) values (1,'西安','孙鑫言','13851385906','收入增高'),(2,'北京','孙岩','15897564873','无'),(3,'上海','王海','11251367890','无'),(4,'天津','彭万里','17567908635','收入降低'),(5,'南京','林莽','13356809765','无'),(6,'广州','马宏宇','18568795673','收入增高'),(7,'深圳','章汉夫','14364752868','无'),(8,'成都','谢大海','12567987456','无'),(9,'苏州','范长江','15956835785','无'),(10,'郑州','林君雄','13890764362','收入降低'),(11,'兰州','李中','150798346123','收入一直很高');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vip_id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `gender` varchar(4) DEFAULT NULL,
  `telphone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `exp` int(11) NOT NULL,
  `point` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`vip_id`,`name`,`password`,`gender`,`telphone`,`email`,`birthday`,`start_time`,`end_time`,`status`,`level`,`exp`,`point`) values (1,20200601,'裴钰','1001','女','14454986502','a@163.com','2000-01-01 00:00:00','2015-01-01 00:00:00','2020-03-04 00:00:00',0,5,100,10000),(2,20200602,'陶红万','1002','男','16779075246','b@163.com','2000-02-10 00:00:00','2015-02-01 00:00:00','2020-06-10 00:00:00',2,3,80,5000),(3,20200603,'唐转斌','1003','男','13725935370','c@163.com','1998-03-15 00:00:00','2018-10-17 00:00:00','2020-02-28 00:00:00',1,4,60,3000),(4,20200604,'黄飞','1004','男','15637252964','d@163.com','1995-05-26 00:00:00','2017-05-27 00:00:00','2019-11-25 00:00:00',3,6,120,12000),(5,20200605,'张颖','1005','女','16324980475','e@163.com','2002-10-24 00:00:00','2016-11-20 00:00:00','2019-05-20 00:00:00',0,2,80,8000),(6,20200606,'丁雪雪','1006','女','14537253654','f@163.com','2001-08-10 00:00:00','2017-10-10 00:00:00','2020-02-23 00:00:00',2,1,70,4000),(7,20200607,'杨天波','1007','男','12549464750','g@163.com','1999-02-19 00:00:00','2015-04-07 00:00:00','2020-05-30 00:00:00',0,4,90,10000),(8,20200608,'徐亚玲','1008','女','12752845485','h@126.com','1998-12-24 00:00:00','2017-09-27 00:00:00','2019-12-22 00:00:00',3,5,110,11500),(9,20200609,'许飞','1009','男','15472528654','w@126.com','2002-10-29 00:00:00','2016-11-22 00:00:00','2020-04-28 00:00:00',1,4,95,10000),(10,20200610,'曾辉','1010','男','12628442634','q@126.com','2000-11-16 00:00:00','2018-02-17 00:00:00','2020-03-26 00:00:00',0,6,130,20000),(11,20200611,'小魏','1011','男','12345678910','w@163.com','2020-06-29 19:38:01','2020-06-29 19:38:06','2023-06-01 19:38:08',0,5,100,50000),(15,20200612,'李中','123','男','234567','123','2020-07-03 11:19:01','2020-07-03 11:19:01','2021-03-01 11:05:05',2,5,90,10000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
