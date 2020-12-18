/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : leishi

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 31/10/2020 00:39:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for advance
-- ----------------------------
DROP TABLE IF EXISTS `advance`;
CREATE TABLE `advance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `em_id` int(11) NOT NULL COMMENT '员工id',
  `money` decimal(11, 2) NULL DEFAULT NULL COMMENT '借支金额',
  `audit_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核信息',
  `audit_tag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态：wait--待审核\r\n              pass--审核通过\r\n             noPass--审核不通过',
  `create_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建用户',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改用户，',
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工预支表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of advance
-- ----------------------------
INSERT INTO `advance` VALUES (3, 3, 300.00, 'swagger测试', 'wxj-modify', 'joy', '2020-10-20 15:14:27', 'joy', '2020-10-20 15:15:35');

-- ----------------------------
-- Table structure for bank_info
-- ----------------------------
DROP TABLE IF EXISTS `bank_info`;
CREATE TABLE `bank_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_card` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡号',
  `bank_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行名称',
  `bank_deposit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户行',
  `sign` int(1) NULL DEFAULT NULL COMMENT '1:常用0，备用',
  `bank_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行地址',
  `em_id` int(11) NULL DEFAULT NULL COMMENT '员工id',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '银行卡号信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bank_info
-- ----------------------------
INSERT INTO `bank_info` VALUES (1, '23543453', 'zs', '武汉', 1, '江汉路', 1, '2020-08-16 11:05:47', '2019-03-08 11:29:21');
INSERT INTO `bank_info` VALUES (3, '6226621408215354', 'gs', '江岸支行', 1, '湖北省武汉市江岸区解放大道110号', 8, '2020-10-22 16:44:57', NULL);
INSERT INTO `bank_info` VALUES (4, '6226621408215353', 'gd', '武昌南湖支行', 0, '湖北省武汉市武昌区南湖', 8, '2020-10-22 17:30:12', NULL);
INSERT INTO `bank_info` VALUES (5, '321524143241324132', 'gd', 'qrerq', 1, 'qewrqwerq', 18, '2020-10-28 13:50:16', NULL);

-- ----------------------------
-- Table structure for construction
-- ----------------------------
DROP TABLE IF EXISTS `construction`;
CREATE TABLE `construction`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area_desc` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工地描述',
  `emp_id` int(11) NULL DEFAULT NULL COMMENT '工地负责人',
  `stakeholder` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目干系人',
  `st_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目干系人电话',
  `status` int(1) NOT NULL DEFAULT 1 COMMENT '工地状态：1未完工，0完工',
  `area_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工地地址',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_user` int(11) NULL DEFAULT NULL COMMENT '创建用户',
  `update_user` int(11) NULL DEFAULT NULL COMMENT '更新用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工地信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of construction
-- ----------------------------
INSERT INTO `construction` VALUES (1, '孝感保利', '南湖长沙,2', 1, '吴兴军', '18772118541', 1, '湖北省孝感市', '2019-03-11 10:34:16', '2019-03-11 10:35:13', 1, 1);
INSERT INTO `construction` VALUES (2, '湖南长沙工地', '南湖长沙,2', 2, '吴兴军', '18772118541', 1, '湖南省长沙市，长沙县', '2019-03-11 10:34:16', '2019-03-11 10:35:07', 1, 1);
INSERT INTO `construction` VALUES (3, '湖南长沙工地', '南湖长沙,2', 1, '吴兴军', '18772118541', 1, '湖南省长沙市，长沙县', '2019-03-10 15:06:49', '2019-03-11 10:35:09', 1, 1);

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典类型code',
  `param_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典code',
  `show_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '页面上展示的值',
  `param_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库中用到的值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES (1, 'salary', '1', '一级', '170');
INSERT INTO `dictionary` VALUES (2, 'salary', '2', '二级', '180');
INSERT INTO `dictionary` VALUES (3, 'salary', '3', '三级', '200');
INSERT INTO `dictionary` VALUES (4, 'salary', '4', '四级', '250');
INSERT INTO `dictionary` VALUES (5, 'salary', '5', '五级', '280');
INSERT INTO `dictionary` VALUES (6, 'salary', '6', '六级', '300');
INSERT INTO `dictionary` VALUES (7, 'salary', '7', '七级', '350');
INSERT INTO `dictionary` VALUES (8, 'salary', '8', '八级', '400');
INSERT INTO `dictionary` VALUES (9, 'salary', '9', '九级', '500');
INSERT INTO `dictionary` VALUES (10, 'color', 'red', '红色', '红色');
INSERT INTO `dictionary` VALUES (11, 'color', 'white', '白色', '白色');
INSERT INTO `dictionary` VALUES (12, 'bank', 'gd', '光大银行', '光大银行');
INSERT INTO `dictionary` VALUES (13, 'bank', 'zs', '招商银行', '招商银行');
INSERT INTO `dictionary` VALUES (14, 'bank', 'gs', '工商银行', '工商银行');
INSERT INTO `dictionary` VALUES (15, 'bank', 'zg', '中国银行', '中国银行');
INSERT INTO `dictionary` VALUES (16, 'bank', 'ny', '农业银行', '农业银行');
INSERT INTO `dictionary` VALUES (17, 'bank', 'hk', '汉口银行', '汉口银行');
INSERT INTO `dictionary` VALUES (18, 'bank', 'js', '建设银行', '建设银行');
INSERT INTO `dictionary` VALUES (19, 'bank', 'jt', '交通银行', '交通银行');
INSERT INTO `dictionary` VALUES (20, 'bank', 'zx', '中信银行', '中信银行');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(2) NULL DEFAULT NULL COMMENT '年龄',
  `work_id` int(11) NULL DEFAULT NULL COMMENT '工地id',
  `phone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `identity` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录用户名',
  `comm_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通讯地址',
  `home_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salary_grade` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '薪资等级',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态：1在职，0离职',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (8, '雷朝兵', 35, NULL, '13667176303', '422802198511132139', 'LCB', '湖北武汉', '湖北恩施', 'e10adc3949ba59abbe56e057f20f883e', '9', '2020-10-22 15:34:07', '2020-10-22 15:34:51', 1);
INSERT INTO `employee` VALUES (9, '1', 27, NULL, '18772118541', '422802199305142138', 'LCA', 'SAFDS', 'DAFDASF', 'a19d36db01652d137fd3c8ecfa8855a1', '7', '2020-10-27 15:53:05', '2020-10-27 15:53:05', 1);
INSERT INTO `employee` VALUES (10, '柑柑城区', 27, NULL, '18772118541', '422802199305142133', 'LCA', '模板', '械', 'a19d36db01652d137fd3c8ecfa8855a1', '5', '2020-10-27 15:53:36', '2020-10-27 15:57:09', 1);
INSERT INTO `employee` VALUES (11, '斯柯达', 27, NULL, '13667176303', '422802199305142134', 'LCA', 'sdaf', 'savad', 'a19d36db01652d137fd3c8ecfa8855a1', '7', '2020-10-27 15:54:16', '2020-10-27 15:54:16', 1);
INSERT INTO `employee` VALUES (12, 'safds', 27, NULL, '13667176303', '422802199305142135', 'LCA', 'SAF萨芬多少', '柑', 'a19d36db01652d137fd3c8ecfa8855a1', '7', '2020-10-27 15:55:05', '2020-10-27 15:55:05', 1);
INSERT INTO `employee` VALUES (13, '枯萎', 35, NULL, '13667176303', '422802198511132137', 'LCA', 'SAV', '基本', 'a19d36db01652d137fd3c8ecfa8855a1', '7', '2020-10-27 15:55:40', '2020-10-27 15:55:40', 1);
INSERT INTO `employee` VALUES (14, '械', 35, NULL, '13667176303', '422802198511132136', 'LCA', 'XADSFA', 'SAFDSA', 'a19d36db01652d137fd3c8ecfa8855a1', '7', '2020-10-27 15:56:06', '2020-10-27 15:56:06', 1);
INSERT INTO `employee` VALUES (15, '械手动阀', 35, NULL, '13667176303', '422802198511132135', 'LCA', 'ASDF', 'AFDS', 'e2b8c92d6f27d9891ed59baa07c33407', '7', '2020-10-27 15:56:56', '2020-10-27 15:56:56', 1);
INSERT INTO `employee` VALUES (16, '械奇葩', 35, NULL, '13667176303', '422802198511132131', 'LCA', 'SADASD', 'safadsa', 'e2b8c92d6f27d9891ed59baa07c33407', '7', '2020-10-27 15:57:47', '2020-10-27 15:57:47', 1);
INSERT INTO `employee` VALUES (17, 'dfasdaf', 35, NULL, '13667176303', '422802198511132132', 'LCA', 's柑', '模压', 'e2b8c92d6f27d9891ed59baa07c33407', '7', '2020-10-27 15:58:24', '2020-10-27 15:58:24', 1);
INSERT INTO `employee` VALUES (18, '枯三行左', 35, NULL, '13667176303', '422802198511132121', 'LCA', '苦模压', '基本功苯胺', 'e2b8c92d6f27d9891ed59baa07c33407', '7', '2020-10-27 15:59:32', '2020-10-27 15:59:32', 1);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `path` varchar(59) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '路径',
  `order` int(1) NULL DEFAULT NULL COMMENT '排序',
  `pid` int(11) NOT NULL COMMENT '父id',
  `create_user` int(11) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `modify_user` int(11) NOT NULL,
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '员工管理', '/employee', 2, 0, 0, '2020-10-31 00:26:48', 0, '2020-10-31 00:26:48');
INSERT INTO `menu` VALUES (2, '考勤管理', '/ts', 1, 0, 0, '2020-10-31 00:27:14', 0, '2020-10-31 00:27:14');
INSERT INTO `menu` VALUES (3, '项目管理', '/construction', 3, 0, 0, '2020-10-31 00:29:20', 0, '2020-10-31 00:29:20');
INSERT INTO `menu` VALUES (4, '借支管理', '/advance', 4, 0, 8, '2020-10-31 00:29:31', 9, '2020-10-31 00:29:31');
INSERT INTO `menu` VALUES (5, '工作量管理', 'workload', 4, 0, 2, '2020-10-31 00:29:45', 2, '2020-10-31 00:29:45');
INSERT INTO `menu` VALUES (6, '薪酬管理', '/salary', 4, 0, 1, '2020-10-31 00:29:58', 1, '2020-10-31 00:29:58');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
  `level` int(11) NULL DEFAULT NULL COMMENT '等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '超级管理员', 1);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1);
INSERT INTO `role_menu` VALUES (1, 2);
INSERT INTO `role_menu` VALUES (1, 3);
INSERT INTO `role_menu` VALUES (1, 4);
INSERT INTO `role_menu` VALUES (1, 4);
INSERT INTO `role_menu` VALUES (1, 5);
INSERT INTO `role_menu` VALUES (1, 5);
INSERT INTO `role_menu` VALUES (1, 6);
INSERT INTO `role_menu` VALUES (1, 6);

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `em_id` int(11) NOT NULL,
  `work_id` int(11) NOT NULL COMMENT '工地id',
  `years` int(5) NOT NULL,
  `moths` int(3) NOT NULL,
  `timesheets` double(2, 2) NOT NULL COMMENT '工时',
  `day_salary` int(4) NOT NULL COMMENT '当月日薪',
  `month_salary` double(11, 2) NOT NULL COMMENT '当月核算月薪',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '薪资表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary
-- ----------------------------

-- ----------------------------
-- Table structure for salary_record
-- ----------------------------
DROP TABLE IF EXISTS `salary_record`;
CREATE TABLE `salary_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `before_greade` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原来的薪资等级',
  `after_greade` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '变化后薪资等级',
  `em_id` int(11) NOT NULL COMMENT '员工id',
  `change_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '变化描述',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `reason` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '升降原因',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工薪资等级记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary_record
-- ----------------------------
INSERT INTO `salary_record` VALUES (1, '0', '3', 3, '入职', '2019-01-01 16:17:19', '新员工入职！');
INSERT INTO `salary_record` VALUES (2, '0', '3', 5, '入职', '2019-01-01 16:17:17', '新员工入职！');
INSERT INTO `salary_record` VALUES (3, '3', '2', 2, '降薪', '2019-01-01 16:15:17', '重大失误一次，所以降薪');
INSERT INTO `salary_record` VALUES (4, '0', '8', 6, '入职', '2019-01-20 18:18:57', '新员工入职！');
INSERT INTO `salary_record` VALUES (5, '0', '8', 7, '入职', '2019-01-20 18:20:44', '新员工入职！');
INSERT INTO `salary_record` VALUES (6, '0', '8', 1, '入职', '2019-01-20 18:24:28', '新员工入职！');
INSERT INTO `salary_record` VALUES (7, '0', '1', 2, '入职', '2019-02-01 14:43:00', '新员工入职！');
INSERT INTO `salary_record` VALUES (8, '0', '4', 3, '入职', '2019-05-14 15:58:07', '新员工入职！');
INSERT INTO `salary_record` VALUES (9, '8', '9', 1, '涨薪', '2019-05-19 10:06:01', '表现优异，提升薪资等级');
INSERT INTO `salary_record` VALUES (10, '9', '2', 1, '降薪', '2019-05-19 10:09:31', '降级');
INSERT INTO `salary_record` VALUES (11, '0', '9', 4, '入职', '2019-05-19 10:51:29', '新员工入职！');
INSERT INTO `salary_record` VALUES (12, '0', '9', 5, '入职', '2019-05-19 10:54:40', '新员工入职！');
INSERT INTO `salary_record` VALUES (13, '9', '8', 2, '降薪', '2020-07-06 23:23:19', '降薪');
INSERT INTO `salary_record` VALUES (14, '0', '5', 6, '入职', '2020-07-18 13:40:06', '新员工入职！');
INSERT INTO `salary_record` VALUES (15, '0', '4', 7, '入职', '2020-07-18 13:46:18', '新员工入职！');
INSERT INTO `salary_record` VALUES (16, '0', '1', 8, '入职', '2020-08-15 21:47:10', '新员工入职！');
INSERT INTO `salary_record` VALUES (17, '1', '4', 8, '涨薪', '2020-08-15 21:48:57', '升职加薪');
INSERT INTO `salary_record` VALUES (18, '0', '7', 7, '入职', '2020-10-22 15:25:50', '新员工入职！');
INSERT INTO `salary_record` VALUES (19, '7', '9', 7, '涨薪', '2020-10-22 15:26:17', '是老板');
INSERT INTO `salary_record` VALUES (20, '7', '9', 7, '涨薪', '2020-10-22 15:26:20', '是老板');
INSERT INTO `salary_record` VALUES (21, '7', '9', 7, '涨薪', '2020-10-22 15:26:29', '是老板');
INSERT INTO `salary_record` VALUES (22, '7', '9', 7, '涨薪', '2020-10-22 15:26:47', '是老板');
INSERT INTO `salary_record` VALUES (23, '7', '9', 7, '涨薪', '2020-10-22 15:28:52', '是老板');
INSERT INTO `salary_record` VALUES (24, '0', '8', 8, '入职', '2020-10-22 15:34:07', '新员工入职！');
INSERT INTO `salary_record` VALUES (25, '8', '9', 8, '涨薪', '2020-10-22 15:34:51', '是老板，要最高的');
INSERT INTO `salary_record` VALUES (26, '0', '7', 9, '入职', '2020-10-27 15:53:05', '新员工入职！');
INSERT INTO `salary_record` VALUES (27, '0', '5', 10, '入职', '2020-10-27 15:53:36', '新员工入职！');
INSERT INTO `salary_record` VALUES (28, '0', '7', 11, '入职', '2020-10-27 15:54:16', '新员工入职！');
INSERT INTO `salary_record` VALUES (29, '0', '7', 12, '入职', '2020-10-27 15:55:05', '新员工入职！');
INSERT INTO `salary_record` VALUES (30, '0', '7', 13, '入职', '2020-10-27 15:55:40', '新员工入职！');
INSERT INTO `salary_record` VALUES (31, '0', '7', 14, '入职', '2020-10-27 15:56:06', '新员工入职！');
INSERT INTO `salary_record` VALUES (32, '0', '7', 15, '入职', '2020-10-27 15:56:56', '新员工入职！');
INSERT INTO `salary_record` VALUES (33, '0', '7', 16, '入职', '2020-10-27 15:57:47', '新员工入职！');
INSERT INTO `salary_record` VALUES (34, '0', '7', 17, '入职', '2020-10-27 15:58:24', '新员工入职！');
INSERT INTO `salary_record` VALUES (35, '0', '7', 18, '入职', '2020-10-27 15:59:32', '新员工入职！');

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `job_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job_group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cron_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bean_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_concurrent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1',
  `spring_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `method_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`job_id`) USING BTREE,
  UNIQUE INDEX `name_group`(`job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------

-- ----------------------------
-- Table structure for timesheets
-- ----------------------------
DROP TABLE IF EXISTS `timesheets`;
CREATE TABLE `timesheets`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cst_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工地名称',
  `cst_id` int(11) NULL DEFAULT NULL COMMENT '工地id',
  `em_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工地name',
  `em_id` int(11) NOT NULL COMMENT '员工id',
  `years` int(5) NOT NULL COMMENT '年份',
  `months` int(2) NOT NULL COMMENT '月份',
  `day01` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day02` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day03` double(3, 2) NOT NULL DEFAULT 0.00,
  `day04` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day05` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day06` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day07` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day08` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day09` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day10` double(3, 2) UNSIGNED ZEROFILL NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day11` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day12` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day13` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day14` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day15` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day16` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day17` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day18` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day19` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day20` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day21` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day22` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day23` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day24` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day25` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day26` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day27` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day28` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day29` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day30` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `day31` double(3, 2) NOT NULL DEFAULT 0.00 COMMENT '工时',
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `modify_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工时表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of timesheets
-- ----------------------------
INSERT INTO `timesheets` VALUES (1, '孝感保利', 1, '雷朝兵', 2, 2019, 1, 0.00, 4.00, 8.00, 8.00, 8.00, 8.00, 8.00, 5.00, 4.50, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 8.00, 4.30, 0.00, 8.00, 6.50, 8.00, 8.00, 8.00, '8', NULL, '2020-10-29 16:43:22', NULL);
INSERT INTO `timesheets` VALUES (2, '孝感保利', 1, '陆淋', 1, 2019, 2, 4.00, 5.00, 1.50, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, NULL, NULL, '2020-10-30 11:39:34', NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 8);

-- ----------------------------
-- Table structure for work_record
-- ----------------------------
DROP TABLE IF EXISTS `work_record`;
CREATE TABLE `work_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `work_id` int(11) NULL DEFAULT NULL COMMENT '工地ID',
  `work_area` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工地名称',
  `specific` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体位置',
  `wide` decimal(11, 2) NULL DEFAULT NULL COMMENT '宽',
  `lengths` decimal(11, 2) NULL DEFAULT NULL COMMENT '长',
  `hights` decimal(11, 2) NULL DEFAULT NULL COMMENT '高',
  `area` decimal(11, 2) NULL DEFAULT NULL COMMENT '面积',
  `volume` decimal(11, 2) NULL DEFAULT NULL COMMENT '体积',
  `create_user` int(11) NOT NULL COMMENT '创建用户',
  `update_user` int(11) NULL DEFAULT NULL COMMENT '更新用户',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工作记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of work_record
-- ----------------------------
INSERT INTO `work_record` VALUES (1, 1, '孝感保利', 'A区域', 23.50, 14.60, 5.00, 343.10, 1715.50, 1, 1, '2019-03-11 10:49:47', '2019-03-11 10:49:51');

-- ----------------------------
-- Table structure for workload
-- ----------------------------
DROP TABLE IF EXISTS `workload`;
CREATE TABLE `workload`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `con_id` int(11) NOT NULL COMMENT '工地ID',
  `length` double(11, 2) NOT NULL COMMENT '长',
  `width` double(11, 2) NOT NULL COMMENT '宽',
  `height` double(11, 2) NULL DEFAULT NULL COMMENT '高',
  `area` double(11, 2) NULL DEFAULT NULL COMMENT '面积 ',
  `volume` double(11, 2) NULL DEFAULT NULL COMMENT '体积',
  `price` double(11, 2) NULL DEFAULT NULL,
  `total` double(11, 2) NULL DEFAULT NULL,
  `create_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `modify_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工作量表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of workload
-- ----------------------------
INSERT INTO `workload` VALUES (2, 1, 2.00, 5.00, 900.00, NULL, NULL, 17.00, NULL, 'joy', NULL, NULL, '2020-10-20 16:58:40');
INSERT INTO `workload` VALUES (3, 1, 2.00, 5.00, 3.00, NULL, NULL, 17.00, NULL, 'joy', '2020-10-20 16:55:00', NULL, '2020-10-20 16:55:00');

SET FOREIGN_KEY_CHECKS = 1;
