package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"blog_sina_post\"")
public class BlogSinaPostEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="author_href")
    private String authorHref;

    @Property(value="collect_num")
    private String collectNum;

    @Property(value="content")
    private String content;

    @Property(value="comment_num")
    private String commentNum;

    @Property(value="date_time")
    private String dateTime;

    @Property(value="enjoy_num")
    private String enjoyNum;

    @Property(value="forward_num")
    private String forwardNum;

    @Property(value="get_golden_num")
    private String getGoldenNum;

    @Property(value="key_words")
    private String keyWords;

    @Property(value="post_id")
    private String postID;

    @Property(value="read_num")
    private String readNum;

    @Property(value="tags")
    private String tags;

    @Property(value="title")
    private String title;

    @Property(value="url")
    private String url;

    @Property(value="url_in_content")
    private String urlInContent;

    @Property(value="picture_urls_num")
    private String pictureUrlsNum;

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

    public String getAuthorHref() {
        return authorHref;
    }

    public void setAuthorHref(String authorHref) {
        this.authorHref = authorHref;
    }

    public String getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(String collectNum) {
        this.collectNum = collectNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getEnjoyNum() {
        return enjoyNum;
    }

    public void setEnjoyNum(String enjoyNum) {
        this.enjoyNum = enjoyNum;
    }

    public String getForwardNum() {
        return forwardNum;
    }

    public void setForwardNum(String forwardNum) {
        this.forwardNum = forwardNum;
    }

    public String getGetGoldenNum() {
        return getGoldenNum;
    }

    public void setGetGoldenNum(String getGoldenNum) {
        this.getGoldenNum = getGoldenNum;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    public String getUrlInContent() {
        return urlInContent;
    }

    public void setUrlInContent(String urlInContent) {
        this.urlInContent = urlInContent;
    }

    public String getPictureUrlsNum() {
        return pictureUrlsNum;
    }

    public void setPictureUrlsNum(String pictureUrlsNum) {
        this.pictureUrlsNum = pictureUrlsNum;
    }

    @Override
    public String toString() {
        return "BlogSinaPostEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorHref='" + authorHref + '\'' +
                ", collectNum='" + collectNum + '\'' +
                ", content='" + content + '\'' +
                ", commentNum='" + commentNum + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", enjoyNum='" + enjoyNum + '\'' +
                ", forwardNum='" + forwardNum + '\'' +
                ", getGoldenNum='" + getGoldenNum + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", postID='" + postID + '\'' +
                ", readNum='" + readNum + '\'' +
                ", tags='" + tags + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", urlInContent='" + urlInContent + '\'' +
                ", pictureUrlsNum='" + pictureUrlsNum + '\'' +
                '}';
    }
}
