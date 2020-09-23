/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.117
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : dingwen_study

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 23/09/2020 17:35:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `age` int(0) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'maorui', '400590', 21);
INSERT INTO `user` VALUES (2, 'dingwen', '400590', 21);
INSERT INTO `user` VALUES (3, 'zhangcongbo', '400590', 21);
INSERT INTO `user` VALUES (4, 'chengna', '400590', 21);
INSERT INTO `user` VALUES (6, '系统管理员', '123456', 21);
INSERT INTO `user` VALUES (8, 'zhangtao', '123456', 21);
INSERT INTO `user` VALUES (10, '测试', '123456', 21);
INSERT INTO `user` VALUES (11, 'libairong', '123456', 21);
INSERT INTO `user` VALUES (12, '测试', '123456', 21);
INSERT INTO `user` VALUES (14, 'dingwenxiong', '123456', 21);
INSERT INTO `user` VALUES (15, 'java', '123456', 21);
INSERT INTO `user` VALUES (16, 'yueshiquan', '123456', 23);

SET FOREIGN_KEY_CHECKS = 1;
