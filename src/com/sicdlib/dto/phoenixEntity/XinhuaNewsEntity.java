package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"xinhua_news\"")
public class XinhuaNewsEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author")
    private String author;

    @Property(value="content")
    private String content;

    @Property(value="date_time")
    private String dateTime;

    @Property(value="editor")
    private String editor;

    @Property(value="key_words")
    private String keyWords;

    @Property(value="path_text")
    private String pathText;

    @Property(value="path_href")
    private String pathHref;

    @Property(value="picture_urls")
    private String pictureUrls;

    @Property(value="source_text")
    private String sourceText;

    @Property(value="title")
    private String title;

    @Property(value="url")
    private String url;

    @Property(value="pic_num")
    private String picNum;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getPathText() {
        return pathText;
    }

    public void setPathText(String pathText) {
        this.pathText = pathText;
    }

    public String getPathHref() {
        return pathHref;
    }

    public void setPathHref(String pathHref) {
        this.pathHref = pathHref;
    }

    public String getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(String pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public String getSourceText() {
        return sourceText;
    }

    public void setSourceText(String sourceText) {
        this.sourceText = sourceText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicNum() {
        return picNum;
    }

    public void setPicNum(String picNum) {
        this.picNum = picNum;
    }

    @Override
    public String toString() {
        return "XinhuaNewsEntity{" +
                "pk='" + pk + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", editor='" + editor + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", pathText='" + pathText + '\'' +
                ", pathHref='" + pathHref + '\'' +
                ", pictureUrls='" + pictureUrls + '\'' +
                ", sourceText='" + sourceText + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", picNum='" + picNum + '\'' +
                '}';
    }
}
