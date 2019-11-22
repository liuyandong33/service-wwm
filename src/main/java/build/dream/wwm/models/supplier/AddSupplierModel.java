package build.dream.wwm.models.supplier;

import build.dream.wwm.models.UserBasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddSupplierModel extends UserBasicModel {
    /**
     * 编号
     */
    @NotNull
    @Length(max = 20)
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
}
