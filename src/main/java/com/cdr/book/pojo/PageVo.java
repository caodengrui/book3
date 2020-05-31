package com.cdr.book.pojo;

import java.util.List;

public class PageVo<T> {
    private int total;

    private List<T> entity;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getEntity() {
        return entity;
    }

    public void setEntity(List<T> entity) {
        this.entity = entity;
    }
}
