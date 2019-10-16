package build.dream.wwm.domains;

public class Organization extends BasicDomain {
    public static final String TABLE_NAME = "organization";
    /**
     * 水厂编码
     */
    private String code;
    /**
     * 水厂名称
     */
    private String name;
    /**
     * 水厂ID
     */
    private long waterWorksId;
    /**
     * 上级机构ID
     */
    private long parentId;

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

    public long getWaterWorksId() {
        return waterWorksId;
    }

    public void setWaterWorksId(long waterWorksId) {
        this.waterWorksId = waterWorksId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Organization> {
        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder waterWorksId(long waterWorksId) {
            instance.setWaterWorksId(waterWorksId);
            return this;
        }

        public Builder parentId(long parentId) {
            instance.setParentId(parentId);
            return this;
        }

        @Override
        public Organization build() {
            Organization organization = super.build();
            organization.setCode(instance.getCode());
            organization.setName(instance.getName());
            organization.setWaterWorksId(instance.getWaterWorksId());
            organization.setParentId(instance.getParentId());
            return organization;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String WATER_WORKS_ID = "water_works_id";
        public static final String PARENT_ID = "parent_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String WATER_WORKS_ID = "waterWorksId";
        public static final String PARENT_ID = "parentId";
    }
}
