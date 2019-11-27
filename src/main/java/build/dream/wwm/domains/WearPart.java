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
}
