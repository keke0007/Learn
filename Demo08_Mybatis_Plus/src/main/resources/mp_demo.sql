/*
Navicat MySQL Data Transfer

Source Server         : window
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : mp_demo

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-09-08 17:29:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `class_id` varchar(50) NOT NULL COMMENT '班级主键',
  `class_name` varchar(50) DEFAULT NULL COMMENT '班级名称',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('1', '计算机科学与技术');
INSERT INTO `t_class` VALUES ('2', '软件工程');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(255) NOT NULL COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `class_id` varchar(255) DEFAULT NULL COMMENT '班级外键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'Jone', '18', 'test1@baomidou.com', '1');
INSERT INTO `t_user` VALUES ('2', 'Jack', '20', 'test2@baomidou.com', '1');
INSERT INTO `t_user` VALUES ('3', 'Tom', '28', 'test3@baomidou.com', '1');
INSERT INTO `t_user` VALUES ('4', 'Sandy', '21', 'test4@baomidou.com', '2');
INSERT INTO `t_user` VALUES ('5', 'Billie', '24', 'test5@baomidou.com', '2');
