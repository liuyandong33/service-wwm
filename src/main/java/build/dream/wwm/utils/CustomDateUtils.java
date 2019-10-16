package build.dream.wwm.utils;

import build.dream.wwm.constants.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class CustomDateUtils {
    public static Date parse(String source, String pattern) {
        return parse(new SimpleDateFormat(pattern), source);
    }

    public static Date parse(SimpleDateFormat simpleDateFormat, String source) {
        return ApplicationHandler.callMethodSuppressThrow(() -> simpleDateFormat.parse(source));
    }

    public static String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static SimpleDateFormat buildISO8601SimpleDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.ISO8601_DATE_PATTERN, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, Constants.GMT));
        return simpleDateFormat;
    }
}
