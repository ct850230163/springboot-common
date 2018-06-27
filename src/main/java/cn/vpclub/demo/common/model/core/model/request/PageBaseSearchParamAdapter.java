package cn.vpclub.demo.common.model.core.model.request;

import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.util.regex.Pattern;

/**
 * 分页查询基础参数类
 *
 * @author HJ
 */
@MappedSuperclass
@ToString(callSuper = true)
public class PageBaseSearchParamAdapter extends BasePageParam {

    /**
     * 页码
     */
    protected Integer pageNo;

    /**
     * 查询排序标准查询有效， 实例： update_date desc, name asc
     */
    protected String orderBy = "";

    public PageBaseSearchParamAdapter() {
        super();
    }

    public PageBaseSearchParamAdapter(Integer pageSize, Integer pageNo) {
        super();
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.startRow = (null == pageNo || 0 == pageNo ? 0
                : (pageNo - 1)) * (null == pageSize ? 10 : pageSize);
    }

    /**
     * GET页码
     *
     * @return Integer
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * SET页码
     *
     * @param pageNo
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * GET查询开始记录行号
     *
     * @return Integer
     */
    @Override
    public Integer getStartRow() {
        return startRow = (null == this.getPageNo() || 0 == this.getPageNo() ? 0
                : (this.getPageNo() - 1)) * (null == this.getPageSize() ? 10 : this.getPageSize());
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

    /**
     * 获取查询排序字符串
     * @return
     */
    public String getOrderBy() {
        // SQL过滤，防止注入
        String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
                + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
        Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        if (sqlPattern.matcher(orderBy).find()) {
            return "";
        }
        return orderBy;
    }

    /**
     * 设置查询排序字符串
     * @param orderBy
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
