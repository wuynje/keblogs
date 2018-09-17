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

 Date: 17/09/2018 09:31:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ke_log
-- ----------------------------
DROP TABLE IF EXISTS `ke_log`;
CREATE TABLE `ke_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NULL DEFAULT NULL COMMENT '用户主键',
  `login_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录ip',
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作',
  `ts` bigint(255) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 137 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '\'sys.x$waits_global_by_latency\' is not BASE TABLE' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ke_log
-- ----------------------------
INSERT INTO `ke_log` VALUES (1, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535445432758);
INSERT INTO `ke_log` VALUES (2, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535451455060);
INSERT INTO `ke_log` VALUES (3, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535451520680);
INSERT INTO `ke_log` VALUES (4, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535451542340);
INSERT INTO `ke_log` VALUES (5, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535451889305);
INSERT INTO `ke_log` VALUES (6, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535454247453);
INSERT INTO `ke_log` VALUES (7, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535509984983);
INSERT INTO `ke_log` VALUES (8, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535613397024);
INSERT INTO `ke_log` VALUES (9, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535613611515);
INSERT INTO `ke_log` VALUES (10, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535613643012);
INSERT INTO `ke_log` VALUES (11, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535613686390);
INSERT INTO `ke_log` VALUES (12, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535613898710);
INSERT INTO `ke_log` VALUES (13, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535614038139);
INSERT INTO `ke_log` VALUES (14, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535631681512);
INSERT INTO `ke_log` VALUES (15, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535631874730);
INSERT INTO `ke_log` VALUES (16, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535631917906);
INSERT INTO `ke_log` VALUES (17, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535679614413);
INSERT INTO `ke_log` VALUES (18, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535680153239);
INSERT INTO `ke_log` VALUES (19, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535680325919);
INSERT INTO `ke_log` VALUES (20, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535680449505);
INSERT INTO `ke_log` VALUES (21, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535680914237);
INSERT INTO `ke_log` VALUES (22, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535681038351);
INSERT INTO `ke_log` VALUES (23, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535681147086);
INSERT INTO `ke_log` VALUES (24, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535681261590);
INSERT INTO `ke_log` VALUES (25, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535682514386);
INSERT INTO `ke_log` VALUES (26, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535682714017);
INSERT INTO `ke_log` VALUES (27, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535683043337);
INSERT INTO `ke_log` VALUES (28, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535683402307);
INSERT INTO `ke_log` VALUES (29, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535683741030);
INSERT INTO `ke_log` VALUES (30, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535684197226);
INSERT INTO `ke_log` VALUES (31, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535693632371);
INSERT INTO `ke_log` VALUES (32, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535703169677);
INSERT INTO `ke_log` VALUES (33, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535704286152);
INSERT INTO `ke_log` VALUES (34, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535704951592);
INSERT INTO `ke_log` VALUES (35, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535706023154);
INSERT INTO `ke_log` VALUES (36, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535706188598);
INSERT INTO `ke_log` VALUES (37, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535940644364);
INSERT INTO `ke_log` VALUES (38, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535940859152);
INSERT INTO `ke_log` VALUES (39, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535941171811);
INSERT INTO `ke_log` VALUES (40, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535943704230);
INSERT INTO `ke_log` VALUES (41, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535960246611);
INSERT INTO `ke_log` VALUES (42, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535960349165);
INSERT INTO `ke_log` VALUES (43, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535960592436);
INSERT INTO `ke_log` VALUES (44, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535960751377);
INSERT INTO `ke_log` VALUES (45, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535962796056);
INSERT INTO `ke_log` VALUES (46, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535962958126);
INSERT INTO `ke_log` VALUES (47, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535963995882);
INSERT INTO `ke_log` VALUES (48, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535965447951);
INSERT INTO `ke_log` VALUES (49, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535965738286);
INSERT INTO `ke_log` VALUES (50, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535965822419);
INSERT INTO `ke_log` VALUES (51, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535965951662);
INSERT INTO `ke_log` VALUES (52, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535966032343);
INSERT INTO `ke_log` VALUES (53, 1, '0:0:0:0:0:0:0:1', '后台登录', 1535966599590);
INSERT INTO `ke_log` VALUES (54, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536024446352);
INSERT INTO `ke_log` VALUES (55, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536049371056);
INSERT INTO `ke_log` VALUES (56, 1, '127.0.0.1', '后台登录', 1536049617595);
INSERT INTO `ke_log` VALUES (57, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536049763906);
INSERT INTO `ke_log` VALUES (58, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536050034006);
INSERT INTO `ke_log` VALUES (59, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536050090444);
INSERT INTO `ke_log` VALUES (60, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536050340442);
INSERT INTO `ke_log` VALUES (61, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536051086040);
INSERT INTO `ke_log` VALUES (62, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536051155607);
INSERT INTO `ke_log` VALUES (63, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536051219813);
INSERT INTO `ke_log` VALUES (64, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536057092780);
INSERT INTO `ke_log` VALUES (65, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536058045915);
INSERT INTO `ke_log` VALUES (66, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536058209253);
INSERT INTO `ke_log` VALUES (67, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536058784394);
INSERT INTO `ke_log` VALUES (68, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536063779382);
INSERT INTO `ke_log` VALUES (69, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536063985909);
INSERT INTO `ke_log` VALUES (70, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536111542433);
INSERT INTO `ke_log` VALUES (71, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536132961197);
INSERT INTO `ke_log` VALUES (72, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536133044257);
INSERT INTO `ke_log` VALUES (73, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536133130808);
INSERT INTO `ke_log` VALUES (74, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536133612962);
INSERT INTO `ke_log` VALUES (75, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536135855490);
INSERT INTO `ke_log` VALUES (76, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536138172219);
INSERT INTO `ke_log` VALUES (77, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536290327519);
INSERT INTO `ke_log` VALUES (78, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536543972251);
INSERT INTO `ke_log` VALUES (79, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536545155429);
INSERT INTO `ke_log` VALUES (80, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536545454261);
INSERT INTO `ke_log` VALUES (81, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536548919873);
INSERT INTO `ke_log` VALUES (82, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536549024412);
INSERT INTO `ke_log` VALUES (83, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536549564985);
INSERT INTO `ke_log` VALUES (84, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536549661010);
INSERT INTO `ke_log` VALUES (85, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536552336839);
INSERT INTO `ke_log` VALUES (86, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536553040401);
INSERT INTO `ke_log` VALUES (87, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536553097920);
INSERT INTO `ke_log` VALUES (88, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536553351445);
INSERT INTO `ke_log` VALUES (89, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536561773610);
INSERT INTO `ke_log` VALUES (90, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536561823997);
INSERT INTO `ke_log` VALUES (91, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536645928160);
INSERT INTO `ke_log` VALUES (92, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536646215197);
INSERT INTO `ke_log` VALUES (93, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536647614954);
INSERT INTO `ke_log` VALUES (94, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536648269812);
INSERT INTO `ke_log` VALUES (95, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536655968415);
INSERT INTO `ke_log` VALUES (96, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536664391773);
INSERT INTO `ke_log` VALUES (97, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536664568244);
INSERT INTO `ke_log` VALUES (98, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536664619267);
INSERT INTO `ke_log` VALUES (99, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536664774167);
INSERT INTO `ke_log` VALUES (100, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536668411557);
INSERT INTO `ke_log` VALUES (101, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536717096374);
INSERT INTO `ke_log` VALUES (102, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536731318011);
INSERT INTO `ke_log` VALUES (103, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536734340306);
INSERT INTO `ke_log` VALUES (104, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536739308469);
INSERT INTO `ke_log` VALUES (105, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536739345562);
INSERT INTO `ke_log` VALUES (106, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536743809966);
INSERT INTO `ke_log` VALUES (107, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536744138953);
INSERT INTO `ke_log` VALUES (108, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536744202293);
INSERT INTO `ke_log` VALUES (109, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536744368691);
INSERT INTO `ke_log` VALUES (110, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536744418406);
INSERT INTO `ke_log` VALUES (111, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536744488336);
INSERT INTO `ke_log` VALUES (112, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536802310140);
INSERT INTO `ke_log` VALUES (113, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536816669978);
INSERT INTO `ke_log` VALUES (114, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536816782002);
INSERT INTO `ke_log` VALUES (115, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536818300977);
INSERT INTO `ke_log` VALUES (116, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536819872532);
INSERT INTO `ke_log` VALUES (117, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536821363931);
INSERT INTO `ke_log` VALUES (118, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536822166470);
INSERT INTO `ke_log` VALUES (119, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536822399049);
INSERT INTO `ke_log` VALUES (120, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536822440574);
INSERT INTO `ke_log` VALUES (121, 1, '127.0.0.1', '后台登录', 1536839563767);
INSERT INTO `ke_log` VALUES (122, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536840002624);
INSERT INTO `ke_log` VALUES (123, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536840603314);
INSERT INTO `ke_log` VALUES (124, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536840694283);
INSERT INTO `ke_log` VALUES (125, 1, '127.0.0.1', '后台登录', 1536840888820);
INSERT INTO `ke_log` VALUES (126, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536841035801);
INSERT INTO `ke_log` VALUES (127, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536841423542);
INSERT INTO `ke_log` VALUES (128, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536889283406);
INSERT INTO `ke_log` VALUES (129, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536889621590);
INSERT INTO `ke_log` VALUES (130, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536892713490);
INSERT INTO `ke_log` VALUES (131, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536892794985);
INSERT INTO `ke_log` VALUES (132, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536892864067);
INSERT INTO `ke_log` VALUES (133, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536892943138);
INSERT INTO `ke_log` VALUES (134, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536893003198);
INSERT INTO `ke_log` VALUES (135, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536893373720);
INSERT INTO `ke_log` VALUES (136, 1, '0:0:0:0:0:0:0:1', '后台登录', 1536893765720);

SET FOREIGN_KEY_CHECKS = 1;
