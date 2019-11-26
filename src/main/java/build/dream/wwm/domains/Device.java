package build.dream.wwm.domains;

import java.util.Date;

public class Device extends BasicDomain {
    public static final String TABLE_NAME = "device";
    /**
     * 水厂ID
     */
    private Long waterWorksId;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备编号
     */
    private String code;

    /**
     * 设备型号
     */
    private String model;

    /**
     * 设备分类
     */
    private String category;

    /**
     * 设备所属部门
     */
    private String department;

    /**
     * 设备存放地点
     */
    private String storageLocation;

    /**
     * 建档日期
     */
    private Date createdDate;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 购置日期
     */
    private Date purchasedDate;

    /**
     * 数量
     */
    private Double quantity;

    /**
     * 单价
     */
    private Double price;

    /**
     * 购置金额
     */
    private Double purchasedAmount;

    /**
     * 所属管理员
     */
    private String administrator;

    /**
     * 登记人
     */
    private String registrant;

    /**
     * 规定使用年限
     */
    private Double specifiedServiceLife;

    /**
     * 保修截止日期
     */
    private Date warrantyExpirationDate;

    /**
     * 设备资产状态
     */
    private String assetStatus;

    /**
     * 设备图片地址
     */
    private String imageUrl;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPurchasedAmount() {
        return purchasedAmount;
    }

    public void setPurchasedAmount(Double purchasedAmount) {
        this.purchasedAmount = purchasedAmount;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Double getSpecifiedServiceLife() {
        return specifiedServiceLife;
    }

    public void setSpecifiedServiceLife(Double specifiedServiceLife) {
        this.specifiedServiceLife = specifiedServiceLife;
    }

    public Date getWarrantyExpirationDate() {
        return warrantyExpirationDate;
    }

    public void setWarrantyExpirationDate(Date warrantyExpirationDate) {
        this.warrantyExpirationDate = warrantyExpirationDate;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Device> {
        public Builder waterWorksId(Long waterWorksId) {
            instance.setWaterWorksId(waterWorksId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder model(String model) {
            instance.setModel(model);
            return this;
        }

        public Builder category(String category) {
            instance.setCategory(category);
            return this;
        }

        public Builder department(String department) {
            instance.setDepartment(department);
            return this;
        }

        public Builder storageLocation(String storageLocation) {
            instance.setStorageLocation(storageLocation);
            return this;
        }

        public Builder createdDate(Date createdDate) {
            instance.setCreatedDate(createdDate);
            return this;
        }

        public Builder brand(String brand) {
            instance.setBrand(brand);
            return this;
        }

        public Builder supplier(String supplier) {
            instance.setSupplier(supplier);
            return this;
        }

        public Builder purchasedDate(Date purchasedDate) {
            instance.setPurchasedDate(purchasedDate);
            return this;
        }

        public Builder quantity(Double quantity) {
            instance.setQuantity(quantity);
            return this;
        }

        public Builder price(Double price) {
            instance.setPrice(price);
            return this;
        }

        public Builder purchasedAmount(Double purchasedAmount) {
            instance.setPurchasedAmount(purchasedAmount);
            return this;
        }

        public Builder administrator(String administrator) {
            instance.setAdministrator(administrator);
            return this;
        }

        public Builder registrant(String registrant) {
            instance.setRegistrant(registrant);
            return this;
        }

        public Builder specifiedServiceLife(Double specifiedServiceLife) {
            instance.setSpecifiedServiceLife(specifiedServiceLife);
            return this;
        }

        public Builder warrantyExpirationDate(Date warrantyExpirationDate) {
            instance.setWarrantyExpirationDate(warrantyExpirationDate);
            return this;
        }

        public Builder assetStatus(String assetStatus) {
            instance.setAssetStatus(assetStatus);
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            instance.setImageUrl(imageUrl);
            return this;
        }

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        @Override
        public Device build() {
            Device device = super.build();
            device.setWaterWorksId(instance.getWaterWorksId());
            device.setName(instance.getName());
            device.setCode(instance.getCode());
            device.setModel(instance.getModel());
            device.setCategory(instance.getCategory());
            device.setDepartment(instance.getDepartment());
            device.setStorageLocation(instance.getStorageLocation());
            device.setCreatedDate(instance.getCreatedDate());
            device.setBrand(instance.getBrand());
            device.setSupplier(instance.getSupplier());
            device.setPurchasedDate(instance.getPurchasedDate());
            device.setQuantity(instance.getQuantity());
            device.setPrice(instance.getPrice());
            device.setPurchasedAmount(instance.getPurchasedAmount());
            device.setAdministrator(instance.getAdministrator());
            device.setRegistrant(instance.getRegistrant());
            device.setSpecifiedServiceLife(instance.getSpecifiedServiceLife());
            device.setWarrantyExpirationDate(instance.getWarrantyExpirationDate());
            device.setAssetStatus(instance.getAssetStatus());
            device.setImageUrl(instance.getImageUrl());
            device.setRemark(instance.getRemark());
            return device;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String WATER_WORKS_ID = "water_works_id";
        public static final String NAME = "name";
        public static final String CODE = "code";
        public static final String MODEL = "model";
        public static final String CATEGORY = "category";
        public static final String DEPARTMENT = "department";
        public static final String STORAGE_LOCATION = "storage_location";
        public static final String CREATED_DATE = "created_date";
        public static final String BRAND = "brand";
        public static final String SUPPLIER = "supplier";
        public static final String PURCHASED_DATE = "purchased_date";
        public static final String QUANTITY = "quantity";
        public static final String PRICE = "price";
        public static final String PURCHASED_AMOUNT = "purchased_amount";
        public static final String ADMINISTRATOR = "administrator";
        public static final String REGISTRANT = "registrant";
        public static final String SPECIFIED_SERVICE_LIFE = "specified_service_life";
        public static final String WARRANTY_EXPIRATION_DATE = "warranty_expiration_date";
        public static final String ASSET_STATUS = "asset_status";
        public static final String IMAGE_URL = "image_url";
        public static final String REMARK = "remark";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String WATER_WORKS_ID = "waterWorksId";
        public static final String NAME = "name";
        public static final String CODE = "code";
        public static final String MODEL = "model";
        public static final String CATEGORY = "category";
        public static final String DEPARTMENT = "department";
        public static final String STORAGE_LOCATION = "storageLocation";
        public static final String CREATED_DATE = "createdDate";
        public static final String BRAND = "brand";
        public static final String SUPPLIER = "supplier";
        public static final String PURCHASED_DATE = "purchasedDate";
        public static final String QUANTITY = "quantity";
        public static final String PRICE = "price";
        public static final String PURCHASED_AMOUNT = "purchasedAmount";
        public static final String ADMINISTRATOR = "administrator";
        public static final String REGISTRANT = "registrant";
        public static final String SPECIFIED_SERVICE_LIFE = "specifiedServiceLife";
        public static final String WARRANTY_EXPIRATION_DATE = "warrantyExpirationDate";
        public static final String ASSET_STATUS = "assetStatus";
        public static final String IMAGE_URL = "imageUrl";
        public static final String REMARK = "remark";
    }
}
