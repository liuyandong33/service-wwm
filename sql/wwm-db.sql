DROP TABLE IF EXISTS water_works;
CREATE TABLE water_works
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    code VARCHAR(20) NOT NULL COMMENT '水厂编码',
    name VARCHAR(20) NOT NULL COMMENT '水厂名称',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '水厂表';

DROP TABLE IF EXISTS organization;
CREATE TABLE organization
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    code VARCHAR(20) NOT NULL COMMENT '水厂编码',
    name VARCHAR(20) NOT NULL COMMENT '水厂名称',
    water_works_id BIGINT NOT NULL COMMENT '水厂ID',
    parent_id BIGINT NOT NULL COMMENT '上级机构ID',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '机构';

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    role_code VARCHAR(20) NOT NULL COMMENT '权限编码',
    role_name VARCHAR(20) NOT NULL COMMENT '角色名称',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '系统角色';

DROP TABLE IF EXISTS user_role_r;
CREATE TABLE user_role_r
(
    user_id BIGINT NOT NULL COMMENT 'user id',
    pos_role_id BIGINT NOT NULL COMMENT 'pos role id',
    PRIMARY KEY (user_id, pos_role_id)
) COMMENT '系统用户与系统角色中间表';

DROP TABLE IF EXISTS role_privilege_r;
CREATE TABLE role_privilege_r
(
    pos_role_id BIGINT NOT NULL COMMENT 'background id',
    privilege_id BIGINT NOT NULL COMMENT 'privilege id',
    PRIMARY KEY (pos_role_id, privilege_id)
) COMMENT '系统角色与系统权限中间表';

DROP TABLE IF EXISTS sys_privilege;
CREATE TABLE sys_privilege
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    privilege_code VARCHAR(20) NOT NULL COMMENT '权限编码',
    privilege_name VARCHAR(20) NOT NULL COMMENT '权限名称',
    service_name VARCHAR(50) NOT NULL COMMENT '服务名称',
    controller_name VARCHAR(50) NOT NULL COMMENT 'controller name',
    action_name VARCHAR(50) NOT NULL COMMENT 'action name',
    parent_id BIGINT NOT NULL COMMENT '父级权限ID',
    remark VARCHAR(255) NOT NULL COMMENT '备注',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '系统权限';