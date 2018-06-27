package cn.vpclub.demo.common.model.core.model.request;


import cn.vpclub.demo.common.model.utils.constant.ValidatorConditionType;
import cn.vpclub.demo.common.model.utils.validator.BaseAbstractParameter;
import cn.vpclub.demo.common.model.utils.validator.annotations.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 分页查询基础参数类
 *
 * @author HJ
 */
@MappedSuperclass
@Getter
@Setter
@ToString(callSuper = true)
public abstract class BasePageParam extends BaseAbstractParameter implements Serializable {
    /**
     * 每页查询记录数
     */
    @NotNull(when = {ValidatorConditionType.LIST})
    protected Integer pageSize;

    /**
     * 查询开始记录行号
     */
    @NotNull(when = {ValidatorConditionType.LIST})
    protected Integer startRow;

    public BasePageParam() {
        super();
    }

}
