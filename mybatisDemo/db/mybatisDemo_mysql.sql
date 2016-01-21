SET SESSION FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `test_user`;
CREATE TABLE `test_user` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `user_id` varchar(64) DEFAULT NULL COMMENT '归属用户',
  `office_id` varchar(64) DEFAULT NULL COMMENT '归属部门',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试数据表';

-- ----------------------------
-- Records of test_user
-- ----------------------------
INSERT INTO `test_user` VALUES ('1', '1', '1', '张三', '1', '');
INSERT INTO `test_user` VALUES ('2', '2', '1', '李四', '1', '');
INSERT INTO `test_user` VALUES ('3', '3', '1', '王五', '1', '');
INSERT INTO `test_user` VALUES ('4', '4', '1', '赵六', '1', '');