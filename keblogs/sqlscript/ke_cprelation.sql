/*
 Navicat Premium Data Transfer

 Source Server         : yjytke
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : yjytke

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 17/09/2018 09:31:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ke_cprelation
-- ----------------------------
DROP TABLE IF EXISTS `ke_cprelation`;
CREATE TABLE `ke_cprelation`  (
  `contentid` int(11) NOT NULL,
  `propertiesid` int(11) NOT NULL,
  `userid` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '\'sys.x$waits_global_by_latency\' is not BASE TABLE' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ke_cprelation
-- ----------------------------
INSERT INTO `ke_cprelation` VALUES (17, 13, 1);
INSERT INTO `ke_cprelation` VALUES (17, 14, 1);
INSERT INTO `ke_cprelation` VALUES (17, 10, 1);
INSERT INTO `ke_cprelation` VALUES (23, 22, 1);
INSERT INTO `ke_cprelation` VALUES (23, 8, 1);
INSERT INTO `ke_cprelation` VALUES (24, 8, 1);
INSERT INTO `ke_cprelation` VALUES (25, 8, 1);
INSERT INTO `ke_cprelation` VALUES (26, 10, 1);
INSERT INTO `ke_cprelation` VALUES (28, 23, 1);
INSERT INTO `ke_cprelation` VALUES (28, 10, 1);
INSERT INTO `ke_cprelation` VALUES (29, 8, 1);
INSERT INTO `ke_cprelation` VALUES (30, 8, 1);
INSERT INTO `ke_cprelation` VALUES (31, 8, 1);

SET FOREIGN_KEY_CHECKS = 1;
