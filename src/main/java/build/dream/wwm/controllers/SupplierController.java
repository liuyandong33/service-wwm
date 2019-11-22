package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.models.supplier.*;
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

    /**
     * 新增供应商信息
     *
     * @return
     */
    @RequestMapping(value = "/addSupplier", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = AddSupplierModel.class, serviceClass = SupplierService.class, serviceMethodName = "addSupplier", error = "新增供应商信息失败")
    public String addSupplier() {
        return null;
    }

    /**
     * 修改供应商信息
     *
     * @return
     */
    @RequestMapping(value = "/updateSupplier", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = UpdateSupplierModel.class, serviceClass = SupplierService.class, serviceMethodName = "updateSupplier", error = "修改供应商信息失败")
    public String updateSupplier() {
        return null;
    }

    /**
     * 获取供应商信息
     *
     * @return
     */
    @RequestMapping(value = "/obtainSupplierInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = ObtainSupplierInfoModel.class, serviceClass = SupplierService.class, serviceMethodName = "obtainSupplierInfo", error = "获取供应商信息失败")
    public String obtainSupplierInfo() {
        return null;
    }

    /**
     * 删除供应商信息
     *
     * @return
     */
    @RequestMapping(value = "/deleteSupplier", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = DeleteSupplierModel.class, serviceClass = SupplierService.class, serviceMethodName = "deleteSupplier", error = "删除供应商信息失败")
    public String deleteSupplier() {
        return null;
    }
}
