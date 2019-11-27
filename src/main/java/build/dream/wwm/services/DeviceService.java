package build.dream.wwm.services;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.domains.*;
import build.dream.wwm.models.device.*;
import build.dream.wwm.orm.PagedSearchModel;
import build.dream.wwm.orm.SearchCondition;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.orm.UpdateModel;
import build.dream.wwm.utils.DatabaseHelper;
import build.dream.wwm.utils.ValidateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class DeviceService {
    /**
     * 分页查询设备信息
     *
     * @param listDevicesModel
     * @return
     */
    @Transactional(readOnly = true)
    public ApiRest listDevices(ListDevicesModel listDevicesModel) {
        long waterWorksId = listDevicesModel.obtainWaterWorksId();
        int page = listDevicesModel.getPage();
        int rows = listDevicesModel.getRows();

        List<SearchCondition> searchConditions = new ArrayList<SearchCondition>();
        searchConditions.add(new SearchCondition("deleted", Constants.SQL_OPERATION_SYMBOL_EQUAL, 0));
        searchConditions.add(new SearchCondition("water_works_id", Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId));
        SearchModel searchModel = SearchModel.builder()
                .searchConditions(searchConditions)
                .build();
        long total = DatabaseHelper.count(Supplier.class, searchModel);

        List<Device> devices = null;
        if (total > 0) {
            PagedSearchModel pagedSearchModel = PagedSearchModel.builder()
                    .searchConditions(searchConditions)
                    .page(page)
                    .rows(rows)
                    .build();
            devices = DatabaseHelper.findAllPaged(Device.class, pagedSearchModel);
        } else {
            devices = new ArrayList<Device>();
        }

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("total", total);
        data.put("rows", devices);
        return ApiRest.builder().data(data).message("查询设备信息成功！").successful(true).build();
    }

    /**
     * 获取设备信息
     *
     * @param obtainDeviceInfoModel
     * @return
     */
    @Transactional(readOnly = true)
    public ApiRest obtainDeviceInfo(ObtainDeviceInfoModel obtainDeviceInfoModel) {
        long waterWorksId = obtainDeviceInfoModel.obtainWaterWorksId();
        long id = obtainDeviceInfoModel.getId();

        SearchModel deviceSearchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .equal(Device.ColumnName.ID, id)
                .equal(Device.ColumnName.WATER_WORKS_ID, waterWorksId)
                .build();
        Device device = DatabaseHelper.find(Device.class, deviceSearchModel);
        ValidateUtils.notNull(device, "设备信息不存在！");

        SearchModel searchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .equal("water_works_id", waterWorksId)
                .equal("device_id", id)
                .build();
        TechnicalData technicalData = DatabaseHelper.find(TechnicalData.class, searchModel);
        List<AttachedDevice> attachedDevices = DatabaseHelper.findAll(AttachedDevice.class, searchModel);
        List<WearPart> wearParts = DatabaseHelper.findAll(WearPart.class, searchModel);

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("device", device);
        data.put("technicalData", technicalData);
        data.put("attachedDevices", attachedDevices);
        data.put("wearParts", wearParts);
        return ApiRest.builder().data(data).message("获取设备信息成功！").successful(true).build();
    }

    /**
     * 删除设备
     *
     * @param deleteDeviceModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest deleteDevice(DeleteDeviceModel deleteDeviceModel) {
        long waterWorksId = deleteDeviceModel.obtainWaterWorksId();
        long userId = deleteDeviceModel.obtainUserId();
        long id = deleteDeviceModel.getId();

        Date now = new Date();

        SearchModel deviceSearchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .equal(Device.ColumnName.ID, id)
                .equal(Device.ColumnName.WATER_WORKS_ID, waterWorksId)
                .build();
        Device device = DatabaseHelper.find(Device.class, deviceSearchModel);
        ValidateUtils.notNull(device, "设备信息不存在！");

        device.setDeleted(true);
        device.setDeletedTime(now);
        device.setUpdatedUserId(userId);
        device.setUpdatedRemark("删除设备信息");
        DatabaseHelper.update(device);

        UpdateModel updateModel = UpdateModel.builder()
                .autoSetDeletedFalse()
                .equal("water_works_id", waterWorksId)
                .equal("id", id)
                .addContentValue("deleted", 1, 1)
                .addContentValue("deleted_time", now, 1)
                .addContentValue("updated_user_id", userId, 1)
                .addContentValue("updated_remark", "删除设备信息", 1)
                .build();
        DatabaseHelper.universalUpdate(updateModel, TechnicalData.TABLE_NAME);
        DatabaseHelper.universalUpdate(updateModel, AttachedDevice.TABLE_NAME);
        DatabaseHelper.universalUpdate(updateModel, WearPart.TABLE_NAME);
        return ApiRest.builder().message("删除设备信息成功！").successful(true).build();
    }

    /**
     * 增加设备信息
     *
     * @param addDeviceModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest addDevice(AddDeviceModel addDeviceModel) {
        return ApiRest.builder().message("增加设备信息成功！").successful(true).build();
    }

    /**
     * 修改设备信息
     *
     * @param updateDeviceModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest updateDevice(UpdateDeviceModel updateDeviceModel) {
        return ApiRest.builder().message("修改设备信息成功！").successful(true).build();
    }
}
