package com.sicdlib.dto;

import com.sicdlib.dto.entity.BbsPeoplePostEntity;
import com.sicdlib.dto.entity.BbsSohuPostEntity;
import com.sicdlib.dto.entity.DoubanGroupPostEntity;
import com.sicdlib.dto.entity.XinhuaNewsEntity;

import java.util.List;

/**
 * Created by DeMH on 2017/5/9.
 */
public class TableHotValue {
    //热度值
    private Double hotValue;
    //网站名称
    private String websiteName;
    //表名（对应tb_table的网站名称）
    private String tableName;
    //例：豆瓣
    private DoubanGroupPostEntity doubanGroupPost;
    //例：人民网BBS
    private BbsPeoplePostEntity bbsPeoplePost;
    //例：新华网
    private XinhuaNewsEntity xinhuaNews;
    //例：搜狐
    private BbsSohuPostEntity bbssohuPost;

    public BbsSohuPostEntity getBbssohuPost() {
        return bbssohuPost;
    }

    public void setBbssohuPost(BbsSohuPostEntity bbssohuPost) {
        this.bbssohuPost = bbssohuPost;
    }

    public XinhuaNewsEntity getXinhuaNews() {
        return xinhuaNews;
    }

    public void setXinhuaNews(XinhuaNewsEntity xinhuaNews) {
        this.xinhuaNews = xinhuaNews;
    }

    public BbsPeoplePostEntity getBbsPeoplePost() {
        return bbsPeoplePost;
    }

    public void setBbsPeoplePost(BbsPeoplePostEntity bbsPeoplePost) {
        this.bbsPeoplePost = bbsPeoplePost;
    }

    public Double getHotValue() {
        return hotValue;
    }

    public void setHotValue(Double hotValue) {
        this.hotValue = hotValue;
    }

    public DoubanGroupPostEntity getDoubanGroupPost() {
        return doubanGroupPost;
    }

    public void setDoubanGroupPost(DoubanGroupPostEntity doubanGroupPost) {
        this.doubanGroupPost = doubanGroupPost;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

}
