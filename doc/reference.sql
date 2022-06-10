SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `reference`;
CREATE TABLE `reference`  (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
                         `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '引用内容',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `reference` VALUES (1, '数据库系统及其应用');
INSERT INTO `reference` VALUES (2, '操作系统');
INSERT INTO `reference` VALUES (3, '计算机网络原理');
INSERT INTO `reference` VALUES (4, 'C++从入门到学废');
INSERT INTO `reference` VALUES (5, '第一行代码');

