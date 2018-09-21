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

 Date: 17/09/2018 09:31:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ke_file
-- ----------------------------
DROP TABLE IF EXISTS `ke_file`;
CREATE TABLE `ke_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `fname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `ftype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `fkey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `created` bigint(255) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '\'sys.x$waits_global_by_latency\' is not BASE TABLE' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ke_file
-- ----------------------------
INSERT INTO `ke_file` VALUES (7, 1, 'pic10.jpg', 'img', 'https://keblog-1252041665.cos.ap-beijing.myqcloud.com/2018/08/1535704302318eYgCkVQlP3.jpg', 1535704302822);
INSERT INTO `ke_file` VALUES (8, 1, 'pic04.jpg', 'img', 'https://keblog-1252041665.cos.ap-beijing.myqcloud.com/2018/09/15360505358058iabdToBOY.jpg', 1536050536468);
INSERT INTO `ke_file` VALUES (9, 1, 'pic01.jpg', 'img', 'https://keblog-1252041665.cos.ap-beijing.myqcloud.com/2018/09/1536133742499TLhndblB67.jpg', 1536133743049);
INSERT INTO `ke_file` VALUES (10, 1, 'pic13.jpg', 'img', 'https://keblog-1252041665.cos.ap-beijing.myqcloud.com/2018/09/15367334112447NHhAHSSDA.jpg', 1536733411926);
INSERT INTO `ke_file` VALUES (11, 1, 'pic05.jpg', 'img', 'https://keblog-1252041665.cos.ap-beijing.myqcloud.com/2018/09/15368937828412VmFPg7964.jpg', 1536893783486);

SET FOREIGN_KEY_CHECKS = 1;
