package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"kdnet_comment\"")
public class KdnetCommentEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="at_href")
    private String atHref;

    @Property(value="author_href")
    private String authorHref;

    @Property(value="comment_id")
    private String commentID;

    @Property(value="content")
    private String content;

    @Property(value="at_user")
    private String atUser;

    @Property(value="author_nick")
    private String authorNick;

    @Property(value="date_time")
    private String dateTime;

    @Property(value="floor_num")
    private String floorNum;

    @Property(value="parse_time")
    private String parseTime;

    @Property(value="quote_comment_id")
    private String quoteCommentID;

    @Property(value="picture_href_num")
    private String pictureHrefNum;

    @Property(value="post_id")
    private String postID;

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

    public String getAtUser() {
        return atUser;
    }

    public void setAtUser(String atUser) {
        this.atUser = atUser;
    }

    public String getAuthorNick() {
        return authorNick;
    }

    public void setAuthorNick(String authorNick) {
        this.authorNick = authorNick;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }

    public String getParseTime() {
        return parseTime;
    }

    public void setParseTime(String parseTime) {
        this.parseTime = parseTime;
    }

    public String getQuoteCommentID() {
        return quoteCommentID;
    }

    public void setQuoteCommentID(String quoteCommentID) {
        this.quoteCommentID = quoteCommentID;
    }

    public String getPictureHrefNum() {
        return pictureHrefNum;
    }

    public void setPictureHrefNum(String pictureHrefNum) {
        this.pictureHrefNum = pictureHrefNum;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    @Override
    public String toString() {
        return "KdnetCommentEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", atHref='" + atHref + '\'' +
                ", authorHref='" + authorHref + '\'' +
                ", commentID='" + commentID + '\'' +
                ", content='" + content + '\'' +
                ", atUser='" + atUser + '\'' +
                ", authorNick='" + authorNick + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", floorNum='" + floorNum + '\'' +
                ", parseTime='" + parseTime + '\'' +
                ", quoteCommentID='" + quoteCommentID + '\'' +
                ", pictureHrefNum='" + pictureHrefNum + '\'' +
                ", postID='" + postID + '\'' +
                '}';
    }
}
