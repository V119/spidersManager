package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_sohu_comment\"")
public class BBSSohuCommentEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_href")
    private String authorHref;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="comment_id")
    private String commentID;

    @Property(value="date_time")
    private String dateTime;

    @Property(value="floor")
    private String floor;

    @Property(value="parse_time")
    private String parseTime;

    @Property(value="post_id")
    private String postID;

    @Property(value="quote_floor")
    private String quoteFloor;

    @Property(value="picture_hrefs_num")
    private String pictureHrefsNum;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getAuthorHref() {
        return authorHref;
    }

    public void setAuthorHref(String authorHref) {
        this.authorHref = authorHref;
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

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getParseTime() {
        return parseTime;
    }

    public void setParseTime(String parseTime) {
        this.parseTime = parseTime;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getQuoteFloor() {
        return quoteFloor;
    }

    public void setQuoteFloor(String quoteFloor) {
        this.quoteFloor = quoteFloor;
    }

    public String getPictureHrefsNum() {
        return pictureHrefsNum;
    }

    public void setPictureHrefsNum(String pictureHrefsNum) {
        this.pictureHrefsNum = pictureHrefsNum;
    }

    @Override
    public String toString() {
        return "BBSSohuCommentEntity{" +
                "pk='" + pk + '\'' +
                ", authorHref='" + authorHref + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", commentID='" + commentID + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", floor='" + floor + '\'' +
                ", parseTime='" + parseTime + '\'' +
                ", postID='" + postID + '\'' +
                ", quoteFloor='" + quoteFloor + '\'' +
                ", pictureHrefsNum='" + pictureHrefsNum + '\'' +
                '}';
    }
}
