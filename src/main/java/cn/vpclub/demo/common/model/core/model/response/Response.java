package cn.vpclub.demo.common.model.core.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * Response
 * Created by johnd on 7/17/17.
 */
@Data
public class Response implements Serializable {
    /**
     * 请求结果
     */
    protected Integer returnCode;
    /**
     * 错误信息
     */
    protected String message;
}
