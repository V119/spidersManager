package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;
@Entity(value="\"bbs_news_post\"")
public class BBSNewsPostEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="author_url")
    private String authorUrl;

    @Property(value="comment_ids")
    private String commentIDS;

    @Property(value="comment_num")
    private String commentNum;

    @Property(value="content")
    private String content;

    @Property(value="date_time")
    private String dateTime;

    @Property(value="detail_time")
    private String detailTime;

    @Property(value="like_num")
    private String likeNum;

    @Property(value="parse_time")
    private String parseTime;

    @Property(value="path_href")
    private String pathGref;

    @Property(value="path_text")
    private String pathText;

    @Property(value="post_id")
    private String postID;

    @Property(value="read_num")
    private String readNum;

    @Property(value="title")
    private String title;

    @Property(value="url")
    private String url;

    @Property(value="picture_hrefs_num")
    private String picture_hrefs_num;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getCommentIDS() {
        return commentIDS;
    }

    public void setCommentIDS(String commentIDS) {
        this.commentIDS = commentIDS;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
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

    public String getDetailTime() {
        return detailTime;
    }

    public void setDetailTime(String detailTime) {
        this.detailTime = detailTime;
    }

    public String getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(String likeNum) {
        this.likeNum = likeNum;
    }

    public String getParseTime() {
        return parseTime;
    }

    public void setParseTime(String parseTime) {
        this.parseTime = parseTime;
    }

    public String getPathGref() {
        return pathGref;
    }

    public void setPathGref(String pathGref) {
        this.pathGref = pathGref;
    }

    public String getPathText() {
        return pathText;
    }

    public void setPathText(String pathText) {
        this.pathText = pathText;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
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

    public String getPicture_hrefs_num() {
        return picture_hrefs_num;
    }

    public void setPicture_hrefs_num(String picture_hrefs_num) {
        this.picture_hrefs_num = picture_hrefs_num;
    }

    @Override
    public String toString() {
        return "BBSNewsPostEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", commentIDS='" + commentIDS + '\'' +
                ", commentNum='" + commentNum + '\'' +
                ", content='" + content + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", detailTime='" + detailTime + '\'' +
                ", likeNum='" + likeNum + '\'' +
                ", parseTime='" + parseTime + '\'' +
                ", pathGref='" + pathGref + '\'' +
                ", pathText='" + pathText + '\'' +
                ", postID='" + postID + '\'' +
                ", readNum='" + readNum + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", picture_hrefs_num='" + picture_hrefs_num + '\'' +
                '}';
    }
}
