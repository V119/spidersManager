package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_mop_post\"")
public class BBSMopPostEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="comment_ids")
    private String commentIDS;

    @Property(value="author_href")
    private String authorHref;

    @Property(value="collect_num")
    private String collectNum;

    @Property(value="content")
    private String content;

    @Property(value="hits")
    private String hits;

    @Property(value="path_href")
    private String pathHref;

    @Property(value="path_text")
    private String pathText;

    @Property(value="post_id")
    private String postID;

    @Property(value="praise_num")
    private String praiseNum;

    @Property(value="publish_date")
    private String publishDate;

    @Property(value="recommend_num")
    private String recommendNum;

    @Property(value="reply_num")
    private String replyNum;

    @Property(value="title")
    private String title;

    @Property(value="tags")
    private String tags;

    @Property(value="url")
    private String url;

    @Property(value="picture_hrefs_num")
    private String pictureHrefsNum;

    @Property(value="date_time")
    private String dateTime;

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

    public String getAuthorHref() {
        return authorHref;
    }

    public void setAuthorHref(String authorHref) {
        this.authorHref = authorHref;
    }

    public String getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(String collectNum) {
        this.collectNum = collectNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
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

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(String recommendNum) {
        this.recommendNum = recommendNum;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
