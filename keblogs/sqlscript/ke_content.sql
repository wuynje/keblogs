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

 Date: 17/09/2018 09:31:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ke_content
-- ----------------------------
DROP TABLE IF EXISTS `ke_content`;
CREATE TABLE `ke_content`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(255) NULL DEFAULT NULL COMMENT '用户id',
  `btype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容类别id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `titlePic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题图片',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `style` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章类别,分为博文,生活',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章状态,草稿发布',
  `tags` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章简单描述',
  `created` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `modifiedtime` bigint(20) NULL DEFAULT NULL COMMENT '修改时间',
  `hits` int(255) NULL DEFAULT NULL COMMENT '点击次数',
  `allowComment` int(255) NULL DEFAULT NULL COMMENT '是否允许评论',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '\'sys.x$waits_global_by_latency\' is not BASE TABLE' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ke_content
-- ----------------------------
INSERT INTO `ke_content` VALUES (17, 1, 'blog', '粉丝丰富', 'https://keblog-1252041665.cos.ap-beijing.myqcloud.com/2018/09/1536133742499TLhndblB67.jpg', '### 纷纷从被除数的午饭\r\n*大声道*\r\n第三方第三方- \r\n```java\r\n	public void doAction(ActionEvent e) throws Exception {\r\n		FuncletDialog fd = new FuncletDialog(model.getContext().getEntranceUI());\r\n		Map<String, String> data = new HashMap<String, String>();\r\n		String pk_pretemset = getToppanel().getPk_pretemset();\r\n		String start_date = getToppanel().getStart_date()==null?\"\":getToppanel().getStart_date().toStdString();\r\n		String end_date = getToppanel().getEnd_date()==null?\"\":getToppanel().getEnd_date().toStdString();\r\n		data.put(\"pk_pretemset\", pk_pretemset);\r\n		data.put(\"type\", PocHistRateListener.LOANTYPE);\r\n		String sql = \"select max(data_date) as data_date from poc_history_rate where\"\r\n				+ \" pk_pretemset = \'\"+pk_pretemset+\"\' and nvl(dr,0)=0 and \"\r\n						+ \" data_date between \'\"+start_date+\"\' and \'\"+end_date+\"\'\";\r\n		String data_date  = (String) NCLocator.getInstance().lookup(IUAPQueryBS.class).executeQuery(sql, new ColumnProcessor(\"data_date\"));\r\n		data.put(\"data_date\", data_date);\r\n		FuncletInitData f= new FuncletInitData();\r\n		f.setInitData(data);\r\n		fd.setTitle(\"历史价格查看\");\r\n		fd.initUI(model.getContext(),\"nc/ui/fc_map/poc_history_rate/ace/view/Poc_history_rate_config.xml\",f,new Dimension(1200, 650));\r\n		fd.showModal();\r\n	}\r\n```\r\n\r\n\r\n![颠三倒四](https://keblog-1252041665.cos.ap-beijing.myqcloud.com/2018/09/1536133742499TLhndblB67.jpg \"颠三倒四\")', 'blogs', 'publish', 'f,纷纷分', '这是一篇图文博文测试文章', 1536133750438, 1536734434894, 0, 1);
INSERT INTO `ke_content` VALUES (22, 1, NULL, '大声道,,', NULL, '得唔得', 'life', 'publish', NULL, NULL, 1536733649756, NULL, 0, 1);
INSERT INTO `ke_content` VALUES (23, 1, '默认分类', '测试一', 'https://keblog-1252041665.cos.ap-beijing.myqcloud.com/2018/09/15368937828412VmFPg7964.jpg', '讲道理，这篇文字我写了，但是我不知道写它干嘛，阿门\r\n![](https://keblog-1252041665.cos.ap-beijing.myqcloud.com/2018/09/15368937828412VmFPg7964.jpg)', 'blogs', 'publish', '没有标签', '没有简介', 1536893841875, NULL, 0, 1);
INSERT INTO `ke_content` VALUES (24, 1, '默认分类', '测试二', '', '得到', 'blogs', 'publish', '', '打得我', 1536894016071, 1536894048602, 0, 1);
INSERT INTO `ke_content` VALUES (25, 1, '默认分类', '测试三', '', '得的', 'blogs', 'publish', '', '飞飞飞飞', 1536894041241, NULL, 0, 1);
INSERT INTO `ke_content` VALUES (26, 1, 'blog', '测试四', '', '得的', 'blogs', 'publish', '', '分得分', 1536894064087, NULL, 0, 1);
INSERT INTO `ke_content` VALUES (27, 1, NULL, '测试五', '', '粗大的萨芬的', 'life', 'publish', NULL, '车等我等我等我', 1536894078250, NULL, 0, 1);
INSERT INTO `ke_content` VALUES (28, 1, 'blog', '测试六', '', '大萨达', 'blogs', 'publish', '打', '定时达大啊', 1536894124686, NULL, 0, 1);
INSERT INTO `ke_content` VALUES (29, 1, '默认分类', '测试七', '', ' 大萨达大萨达', 'blogs', 'publish', '', 's\'d\'sa\'d\'s\'asdsadsa', 1536894180378, NULL, 0, 1);
INSERT INTO `ke_content` VALUES (30, 1, '默认分类', '测试八', '', '大V防盗网是浮动', 'blogs', 'publish', '', '大萨达撒多', 1536894190864, NULL, 0, 1);
INSERT INTO `ke_content` VALUES (31, 1, '默认分类', '测试9', '', '大萨达撒发放给范德萨的', 'blogs', 'publish', '', '发大萨达撒多', 1536894202773, NULL, 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
