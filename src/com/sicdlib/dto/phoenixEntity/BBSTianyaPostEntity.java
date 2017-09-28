package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_tianya_post\"")
public class BBSTianyaPostEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="author_url")
    private String authorUrl;

    @Property(value="category")
    private String category;

    @Property(value="comment_ids")
    private String commentIDS;

    @Property(value="comment_num")
    private String commentNum;

    @Property(value="content")
    private String content;

    @Property(value="date_time")
    private String dateTime;

    @Property(value="create_time")
    private String createTime;

    @Property(value="post_id")
    private String postID;

    @Property(value="key_words")
    private String keyWords;

    @Property(value="tags")
    private String tags;

    @Property(value="url")
    private String url;

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

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCommentIDS() {
        return commentIDS;
    }

    public void setCommentIDS(String commentIDS) {
        this.commentIDS = commentIDS;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
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
        return "BBSTianyaPostEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", category='" + category + '\'' +
                ", commentIDS='" + commentIDS + '\'' +
                ", commentNum='" + commentNum + '\'' +
                ", content='" + content + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", postID='" + postID + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", tags='" + tags + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", pictureHrefsNum='" + pictureHrefsNum + '\'' +
                '}';
    }
}
