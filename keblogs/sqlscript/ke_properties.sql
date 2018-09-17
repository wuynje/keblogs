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

 Date: 17/09/2018 09:31:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ke_properties
-- ----------------------------
DROP TABLE IF EXISTS `ke_properties`;
CREATE TABLE `ke_properties`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '包含链接，标签，分类等类型，类似自定义档案',
  `rea_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实际内容',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'log等标识图片',
  `sort` int(255) NULL DEFAULT NULL COMMENT '顺序',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '\'sys.x$waits_global_by_latency\' is not BASE TABLE' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ke_properties
-- ----------------------------
INSERT INTO `ke_properties` VALUES (6, 1, 'tag', '纷纷', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (7, 1, 'tag', '菲菲', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (8, 1, 'blogtype', '默认分类', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (9, 1, 'tag', 'efefe', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (10, 1, 'blogtype', 'blog', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (11, 1, 'tag', '单位得我多', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (12, 1, 'tag', 'dwdwad', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (13, 1, 'tag', 'f', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (14, 1, 'tag', '纷纷分', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (15, 1, 'tag', '00000000', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (16, 1, 'tag', 'ccccccc', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (17, 1, 'tag', '丰富的所得税等我但是得分的我单位dd', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (18, 1, 'tag', '分而非而', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (19, 1, 'tag', '丰富而后人', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (20, 1, 'tag', '会让他让他热燕塘乳业', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (21, 1, 'tag', 'fdsf', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (22, 1, 'tag', '没有标签', NULL, 0, NULL);
INSERT INTO `ke_properties` VALUES (23, 1, 'tag', '打', NULL, 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
