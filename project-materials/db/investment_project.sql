/*
SQLyog Ultimate v8.55 
MySQL - 5.5.5-10.1.34-MariaDB : Database - debsoftbd_friends_investment
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `pk_app_users` */

DROP TABLE IF EXISTS `pk_app_users`;

CREATE TABLE `pk_app_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `name` varchar(192) NOT NULL,
  `email` varchar(192) DEFAULT NULL,
  `password` varchar(65) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` text,
  `role_id` int(3) DEFAULT NULL,
  `user_type` enum('user','admin','superAdmin') DEFAULT 'user',
  `created_by` int(3) DEFAULT NULL,
  `creation_date` date NOT NULL,
  `current_status` enum('active','inactive') DEFAULT 'active',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Phone` (`phone`),
  UNIQUE KEY `username` (`username`),
  KEY `FK_role` (`role_id`),
  CONSTRAINT `FK_role` FOREIGN KEY (`role_id`) REFERENCES `pkn_app_roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `pk_app_users` */

insert  into `pk_app_users`(`id`,`username`,`name`,`email`,`password`,`phone`,`address`,`role_id`,`user_type`,`created_by`,`creation_date`,`current_status`) values (1,'01717457174','Palash','palash.ict08@yahoo.com','$2a$05$lrk4tq6opQZj5OtI6m4Hp.ALr61SWvI/7xAsY1u59eWPYeLDDaiGS','01717457174','Shewrapara, Mirpur',1,'superAdmin',1,'2018-11-27','active');

/*Table structure for table `pkn_app_modules` */

DROP TABLE IF EXISTS `pkn_app_modules`;

CREATE TABLE `pkn_app_modules` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(132) DEFAULT NULL,
  `module_purpose` varchar(255) DEFAULT NULL,
  `created_by` int(3) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `current_status` enum('active','inactive') NOT NULL DEFAULT 'active',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pkn_app_modules` */

/*Table structure for table `pkn_app_permissions` */

DROP TABLE IF EXISTS `pkn_app_permissions`;

CREATE TABLE `pkn_app_permissions` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `user_id` int(3) DEFAULT NULL,
  `module_id` int(3) NOT NULL,
  `role_id` int(3) DEFAULT NULL,
  `permission_level` tinyint(1) NOT NULL,
  `created_by` int(3) DEFAULT NULL,
  `creation_date` date NOT NULL,
  `current_status` enum('active','inactive') NOT NULL DEFAULT 'active',
  PRIMARY KEY (`id`),
  KEY `FK_pkn_app_modules` (`module_id`),
  KEY `FK_pkn_app_role` (`role_id`),
  KEY `FK_pkn_app_users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pkn_app_permissions` */

/*Table structure for table `pkn_app_roles` */

DROP TABLE IF EXISTS `pkn_app_roles`;

CREATE TABLE `pkn_app_roles` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) NOT NULL,
  `role_purpose` varchar(255) DEFAULT NULL,
  `created_by` int(3) DEFAULT NULL,
  `creation_date` date NOT NULL,
  `current_status` enum('active','inactive') DEFAULT 'active',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `pkn_app_roles` */

insert  into `pkn_app_roles`(`id`,`role_name`,`role_purpose`,`created_by`,`creation_date`,`current_status`) values (1,'superAdmin','Have all privileges',1,'2018-11-27','active');
insert  into `pkn_app_roles`(`id`,`role_name`,`role_purpose`,`created_by`,`creation_date`,`current_status`) values (2,'admin','Have most of privileges',1,'2018-11-27','active');
insert  into `pkn_app_roles`(`id`,`role_name`,`role_purpose`,`created_by`,`creation_date`,`current_status`) values (3,'user','specific module privileges',1,'2018-11-27','active');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
