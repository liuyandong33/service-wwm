package build.dream.wwm.utils;

import build.dream.wwm.constants.Constants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by liuyandong on 2017/5/11.
 */
public class PropertyUtils {
    private static Properties properties = null;

    public static String getProperty(String key) {
        return getProperties().getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return getProperties().getProperty(key, defaultValue);
    }

    public static Properties getProperties() {
        if (Objects.isNull(properties)) {
            loadProperties();
        }
        return properties;
    }

    public static void loadProperties() {
        properties = new Properties();
        try (InputStream inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream(Constants.DEVELOPMENT_PROPERTIES)) {
            if (Objects.nonNull(inputStream)) {
                loadProperties(inputStream);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadProperties(InputStream inputStream) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Constants.CHARSET_UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            properties.load(bufferedReader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
