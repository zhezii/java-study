-- 创建数据库
drop database `javastudy` IF exists `javastudy`;
CREATE DATABASE javastudy;
-- 使用数据库
use javastudy;
-- 创建用户表
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `username` varchar(64) DEFAULT NULL,
                           `password` varchar(64) DEFAULT NULL,
                           `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
                           `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='后台用户表';


DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
                                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                         `user_id` bigint(20) DEFAULT NULL,
                                         `role_id` bigint(20) DEFAULT NULL,
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='后台用户和角色关系表';


DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
                                `name` varchar(100) DEFAULT NULL COMMENT '名称',
                                `value` varchar(200) DEFAULT NULL COMMENT '权限值',
                                `type` int(1) DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
                                `url` varchar(200) DEFAULT NULL COMMENT '前端资源路径',
                                `status` int(1) NOT NULL DEFAULT '1' COMMENT '启用状态；0->禁用；1->启用',
                                `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='后台权限表';


-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `name` varchar(100) DEFAULT NULL COMMENT '名称',
                          `description` varchar(500) DEFAULT NULL COMMENT '描述',
                          `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='后台角色表';


-- ----------------------------
-- Table structure for t_user_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
                                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                              `role_id` bigint(20) DEFAULT NULL,
                                              `permission_id` bigint(20) DEFAULT NULL,
                                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='后台用户角色和权限关系表';

INSERT INTO `t_user` (`id`,`username`,`password`,`nick_name`) VALUES ('1', 'admin', 'd3c59d25033dbf980d29554025c23a75','管理员');
INSERT INTO `t_permission` (`id`,`name`,`pid`,`value`,`type`,`url`) VALUES (1,'用户管理',0,'user:view',0,'user/userList');
INSERT INTO `t_permission` (`id`,`name`,`pid`,`value`,`type`,`url`) VALUES (2,'用户添加',1,'user:add',1,'user/userAdd');
INSERT INTO `t_permission` (`id`,`name`,`pid`,`value`,`type`,`url`) VALUES (3,'用户删除',1,'user:del',1,'user/userDel');
INSERT INTO `t_role` (`id`,`description`,`name`) VALUES (1,'管理员','admin');
INSERT INTO `t_role` (`id`,`description`,`name`) VALUES (2,'VIP会员','vip');
INSERT INTO `t_role` (`id`,`description`,`name`) VALUES (3,'test','test');
INSERT INTO `t_role_permission` (`permission_id`,`role_id`) VALUES (1,1);
INSERT INTO `t_role_permission` (`permission_id`,`role_id`) VALUES (2,1);
INSERT INTO `t_role_permission` (`permission_id`,`role_id`) VALUES (3,2);
INSERT INTO `t_user_role` (`role_id`,`user_id`) VALUES (1,1);