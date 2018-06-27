package cn.vpclub.demo.common.model.core.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 接口返回基类
 *
 * Created by admin on 2016/3/10.
 */
@MappedSuperclass
@Getter
@Setter
@ToString(callSuper = true)
public class BaseResponse<T> extends Response implements Serializable {

    /**
     * 操作数据信息(请求结果成功返回)
     */
    protected T dataInfo;

    /**
     * Default Constructor
     */
    public BaseResponse() {
        super();
    }
}
