package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"moe_news\"")
public class MoeNewsEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="file_num")
    private String fileNum;

    @Property(value="QRCode_url")
    private String QRCodeUrl;

    @Property(value="b_QRCode")
    private String bQRCode;

    @Property(value="news_content")
    private String newsContent;

    @Property(value="file_urls")
    private String fileUrls;

    @Property(value="news_editor")
    private String newsEditor;

    @Property(value="news_fwzh")
    private String newsFwzh;

    @Property(value="news_sub_title")
    private String newsSubTitle;

    @Property(value="news_yt")
    private String newsYt;

    @Property(value="position")
    private String position;

    @Property(value="news_time")
    private String newsTime;

    @Property(value="news_title")
    private String newsTitle;

    @Property(value="spider_path")
    private String spiderPath;

    @Property(value="url")
    private String url;

    @Property(value="picture_num")
    private String pictureNum;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getFileNum() {
        return fileNum;
    }

    public void setFileNum(String fileNum) {
        this.fileNum = fileNum;
    }

    public String getQRCodeUrl() {
        return QRCodeUrl;
    }

    public void setQRCodeUrl(String QRCodeUrl) {
        this.QRCodeUrl = QRCodeUrl;
    }

    public String getbQRCode() {
        return bQRCode;
    }

    public void setbQRCode(String bQRCode) {
        this.bQRCode = bQRCode;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String fileUrls) {
        this.fileUrls = fileUrls;
    }

    public String getNewsEditor() {
        return newsEditor;
    }

    public void setNewsEditor(String newsEditor) {
        this.newsEditor = newsEditor;
    }

    public String getNewsFwzh() {
        return newsFwzh;
    }

    public void setNewsFwzh(String newsFwzh) {
        this.newsFwzh = newsFwzh;
    }

    public String getNewsSubTitle() {
        return newsSubTitle;
    }

    public void setNewsSubTitle(String newsSubTitle) {
        this.newsSubTitle = newsSubTitle;
    }

    public String getNewsYt() {
        return newsYt;
    }

    public void setNewsYt(String newsYt) {
        this.newsYt = newsYt;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getSpiderPath() {
        return spiderPath;
    }

    public void setSpiderPath(String spiderPath) {
        this.spiderPath = spiderPath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPictureNum() {
        return pictureNum;
    }

    public void setPictureNum(String pictureNum) {
        this.pictureNum = pictureNum;
    }

    @Override
    public String toString() {
        return "MoeNewsEntity{" +
                "pk='" + pk + '\'' +
                ", fileNum='" + fileNum + '\'' +
                ", QRCodeUrl='" + QRCodeUrl + '\'' +
                ", bQRCode='" + bQRCode + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", fileUrls='" + fileUrls + '\'' +
                ", newsEditor='" + newsEditor + '\'' +
                ", newsFwzh='" + newsFwzh + '\'' +
                ", newsSubTitle='" + newsSubTitle + '\'' +
                ", newsYt='" + newsYt + '\'' +
                ", position='" + position + '\'' +
                ", newsTime='" + newsTime + '\'' +
                ", newsTitle='" + newsTitle + '\'' +
                ", spiderPath='" + spiderPath + '\'' +
                ", url='" + url + '\'' +
                ", pictureNum='" + pictureNum + '\'' +
                '}';
    }
}
