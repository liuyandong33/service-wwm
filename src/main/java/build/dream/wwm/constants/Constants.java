package build.dream.wwm.constants;

import build.dream.wwm.utils.CustomDateUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.UUID;

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

    public static final String PUBLIC_KEY = "publicKey";
    public static final String PRIVATE_KEY = "privateKey";

    /**
     * 数据库默认值
     */
    public static final int TINYINT_DEFAULT_VALUE = 0;
    public static final int INT_DEFAULT_VALUE = 0;
    public static final BigInteger BIGINT_DEFAULT_VALUE = BigInteger.ZERO;
    public static final BigDecimal DECIMAL_DEFAULT_VALUE = BigDecimal.ZERO;
    public static final Date DATETIME_DEFAULT_VALUE = CustomDateUtils.parse("1970-01-01 00:00:00", DEFAULT_DATE_PATTERN);
    public static final String VARCHAR_DEFAULT_VALUE = "";

    public static final String REDIS_TEMPLATE = "redisTemplate";
    public static final String COMMON_STRING_REDIS_TEMPLATE = "commonStringRedisTemplate";
    public static final String PARTITION_STRING_REDIS_TEMPLATE = "partitionStringRedisTemplate";
    public static final String COMMON_REDIS_CONNECTION_FACTORY = "commonRedisConnectionFactory";
    public static final String PARTITION_REDIS_CONNECTION_FACTORY = "partitionRedisConnectionFactory";

    public static final String COMMON_REDIS_HOST = "common.redis.host";
    public static final String COMMON_REDIS_PORT = "common.redis.port";
    public static final String COMMON_REDIS_PASSWORD = "common.redis.password";

    public static final String PARTITION_REDIS_HOST = "partition.redis.host";
    public static final String PARTITION_REDIS_PORT = "partition.redis.port";
    public static final String PARTITION_REDIS_PASSWORD = "partition.redis.password";

    public static final String CONTENT_TYPE_APPLICATION_FORM_URLENCODED_UTF8 = "application/x-www-form-urlencoded;charset=UTF-8";
    public static final String CONTENT_TYPE_APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";
    public static final String CONTENT_TYPE_MULTIPART_FORM_DATA_UTF8 = "multipart/form-data;boundary=" + UUID.randomUUID().toString() + ";charset=UTF-8";

    public static final String REQUEST_METHOD_GET = "GET";
    public static final String REQUEST_METHOD_HEAD = "HEAD";
    public static final String REQUEST_METHOD_POST = "POST";
    public static final String REQUEST_METHOD_PUT = "PUT";
    public static final String REQUEST_METHOD_PATCH = "PATCH";
    public static final String REQUEST_METHOD_DELETE = "DELETE";
    public static final String REQUEST_METHOD_OPTIONS = "OPTIONS";
    public static final String REQUEST_METHOD_TRACE = "TRACE";

    public static final String LOG_STACK_INFO = "log.stack.info";
}
