CREATE DATABASE  IF NOT EXISTS `legoDB`;

USE `legoDB`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES
(1,'jens@somewhere.com','jensen','customer'),
(2,'ken@somewhere.com','kensen','customer'),
(3,'robin@somewhere.com','batman','employee');
UNLOCK TABLES;

DROP TABLE IF EXISTS `legoDB`.`orders` ;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `length` int NOT NULL,
  `width` int NOT NULL,
  `height` int NOT NULL,
  `users_id` int(11) NOT NULL,
  PRIMARY KEY (orderid),
  FOREIGN KEY (`users_id`) REFERENCES `legoDB`.`users`(id) ON DELETE NO ACTION
)

