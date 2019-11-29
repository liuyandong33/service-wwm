package build.dream.wwm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamingStrategyUtils {
    private static Pattern camelCasePattern = Pattern.compile("[A-Z]");

    /**
     * 下换线转驼峰
     *
     * @param underscore
     * @param type:      1-转为小驼峰（LowerCamelCase），2-转为大驼峰（UpperCamelCase）
     * @return
     */
    public static String underscoreToCamelCase(String underscore, int type) {
        StringBuilder camelCase = new StringBuilder();
        String[] underscoreArray = underscore.split("_");
        String firstWord = underscoreArray[0];
        if (type == 1) {
            camelCase.append(firstWord);
        } else if (type == 2) {
            if (firstWord.length() == 1) {
                camelCase.append(firstWord);
            } else {
                camelCase.append(firstWord.substring(0, 1).toUpperCase());
                camelCase.append(firstWord.substring(1));
            }
        }
        int length = underscoreArray.length;
        for (int index = 1; index < length; index++) {
            String underscoreSplit = underscoreArray[index];
            if (underscoreSplit.length() == 1) {
                camelCase.append(underscoreSplit.toUpperCase());
                continue;
            }
            camelCase.append(underscoreSplit.substring(0, 1).toUpperCase()).append(underscoreSplit.substring(1));
        }
        return camelCase.toString();
    }

    /**
     * 下换线转小驼峰
     * test_named ==> testNamed
     *
     * @param underscore
     * @return
     */
    public static String underscoreToLowerCamelCase(String underscore) {
        return underscoreToCamelCase(underscore, 1);
    }

    /**
     * 下换线转小驼峰，忽略下划线命名中大小写
     * Test_Named ==> testNamed
     * test_named ==> testNamed
     *
     * @param underscore
     * @return
     */
    public static String underscoreToLowerCamelCaseIgnoreCase(String underscore) {
        return underscoreToLowerCamelCase(underscore.toLowerCase());
    }

    /**
     * 下划线转大驼峰
     * test_named ==> TestNamed
     *
     * @param underscore
     * @return
     */
    public static String underscoreToUpperCamelCase(String underscore) {
        return underscoreToCamelCase(underscore, 2);
    }

    /**
     * 下划线转大驼峰，忽略下划线命名中的大小写
     * Test_Named ==> TestNamed
     * test_named ==> TestNamed
     *
     * @param underscore
     * @return
     */
    public static String underscoreToUpperCamelCaseIgnoreCase(String underscore) {
        return underscoreToCamelCase(underscore.toLowerCase(), 2);
    }

    /**
     * 小驼峰转下划线命名
     * testNamed ==> test_named
     *
     * @param camelCase
     * @return
     */
    public static String lowerCamelCaseToUnderscore(String camelCase) {
        Matcher matcher = camelCasePattern.matcher(camelCase);
        StringBuffer underscore = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(underscore, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(underscore);
        return underscore.toString();
    }

    /**
     * 大驼峰转下划线命名
     * TestNamed ==> test_named
     *
     * @param camelCase
     * @return
     */
    public static String upperCamelCaseToUnderscore(String camelCase) {
        return lowerCamelCaseToUnderscore(camelCase).substring(1);
    }
}
