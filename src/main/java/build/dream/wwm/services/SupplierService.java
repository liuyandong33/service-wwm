package build.dream.wwm.services;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.domains.Supplier;
import build.dream.wwm.models.supplier.AddSupplierModel;
import build.dream.wwm.models.supplier.ListSuppliersModel;
import build.dream.wwm.models.supplier.UpdateSupplierModel;
import build.dream.wwm.orm.PagedSearchModel;
import build.dream.wwm.orm.SearchCondition;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.utils.DatabaseHelper;
import build.dream.wwm.utils.ValidateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupplierService {
    @Transactional(readOnly = true)
    public ApiRest listSuppliers(ListSuppliersModel listSuppliersModel) {
        long waterWorksId = listSuppliersModel.obtainWaterWorksId();
        int page = listSuppliersModel.getPage();
        int rows = listSuppliersModel.getRows();

        List<SearchCondition> searchConditions = new ArrayList<SearchCondition>();
        searchConditions.add(new SearchCondition(Supplier.ColumnName.DELETED, Constants.SQL_OPERATION_SYMBOL_EQUAL, 0));
        searchConditions.add(new SearchCondition(Supplier.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId));
        SearchModel searchModel = SearchModel.builder()
                .searchConditions(searchConditions)
                .build();
        long total = DatabaseHelper.count(Supplier.class, searchModel);

        List<Supplier> suppliers = null;
        if (total > 0) {
            PagedSearchModel pagedSearchModel = PagedSearchModel.builder()
                    .searchConditions(searchConditions)
                    .page(page)
                    .rows(rows)
                    .build();
            suppliers = DatabaseHelper.findAllPaged(Supplier.class, pagedSearchModel);
        } else {
            suppliers = new ArrayList<Supplier>();
        }

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("total", total);
        data.put("rows", suppliers);
        return ApiRest.builder().data(data).message("查询供应商信息成功！").successful(true).build();
    }

    /**
     * 新增供应商信息
     *
     * @param addSupplierModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest addSupplier(AddSupplierModel addSupplierModel) {
        long waterWorksId = addSupplierModel.obtainWaterWorksId();
        long userId = addSupplierModel.obtainUserId();
        String code = addSupplierModel.getCode();
        String name = addSupplierModel.getName();
        String linkman = addSupplierModel.getLinkman();
        String telephoneNumber = addSupplierModel.getTelephoneNumber();
        String fax = addSupplierModel.getFax();
        String address = addSupplierModel.getAddress();
        String postcode = addSupplierModel.getPostcode();
        String email = addSupplierModel.getEmail();
        String taxNumber = addSupplierModel.getTaxNumber();
        String bank = addSupplierModel.getBank();
        String accountNumber = addSupplierModel.getAccountNumber();
        String remark = addSupplierModel.getRemark();

        Supplier supplier = Supplier.builder()
                .waterWorksId(waterWorksId)
                .code(code)
                .name(name)
                .linkman(linkman)
                .telephoneNumber(telephoneNumber)
                .fax(fax)
                .address(address)
                .postcode(postcode)
                .email(email)
                .taxNumber(taxNumber)
                .bank(bank)
                .accountNumber(accountNumber)
                .remark(remark)
                .createdUserId(userId)
                .updatedUserId(userId)
                .updatedRemark("新增供应商信息！")
                .build();
        DatabaseHelper.insert(supplier);
        return ApiRest.builder().data(supplier).message("新增供应商信息成功！").successful(true).build();
    }

    /**
     * 修改供应商信息
     *
     * @param updateSupplierModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest updateSupplier(UpdateSupplierModel updateSupplierModel) {
        long waterWorksId = updateSupplierModel.obtainWaterWorksId();
        long userId = updateSupplierModel.obtainUserId();
        long id = updateSupplierModel.getId();
        String name = updateSupplierModel.getName();
        String linkman = updateSupplierModel.getLinkman();
        String telephoneNumber = updateSupplierModel.getTelephoneNumber();
        String fax = updateSupplierModel.getFax();
        String address = updateSupplierModel.getAddress();
        String postcode = updateSupplierModel.getPostcode();
        String email = updateSupplierModel.getEmail();
        String taxNumber = updateSupplierModel.getTaxNumber();
        String bank = updateSupplierModel.getBank();
        String accountNumber = updateSupplierModel.getAccountNumber();
        String remark = updateSupplierModel.getRemark();

        SearchModel searchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .equal(Supplier.ColumnName.ID, id)
                .equal(Supplier.ColumnName.WATER_WORKS_ID, waterWorksId)
                .build();
        Supplier supplier = DatabaseHelper.find(Supplier.class, searchModel);
        ValidateUtils.notNull(supplier, "供应商信息不存在！");

        supplier.setName(name);
        supplier.setLinkman(linkman);
        supplier.setTelephoneNumber(telephoneNumber);
        supplier.setFax(fax);
        supplier.setAddress(address);
        supplier.setPostcode(postcode);
        supplier.setEmail(email);
        supplier.setTaxNumber(taxNumber);
        supplier.setBank(bank);
        supplier.setAccountNumber(accountNumber);
        supplier.setRemark(remark);
        supplier.setUpdatedUserId(userId);
        supplier.setUpdatedRemark("修改供应商信息！");
        DatabaseHelper.update(supplier);
        return ApiRest.builder().data(supplier).message("修改供应商信息成功！").successful(true).build();
    }
}
