﻿CREATE TABLE `user` (
  `id` varchar(255) NOT NULL COMMENT '标识符',
  `name` varchar(255) NOT NULL COMMENT '昵称',
  `phone` varchar(11) NOT NULL COMMENT '手机号码',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `gender` tinyint(1) NOT NULL COMMENT '性别',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `regTime` datetime NOT NULL COMMENT '注册时间',
  `verify` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否激活(0：没有，1：有)',
  `visible` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可见(0：不可见，1：可见)',
  `isTeacher` tinyint(1) NOT NULL COMMENT '是否教师(0：不是，1：是)',
  `roleId` varchar(255) NOT NULL COMMENT '角色Id',
  PRIMARY KEY (`id`),
  KEY `user_ibfk_1` (`roleId`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
