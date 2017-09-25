package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"douban_group_comment\"")
public class DoubanGroupCommentEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="author_href")
    private String authorHref;

    @Property(value="comment_id")
    private String commentID;

    @Property(value="content")
    private String content;

    @Property(value="post_id")
    private String postID;

    @Property(value="prise_num")
    private String priseNum;

    @Property(value="pub_time")
    private String pubTime;

    @Property(value="quote_author_href")
    private String quoteAuthorHref;

    @Property(value="quote_author_name")
    private String quoteAuthorName;

    @Property(value="quote_content")
    private String quoteContent;

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

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getPriseNum() {
        return priseNum;
    }

    public void setPriseNum(String priseNum) {
        this.priseNum = priseNum;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getQuoteAuthorHref() {
        return quoteAuthorHref;
    }

    public void setQuoteAuthorHref(String quoteAuthorHref) {
        this.quoteAuthorHref = quoteAuthorHref;
    }

    public String getQuoteAuthorName() {
        return quoteAuthorName;
    }

    public void setQuoteAuthorName(String quoteAuthorName) {
        this.quoteAuthorName = quoteAuthorName;
    }

    public String getQuoteContent() {
        return quoteContent;
    }

    public void setQuoteContent(String quoteContent) {
        this.quoteContent = quoteContent;
    }

    @Override
    public String toString() {
        return "DoubanGroupCommentEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorHref='" + authorHref + '\'' +
                ", commentID='" + commentID + '\'' +
                ", content='" + content + '\'' +
                ", postID='" + postID + '\'' +
                ", priseNum='" + priseNum + '\'' +
                ", pubTime='" + pubTime + '\'' +
                ", quoteAuthorHref='" + quoteAuthorHref + '\'' +
                ", quoteAuthorName='" + quoteAuthorName + '\'' +
                ", quoteContent='" + quoteContent + '\'' +
                '}';
    }
}
