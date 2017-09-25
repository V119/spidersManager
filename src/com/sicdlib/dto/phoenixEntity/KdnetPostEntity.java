package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"kdnet_post\"")
public class KdnetPostEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="at_href")
    private String atHref;

    @Property(value="author_href")
    private String authorHref;

    @Property(value="author")
    private String author;

    @Property(value="content")
    private String content;

    @Property(value="category")
    private String category;

    @Property(value="comment_num")
    private String commentNum;

    @Property(value="hits")
    private String hits;

    @Property(value="post_id")
    private String postID;

    @Property(value="post_status")
    private String postStatus;

    @Property(value="post_status")
    private String postUrl;

    @Property(value="title")
    private String title;

    @Property(value="picture_href_num")
    private String pictureHrefNum;

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

    public String getAtHref() {
        return atHref;
    }

    public void setAtHref(String atHref) {
        this.atHref = atHref;
    }

    public String getAuthorHref() {
        return authorHref;
    }

    public void setAuthorHref(String authorHref) {
        this.authorHref = authorHref;
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

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictureHrefNum() {
        return pictureHrefNum;
    }

    public void setPictureHrefNum(String pictureHrefNum) {
        this.pictureHrefNum = pictureHrefNum;
    }

    @Override
    public String toString() {
        return "KdnetPostEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", atHref='" + atHref + '\'' +
                ", authorHref='" + authorHref + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", commentNum='" + commentNum + '\'' +
                ", hits='" + hits + '\'' +
                ", postID='" + postID + '\'' +
                ", postStatus='" + postStatus + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", title='" + title + '\'' +
                ", pictureHrefNum='" + pictureHrefNum + '\'' +
                '}';
    }
}
