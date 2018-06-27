package cn.vpclub.demo.common.model.core.model.request;


import cn.vpclub.demo.common.model.utils.constant.ValidatorConditionType;
import cn.vpclub.demo.common.model.utils.validator.BaseAbstractParameter;
import cn.vpclub.demo.common.model.utils.validator.annotations.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * BaseParam
 * Created by johnd on 2/27/17.
 */

@Getter
@Setter
@ToString(callSuper = true)
public class BaseParam extends BaseAbstractParameter implements Serializable {
    @NotNull(when = {ValidatorConditionType.CREATE})
    private Long createdBy  = 888888L;
    @NotNull(when = {ValidatorConditionType.CREATE, ValidatorConditionType.UPDATE})
    private Long updatedBy  =   888888L;
    private Long createdTime;
    private Long updatedTime;
    private Integer deleted ;
}
