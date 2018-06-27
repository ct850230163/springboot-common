package cn.vpclub.demo.common.model.core.model.request;


import cn.vpclub.demo.common.model.utils.validator.AbstractParameter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * BaseDataInfoRequest
 *
 * Created by Johnd
 */
@Getter
@Setter
@MappedSuperclass
@ToString(callSuper = true)
public class BaseDataInfoRequest<T> extends AbstractParameter implements Serializable {

    /**
     * token
     */
    protected String token;

    /**
     * data info
     */
    protected T dataInfo;
}
