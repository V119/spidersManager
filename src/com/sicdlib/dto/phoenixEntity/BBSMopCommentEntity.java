package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_mop_comment\"")
public class BBSMopCommentEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="comment_id")
    private String commentID;

    @Property(value="content")
    private String content;

    @Property(value="date_time")
    private String dateTime;

    @Property(value="floor_num")
    private String floorNum;

    @Property(value="post_id")
    private String postID;

    @Property(value="praise_num")
    private String praiseNum;

    @Property(value="reply_num")
    private String replyNum;

    @Property(value="user_href")
    private String userHref;

    @Property(value="user_id")
    private String userID;

    @Property(value="user_name")
    private String userName;

    @Property(value="picture_hrefs_num")
    private String pictureHrefsNum;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
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

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(String praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(String replyNum) {
        this.replyNum = replyNum;
    }

    public String getUserHref() {
        return userHref;
    }

    public void setUserHref(String userHref) {
        this.userHref = userHref;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPictureHrefsNum() {
        return pictureHrefsNum;
    }

    public void setPictureHrefsNum(String pictureHrefsNum) {
        this.pictureHrefsNum = pictureHrefsNum;
    }

    @Override
    public String toString() {
        return "BBSMopCommentEntity{" +
                "pk='" + pk + '\'' +
                ", commentID='" + commentID + '\'' +
                ", content='" + content + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", floorNum='" + floorNum + '\'' +
                ", postID='" + postID + '\'' +
                ", praiseNum='" + praiseNum + '\'' +
                ", replyNum='" + replyNum + '\'' +
                ", userHref='" + userHref + '\'' +
                ", userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", pictureHrefsNum='" + pictureHrefsNum + '\'' +
                '}';
    }
}
