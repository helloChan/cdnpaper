CREATE TABLE role(
id varchar(255) NOT NULL COMMENT '标识符',
name varchar(255) NOT NULL COMMENT '名称',
description varchar(255) NOT NULL COMMENT '描述',
level int(11) NOT NULL DEFAULT '1' COMMENT '等级(排序)',
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;