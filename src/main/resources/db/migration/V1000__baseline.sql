-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: 47.107.145.27    Database: spr
-- ------------------------------------------------------
-- Server version	5.7.26-log
-- ----------------------------
-- Table structure for vlab_user
-- ----------------------------
DROP TABLE IF EXISTS `vlab_user`;
CREATE TABLE `vlab_user` (
  `id` varchar(36) NOT NULL COMMENT '用户ID（UUID）',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `open_id` varchar(128) DEFAULT NULL COMMENT '微信用户唯一标识',
  `session_key` varchar(128) DEFAULT NULL COMMENT '微信会话密钥',
  `password` varchar(256) DEFAULT NULL COMMENT '密码',
  `realname` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `id_card` char(18) DEFAULT NULL COMMENT '身份证号码',
  `mobile` char(13) DEFAULT NULL COMMENT '手机号',
  `head_image_url` varchar(256) DEFAULT NULL COMMENT '头像',
  `birthdate` varchar(36) NOT NULL DEFAULT '' COMMENT '出生年月日',
  `sex` int(11) NOT NULL DEFAULT '0' COMMENT '性别：性别：0-未知；1 - 男；2 - 女',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：0 - 已删除；1 - 正常, 2 - 锁定',
  `user_type` int(11) NOT NULL DEFAULT '0' COMMENT '用户类别：0 - 普通用户；1 - 管理员用户',
  `email` varchar(20) DEFAULT '' COMMENT '邮箱',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `balance` decimal(15,2) DEFAULT 0 COMMENT '账户余额',
  `create_time` datetime  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `openId_unique` (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';


-- ----------------------------
--  Table structure for `sys_acl`
-- ----------------------------
DROP TABLE IF EXISTS `sys_acl`;
CREATE TABLE `sys_acl` (
      `id` varchar(36) NOT NULL COMMENT '权限id',
      `code` varchar(20) NOT NULL DEFAULT '' COMMENT '权限码',
      `name` varchar(20) NOT NULL DEFAULT '' COMMENT '权限名称',
      `acl_module_id` varchar(36) NOT NULL DEFAULT '0' COMMENT '权限所在的权限模块id',
      `url` varchar(100) NOT NULL DEFAULT '' COMMENT '请求的url, 可以填正则表达式',
      `type` int(11) NOT NULL DEFAULT '3' COMMENT '类型，1：菜单，2：按钮，3：其他',
      `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结',
      `seq` int(11) NOT NULL DEFAULT '0' COMMENT '权限在当前模块下的顺序，由小到大',
      `remark` varchar(200) DEFAULT '' COMMENT '备注',
      `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
      `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
      `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一个更新者的ip地址',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '系统权限表';

-- ----------------------------
--  Table structure for `sys_acl_module`
-- ----------------------------
DROP TABLE IF EXISTS `sys_acl_module`;
CREATE TABLE `sys_acl_module` (
      `id` varchar(36) NOT NULL COMMENT '权限模块id',
      `name` varchar(20) NOT NULL DEFAULT '' COMMENT '权限模块名称',
      `code` varchar(80) NOT NULL DEFAULT '' COMMENT '权限模块的编码，需要跟前端路由模块严格对应',
      `parent_id` varchar(36) NOT NULL DEFAULT '0' COMMENT '上级权限模块id',
      `level` varchar(200) NOT NULL DEFAULT '' COMMENT '权限模块层级',
      `seq` int(11) NOT NULL DEFAULT '0' COMMENT '权限模块在当前层级下的顺序，由小到大',
      `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结',
      `remark` varchar(200) DEFAULT '' COMMENT '备注',
      `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
      `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
      `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新操作者的ip地址',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT '系统权限模块';

-- ----------------------------
--  Table structure for `sys_acl_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_acl_log`;
CREATE TABLE `sys_acl_log` (
      `id` varchar(36) NOT NULL,
      `type` int(11) NOT NULL DEFAULT '0' COMMENT '权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系',
      `target_id` varchar(36) NOT NULL COMMENT '基于type后指定的对象id，比如用户、权限、角色等表的主键',
      `old_value` text COMMENT '旧值',
      `new_value` text COMMENT '新值',
      `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
      `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
      `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
      `status` int(11) NOT NULL DEFAULT '0' COMMENT '当前是否复原过，0：没有，1：复原过',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '系统权限日志';

-- ----------------------------
--  Table structure for `sys_role_acl`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_acl`;
CREATE TABLE `sys_role_acl` (
      `id` varchar(36) NOT NULL,
      `role_id` varchar(36) NOT NULL COMMENT '角色id',
      `acl_id` varchar(36) NOT NULL COMMENT '权限id',
      `acl_type` int(11) NOT NULL DEFAULT '0' COMMENT '权限类型：0 - 权限点；1 - 权限模块',
      `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
      `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
      `operate_ip` varchar(200) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '系统角色权限表';

-- ----------------------------
--  Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
      `id` varchar(36) NOT NULL COMMENT '角色id',
      `name` varchar(20) NOT NULL COMMENT '角色名',
      `type` int(11) NOT NULL DEFAULT '1' COMMENT '角色的类型，1：管理员角色，2：其他',
      `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1：可用，0：冻结',
      `remark` varchar(200) DEFAULT '' COMMENT '备注',
      `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
      `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
      `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '角色表';
insert into sys_role(id, name, type, status, remark, operate_time)
VALUES('8974B7437DF94851E05011AC0200024C', 'superadmin', 1, 1, '超级管理员具有所有权限，并且不能删除', '2019-07-18 10:52:31');


-- ----------------------------
--  Table structure for `sys_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
      `id` varchar(36) NOT NULL,
      `role_id` varchar(36) NOT NULL COMMENT '角色id',
      `user_id` varchar(36) NOT NULL COMMENT '用户id',
      `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
      `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
      `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户角色关联表';

insert into sys_role_user(id, role_id, user_id, operate_time)
values('asdfkldjfldlfjdslkf12432545', '8974B7437DF94851E05011AC0200024C', '87DD99DC951F31DEE05011AC020005DA', '2019-07-18 10:52:31');

-- ----------------------------
--  Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
      `id` varchar(36) NOT NULL,
      `log_type` int(11) NOT NULL DEFAULT '0' COMMENT '日志类型',
      `operator_id` varchar(36) NOT NULL DEFAULT '' COMMENT '操作者ID',
      `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
      `operator_roles` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者角色',
      `action` varchar(100) NOT NULL DEFAULT '' COMMENT '动作',
      `target` varchar(360) NOT NULL DEFAULT '' COMMENT '动作对应的目标，如用户、角色等',
      `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
      `target_id` varchar(36) NOT NULL DEFAULT '' COMMENT '基于type后指定的对象id,比如用户、权限、角色等表的主键',
      `old_value` varchar(2000) NOT NULL DEFAULT '' COMMENT '旧值ֵ',
      `new_value` varchar(2000) NOT NULL DEFAULT '' COMMENT '新值ֵ',
      `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者的ip地址ַ',
      `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态：当前是否复原过，0：没有，1：复原过',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '系统日志表';


