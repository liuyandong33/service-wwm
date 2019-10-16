package build.dream.wwm.annotations;

import build.dream.wwm.constants.Constants;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateFormat {
    String pattern() default Constants.DEFAULT_DATE_PATTERN;
}
