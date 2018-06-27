package cn.vpclub.demo.common.model.core.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * Created by chenwei on 2017/12/6.
 */
@Data
public class BaseEntity implements Serializable{

    /**
     * 创建人
     */
    private Long createdBy= 888888L;
    /**
     * 创建时间
     */
    private Long createdTime;
    /**
     * 更新人
     */
    private Long updatedBy= 888888L;
    /**
     * 更新时间
     */
    private Long updatedTime;
    /**
     * 删除标识(1:在线; 2:删除)
     */
    private Integer deleted;

}

