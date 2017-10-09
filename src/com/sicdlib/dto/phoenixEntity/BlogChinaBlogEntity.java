package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"blogchina_blog_1\"")
public class BlogChinaBlogEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="blog_id")
    private String blogID;

    @Property(value="category")
    private String category;

    @Property(value="comment_num")
    private String commentNum;

    @Property(value="content")
    private String content;

    @Property(value="hand_down_num")
    private String handDownNum;

    @Property(value="hand_up_num")
    private String handUpNum;

    @Property(value="picuture_urls")
    private String pictureUrls;

    @Property(value="publish_time")
    private String publishTime;

    @Property(value="read_num")
    private String readNum;

    @Property(value="sub_title")
    private String subTitle;

    @Property(value="title")
    private String title;

    @Property(value="url")
    private String url;

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

    public String getBlogID() {
        return blogID;
    }

    public void setBlogID(String blogID) {
        this.blogID = blogID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getHandDownNum() {
        return handDownNum;
    }

    public void setHandDownNum(String handDownNum) {
        this.handDownNum = handDownNum;
    }

    public String getHandUpNum() {
        return handUpNum;
    }

    public void setHandUpNum(String handUpNum) {
        this.handUpNum = handUpNum;
    }

    public String getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(String pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BlogChinaBlogEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", blogID='" + blogID + '\'' +
                ", category='" + category + '\'' +
                ", commentNum='" + commentNum + '\'' +
                ", content='" + content + '\'' +
                ", handDownNum='" + handDownNum + '\'' +
                ", handUpNum='" + handUpNum + '\'' +
                ", pictureUrls='" + pictureUrls + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", readNum='" + readNum + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
