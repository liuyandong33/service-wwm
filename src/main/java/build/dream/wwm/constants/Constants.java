package build.dream.wwm.constants;

import java.nio.charset.Charset;

public class Constants {
    /**
     * sql 操作符常量
     */
    public static final String SQL_OPERATION_SYMBOL_IN = "IN";
    public static final String SQL_OPERATION_SYMBOL_NOT_IN = "NOT IN";
    public static final String SQL_OPERATION_SYMBOL_LIKE = "LIKE";
    public static final String SQL_OPERATION_SYMBOL_NOT_LIKE = "NOT LIKE";
    public static final String SQL_OPERATION_SYMBOL_EQUAL = "=";
    public static final String SQL_OPERATION_SYMBOL_NOT_EQUAL = "!=";
    public static final String SQL_OPERATION_SYMBOL_LESS_THAN = "<";
    public static final String SQL_OPERATION_SYMBOL_LESS_THAN_EQUAL = "<=";
    public static final String SQL_OPERATION_SYMBOL_GREATER_THAN = ">";
    public static final String SQL_OPERATION_SYMBOL_GREATER_THAN_EQUAL = ">=";
    public static final String SQL_OPERATION_SYMBOL_IS_NULL = "IS NULL";
    public static final String SQL_OPERATION_SYMBOL_IS_NOT_NULL = "IS NOT NULL";
    public static final String DESC = "DESC";
    public static final String ASC = "ASC";

    public static final String DATABASE_PRODUCT_NAME_MYSQL = "MySQL";
    public static final String DATABASE_PRODUCT_NAME_ORACLE = "Oracle";
    public static final String DATABASE_PRODUCT_NAME_MICROSOFT_SQL_SERVER = "Microsoft SQL Server";

    /**
     * @see #DATABASE_ID_MYSQL: MySQL数据库标识
     * @see #DATABASE_ID_ORACLE: Oracle数据库标识
     * @see #DATABASE_ID_SQL_SERVER: SqlServer 数据库标识
     */
    public static final String DATABASE_ID_MYSQL = "mysql";
    public static final String DATABASE_ID_ORACLE = "oracle";
    public static final String DATABASE_ID_SQL_SERVER = "sql_server";

    /**
     * 日期格式化相关常量
     */
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String ISO8601_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String GMT = "GMT";

    /**
     * 字符集相关常量
     */
    public static final Charset CHARSET_UTF_8 = Charset.forName("UTF-8");
    public static final Charset CHARSET_GBK = Charset.forName("GBK");
    public static final Charset CHARSET_ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset CHARSET_GB2312 = Charset.forName("GB2312");
    public static final Charset CHARSET_GB18030 = Charset.forName("GB18030");
    public static final String CHARSET_NAME_UTF_8 = "UTF-8";
    public static final String CHARSET_NAME_GBK = "GBK";
    public static final String CHARSET_NAME_ISO_8859_1 = "ISO-8859-1";
    public static final String CHARSET_NAME_GB2312 = "GB2312";
    public static final String CHARSET_NAME_GB18030 = "GB18030";

    public static final String UPPER_CASE_TRUE = "TRUE";
    public static final String UPPER_CASE_FALSE = "FALSE";
    public static final String LOWER_CASE_TRUE = "true";
    public static final String LOWER_CASE_FALSE = "false";

    public static final String XML_HTTP_REQUEST = "XMLHttpRequest";

    // 开发环境或测试环境参数错误错误信息
    public static final String PARAMETER_ERROR_MESSAGE_PATTERN = "参数(%s)错误！";
    // 生产环境参数错误错误信息
    public static final String API_PARAMETER_ERROR_MESSAGE = "API参数错误！";

    /**
     * 部署环境
     */
    public static final String WWW = "www";
    public static final String BETA = "beta";
    public static final String TEST = "test";
    public static final String DEVELOPMENT = "development";

    /**
     * 配置文件名称常量
     */
    public static final String DEVELOPMENT_PROPERTIES = "development.properties";

    public static final String DEPLOYMENT_ENVIRONMENT = "deployment.environment";
    public static final String SERVICE_NAME = "service.name";
}
