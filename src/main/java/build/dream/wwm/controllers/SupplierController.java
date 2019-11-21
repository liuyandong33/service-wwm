package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.models.supplier.ListSuppliersModel;
import build.dream.wwm.services.SupplierService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/supplier")
public class SupplierController {
    /**
     * 分页查询供应商信息
     *
     * @return
     */
    @RequestMapping(value = "/listSuppliers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = ListSuppliersModel.class, serviceClass = SupplierService.class, serviceMethodName = "listSuppliers", error = "分页查询供应商信息失败")
    public String listSuppliers() {
        return null;
    }
}
