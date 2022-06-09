SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
                         `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标签内容',
                         `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '权限',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `tag` VALUES (1, 'Author: Caoqijun', '[1,2,3,19,27,30,31]');
INSERT INTO `tag` VALUES (2, 'Author: Fanghongyun', '[1,2,3,19,27,30,31]');
INSERT INTO `tag` VALUES (3, 'A类', '[1,2,3,19,27,30,31]');
INSERT INTO `tag` VALUES (4, 'B类', '[1,2,3,19,27,30,31]');
INSERT INTO `tag` VALUES (5, '国内文献', '[1,2,3,19,27,30,31]');
INSERT INTO `tag` VALUES (6, '国外文献', '[1,2,3,19,27,30,31]');
INSERT INTO `tag` VALUES (7, '近三年内', '[1,2,3,19,27,30,31]');
INSERT INTO `tag` VALUES (8, '三年之前', '[1,2,3,19,27,30,31]');

