package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"moe_data\"")
public class MoeDataEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="file_num")
    private String fileNum;

    @Property(value="QRCode_url")
    private String QRCodeUrl;

    @Property(value="b_QRCode")
    private String bQRCode;

    @Property(value="content")
    private String content;

    @Property(value="date")
    private String date;

    @Property(value="editor")
    private String editor;

    @Property(value="file_urls")
    private String fileUrls;

    @Property(value="position")
    private String position;

    @Property(value="spider_path")
    private String spiderPath;

    @Property(value="sub_title")
    private String subTitle;

    @Property(value="title")
    private String title;

    @Property(value="title_fwzh")
    private String titleFwzh;

    @Property(value="title_yt")
    private String titleYt;

    @Property(value="url")
    private String url;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String fileUrls) {
        this.fileUrls = fileUrls;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSpiderPath() {
        return spiderPath;
    }

    public void setSpiderPath(String spiderPath) {
        this.spiderPath = spiderPath;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleFwzh() {
        return titleFwzh;
    }

    public void setTitleFwzh(String titleFwzh) {
        this.titleFwzh = titleFwzh;
    }

    public String getTitleYt() {
        return titleYt;
    }

    public void setTitleYt(String titleYt) {
        this.titleYt = titleYt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MoeDataEntity{" +
                "pk='" + pk + '\'' +
                ", fileNum='" + fileNum + '\'' +
                ", QRCodeUrl='" + QRCodeUrl + '\'' +
                ", bQRCode='" + bQRCode + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", editor='" + editor + '\'' +
                ", fileUrls='" + fileUrls + '\'' +
                ", position='" + position + '\'' +
                ", spiderPath='" + spiderPath + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", title='" + title + '\'' +
                ", titleFwzh='" + titleFwzh + '\'' +
                ", titleYt='" + titleYt + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
