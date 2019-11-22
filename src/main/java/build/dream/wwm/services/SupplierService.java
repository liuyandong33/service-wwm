package build.dream.wwm.services;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.domains.Supplier;
import build.dream.wwm.models.supplier.AddSupplierModel;
import build.dream.wwm.models.supplier.ListSuppliersModel;
import build.dream.wwm.models.supplier.UpdateSupplierModel;
import build.dream.wwm.orm.PagedSearchModel;
import build.dream.wwm.orm.SearchCondition;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.utils.DatabaseHelper;
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
        return null;
    }

    /**
     * 修改供应商信息
     *
     * @param updateSupplierModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest updateSupplier(UpdateSupplierModel updateSupplierModel) {
        long id = updateSupplierModel.getId();
        return null;
    }
}
