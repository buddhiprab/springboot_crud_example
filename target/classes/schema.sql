DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`first_name` varchar(100) DEFAULT NULL,
`last_name` varchar(100) DEFAULT NULL,
`username` varchar(100) DEFAULT NULL,
`created` datetime DEFAULT NULL,
`updated` datetime DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `holding` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`type` varchar(10) DEFAULT NULL,
`amount` DOUBLE (11) DEFAULT NULL,
`owner_id` integer(11) DEFAULT NULL,
`created` datetime DEFAULT NULL,
`updated` datetime DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
