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

 Date: 17/09/2018 09:31:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ke_user
-- ----------------------------
DROP TABLE IF EXISTS `ke_user`;
CREATE TABLE `ke_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账户',
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `account_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `email` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `phone_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `avatar` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像路径',
  `login_error_tale` int(255) NULL DEFAULT NULL COMMENT '登录失败次数',
  `login_time` bigint(20) NULL DEFAULT NULL COMMENT '上次登录时间',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号标识',
  `ts` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_phone_number`(`phone_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '\'sys.x$waits_global_by_latency\' is not BASE TABLE' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ke_user
-- ----------------------------
INSERT INTO `ke_user` VALUES (1, 'admin', 'admin', '12121', NULL, NULL, NULL, 0, 1536893765705, '0', '2018-08-21 18:45:09');

SET FOREIGN_KEY_CHECKS = 1;
