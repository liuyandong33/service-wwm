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
    water_works_id BIGINT NOT NULL COMMENT '水厂ID',
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
    role_id BIGINT NOT NULL COMMENT 'role id',
    PRIMARY KEY (user_id, role_id)
) COMMENT '系统用户与系统角色中间表';

DROP TABLE IF EXISTS role_privilege_r;
CREATE TABLE role_privilege_r
(
    role_id BIGINT NOT NULL COMMENT 'role id',
    privilege_id BIGINT NOT NULL COMMENT 'privilege id',
    PRIMARY KEY (role_id, privilege_id)
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

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    `name` VARCHAR(20) NOT NULL COMMENT '姓名',
    mobile VARCHAR(20) NOT NULL COMMENT '手机号码',
    email VARCHAR(20) NOT NULL COMMENT '邮箱',
    `login_name` VARCHAR(20) NOT NULL COMMENT '登录名',
    user_type TINYINT NOT NULL COMMENT '用户类型，1-超级管理员，2-普通用户',
    `password` VARCHAR(50) NOT NULL COMMENT '登录密码',
    water_works_id BIGINT NOT NULL COMMENT '水厂ID',
    account_non_expired TINYINT NOT NULL DEFAULT 1 COMMENT '账户是否没有过期，1-没有过期，0-已经过期',
    account_non_locked TINYINT NOT NULL DEFAULT 1 COMMENT '账户是否没有锁定，1-没有锁定，0-已经锁定',
    credentials_non_expired TINYINT NOT NULL DEFAULT 1 COMMENT '账户凭证是否没有过期，1-没有过期，0-已经过期',
    enabled TINYINT NOT NULL DEFAULT 1 COMMENT '账户是否启用，1-启用，0-禁用',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '系统用户表';

DROP TABLE IF EXISTS oauth_client_detail;
CREATE TABLE oauth_client_detail
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    client_id VARCHAR(50) NOT NULL COMMENT '客户端ID，必须唯一，不能为空。用于唯一标识每一个客户端(client)。在注册时必须填写(也可由服务端自动生成)。对于不同的grant_type，该字段都是必须的，在实际应用中的另一个名称叫appKey，与client_id是同一个概念',
    client_secret VARCHAR(255) NOT NULL COMMENT '用于指定客户端(client)的访问密匙。在注册时必须填写(也可由服务端自动生成)。对于不同的grant_type，该字段都是必须的。在实际应用中的另一个名称叫appSecret，与client_secret是同一个概念。',
    resource_ids VARCHAR(255) NOT NULL COMMENT '客户端所能访问的资源id集合，多个资源时用逗号(,)分隔，如: "unity-resource,mobile-resource"。该字段的值必须来源于资源服务器resourceId属性。在实际应用中，我们一般将资源进行分类，并分别配置对应的resourceId，如订单资源配置一个resourceId，用户资源又配置一个resourceId。当注册客户端时，根据实际需要可选择资源id，也可根据不同的注册流程，赋予对应的resourceId',
    scope VARCHAR(255) NOT NULL COMMENT '指定客户端申请的权限范围，可选值包括read,write,trust;若有多个权限范围用逗号(,)分隔,如: "read,write".scope的值与security.xml中配置的‹intercept-url的access属性有关系. 如‹intercept-url的配置为 ‹intercept-url pattern="/m/**" access="ROLE_MOBILE,SCOPE_READ"/> 则说明访问该URL时的客户端必须有read权限范围. write的配置值为SCOPE_WRITE, trust的配置值为SCOPE_TRUST. 在实际应该中, 该值一般由服务端指定, 常用的值为read,write.',
    authorized_grant_types VARCHAR(255) NOT NULL COMMENT '指定客户端支持的grant_type,可选值包括authorization_code,password,refresh_token,implicit,client_credentials, 若支持多个grant_type用逗号(,)分隔,如: "authorization_code,password". 在实际应用中,当注册时,该字段是一般由服务器端指定的,而不是由申请者去选择的,最常用的grant_type组合有: "authorization_code,refresh_token"(针对通过浏览器访问的客户端); "password,refresh_token"(针对移动设备的客户端). implicit与client_credentials在实际中很少使用.',
    web_server_redirect_uri VARCHAR(255) NOT NULL COMMENT '客户端的重定向URI,可为空, 当grant_type为authorization_code或implicit时, 在Oauth的流程中会使用并检查与注册时填写的redirect_uri是否一致. 下面分别说明:当grant_type=authorization_code时, 第一步 从 spring-oauth-server获取 code时客户端发起请求时必须有redirect_uri参数, 该参数的值必须与 web_server_redirect_uri的值一致. 第二步 用 code 换取 access_token 时客户也必须传递相同的redirect_uri.在实际应用中, web_server_redirect_uri在注册时是必须填写的, 一般用来处理服务器返回的code, 验证state是否合法与通过code去换取access_token值.当grant_type=implicit时通过redirect_uri的hash值来传递access_token值.如:http://localhost:7777/spring-oauth-client/implicit#access_token=dc891f4a-ac88-4ba6-8224-a2497e013865&token_type=bearer&expires_in=43199然后客户端通过JS等从hash值中取到access_token值.',
    authorities VARCHAR(255) NOT NULL COMMENT '指定客户端所拥有的Spring Security的权限值,可选, 若有多个权限值,用逗号(,)分隔, 如: "ROLE_UNITY,ROLE_USER". 对于是否要设置该字段的值,要根据不同的grant_type来判断, 若客户端在Oauth流程中需要用户的用户名(username)与密码(password)的(authorization_code,password), 则该字段可以不需要设置值,因为服务端将根据用户在服务端所拥有的权限来判断是否有权限访问对应的API. 但如果客户端在Oauth流程中不需要用户信息的(implicit,client_credentials), 则该字段必须要设置对应的权限值, 因为服务端将根据该字段值的权限来判断是否有权限访问对应的API. ',
    access_token_validity INT NOT NULL COMMENT '设定客户端的access_token的有效时间值(单位:秒),可选, 若不设定值则使用默认的有效时间值(60 * 60 * 12, 12小时).在服务端获取的access_token JSON数据中的expires_in字段的值即为当前access_token的有效时间值.在项目中, 可具体参考DefaultTokenServices.java中属性accessTokenValiditySeconds.在实际应用中, 该值一般是由服务端处理的, 不需要客户端自定义.',
    refresh_token_validity INT NOT NULL COMMENT '设定客户端的refresh_token的有效时间值(单位:秒),可选, 若不设定值则使用默认的有效时间值(60 * 60 * 24 * 30, 30天). 若客户端的grant_type不包括refresh_token,则不用关心该字段 在项目中, 可具体参考DefaultTokenServices.java中属性refreshTokenValiditySeconds. 在实际应用中, 该值一般是由服务端处理的, 不需要客户端自定义.',
    additional_information VARCHAR(255) NOT NULL COMMENT '这是一个预留的字段,在Oauth的流程中没有实际的使用,可选,但若设置值,必须是JSON格式的数据,如:{"country":"CN","country_code":"086"}按照spring-security-oauth项目中对该字段的描述 Additional information for this client, not need by the vanilla OAuth protocol but might be useful, for example,for storing descriptive information. (详见ClientDetails.java的getAdditionalInformation()方法的注释)在实际应用中, 可以用该字段来存储关于客户端的一些其他信息,如客户端的国家,地区,注册时的IP地址等等.',
    auto_approve_scope VARCHAR(255) NOT NULL COMMENT '用户自动Approval的scope, 该字段只适用于grant_type="authorization_code"的情况,当用户登录成功后,则会跳过用户Approve的页面, 直接授权。',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '客户端信息';

DROP TABLE IF EXISTS device;
CREATE TABLE device
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    name VARCHAR(20) NOT NULL COMMENT '设备名称',
    code VARCHAR(20) NOT NULL COMMENT '设备编号',
    model VARCHAR(20) NOT NULL COMMENT '设备型号',
    category VARCHAR(20) NOT NULL COMMENT '设备分类',
    department VARCHAR(20) NOT NULL COMMENT '设备所属部门',
    storage_location VARCHAR(20) NOT NULL COMMENT '设备存放地点',
    created_date DATETIME NOT NULL COMMENT '建档日期',
    brand VARCHAR(20) NOT NULL COMMENT '品牌',
    supplier VARCHAR(20) NOT NULL COMMENT '供应商',
    purchased_date DATETIME NOT NULL COMMENT '购置日期',
    quantity DECIMAL(11, 3) NOT NULL COMMENT '数量',
    price DECIMAL(11, 3) NOT NULL COMMENT '单价',
    purchased_amount DECIMAL(11, 3) NOT NULL COMMENT '购置金额',
    administrator VARCHAR(20) NOT NULL COMMENT '所属管理员',
    registrant VARCHAR(20) NOT NULL COMMENT '登记人',
    specified_service_life DECIMAL(11, 3) NOT NULL COMMENT '规定使用年限',
    warranty_expiration_date DATETIME NOT NULL COMMENT '保修截止日期',
    asset_status VARCHAR(20) NOT NULL COMMENT '设备资产状态',
    image_url VARCHAR(255) NOT NULL COMMENT '设备图片地址',
    remark VARCHAR(255) NOT NULL COMMENT '备注',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '设备基本信息';

DROP TABLE IF EXISTS supplier;
CREATE TABLE supplier
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    code VARCHAR(20) NOT NULL COMMENT '编号',
    name VARCHAR(20) NOT NULL COMMENT '名称',
    linkman VARCHAR(20) NOT NULL COMMENT '联系人',
    telephone_number VARCHAR(20) NOT NULL COMMENT '联系电话',
    fax VARCHAR(20) NOT NULL COMMENT '传真',
    address VARCHAR(255) NOT NULL COMMENT '详细地址',
    postcode VARCHAR(20) NOT NULL COMMENT '邮编',
    email VARCHAR(50) NOT NULL COMMENT '电子邮箱',
    tax_number VARCHAR(50) NOT NULL COMMENT '税号',
    bank VARCHAR(50) NOT NULL COMMENT '开户行',
    account_number VARCHAR(50) NOT NULL COMMENT '开户行账号',
    remark VARCHAR(255) NOT NULL COMMENT '备注',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = '供应商信息表';