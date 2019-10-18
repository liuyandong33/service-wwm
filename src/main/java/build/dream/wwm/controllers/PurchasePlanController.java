package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.models.purchaseplan.SavePurchasePlanModel;
import build.dream.wwm.services.PurchasePlanService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/purchasePlan")
public class PurchasePlanController {
    /**
     * 保存采购计划
     *
     * @return
     */
    @RequestMapping(value = "/savePurchasePlan", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = SavePurchasePlanModel.class, serviceClass = PurchasePlanService.class, serviceMethodName = "savePurchasePlan", error = "保存采购计划失败")
    public String savePurchasePlan() {
        return null;
    }
}
