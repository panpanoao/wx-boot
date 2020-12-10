package com.guyu.bdcwxsubscription.query;

import java.io.Serializable;

/**
 * @创建人 黄盼
 * @创建时间 2020/12/10 0010 10:16
 * @描述
 **/
public class BaseQuery implements Serializable {

    /**
     * 开始页码
     */
    private Integer page = 1;
    /**
     * 单页显示数量
     */
    private Integer size = 10;


    //用户id
    private Integer userId;

    /**
     * 排序的字段名称
     */
    private String sort;

    /**
     * 排序规则，默认DESC
     */
    private String order;


    private Integer offset;
    /**
     * 综合查询的条件，例如名称、五笔码、拼音码等模糊查询
     */
    private String q;

    public BaseQuery() {
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page != null && page > 0) {
            this.page = page;
        }
    }

    public Integer getLimit() {
        return size;
    }

    public void setLimit(Integer rows) {
        if (rows != null && rows > 0) {
            this.size = rows;
        }
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPageNumber() {
        return page;
    }


    public Integer getPageSize() {
        return size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.page = offset;
        this.offset = offset;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
