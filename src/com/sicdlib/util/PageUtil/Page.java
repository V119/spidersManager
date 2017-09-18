package com.sicdlib.util.PageUtil;

public class Page {


    private int totalRecord;//总共多少条记录

    private int totalPage;//总页数

    private int pageSize;//每页多少条

    private int pageIndex;//第几页(当前页码)

    private int pageStart;//分页的记录起始值

    public Page(){};

    public Page(int pageIndex){

        this.pageIndex = pageIndex;//当前页码

        if(this.pageIndex < 1){
            this.pageIndex = 1;
        }

        this.pageStart = (this.pageIndex -1) * this.pageSize;//起始位置
        if(this.pageStart < 0){
            this.pageStart = 0;
        }
    }

    public Page(int totalRecord, int pageIndex){

        this.totalRecord = totalRecord;
        this.pageIndex = pageIndex;

        //计算共几页
        this.totalPage = this.totalRecord / this.pageSize;

        if(this.totalRecord % this.pageSize != 0){
            this.totalPage++;
        }

        //计算当前页码
        if(this.pageIndex < 1){
            this.pageIndex = 1;
        }
        if(this.pageIndex > this.totalPage){
            this.pageIndex = this.totalPage;
        }

        //计算起始位置
        this.pageStart = (this.pageIndex - 1) * this.pageSize;//pageStart=0时表示起始位置为第一条数据
        if(this.pageStart < 0){
            this.pageStart = 0;
        }
    }

    public Page(int totalRecord, int pageIndex, int pageSize){

        this.totalRecord = totalRecord;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;

        //计算共几页
        this.totalPage = this.totalRecord / this.pageSize;

        if (this.totalRecord % this.pageSize != 0) {
            this.totalPage++;
        }

        // 计算当前页码
        if (this.pageIndex < 1) {
            this.pageIndex = 1;
        }
        if (this.pageIndex > this.totalPage) {
            this.pageIndex = this.totalPage;
        }

        //计算起始位置
        this.pageStart = (this.pageIndex - 1) * this.pageSize;//pageStart=0时表示起始位置为第一条数据

        if(this.pageStart < 0){
            this.pageStart = 0;
        }
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }


}
