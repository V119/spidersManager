package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_china_post\"")
public class BBSChinaPostEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="comment_ids")
    private String commentIDS;

    @Property(value="content")
    private String content;

    @Property(value="date_time")
    private String dateTime;

    @Property(value="hot_words")
    private String hotWords;

    @Property(value="key_words")
    private String keyWords;

    @Property(value="level")
    private String level;

    @Property(value="parse_time")
    private String parseTime;

    @Property(value="participant_num")
    private String participantNum;

    @Property(value="path_href")
    private String pathHref;

    @Property(value="path_text")
    private String pathText;

    @Property(value="point")
    private String point;

    @Property(value="read_num")
    private String readNum;

    @Property(value="reply_num")
    private String replyNum;

    @Property(value="title")
    private String title;

    @Property(value="post_id")
    private String postID;

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

    public String getHotWords() {
        return hotWords;
    }

    public void setHotWords(String hotWords) {
        this.hotWords = hotWords;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParseTime() {
        return parseTime;
    }

    public void setParseTime(String parseTime) {
        this.parseTime = parseTime;
    }

    public String getParticipantNum() {
        return participantNum;
    }

    public void setParticipantNum(String participantNum) {
        this.participantNum = participantNum;
    }

    public String getPathHref() {
        return pathHref;
    }

    public void setPathHref(String pathHref) {
        this.pathHref = pathHref;
    }

    public String getPathText() {
        return pathText;
    }

    public void setPathText(String pathText) {
        this.pathText = pathText;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
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

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
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
        return "BBSChinaPostEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", commentIDS='" + commentIDS + '\'' +
                ", content='" + content + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", hotWords='" + hotWords + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", level='" + level + '\'' +
                ", parseTime='" + parseTime + '\'' +
                ", participantNum='" + participantNum + '\'' +
                ", pathHref='" + pathHref + '\'' +
                ", pathText='" + pathText + '\'' +
                ", point='" + point + '\'' +
                ", readNum='" + readNum + '\'' +
                ", replyNum='" + replyNum + '\'' +
                ", title='" + title + '\'' +
                ", postID='" + postID + '\'' +
                ", url='" + url + '\'' +
                ", picture_hrefs_num='" + picture_hrefs_num + '\'' +
                '}';
    }
}
