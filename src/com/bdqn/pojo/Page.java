package com.bdqn.pojo;

import com.bdqn.pojo.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ldwjava
 * @Date 2018/7/11 14:09
 * @Desc 分页封装类
 **/

public class Page {
    private Integer currentPage; //当前页
    private Integer pageSize; //每页显示记录数
    private Integer totalPages; //总共多少页
    private Integer totalRows;// 总记录数
    private List<Users> list = new ArrayList<>();//对应页码显示的记录


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

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public List<Users> getList() {
        return list;
    }

    public void setList(List<Users> list) {
        this.list = list;
    }
}
