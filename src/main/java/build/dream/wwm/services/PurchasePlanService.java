package build.dream.wwm.services;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.models.purchaseplan.SavePurchasePlanModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchasePlanService {
    /**
     * 保存采购计划
     *
     * @param savePurchasePlanModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest savePurchasePlan(SavePurchasePlanModel savePurchasePlanModel) {
        Long waterWorksId = savePurchasePlanModel.obtainWaterWorksId();
        Long userId = savePurchasePlanModel.obtainUserId();
        return null;
    }
}
