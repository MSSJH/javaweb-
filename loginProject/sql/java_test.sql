/*
 Navicat Premium Dump SQL

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026 (8.0.26)
 Source Host           : localhost:3306
 Source Schema         : java_test

 Target Server Type    : MySQL
 Target Server Version : 80026 (8.0.26)
 File Encoding         : 65001

 Date: 21/01/2025 15:56:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `userId` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `userPwd` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `userAge` int NULL DEFAULT 18 COMMENT '用户年龄',
  PRIMARY KEY (`userId` DESC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (100, '小马', '123', 21);
INSERT INTO `tb_user` VALUES (99, 'qqq', '1234567', 18);
INSERT INTO `tb_user` VALUES (98, 'eee', '1234567', 18);
INSERT INTO `tb_user` VALUES (97, 'cxk', '123456', 18);
INSERT INTO `tb_user` VALUES (91, 'mjh', '123', 18);
INSERT INTO `tb_user` VALUES (27, 'dsj', '123456', 18);
INSERT INTO `tb_user` VALUES (23, 'byc', '123', 20);

SET FOREIGN_KEY_CHECKS = 1;
