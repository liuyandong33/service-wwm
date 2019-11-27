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
}
