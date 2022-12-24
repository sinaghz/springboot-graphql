package com.sinaghz.demo.types;

public class DeletedBook {
    private Integer id;
    private String name;
    private String pageCount;

    public DeletedBook(Integer id, String name, String pageCount) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }
}