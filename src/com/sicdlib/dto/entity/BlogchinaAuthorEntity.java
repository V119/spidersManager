package com.sicdlib.dto.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by init on 2017/7/19.
 */
@Entity
@Table(name = "blogchina_author", schema = "socialmind", catalog = "")
public class BlogchinaAuthorEntity {
    private String id;
    private String authorId;
    private String authorName;
    private String authorBlogName;
    private String introduce;
    private Integer articleNum;
    private Integer readNum;
    private Integer fansNum;
    private Integer focuseNum;
    private String allArticleUrl;
    private Timestamp timeStamp;
    private String imageUrl;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "author_id")
    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "author_name")
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Basic
    @Column(name = "author_blog_name")
    public String getAuthorBlogName() {
        return authorBlogName;
    }

    public void setAuthorBlogName(String authorBlogName) {
        this.authorBlogName = authorBlogName;
    }

    @Basic
    @Column(name = "introduce")
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Basic
    @Column(name = "article_num")
    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    @Basic
    @Column(name = "read_num")
    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    @Basic
    @Column(name = "fans_num")
    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    @Basic
    @Column(name = "focuse_num")
    public Integer getFocuseNum() {
        return focuseNum;
    }

    public void setFocuseNum(Integer focuseNum) {
        this.focuseNum = focuseNum;
    }

    @Basic
    @Column(name = "all_article_url")
    public String getAllArticleUrl() {
        return allArticleUrl;
    }

    public void setAllArticleUrl(String allArticleUrl) {
        this.allArticleUrl = allArticleUrl;
    }

    @Basic
    @Column(name = "time_stamp")
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogchinaAuthorEntity that = (BlogchinaAuthorEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (authorName != null ? !authorName.equals(that.authorName) : that.authorName != null) return false;
        if (authorBlogName != null ? !authorBlogName.equals(that.authorBlogName) : that.authorBlogName != null)
            return false;
        if (introduce != null ? !introduce.equals(that.introduce) : that.introduce != null) return false;
        if (articleNum != null ? !articleNum.equals(that.articleNum) : that.articleNum != null) return false;
        if (readNum != null ? !readNum.equals(that.readNum) : that.readNum != null) return false;
        if (fansNum != null ? !fansNum.equals(that.fansNum) : that.fansNum != null) return false;
        if (focuseNum != null ? !focuseNum.equals(that.focuseNum) : that.focuseNum != null) return false;
        if (allArticleUrl != null ? !allArticleUrl.equals(that.allArticleUrl) : that.allArticleUrl != null)
            return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (authorBlogName != null ? authorBlogName.hashCode() : 0);
        result = 31 * result + (introduce != null ? introduce.hashCode() : 0);
        result = 31 * result + (articleNum != null ? articleNum.hashCode() : 0);
        result = 31 * result + (readNum != null ? readNum.hashCode() : 0);
        result = 31 * result + (fansNum != null ? fansNum.hashCode() : 0);
        result = 31 * result + (focuseNum != null ? focuseNum.hashCode() : 0);
        result = 31 * result + (allArticleUrl != null ? allArticleUrl.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
