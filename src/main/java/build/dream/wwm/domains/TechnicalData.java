package build.dream.wwm.domains;

public class TechnicalData extends BasicDomain {
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
    private String deviceType;

    /**
     * 流量（m³/h）
     */
    private Double flow;

    /**
     * 配用功率（KW）
     */
    private Double power;

    /**
     * 扬程（M）
     */
    private Double lift;

    /**
     * 同步转速（r/min）
     */
    private Double rotarySpeed;

    /**
     * 排出口径（mm）
     */
    private Double caliber;

    /**
     * 重量（KG）
     */
    private Double weight;

    /**
     * 额定电压（V）
     */
    private Double ratedVoltage;

    /**
     * 额定电流（V）
     */
    private Double ratedCurrent;

    /**
     * 频率（HZ）
     */
    private Double frequency;

    /**
     * 外壳保护等级
     */
    private String internationalProtectionMarking;

    /**
     * 绝缘等级
     */
    private String insulationLevel;

    /**
     * 相数
     */
    private String phase;

    /**
     * 产品标准编号
     */
    private String productStandardNo;

    /**
     * 生产许可证编号
     */
    private String productionLicenseNo;

    /**
     * 生产厂家
     */
    private String manufacturer;

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

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getLift() {
        return lift;
    }

    public void setLift(Double lift) {
        this.lift = lift;
    }

    public Double getRotarySpeed() {
        return rotarySpeed;
    }

    public void setRotarySpeed(Double rotarySpeed) {
        this.rotarySpeed = rotarySpeed;
    }

    public Double getCaliber() {
        return caliber;
    }

    public void setCaliber(Double caliber) {
        this.caliber = caliber;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getRatedVoltage() {
        return ratedVoltage;
    }

    public void setRatedVoltage(Double ratedVoltage) {
        this.ratedVoltage = ratedVoltage;
    }

    public Double getRatedCurrent() {
        return ratedCurrent;
    }

    public void setRatedCurrent(Double ratedCurrent) {
        this.ratedCurrent = ratedCurrent;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public String getInternationalProtectionMarking() {
        return internationalProtectionMarking;
    }

    public void setInternationalProtectionMarking(String internationalProtectionMarking) {
        this.internationalProtectionMarking = internationalProtectionMarking;
    }

    public String getInsulationLevel() {
        return insulationLevel;
    }

    public void setInsulationLevel(String insulationLevel) {
        this.insulationLevel = insulationLevel;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getProductStandardNo() {
        return productStandardNo;
    }

    public void setProductStandardNo(String productStandardNo) {
        this.productStandardNo = productStandardNo;
    }

    public String getProductionLicenseNo() {
        return productionLicenseNo;
    }

    public void setProductionLicenseNo(String productionLicenseNo) {
        this.productionLicenseNo = productionLicenseNo;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
