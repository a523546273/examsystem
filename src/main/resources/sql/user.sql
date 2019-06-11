/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2019-06-11 17:46:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `loginname` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `slat` varchar(4) NOT NULL DEFAULT '加盐因子',
  `user_type` varchar(1) DEFAULT NULL COMMENT '用户类型',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `telephone` varchar(20) DEFAULT NULL COMMENT '座机号',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `mobile_phone` varchar(200) DEFAULT NULL COMMENT '手机号',
  `fax` varchar(255) DEFAULT NULL COMMENT '传真',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(255) DEFAULT NULL COMMENT 'qq',
  `status` varchar(2) DEFAULT NULL COMMENT '业务状态',
  `organid` int(20) DEFAULT NULL COMMENT '组织id',
  `bindip` varchar(255) DEFAULT NULL COMMENT '绑定IP',
  `validity` varchar(255) DEFAULT NULL COMMENT '有效性',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` int(11) DEFAULT NULL COMMENT '创建人',
  `modifydate` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`userid`),
  KEY `fk_user_organid` (`organid`)
) ENGINE=MyISAM AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '123456', 'qwer', null, null, null, null, null, '15167122048', null, null, null, '1', null, null, null, null, null, null, null);
