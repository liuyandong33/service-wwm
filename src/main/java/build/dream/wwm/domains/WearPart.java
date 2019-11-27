package build.dream.wwm.domains;

/**
 * 易损件
 */
public class WearPart extends BasicDomain {
    public static final String TABLE_NAME = "wear_part";
    /**
     * 水厂ID
     */
    private Long waterWorksId;

    /**
     * 设备ID
     */
    private Long deviceId;

    /**
     * 设备编码
     */
    private String deviceCode;

    /**
     * 配件名称
     */
    private String name;

    /**
     * 型号规格
     */
    private String model;

    /**
     * 数量
     */
    private Double quantity;

    /**
     * 备注
     */
    private String remark;

    public Long getWaterWorksId() {
        return waterWorksId;
    }

    public void setWaterWorksId(Long waterWorksId) {
        this.waterWorksId = waterWorksId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class Builder extends BasicDomain.Builder<Builder, WearPart> {
        public Builder waterWorksId(Long waterWorksId) {
            instance.setWaterWorksId(waterWorksId);
            return this;
        }

        public Builder deviceId(Long deviceId) {
            instance.setDeviceId(deviceId);
            return this;
        }

        public Builder deviceCode(String deviceCode) {
            instance.setDeviceCode(deviceCode);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder model(String model) {
            instance.setModel(model);
            return this;
        }

        public Builder quantity(Double quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        @Override
        public WearPart build() {
            WearPart wearPart = super.build();
            wearPart.setWaterWorksId(instance.getWaterWorksId());
            wearPart.setDeviceId(instance.getDeviceId());
            wearPart.setDeviceCode(instance.getDeviceCode());
            wearPart.setName(instance.getName());
            wearPart.setModel(instance.getModel());
            wearPart.setQuantity(instance.getQuantity());
            wearPart.setRemark(instance.getRemark());
            return wearPart;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String WATER_WORKS_ID = "water_works_id";
        public static final String DEVICE_ID = "device_id";
        public static final String DEVICE_CODE = "device_code";
        public static final String NAME = "name";
        public static final String MODEL = "model";
        public static final String QUANTITY = "quantity";
        public static final String REMARK = "remark";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String WATER_WORKS_ID = "waterWorksId";
        public static final String DEVICE_ID = "deviceId";
        public static final String DEVICE_CODE = "deviceCode";
        public static final String NAME = "name";
        public static final String MODEL = "model";
        public static final String QUANTITY = "quantity";
        public static final String REMARK = "remark";
    }
}
