/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2019-06-11 17:46:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `menu_resource`
-- ----------------------------
DROP TABLE IF EXISTS `menu_resource`;
CREATE TABLE `menu_resource` (
  `menuid` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单标识',
  `parentmenuid` int(11) DEFAULT NULL COMMENT '父菜单',
  `code` varchar(100) DEFAULT NULL COMMENT '代码',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `description` varchar(300) DEFAULT NULL COMMENT '描述',
  `url` varchar(300) DEFAULT NULL COMMENT '链接',
  `priority` int(11) DEFAULT NULL COMMENT '优先级',
  `status` varchar(1) DEFAULT '1',
  `removed` varchar(1) DEFAULT NULL COMMENT '删除标志',
  `menutype` varchar(1) DEFAULT NULL COMMENT '菜单类型',
  `allowcustom` varchar(1) DEFAULT NULL COMMENT '是否允许自定义菜单(0 不支持， 1支持 )',
  `icon` varchar(50) DEFAULT NULL,
  `levels` varchar(255) DEFAULT NULL COMMENT '树的层级',
  PRIMARY KEY (`menuid`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_resource
-- ----------------------------
INSERT INTO `menu_resource` VALUES ('25', '24', '12100000', '对象管理', '', '', '1', '1', '0', '1', null, '&#xe70b;', '1');
INSERT INTO `menu_resource` VALUES ('26', '24', '12200000', '资源管理', '', '', '2', '1', '0', '1', null, '&#xe696;', '1');
INSERT INTO `menu_resource` VALUES ('27', '24', '12300000', '权限管理', '', '', '3', '1', '0', '1', null, '&#xe6ae;', '1');
INSERT INTO `menu_resource` VALUES ('28', '25', '12110000', '用户管理', '', 'user/user_main', '1', '1', '0', '1', null, '', '1');
INSERT INTO `menu_resource` VALUES ('30', '25', '12120000', '角色管理', '', 'role/role_main', '2', '1', '0', '1', null, null, '2');
INSERT INTO `menu_resource` VALUES ('31', '25', '12130000', '组织管理', '', 'organ/organ_main', '3', '1', '0', '1', null, null, '2');
INSERT INTO `menu_resource` VALUES ('32', '26', '12210000', '菜单管理', '', 'menu/menu_main', '1', '1', '0', '1', null, null, '2');
INSERT INTO `menu_resource` VALUES ('33', '27', '12310000', '用户权限管理', '', '', '1', '1', '0', '1', null, null, '2');
INSERT INTO `menu_resource` VALUES ('34', '27', '12320000', '角色权限管理', '', 'permission/role_menu_main', '2', '1', '0', '1', null, null, '2');
INSERT INTO `menu_resource` VALUES ('35', '27', '12330000', '用户角色管理', '', 'permission/role_user_main', '3', '1', '0', '1', null, null, '2');
INSERT INTO `menu_resource` VALUES ('36', '2', '11100000', '我的买家库', '', '', '1', '1', '0', '1', null, '&#xe6f5;', '1');
INSERT INTO `menu_resource` VALUES ('37', '2', '11200000', '产品管理', '', '', '2', '1', '0', '1', null, '&#xe6f6;', '1');
INSERT INTO `menu_resource` VALUES ('38', '37', '11210000', '我的产品', '', '', '1', '1', '0', '1', null, '', '2');
INSERT INTO `menu_resource` VALUES ('40', '37', '11220000', '产品发布', '', '', '2', '1', '0', '1', null, '', '2');
