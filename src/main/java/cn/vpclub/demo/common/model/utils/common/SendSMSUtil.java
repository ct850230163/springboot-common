package cn.vpclub.demo.common.model.utils.common;


import cn.vpclub.demo.common.model.utils.web.HttpRequestUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 18627 on 2017/4/13.
 */
@Slf4j
public class SendSMSUtil {

    public static String sendCodeSmsQuery(String url, String phone, String content) {
        //Basic 验证头信息组装
        Map headerInfo = new HashMap();
        headerInfo.put("appid", "100000073");
        headerInfo.put("childid", 0);
        headerInfo.put("appsecret", "VpClub_CYT");
        String json = JsonUtil.objectToJson(headerInfo);
        String auth = null;
        try {
            auth = "Basic " + Base64Util.encryptBASE64(json);
        } catch (UnsupportedEncodingException e) {
            log.error("Basic 验证头信息编码异常", e);
        }
        Map requestHeader = new HashMap();
        requestHeader.put("Authorization", auth);

        //短信发送参数
        Map reqMap = new HashMap();
        reqMap.put("phone", phone);
        reqMap.put("content", content);
        reqMap.put("dhandler", "WlwxHandler");

        String reqStr = JsonUtil.objectToJson(reqMap);

        log.debug("短信发送Authorization:" + auth);
        log.info("短信发送参数:" + reqStr);
        String respStr = HttpRequestUtil.sendJsonPost(url, reqStr, requestHeader);
        log.info("短信发送结果:" + respStr);
        return respStr;
    }

}


