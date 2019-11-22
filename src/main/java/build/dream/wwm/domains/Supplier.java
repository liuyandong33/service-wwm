package build.dream.wwm.domains;

public class Supplier extends BasicDomain {
    public static final String TABLE_NAME = "supplier";
    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系电话
     */
    private String telephoneNumber;

    /**
     * 传真
     */
    private String fax;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 税号
     */
    private String taxNumber;

    /**
     * 开户行
     */
    private String bank;

    /**
     * 开户行账号
     */
    private String accountNumber;

    /**
     * 备注
     */
    private String remark;

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

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class Builder extends BasicDomain.Builder<Builder, Supplier> {
        public Builder code(String code) {
            instance.setCode(code);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder linkman(String linkman) {
            instance.setLinkman(linkman);
            return this;
        }

        public Builder telephoneNumber(String telephoneNumber) {
            instance.setTelephoneNumber(telephoneNumber);
            return this;
        }

        public Builder fax(String fax) {
            instance.setFax(fax);
            return this;
        }

        public Builder address(String address) {
            instance.setAddress(address);
            return this;
        }

        public Builder postcode(String postcode) {
            instance.setPostcode(postcode);
            return this;
        }

        public Builder email(String email) {
            instance.setEmail(email);
            return this;
        }

        public Builder taxNumber(String taxNumber) {
            instance.setTaxNumber(taxNumber);
            return this;
        }

        public Builder bank(String bank) {
            instance.setBank(bank);
            return this;
        }

        public Builder accountNumber(String accountNumber) {
            instance.setAccountNumber(accountNumber);
            return this;
        }

        public Builder remark(String remark) {
            instance.setRemark(remark);
            return this;
        }

        @Override
        public Supplier build() {
            Supplier supplier = super.build();
            supplier.setCode(instance.getCode());
            supplier.setName(instance.getName());
            supplier.setLinkman(instance.getLinkman());
            supplier.setTelephoneNumber(instance.getTelephoneNumber());
            supplier.setFax(instance.getFax());
            supplier.setAddress(instance.getAddress());
            supplier.setPostcode(instance.getPostcode());
            supplier.setEmail(instance.getEmail());
            supplier.setTaxNumber(instance.getTaxNumber());
            supplier.setBank(instance.getBank());
            supplier.setAccountNumber(instance.getAccountNumber());
            supplier.setRemark(instance.getRemark());
            return supplier;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String WATER_WORKS_ID = "water_works_id";
        public static final String LINKMAN = "linkman";
        public static final String TELEPHONE_NUMBER = "telephone_number";
        public static final String FAX = "fax";
        public static final String ADDRESS = "address";
        public static final String POSTCODE = "postcode";
        public static final String EMAIL = "email";
        public static final String TAX_NUMBER = "tax_number";
        public static final String BANK = "bank";
        public static final String ACCOUNT_NUMBER = "account_number";
        public static final String remark = "remark";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String WATER_WORKS_ID = "waterWorksId";
        public static final String LINKMAN = "linkman";
        public static final String TELEPHONE_NUMBER = "telephoneNumber";
        public static final String FAX = "fax";
        public static final String ADDRESS = "address";
        public static final String POSTCODE = "postcode";
        public static final String EMAIL = "email";
        public static final String TAX_NUMBER = "taxNumber";
        public static final String BANK = "bank";
        public static final String ACCOUNT_NUMBER = "accountNumber";
        public static final String remark = "remark";
    }
}
