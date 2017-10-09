package com.sicdlib.util.HBaseUtil;

import org.apache.hadoop.hbase.util.Bytes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DeMH on 2017/4/27.
 */
public class HBPage {
    private int pageIndex = 0;
    private int pageFirstRowIndex = 1;
    private int pageSize = 50;
    private int prePage = 1;
    private int nextPage = 1;
    private int pageCount = 0;
    private String rowKeyBeginNum = null;
    private String rowKeyEndNum = null;

    private byte [] pageStartRowKey = null;
    private byte [] pageStopRowKey = null;
    private boolean hasNextPage = true;
    private int queryTotalCount = 0;
    private List resultList = new ArrayList();


    public int getPageSize() {
        return pageSize;
    }

    public int getPrePage() {
//        if(this.getPageIndex() > 1) {
//           this.prePage = this.getPageIndex() - 1;
//        } else {
//            this.prePage = 0;
//       }
        return prePage;
    }

    public int getNextPage() {
//        this.nextPage = this.getPageIndex() + 1;
        return nextPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public byte[] getPageStartRowKey() {
        return pageStartRowKey;
    }

    public byte[] getPageStopRowKey() {
        return pageStopRowKey;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setPageStartRowKey(byte[] pageStartRowKey) {
        this.pageStartRowKey = pageStartRowKey;
    }

    public void setPageStopRowKey(byte[] pageStopRowKey) {
        this.pageStopRowKey = pageStopRowKey;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageFirstRowIndex() {
        this.pageFirstRowIndex = (this.getPageIndex() - 1) * this.getPageSize() + 1;
        return pageFirstRowIndex;
    }

    public void setPageFirstRowIndex(int pageFirstRowIndex) {
        this.pageFirstRowIndex = pageFirstRowIndex;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public List getResultList() {
        return resultList;
    }

    public void setResultList(List resultList) {
        this.resultList = resultList;
    }

    /**
     * 获取是否有下一页
     * @return
     */
    public boolean isHasNextPage() {
//这个判断是不严谨的，因为很有可能剩余的数据刚好够一页。
        if(this.getResultList().size() == this.getPageSize()) {
            this.hasNextPage = true;
        } else {
            this.hasNextPage = false;
        }
        return hasNextPage;
    }
    /**
     * 获取已检索总记录数
     */
    public int getQueryTotalCount() {
        return queryTotalCount;
    }
    /**
     * 获取已检索总记录数
     * @param queryTotalCount
     */
    public void setQueryTotalCount(int queryTotalCount) {
        this.queryTotalCount = queryTotalCount;
    }


    public int pageFirstRowIndex(int pageIndex,int pageSize) {
        pageFirstRowIndex = (pageIndex - 1) * pageSize + 1;
        return pageFirstRowIndex;
    }

    public String getRowKeyBeginNum() {
        return rowKeyBeginNum;
    }

    public void setRowKeyBeginNum(String rowKeyBeginNum) {
        this.rowKeyBeginNum = rowKeyBeginNum;
}

    public String getRowKeyEndNum() {
        return rowKeyEndNum;
    }

    public void setRowKeyEndNum(String rowKeyEndNum) {
        this.rowKeyEndNum = rowKeyEndNum;
    }
}
