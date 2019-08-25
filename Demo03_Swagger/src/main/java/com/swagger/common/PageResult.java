package com.swagger.common;

/**
 * @ Author：ke
 * @ Date： 2019/5/13 19:57
 * @ Version 1.0
 */

import java.util.List;

/**
 * 分页响应实体
 * @param <T>
 */
public class PageResult<T> {
    private Long total;//总记录数
    private List<T> rows;//当前页数据

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
