package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;
@Entity(value="\"blogchina_comment_1\"")
public class BlogChinaCommentEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="comment_blog_id")
    private String commentBlogID;

    @Property(value="comment_content")
    private String commentContent;

    @Property(value="comment_id")
    private String commentID;

    @Property(value="comment_time")
    private String commentTime;

    @Property(value="comment_user_if")
    private String commentUserIf;

    @Property(value="ip")
    private String ip;

    @Property(value="praise_num")
    private String praiseNum;

    @Property(value="replay_num")
    private String replayNum;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getCommentBlogID() {
        return commentBlogID;
    }

    public void setCommentBlogID(String commentBlogID) {
        this.commentBlogID = commentBlogID;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentUserIf() {
        return commentUserIf;
    }

    public void setCommentUserIf(String commentUserIf) {
        this.commentUserIf = commentUserIf;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(String praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getReplayNum() {
        return replayNum;
    }

    public void setReplayNum(String replayNum) {
        this.replayNum = replayNum;
    }

    @Override
    public String toString() {
        return "BlogChinaCommentEntity{" +
                "pk='" + pk + '\'' +
                ", commentBlogID='" + commentBlogID + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", commentID='" + commentID + '\'' +
                ", commentTime='" + commentTime + '\'' +
                ", commentUserIf='" + commentUserIf + '\'' +
                ", ip='" + ip + '\'' +
                ", praiseNum='" + praiseNum + '\'' +
                ", replayNum='" + replayNum + '\'' +
                '}';
    }
}
