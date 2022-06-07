SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `paper`  (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
                         `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
                         `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '作者',
                         `meeting` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发表会议',
                         `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发表日期',
                         `link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '链接',
                         `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '权限',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `paper` VALUES (1, '文献1', 'Caoqijun', 'A类', '2022-05-17', 'https://www.google.com/', '[1,2,3,19,27,30,31]');
INSERT INTO `paper` VALUES (2, '文献2', 'Caoqijun', 'A类', '2022-05-17', 'https://www.google.com/', '[1,2,3,19,27,30,31]');
INSERT INTO `paper` VALUES (3, '文献3', 'Caoqijun', 'A类', '2022-05-17', 'https://www.google.com/', '[1,2,3,19,27,30,31]');

