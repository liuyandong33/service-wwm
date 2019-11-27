package build.dream.wwm.domains;

/**
 * 主要附属设备
 */
public class AttachedDevice extends BasicDomain {
    public static final String TABLE_NAME = "technical_data";
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
     * 设备类型
     */
    private String deviceName;

    /**
     * 详细参数
     */
    private String detailedParameter;

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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDetailedParameter() {
        return detailedParameter;
    }

    public void setDetailedParameter(String detailedParameter) {
        this.detailedParameter = detailedParameter;
    }

    public static class Builder extends BasicDomain.Builder<Builder, AttachedDevice> {
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

        public Builder deviceName(String deviceName) {
            instance.setDeviceName(deviceName);
            return this;
        }

        public Builder detailedParameter(String detailedParameter) {
            instance.setDetailedParameter(detailedParameter);
            return this;
        }

        @Override
        public AttachedDevice build() {
            AttachedDevice attachedDevice = super.build();
            attachedDevice.setWaterWorksId(instance.getWaterWorksId());
            attachedDevice.setDeviceId(instance.getDeviceId());
            attachedDevice.setDeviceCode(instance.getDeviceCode());
            attachedDevice.setDeviceName(instance.getDeviceName());
            attachedDevice.setDetailedParameter(instance.getDetailedParameter());
            return attachedDevice;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String WATER_WORKS_ID = "water_works_id";
        public static final String DEVICE_ID = "device_id";
        public static final String DEVICE_CODE = "device_code";
        public static final String DEVICE_NAME = "device_name";
        public static final String DETAILED_PARAMETER = "detailed_parameter";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String WATER_WORKS_ID = "waterWorksId";
        public static final String DEVICE_ID = "deviceId";
        public static final String DEVICE_CODE = "deviceCode";
        public static final String DEVICE_NAME = "deviceName";
        public static final String DETAILED_PARAMETER = "detailedParameter";
    }
}
