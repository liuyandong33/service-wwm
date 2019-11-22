package build.dream.wwm.domains;

import java.util.Date;

public class PurchaseRequisition extends BasicDomain {
    public static final String TABLE_NAME = "purchase_requisition";
    /**
     * 水厂ID
     */
    private long waterWorksId;

    /**
     * 采购申请单编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 申请时间
     */
    private Date applicationTime;

    /**
     * 申请人ID
     */
    private Long applicantId;

    /**
     * 金额
     */
    private Double totalAmount;

    /**
     * 实际金额
     */
    private Double actualAmount;

    /**
     * 申请单状态
     */
    private Integer status;

    public long getWaterWorksId() {
        return waterWorksId;
    }

    public void setWaterWorksId(long waterWorksId) {
        this.waterWorksId = waterWorksId;
    }

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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static class Builder extends BasicDomain.Builder<Builder, PurchaseRequisition> {
        public Builder waterWorksId(long waterWorksId) {
            instance.setWaterWorksId(waterWorksId);
            return this;
        }

        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder supplierId(Long supplierId) {
            instance.setSupplierId(supplierId);
            return this;
        }

        public Builder applicationTime(Date applicationTime) {
            instance.setApplicationTime(applicationTime);
            return this;
        }

        public Builder applicantId(Long applicantId) {
            instance.setApplicantId(applicantId);
            return this;
        }

        public Builder totalAmount(Double totalAmount) {
            instance.setTotalAmount(totalAmount);
            return this;
        }

        public Builder actualAmount(Double actualAmount) {
            instance.setActualAmount(actualAmount);
            return this;
        }

        public Builder status(Integer status) {
            instance.setStatus(status);
            return this;
        }

        @Override
        public PurchaseRequisition build() {
            PurchaseRequisition purchaseRequisition = super.build();
            purchaseRequisition.setWaterWorksId(instance.getWaterWorksId());
            purchaseRequisition.setCode(instance.getCode());
            purchaseRequisition.setName(instance.getName());
            purchaseRequisition.setSupplierId(instance.getSupplierId());
            purchaseRequisition.setApplicationTime(instance.getApplicationTime());
            purchaseRequisition.setApplicantId(instance.getApplicantId());
            purchaseRequisition.setTotalAmount(instance.getTotalAmount());
            purchaseRequisition.setActualAmount(instance.getActualAmount());
            purchaseRequisition.setStatus(instance.getStatus());
            return purchaseRequisition;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String WATER_WORKS_ID = "water_works_id";
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String SUPPLIER_ID = "supplier_id";
        public static final String APPLICATION_TIME = "application_time";
        public static final String APPLICANT_ID = "applicant_id";
        public static final String TOTAL_AMOUNT = "total_amount";
        public static final String ACTUAL_AMOUNT = "actual_amount";
        public static final String STATUS = "status";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String WATER_WORKS_ID = "waterWorksId";
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String SUPPLIER_ID = "supplierId";
        public static final String APPLICATION_TIME = "applicationTime";
        public static final String APPLICANT_ID = "applicantId";
        public static final String TOTAL_AMOUNT = "totalAmount";
        public static final String ACTUAL_AMOUNT = "actualAmount";
        public static final String STATUS = "status";
    }
}
