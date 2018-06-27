package cn.vpclub.demo.common.model.core.model.request;


import cn.vpclub.demo.common.model.utils.constant.ValidatorConditionType;
import cn.vpclub.demo.common.model.utils.validator.annotations.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;

/**
 * 分页查询基础参数类
 *
 * @author HJ
 */
@MappedSuperclass
@Getter
@Setter
@ToString(callSuper = true)
public class PageBaseSearchParam extends BasePageParam {

    /**
     * 页码
     */
    @NotNull(when = {ValidatorConditionType.LIST})
    protected Integer pageNumber;

    public PageBaseSearchParam() {
        super();
    }

    public PageBaseSearchParam(Integer pageSize, Integer pageNumber) {
        super();
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.startRow = (null == pageNumber || 0 == pageNumber ? 0
                : (pageNumber - 1)) * (null == pageSize ? 10 : pageSize);
    }

    /**
     * GET查询开始记录行号
     *
     * @return Integer
     */
    @Override
    public Integer getStartRow() {
        return startRow = (null == this.getPageNumber() || 0 == this.getPageNumber() ? 0
                : (this.getPageNumber() - 1)) * (null == this.getPageSize() ? 10 : this.getPageSize());
    }

    /**
     * SET查询开始记录行号
     *
     * @param startRow
     */
    @Override
    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
}
