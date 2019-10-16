package build.dream.wwm.utils;

import java.util.HashMap;

public class UnderscoreToCamelCaseMap<V> extends HashMap<String, V> {
    @Override
    public V put(String key, V value) {
        return super.put(NamingStrategyUtils.underscoreToLowerCamelCaseIgnoreCase(key), value);
    }
}
