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

    public static class Builder extends BasicDomain.Builder<Builder, TechnicalData> {
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

        public Builder deviceType(String deviceType) {
            instance.setDeviceType(deviceType);
            return this;
        }

        public Builder flow(Double flow) {
            instance.setFlow(flow);
            return this;
        }

        public Builder power(Double power) {
            instance.setPower(power);
            return this;
        }

        public Builder lift(Double lift) {
            instance.setLift(lift);
            return this;
        }

        public Builder rotarySpeed(Double rotarySpeed) {
            instance.setRotarySpeed(rotarySpeed);
            return this;
        }

        public Builder caliber(Double caliber) {
            instance.setCaliber(caliber);
            return this;
        }

        public Builder weight(Double weight) {
            instance.setWeight(weight);
            return this;
        }

        public Builder ratedVoltage(Double ratedVoltage) {
            instance.setRatedVoltage(ratedVoltage);
            return this;
        }

        public Builder ratedCurrent(Double ratedCurrent) {
            instance.setRatedCurrent(ratedCurrent);
            return this;
        }

        public Builder frequency(Double frequency) {
            instance.setFrequency(frequency);
            return this;
        }

        public Builder internationalProtectionMarking(String internationalProtectionMarking) {
            instance.setInternationalProtectionMarking(internationalProtectionMarking);
            return this;
        }

        public Builder insulationLevel(String insulationLevel) {
            instance.setInsulationLevel(insulationLevel);
            return this;
        }

        public Builder phase(String phase) {
            instance.setPhase(phase);
            return this;
        }

        public Builder productStandardNo(String productStandardNo) {
            instance.setProductStandardNo(productStandardNo);
            return this;
        }

        public Builder productionLicenseNo(String productionLicenseNo) {
            instance.setProductionLicenseNo(productionLicenseNo);
            return this;
        }

        public Builder manufacturer(String manufacturer) {
            instance.setManufacturer(manufacturer);
            return this;
        }

        @Override
        public TechnicalData build() {
            TechnicalData technicalData = super.build();
            technicalData.setWaterWorksId(instance.getWaterWorksId());
            technicalData.setDeviceId(instance.getDeviceId());
            technicalData.setDeviceCode(instance.getDeviceCode());
            technicalData.setDeviceType(instance.getDeviceType());
            technicalData.setFlow(instance.getFlow());
            technicalData.setPower(instance.getPower());
            technicalData.setLift(instance.getLift());
            technicalData.setRotarySpeed(instance.getRotarySpeed());
            technicalData.setCaliber(instance.getCaliber());
            technicalData.setWeight(instance.getWeight());
            technicalData.setRatedVoltage(instance.getRatedVoltage());
            technicalData.setRatedCurrent(instance.getRatedCurrent());
            technicalData.setFrequency(instance.getFrequency());
            technicalData.setInternationalProtectionMarking(instance.getInternationalProtectionMarking());
            technicalData.setInsulationLevel(instance.getInsulationLevel());
            technicalData.setPhase(instance.getPhase());
            technicalData.setProductStandardNo(instance.getProductStandardNo());
            technicalData.setProductionLicenseNo(instance.getProductionLicenseNo());
            technicalData.setManufacturer(instance.getManufacturer());
            return technicalData;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String WATER_WORKS_ID = "water_works_id";
        public static final String DEVICE_ID = "device_id";
        public static final String DEVICE_CODE = "device_code";
        public static final String DEVICE_TYPE = "device_type";
        public static final String FLOW = "flow";
        public static final String POWER = "power";
        public static final String LIFT = "lift";
        public static final String ROTARY_SPEED = "rotary_speed";
        public static final String CALIBER = "caliber";
        public static final String WEIGHT = "weight";
        public static final String RATED_VOLTAGE = "rated_voltage";
        public static final String RATED_CURRENT = "rated_current";
        public static final String FREQUENCY = "frequency";
        public static final String INTERNATIONAL_PROTECTION_MARKING = "international_protection_marking";
        public static final String INSULATION_LEVEL = "insulation_level";
        public static final String PHASE = "phase";
        public static final String PRODUCT_STANDARD_NO = "product_standard_no";
        public static final String PRODUCTION_LICENSE_NO = "production_license_no";
        public static final String MANUFACTURER = "manufacturer";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String WATER_WORKS_ID = "waterWorksId";
        public static final String DEVICE_ID = "deviceId";
        public static final String DEVICE_CODE = "deviceCode";
        public static final String DEVICE_TYPE = "deviceType";
        public static final String FLOW = "flow";
        public static final String POWER = "power";
        public static final String LIFT = "lift";
        public static final String ROTARY_SPEED = "rotarySpeed";
        public static final String CALIBER = "caliber";
        public static final String WEIGHT = "weight";
        public static final String RATED_VOLTAGE = "ratedVoltage";
        public static final String RATED_CURRENT = "ratedCurrent";
        public static final String FREQUENCY = "frequency";
        public static final String INTERNATIONAL_PROTECTION_MARKING = "internationalProtectionMarking";
        public static final String INSULATION_LEVEL = "insulationLevel";
        public static final String PHASE = "phase";
        public static final String PRODUCT_STANDARD_NO = "productStandardNo";
        public static final String PRODUCTION_LICENSE_NO = "productionLicenseNo";
        public static final String MANUFACTURER = "manufacturer";
    }
}
