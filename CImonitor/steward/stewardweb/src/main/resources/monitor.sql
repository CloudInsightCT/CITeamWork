/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : monitor

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2016-08-19 10:20:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `agent`
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent` (
`userID`  int(11) NOT NULL ,
`agentID`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  int(11) NOT NULL ,
PRIMARY KEY (`agentID`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `agentinfo`
-- ----------------------------
DROP TABLE IF EXISTS `agentinfo`;
CREATE TABLE `agentinfo` (
`agentID`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`os`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`osArc`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`osVersion`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`ip`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`computerName`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`hostName`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`agentID`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `devinfo`
-- ----------------------------
DROP TABLE IF EXISTS `devinfo`;
CREATE TABLE `devinfo` (
`agentID`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`devID`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`devInfo`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`agentID`, `devID`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `flushmetric`
-- ----------------------------
DROP TABLE IF EXISTS `flushmetric`;
CREATE TABLE `flushmetric` (
`agentID`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`tag`  int(2) NOT NULL ,
`metric`  double(20,3) NULL DEFAULT NULL ,
`timestamp`  bigint(20) NULL DEFAULT NULL ,
`devID`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`agentID`, `tag`, `devID`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `metric`
-- ----------------------------
DROP TABLE IF EXISTS `metric`;
CREATE TABLE `metric` (
`agentID`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`tag`  int(2) NULL DEFAULT NULL ,
`metric`  double(20,3) NULL DEFAULT NULL ,
`timestamp`  bigint(20) NULL DEFAULT NULL ,
`devID`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`id`  int(11) NOT NULL AUTO_INCREMENT ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`username`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`email`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Auto increment value for `metric`
-- ----------------------------
ALTER TABLE `metric` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `user`
-- ----------------------------
ALTER TABLE `user` AUTO_INCREMENT=1;
