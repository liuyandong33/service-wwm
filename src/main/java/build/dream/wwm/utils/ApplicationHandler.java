package build.dream.wwm.utils;

import build.dream.wwm.annotations.DateFormat;
import build.dream.wwm.annotations.InstantiateObjectIgnore;
import build.dream.wwm.annotations.InstantiateObjectKey;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.constants.ErrorConstants;
import build.dream.wwm.constants.HttpHeaders;
import build.dream.wwm.functions.SuppressThrowFunction;
import build.dream.wwm.functions.SuppressThrowNoReturnFunction;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liuyandong on 2017/3/24.
 */
public class ApplicationHandler {
    /**
     * 获取ServletRequestAttributes
     *
     * @return
     */
    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * 获取HttpServletRequest
     *
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        return getServletRequestAttributes().getRequest();
    }

    /**
     * 获取HttpServletResponse
     *
     * @return
     */
    public static HttpServletResponse getHttpServletResponse() {
        return getServletRequestAttributes().getResponse();
    }

    /**
     * 获取请求参数
     *
     * @return
     */
    public static Map<String, String> getRequestParameters() {
        return getRequestParameters(getHttpServletRequest());
    }

    /**
     * 获取请求参数
     *
     * @param httpServletRequest
     * @return
     */
    public static Map<String, String> getRequestParameters(HttpServletRequest httpServletRequest) {
        Map<String, String> requestParameters = new LinkedHashMap<String, String>();
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        for (Map.Entry<String, String[]> parameterEntry : parameterMap.entrySet()) {
            requestParameters.put(parameterEntry.getKey(), StringUtils.trimToEmpty(StringUtils.join(parameterEntry.getValue(), ",")));
        }
        return requestParameters;
    }

    /**
     * 获取请求体
     *
     * @return
     * @throws IOException
     */
    public static String getRequestBody() throws IOException {
        return getRequestBody(getHttpServletRequest(), Constants.CHARSET_NAME_UTF_8);
    }

    /**
     * 获取请求体
     *
     * @param charsetName
     * @return
     * @throws IOException
     */
    public static String getRequestBody(String charsetName) throws IOException {
        return getRequestBody(getHttpServletRequest(), charsetName);
    }

    /**
     * 获取请求体
     *
     * @param httpServletRequest
     * @param charsetName
     * @return
     * @throws IOException
     */
    public static String getRequestBody(HttpServletRequest httpServletRequest, String charsetName) throws IOException {
        return IOUtils.toString(httpServletRequest.getInputStream(), charsetName);
    }

    /**
     * 根据参数名称获取参数
     *
     * @param requestParameterName
     * @return
     */
    public static String getRequestParameter(String requestParameterName) {
        return getRequestParameter(getHttpServletRequest(), requestParameterName);
    }

    /**
     * 根据参数名称获取参数
     *
     * @param httpServletRequest
     * @param requestParameterName
     * @return
     */
    public static String getRequestParameter(HttpServletRequest httpServletRequest, String requestParameterName) {
        return StringUtils.trimToNull(StringUtils.join(httpServletRequest.getParameterValues(requestParameterName), ","));
    }

    /**
     * 获取session id
     *
     * @return
     */
    public static String getSessionId() {
        return getServletRequestAttributes().getSessionId();
    }

    /**
     * 获取ServletContext
     *
     * @return
     */
    public static ServletContext getServletContext() {
        return getServletContext(getHttpServletRequest());
    }

    /**
     * 获取ServletContext
     *
     * @param httpServletRequest
     * @return
     */
    public static ServletContext getServletContext(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getServletContext();
    }

    /**
     * 获取客户点IP地址
     *
     * @return
     */
    public static String getRemoteAddress() {
        return getRemoteAddress(getHttpServletRequest());
    }

    /**
     * 获取客户点IP地址
     *
     * @param httpServletRequest
     * @return
     */
    public static String getRemoteAddress(HttpServletRequest httpServletRequest) {
        String xRealIp = httpServletRequest.getHeader(HttpHeaders.X_REAL_IP);
        if (StringUtils.isNotBlank(xRealIp)) {
            return xRealIp;
        }

        String xForwardedFor = httpServletRequest.getHeader(HttpHeaders.X_FORWARDED_FOR);
        if (StringUtils.isNotBlank(xForwardedFor)) {
            return StringUtils.trim(xForwardedFor.split(",")[0]);
        }
        return httpServletRequest.getRemoteAddr();
    }

    /**
     * 获取 HttpSession
     *
     * @return
     */
    public static HttpSession getHttpSession() {
        return getHttpServletRequest().getSession();
    }

    /**
     * 获取请求的url
     *
     * @return
     */
    public static String getRequestUrl() {
        return getRequestUrl(getHttpServletRequest());
    }

    /**
     * 获取请求协议
     *
     * @return
     */
    public static String obtainProtocol() {
        return obtainProtocol(getHttpServletRequest());
    }

    /**
     * 获取请求协议
     *
     * @param httpServletRequest
     * @return
     */
    public static String obtainProtocol(HttpServletRequest httpServletRequest) {
        String protocol = httpServletRequest.getHeader(HttpHeaders.X_FORWARDED_PROTO);
        if (StringUtils.isBlank(protocol)) {
            return httpServletRequest.getScheme();
        }
        return StringUtils.trim(protocol.split(",")[0]);
    }

    /**
     * 获取请求域名
     *
     * @return
     */
    public static String obtainHost() {
        return obtainHost(getHttpServletRequest());
    }

    /**
     * 获取请求域名
     *
     * @param httpServletRequest
     * @return
     */
    public static String obtainHost(HttpServletRequest httpServletRequest) {
        String host = httpServletRequest.getHeader(HttpHeaders.X_FORWARDED_HOST);
        if (StringUtils.isBlank(host)) {
            return httpServletRequest.getServerName();
        }
        return host;
    }

    /**
     * 获取请求的url
     *
     * @param httpServletRequest
     * @return
     */
    public static String getRequestUrl(HttpServletRequest httpServletRequest) {
        String protocol = obtainProtocol(httpServletRequest);
        String host = obtainHost(httpServletRequest);
        String prefix = httpServletRequest.getHeader(HttpHeaders.X_FORWARDED_PREFIX);

        String requestUri = getRequestUri(httpServletRequest);
        return StringUtils.isBlank(prefix) ? protocol + "://" + host + requestUri : protocol + "://" + host + prefix + requestUri;
    }

    /**
     * 获取请求的uri
     *
     * @return
     */
    public static String getRequestUri() {
        return getRequestUri(getHttpServletRequest());
    }

    /**
     * 获取请求的uri
     *
     * @param httpServletRequest
     * @return
     */
    public static String getRequestUri(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getRequestURI();
    }

    /**
     * 获取请求的url包含queryString
     *
     * @param httpServletRequest
     * @return
     */
    public static String obtainRequestUrl(HttpServletRequest httpServletRequest) {
        String queryString = httpServletRequest.getQueryString();
        String requestUrl = getRequestUrl(httpServletRequest);
        return StringUtils.isBlank(queryString) ? requestUrl : requestUrl + "?" + queryString;
    }

    /**
     * 获取请求的url包含queryString
     *
     * @return
     */
    public static String obtainRequestUrl() {
        return obtainRequestUrl(getHttpServletRequest());
    }

    /**
     * 实例化json对象并校验
     *
     * @param objectClass
     * @param json
     * @param <T>
     * @return
     */
    public static <T> T instantiateObject(Class<T> objectClass, String json) {
        return instantiateObject(objectClass, json, Constants.DEFAULT_DATE_PATTERN);
    }

    /**
     * 实例化json对象并校验
     *
     * @param objectClass
     * @param json
     * @param datePattern
     * @param <T>
     * @return
     */
    public static <T> T instantiateObject(Class<T> objectClass, String json, String datePattern) {
        if (ValidateUtils.isJson(json)) {
            return JacksonUtils.readValue(json, objectClass, datePattern);
        }
        return ObjectUtils.newInstance(objectClass);
    }

    /**
     * 实例化对象
     *
     * @param objectClass
     * @param parameters
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T instantiateObject(Class<T> objectClass, Map<String, String> parameters) throws Exception {
        return instantiateObject(objectClass, parameters, Constants.DEFAULT_DATE_PATTERN);
    }

    /**
     * 实例化对象
     *
     * @param objectClass
     * @param parameters
     * @param datePattern
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T instantiateObject(Class<T> objectClass, Map<String, String> parameters, String datePattern) throws Exception {
        T object = objectClass.newInstance();
        Map<String, SimpleDateFormat> simpleDateFormatMap = new HashMap<String, SimpleDateFormat>();

        List<Field> fields = obtainAllFields(objectClass);
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isNative(modifiers)) {
                continue;
            }
            if (Objects.nonNull(field.getAnnotation(InstantiateObjectIgnore.class))) {
                continue;
            }

            InstantiateObjectKey instantiateObjectKey = field.getAnnotation(InstantiateObjectKey.class);

            String parameterName = null;
            if (Objects.isNull(instantiateObjectKey)) {
                parameterName = field.getName();
            } else {
                parameterName = instantiateObjectKey.name();
            }
            String fieldValue = parameters.get(parameterName);
            if (StringUtils.isBlank(fieldValue)) {
                continue;
            }
            ReflectionUtils.makeAccessible(field);
            Class<?> fieldClass = field.getType();
            if (fieldClass == Byte.class || fieldClass == byte.class) {
                field.set(object, Byte.valueOf(fieldValue));
            } else if (fieldClass == Short.class || fieldClass == short.class) {
                field.set(object, Short.valueOf(fieldValue));
            } else if (fieldClass == Integer.class || fieldClass == int.class) {
                field.set(object, Integer.valueOf(fieldValue));
            } else if (fieldClass == Long.class || fieldClass == long.class) {
                field.set(object, Long.valueOf(fieldValue));
            } else if (fieldClass == Float.class || fieldClass == float.class) {
                field.set(object, Float.valueOf(fieldValue));
            } else if (fieldClass == Double.class || fieldClass == double.class) {
                field.set(object, Double.valueOf(fieldValue));
            } else if (fieldClass == Character.class || fieldClass == char.class) {
                field.set(object, fieldValue.charAt(0));
            } else if (fieldClass == String.class) {
                field.set(object, fieldValue);
            } else if (fieldClass == Boolean.class || fieldClass == boolean.class) {
                field.set(object, Boolean.valueOf(fieldValue));
            } else if (fieldClass == Date.class) {
                SimpleDateFormat simpleDateFormat = obtainSimpleDateFormat(simpleDateFormatMap, field, datePattern);
                field.set(object, simpleDateFormat.parse(fieldValue));
            } else if (fieldClass == BigInteger.class) {
                field.set(object, BigInteger.valueOf(Long.valueOf(fieldValue)));
            } else if (fieldClass == BigDecimal.class) {
                field.set(object, BigDecimal.valueOf(Double.valueOf(fieldValue)));
            } else if (fieldClass == List.class) {
                Type type = field.getGenericType();
                if (type instanceof ParameterizedType) {
                    Type itemType = ((ParameterizedType) type).getActualTypeArguments()[0];
                    SimpleDateFormat simpleDateFormat = null;
                    if (itemType instanceof Date) {
                        simpleDateFormat = obtainSimpleDateFormat(simpleDateFormatMap, field, datePattern);
                    }
                    field.set(object, buildArrayList(field, itemType, parameterName, fieldValue, ",", simpleDateFormat));
                }
            } else if (fieldClass == Map.class) {
                Type type = field.getGenericType();
                if (type instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                    Class<? extends Object> keyClass = (Class<? extends Object>) actualTypeArguments[0];
                    Class<? extends Object> valueClass = (Class<? extends Object>) actualTypeArguments[1];
                    field.set(object, JacksonUtils.readValueAsMap(fieldValue, keyClass, valueClass));
                }
            } else {
                if (ValidateUtils.isJson(fieldValue)) {
                    field.set(object, JacksonUtils.readValue(fieldValue, field.getType()));
                }
            }
        }
        return object;
    }

    /**
     * 获取所有属性，包含父类的属性
     *
     * @param objectClass
     * @return
     */
    private static List<Field> obtainAllFields(Class<?> objectClass) {
        ArrayList<Field> fields = new ArrayList<Field>();
        while (objectClass != Object.class) {
            fields.addAll(Arrays.asList(objectClass.getDeclaredFields()));
            objectClass = objectClass.getSuperclass();
        }
        return fields;
    }

    /**
     * 获取SimpleDateFormat
     *
     * @param simpleDateFormatMap
     * @param field
     * @return
     */
    public static SimpleDateFormat obtainSimpleDateFormat(Map<String, SimpleDateFormat> simpleDateFormatMap, Field field, String defaultDatePattern) {
        DateFormat dateFormat = field.getAnnotation(DateFormat.class);
        String datePattern = null;

        if (Objects.nonNull(dateFormat)) {
            datePattern = dateFormat.pattern();
        } else {
            datePattern = defaultDatePattern;
        }

        if (!simpleDateFormatMap.containsKey(datePattern)) {
            simpleDateFormatMap.put(datePattern, new SimpleDateFormat(datePattern));
        }
        return simpleDateFormatMap.get(datePattern);
    }

    /**
     * 构建List<Byte>
     *
     * @param fieldValue
     * @param separator
     * @return
     */
    public static List<Byte> buildByteArrayList(String fieldValue, String separator) {
        List<Byte> list = new ArrayList<Byte>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Byte.valueOf(str));
        }
        return list;
    }

    /**
     * 构建List<Short>
     *
     * @param fieldValue
     * @param separator
     * @return
     */
    public static List<Short> buildShortArrayList(String fieldValue, String separator) {
        List<Short> list = new ArrayList<Short>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Short.valueOf(str));
        }
        return list;
    }

    /**
     * 构建List<Integer>
     *
     * @param fieldValue
     * @param separator
     * @return
     */
    public static List<Integer> buildIntegerArrayList(String fieldValue, String separator) {
        List<Integer> list = new ArrayList<Integer>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Integer.valueOf(str));
        }
        return list;
    }

    /**
     * 构建List<Long>
     *
     * @param fieldValue
     * @param separator
     * @return
     */
    public static List<Long> buildLongArrayList(String fieldValue, String separator) {
        List<Long> list = new ArrayList<Long>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Long.valueOf(str));
        }
        return list;
    }

    /**
     * 构建List<Float>
     *
     * @param fieldValue
     * @param separator
     * @return
     */
    public static List<Float> buildFloatArrayList(String fieldValue, String separator) {
        List<Float> list = new ArrayList<Float>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Float.valueOf(str));
        }
        return list;
    }

    /**
     * 构建List<Double>
     *
     * @param fieldValue
     * @param separator
     * @return
     */
    public static List<Double> buildDoubleArrayList(String fieldValue, String separator) {
        List<Double> list = new ArrayList<Double>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Double.valueOf(str));
        }
        return list;
    }

    /**
     * 构建List<Character>
     *
     * @param fieldValue
     * @param separator
     * @return
     */
    public static List<Character> buildCharacterArrayList(String fieldValue, String separator) {
        List<Character> list = new ArrayList<Character>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(str.charAt(0));
        }
        return list;
    }

    /**
     * 构建List<Boolean>
     *
     * @param fieldValue
     * @param separator
     * @return
     */
    public static List<Boolean> buildBooleanArrayList(String fieldValue, String separator) {
        List<Boolean> list = new ArrayList<Boolean>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(Boolean.valueOf(str));
        }
        return list;
    }

    /**
     * 构建List<BigInteger>
     *
     * @param fieldValue
     * @param separator
     * @return
     */
    public static List<BigInteger> buildBigIntegerArrayList(String fieldValue, String separator) {
        List<BigInteger> list = new ArrayList<BigInteger>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(BigInteger.valueOf(Long.valueOf(str)));
        }
        return list;
    }

    /**
     * 构建List<BigDecimal>
     *
     * @param fieldValue
     * @param separator
     * @return
     */
    public static List<BigDecimal> buildBigDecimalArrayList(String fieldValue, String separator) {
        List<BigDecimal> list = new ArrayList<BigDecimal>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(BigDecimal.valueOf(Double.valueOf(str)));
        }
        return list;
    }

    /**
     * 构建List<Date>
     *
     * @param fieldValue
     * @param separator
     * @param simpleDateFormat
     * @return
     */
    public static List<Date> buildDateArrayList(String fieldValue, String separator, SimpleDateFormat simpleDateFormat) {
        List<Date> list = new ArrayList<Date>();
        String[] array = fieldValue.split(separator);
        try {
            for (String str : array) {
                list.add(simpleDateFormat.parse(str));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * 构建List<String>
     *
     * @param fieldValue
     * @param separator
     * @return
     */
    public static List<String> buildStringArrayList(String fieldValue, String separator) {
        List<String> list = new ArrayList<String>();
        String[] array = fieldValue.split(separator);
        for (String str : array) {
            list.add(str);
        }
        return list;
    }

    /**
     * 构建List
     *
     * @param field
     * @param type
     * @param parameterName
     * @param fieldValue
     * @param separator
     * @param simpleDateFormat
     * @return
     */
    private static Object buildArrayList(Field field, Type type, String parameterName, String fieldValue, String separator, SimpleDateFormat simpleDateFormat) {
        List<? extends Object> list = null;
        if (type == Byte.class) {
            list = buildByteArrayList(fieldValue, separator);
        } else if (type == Short.class) {
            list = buildShortArrayList(fieldValue, separator);
        } else if (type == Integer.class) {
            list = buildIntegerArrayList(fieldValue, separator);
        } else if (type == Long.class) {
            list = buildLongArrayList(fieldValue, separator);
        } else if (type == Float.class) {
            list = buildFloatArrayList(fieldValue, separator);
        } else if (type == Double.class) {
            list = buildFloatArrayList(fieldValue, separator);
        } else if (type == Character.class) {
            list = buildCharacterArrayList(fieldValue, separator);
        } else if (type == Boolean.class) {
            list = buildBooleanArrayList(fieldValue, separator);
        } else if (type == BigInteger.class) {
            list = buildBigIntegerArrayList(fieldValue, separator);
        } else if (type == BigDecimal.class) {
            list = buildBigDecimalArrayList(fieldValue, separator);
        } else if (type == Date.class) {
            list = buildDateArrayList(fieldValue, separator, simpleDateFormat);
        } else if (type == String.class) {
            list = buildStringArrayList(fieldValue, separator);
        } else {
            if (ValidateUtils.isJson(fieldValue)) {
                list = JacksonUtils.readValueAsList(fieldValue, (Class<? extends Object>) type);
            }
        }
        return list;
    }

    private static ApplicationContext applicationContext;
    private static ServletContext servletContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationHandler.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setServletContext(ServletContext servletContext) {
        ApplicationHandler.servletContext = servletContext;
    }

    public static ServletContext obtainServletContext() {
        return servletContext;
    }

    public static <T> T getBean(Class<T> beanClass) {
        return applicationContext.getBean(beanClass);
    }

    public static <T> T getBean(String name, Class<T> beanClass) {
        return applicationContext.getBean(name, beanClass);
    }

    public static Validator obtainValidator() {
        Validator validator = null;
        if (applicationContext.containsBean("validator")) {
            validator = (Validator) applicationContext.getBean("validator");
        } else {
            ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
            validator = validatorFactory.getValidator();
        }
        return validator;
    }

    public static MessageSource obtainMessageSource() {
        return applicationContext.getBean(MessageSource.class);
    }

    public static void notNullAndPut(Map<String, Object> targetMap, String key, Object value, String message) {
        ValidateUtils.notNull(value, message, ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
        targetMap.put(key, value);
    }

    public static void notBlankAndPut(Map<String, String> targetMap, String key, String value, String message) {
        ValidateUtils.isTrue(StringUtils.isNotBlank(value), message, ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
        targetMap.put(key, value);
    }

    public static void ifNotNullPut(Map<String, Object> targetMap, String key, Object value) {
        if (Objects.nonNull(value)) {
            targetMap.put(key, value);
        }
    }

    public static void ifNotBlankPut(Map<String, String> targetMap, String key, String value) {
        if (StringUtils.isNotBlank(value)) {
            targetMap.put(key, value);
        }
    }

    public static void ifNotBlankPut(Map<String, String> sourceMap, Map<String, String> targetMap, String... keys) {
        for (String key : keys) {
            String value = sourceMap.get(key);
            if (StringUtils.isNotBlank(key)) {
                targetMap.put(key, value);
            }
        }
    }

    public static void ifNotBlankPut(Map<String, String> sourceMap, Map<String, String> targetMap, Map<String, String> keyMapping) {
        Set<Map.Entry<String, String>> entries = keyMapping.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String value = sourceMap.get(entry.getKey());
            if (StringUtils.isNotBlank(value)) {
                targetMap.put(entry.getValue(), value);
            }
        }
    }

    public static String obtainParameterErrorMessage(String parameterName) {
        String deploymentEnvironment = ConfigurationUtils.getConfiguration(Constants.DEPLOYMENT_ENVIRONMENT);
        if (Constants.WWW.equals(deploymentEnvironment)) {
            return Constants.API_PARAMETER_ERROR_MESSAGE;
        }

        return String.format(Constants.PARAMETER_ERROR_MESSAGE_PATTERN, parameterName);
    }

    public static String obtainRequestMethod() {
        return getHttpServletRequest().getMethod();
    }

    public static void forward(String controllerName, String actionName, Map<String, Object> attributes) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        if (MapUtils.isNotEmpty(attributes)) {
            for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                httpServletRequest.setAttribute(entry.getKey(), entry.getValue());
            }
        }
        HttpServletResponse httpServletResponse = getHttpServletResponse();
        httpServletRequest.getRequestDispatcher("/" + controllerName + "/" + actionName).forward(httpServletRequest, httpServletResponse);
    }

    public static void forward(String path) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        HttpServletResponse httpServletResponse = getHttpServletResponse();
        httpServletRequest.getRequestDispatcher(path).forward(httpServletRequest, httpServletResponse);
    }

    public static String obtainHttpHeader(String name) {
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        return httpServletRequest.getHeader(name);
    }

    public static void redirect(String url) throws IOException {
        ApplicationHandler.getHttpServletResponse().sendRedirect(url);
    }

    public static void notNull(Object object, String parameterName) {
        ValidateUtils.notNull(object, obtainParameterErrorMessage(parameterName), ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void isTrue(boolean expression, String parameterName) {
        ValidateUtils.isTrue(expression, obtainParameterErrorMessage(parameterName), ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void notEmpty(Object[] array, String parameterName) {
        ValidateUtils.notEmpty(array, obtainParameterErrorMessage(parameterName), ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void notEmpty(Collection collection, String parameterName) {
        ValidateUtils.notEmpty(collection, obtainParameterErrorMessage(parameterName), ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void notEmpty(Map map, String parameterName) {
        ValidateUtils.notEmpty(map, obtainParameterErrorMessage(parameterName), ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void notEmpty(String string, String parameterName) {
        ValidateUtils.notEmpty(string, obtainParameterErrorMessage(parameterName), ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void inArray(Object[] array, Object value, String name) {
        ValidateUtils.inArray(array, value, "参数(" + name + ")只能为【" + StringUtils.join(array, "，") + "】中的一个！", ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void inArray(Long[] array, Long value, String name) {
        ValidateUtils.inArray(array, value, "参数(" + name + ")只能为【" + StringUtils.join(array, "，") + "】中的一个！", ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void inArray(Integer[] array, Integer value, String name) {
        ValidateUtils.inArray(array, value, "参数(" + name + ")只能为【" + StringUtils.join(array, "，") + "】中的一个！", ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void inArray(Short[] array, Short value, String name) {
        ValidateUtils.inArray(array, value, "参数(" + name + ")只能为【" + StringUtils.join(array, "，") + "】中的一个！", ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void inArray(Character[] array, Character value, String name) {
        ValidateUtils.inArray(array, value, "参数(" + name + ")只能为【" + StringUtils.join(array, "，") + "】中的一个！", ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void inArray(Byte[] array, Byte value, String name) {
        ValidateUtils.inArray(array, value, "参数(" + name + ")只能为【" + StringUtils.join(array, "，") + "】中的一个！", ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void inArray(Double[] array, Double value, String name) {
        ValidateUtils.inArray(array, value, "参数(" + name + ")只能为【" + StringUtils.join(array, "，") + "】中的一个！", ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void inArray(Float[] array, Float value, String name) {
        ValidateUtils.inArray(array, value, "参数(" + name + ")只能为【" + StringUtils.join(array, "，") + "】中的一个！", ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void inArray(Boolean[] array, Boolean value, String name) {
        ValidateUtils.inArray(array, value, "参数(" + name + ")只能为【" + StringUtils.join(array, "，") + "】中的一个！", ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void validateJson(String jsonString, String schemaFilePath, String parameterName) {
        isJson(jsonString, parameterName);
        isTrue(ValidateUtils.isRightJson(jsonString, schemaFilePath), parameterName);
    }

    public static void isJson(String jsonString, String parameterName) {
        isTrue(ValidateUtils.isJson(jsonString), parameterName);
    }

    public static void notBlank(String string, String parameterName) {
        ValidateUtils.notBlank(string, obtainParameterErrorMessage(parameterName), ErrorConstants.ERROR_CODE_INVALID_PARAMETER);
    }

    public static void invalidateHttpSession() {
        getHttpSession().invalidate();
    }

    public static String getRequestHeader(String name) {
        return getRequestHeader(getHttpServletRequest(), name);
    }

    public static String getRequestHeader(HttpServletRequest httpServletRequest, String name) {
        return httpServletRequest.getHeader(name);
    }

    public static List<String> getRequestHeaders(String name) {
        return getRequestHeaders(getHttpServletRequest(), name);
    }

    public static List<String> getRequestHeaders(HttpServletRequest httpServletRequest, String name) {
        List<String> headers = new ArrayList<String>();
        Enumeration<String> enumeration = httpServletRequest.getHeaders(name);
        while (enumeration.hasMoreElements()) {
            headers.add(enumeration.nextElement());
        }
        return headers;
    }

    public static Map<String, List<String>> getRequestHeaders() {
        return getRequestHeaders(getHttpServletRequest());
    }

    public static Map<String, List<String>> getRequestHeaders(HttpServletRequest httpServletRequest) {
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            headers.put(name, getRequestHeaders(httpServletRequest, name));
        }
        return headers;
    }

    public static List<Cookie> getCookies() {
        return getCookies(getHttpServletRequest());
    }

    public static List<Cookie> getCookies(HttpServletRequest httpServletRequest) {
        List<Cookie> cookieList = new ArrayList<Cookie>();
        Cookie[] cookies = httpServletRequest.getCookies();
        if (ArrayUtils.isEmpty(cookies)) {
            return cookieList;
        }
        for (Cookie cookie : cookies) {
            cookieList.add(cookie);
        }
        return cookieList;
    }

    public static Cookie getCookie(String name) {
        return getCookie(getHttpServletRequest(), name);
    }

    public static Cookie getCookie(HttpServletRequest httpServletRequest, String name) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (ArrayUtils.isEmpty(cookies)) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

    public static String getResponseHeader(String name) {
        return getResponseHeader(getHttpServletResponse(), name);
    }

    public static String getResponseHeader(HttpServletResponse httpServletResponse, String name) {
        return httpServletResponse.getHeader(name);
    }

    public static List<String> getResponseHeaders(String name) {
        return getResponseHeaders(getHttpServletResponse(), name);
    }

    public static List<String> getResponseHeaders(HttpServletResponse httpServletResponse, String name) {
        List<String> responseHeaders = new ArrayList<String>();

        Collection<String> headers = httpServletResponse.getHeaders(name);
        for (String header : headers) {
            responseHeaders.add(header);
        }
        return responseHeaders;
    }

    public static Map<String, List<String>> getResponseHeaders() {
        return getResponseHeaders(getHttpServletResponse());
    }

    public static Map<String, List<String>> getResponseHeaders(HttpServletResponse httpServletResponse) {
        Map<String, List<String>> responseHeaders = new HashMap<String, List<String>>();
        Collection<String> names = httpServletResponse.getHeaderNames();
        for (String name : names) {
            responseHeaders.put(name, getResponseHeaders(name));
        }
        return responseHeaders;
    }

    public static String today() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    public static <T> T obtainSessionAttribute(String name) {
        return obtainSessionAttribute(getHttpSession(), name);
    }

    public static <T> T obtainSessionAttribute(HttpSession httpSession, String name) {
        return (T) httpSession.getAttribute(name);
    }

    public static Map<String, Object> obtainAllSessionAttributes() {
        return obtainAllSessionAttributes(getHttpSession());
    }

    public static Map<String, Object> obtainAllSessionAttributes(HttpSession httpSession) {
        Enumeration<String> attributeNames = httpSession.getAttributeNames();
        Map<String, Object> attributesMap = new HashMap<String, Object>();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            attributesMap.put(attributeName, httpSession.getAttribute(attributeName));
        }
        return attributesMap;
    }

    public static void setSessionAttribute(String name, String value) {
        setSessionAttribute(getHttpSession(), name, value);
    }

    public static void setSessionAttribute(HttpSession httpSession, String name, String value) {
        httpSession.setAttribute(name, value);
    }

    public static void setSessionAttributes(Map<String, Object> attributes) {
        setSessionAttributes(getHttpSession(), attributes);
    }

    public static void setSessionAttributes(HttpSession httpSession, Map<String, Object> attributes) {
        for (Map.Entry<String, Object> attribute : attributes.entrySet()) {
            httpSession.setAttribute(attribute.getKey(), attribute.getValue());
        }
    }

    public static boolean isAjax() {
        return isAjax(getHttpServletRequest());
    }

    public static boolean isAjax(HttpServletRequest httpServletRequest) {
        String headerValue = getRequestHeader(httpServletRequest, HttpHeaders.X_REQUESTED_WITH);
        if (StringUtils.isBlank(headerValue)) {
            return false;
        }
        return headerValue.equalsIgnoreCase(Constants.XML_HTTP_REQUEST);
    }

    public static <T> T callMethodSuppressThrow(SuppressThrowFunction<T> suppressThrowFunction) {
        try {
            return suppressThrowFunction.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void callMethodSuppressThrow(SuppressThrowNoReturnFunction suppressThrowNoReturnFunction) {
        try {
            suppressThrowNoReturnFunction.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}