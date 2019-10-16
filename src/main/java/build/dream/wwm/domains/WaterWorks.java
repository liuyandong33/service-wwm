package build.dream.wwm.domains;

public class WaterWorks extends BasicDomain {
    public static final String TABLE_NAME = "water_works";
    /**
     * 水厂编码
     */
    private String code;
    /**
     * 水厂名称
     */
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder extends BasicDomain.Builder<Builder, WaterWorks> {
        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        @Override
        public WaterWorks build() {
            WaterWorks waterWorks = super.build();
            waterWorks.setCode(instance.getCode());
            waterWorks.setName(instance.getName());
            return waterWorks;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String CODE = "code";
        public static final String NAME = "name";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String CODE = "code";
        public static final String NAME = "name";
    }
}
