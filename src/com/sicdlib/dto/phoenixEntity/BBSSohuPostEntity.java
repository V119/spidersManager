package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_sohu_post\"")
public class BBSSohuPostEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="author_href")
    private String authorHref;

    @Property(value="comment_ids")
    private String commentIDS;

    @Property(value="content")
    private String content;

    @Property(value="date_time")
    private String dateTime;

    @Property(value="parse_time")
    private String parseTime;

    @Property(value="post_id")
    private String postID;

    @Property(value="read_num")
    private String readNum;

    @Property(value="reply_num")
    private String replyNum;

    @Property(value="title")
    private String title;

    @Property(value="picture_hrefs_num")
    private String pictureHrefsNum;

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

    public String getCommentIDS() {
        return commentIDS;
    }

    public void setCommentIDS(String commentIDS) {
        this.commentIDS = commentIDS;
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

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
    }

    public String getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(String replyNum) {
        this.replyNum = replyNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictureHrefsNum() {
        return pictureHrefsNum;
    }

    public void setPictureHrefsNum(String pictureHrefsNum) {
        this.pictureHrefsNum = pictureHrefsNum;
    }

    @Override
    public String toString() {
        return "BBSSohuPostEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorHref='" + authorHref + '\'' +
                ", commentIDS='" + commentIDS + '\'' +
                ", content='" + content + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", parseTime='" + parseTime + '\'' +
                ", postID='" + postID + '\'' +
                ", readNum='" + readNum + '\'' +
                ", replyNum='" + replyNum + '\'' +
                ", title='" + title + '\'' +
                ", pictureHrefsNum='" + pictureHrefsNum + '\'' +
                '}';
    }
}
