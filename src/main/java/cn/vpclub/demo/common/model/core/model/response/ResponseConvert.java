package cn.vpclub.demo.common.model.core.model.response;


import cn.vpclub.demo.common.model.core.enums.ReturnCodeEnum;

/**
 * Created by Administrator on 2017/4/7.
 */
public class ResponseConvert {
    public static BaseResponse convert(boolean back) {
        BaseResponse response = new BaseResponse();
        if (back) {
            response.setReturnCode(ReturnCodeEnum.CODE_1000.getCode());
            response.setMessage(ReturnCodeEnum.CODE_1000.getValue());
        } else {
            response.setReturnCode(ReturnCodeEnum.CODE_1005.getCode());
            response.setMessage(ReturnCodeEnum.CODE_1005.getValue());
        }
        return response;
    }

}
