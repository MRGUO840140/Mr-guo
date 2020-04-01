package com.example.healthcare.bean;

import lombok.Data;

import java.util.List;

public class PageHelper<T> {
    private Integer currentPage;
    private Integer pageSize;
    private int totalPages;
    private int pageCount;
    private List<T> listItems;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getListItems() {
        return listItems;
    }

    public void setListItems(List<T> listItems) {
        this.listItems = listItems;
    }
}
