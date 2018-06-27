package cn.vpclub.demo.common.model.utils.common;



import cn.vpclub.demo.common.model.utils.web.HttpResponseUtil;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by johnd on 26/12/2016.
 */
public class Validator {

    private Callable<Boolean> callback;
    private Integer code;
    private String message;

    public Validator(Callable<Boolean> callback, Integer code, String message) {
        this.callback = callback;
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Callable<Boolean> getCallback() {
        return callback;
    }

    public static boolean validate(HttpServletResponse resp, Validator[] validators) throws Exception {

        Map<String, Object> baseResponse = new HashMap<String, Object>();
        for (Validator validator : validators) {
            if (validator.getCallback().call()) {
                baseResponse.put("returnCode", validator.getCode());
                baseResponse.put("message", validator.getMessage());
                String responseStr = JsonUtil.objectToJson(baseResponse);
                HttpResponseUtil.setResponseJsonBody(resp, responseStr);
                return false;
            } else {
                continue;
            }
        }
        return true;
    }
}
