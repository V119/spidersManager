package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"douban_group_post\"")
public class DoubanGroupPostEntity {

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

    @Property(value="group_id")
    private String groupID;

    @Property(value="group_name")
    private String groupName;

    @Property(value="like_num")
    private String likeNum;

    @Property(value="post_id")
    private String postID;

    @Property(value="recommend_num")
    private String recommendNum;

    @Property(value="title")
    private String title;

    @Property(value="url")
    private String url;

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

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(String likeNum) {
        this.likeNum = likeNum;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(String recommendNum) {
        this.recommendNum = recommendNum;
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

    public String getPictureHrefsNum() {
        return pictureHrefsNum;
    }

    public void setPictureHrefsNum(String pictureHrefsNum) {
        this.pictureHrefsNum = pictureHrefsNum;
    }

    @Override
    public String toString() {
        return "DoubanGroupPostEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorHref='" + authorHref + '\'' +
                ", commentIDS='" + commentIDS + '\'' +
                ", content='" + content + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", groupID='" + groupID + '\'' +
                ", groupName='" + groupName + '\'' +
                ", likeNum='" + likeNum + '\'' +
                ", postID='" + postID + '\'' +
                ", recommendNum='" + recommendNum + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", pictureHrefsNum='" + pictureHrefsNum + '\'' +
                '}';
    }
}
