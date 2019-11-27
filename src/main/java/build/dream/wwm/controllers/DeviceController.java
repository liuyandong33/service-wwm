package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.models.device.DeleteDeviceModel;
import build.dream.wwm.models.device.ListDevicesModel;
import build.dream.wwm.models.device.ObtainDeviceInfoModel;
import build.dream.wwm.services.DeviceService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/device")
public class DeviceController {
    /**
     * 分页查询设备信息
     *
     * @return
     */
    @RequestMapping(value = "/listDevices", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = ListDevicesModel.class, serviceClass = DeviceService.class, serviceMethodName = "listDevices", error = "查询设备信息失败")
    public String listDevices() {
        return null;
    }

    /**
     * 获取设备信息
     *
     * @return
     */
    @RequestMapping(value = "/obtainDeviceInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = ObtainDeviceInfoModel.class, serviceClass = DeviceService.class, serviceMethodName = "obtainDeviceInfo", error = "获取设备信息失败")
    public String obtainDeviceInfo() {
        return null;
    }

    /**
     * 删除设备
     *
     * @return
     */
    @RequestMapping(value = "/deleteDevice", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = DeleteDeviceModel.class, serviceClass = DeviceService.class, serviceMethodName = "deleteDevice", error = "删除设备失败")
    public String deleteDevice() {
        return null;
    }
}
