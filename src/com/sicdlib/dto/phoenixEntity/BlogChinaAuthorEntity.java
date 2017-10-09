package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"blogchina_author_1\"")
public class BlogChinaAuthorEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="all_article_url")
    private String allArticleUrl;

    @Property(value="article_num")
    private String articleNum;

    @Property(value="author_blog_name")
    private String authorBlogName;

    @Property(value="b_image")
    private String bImage;

    @Property(value="fans_num")
    private String aFansNum;

    @Property(value="focuse_num")
    private String focuseNum;

    @Property(value="image_url")
    private String imageUrl;

    @Property(value="introduce")
    private String introduce;

    @Property(value="read_num")
    private String readNum;

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

    public String getAllArticleUrl() {
        return allArticleUrl;
    }

    public void setAllArticleUrl(String allArticleUrl) {
        this.allArticleUrl = allArticleUrl;
    }

    public String getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(String articleNum) {
        this.articleNum = articleNum;
    }

    public String getAuthorBlogName() {
        return authorBlogName;
    }

    public void setAuthorBlogName(String authorBlogName) {
        this.authorBlogName = authorBlogName;
    }

    public String getbImage() {
        return bImage;
    }

    public void setbImage(String bImage) {
        this.bImage = bImage;
    }

    public String getaFansNum() {
        return aFansNum;
    }

    public void setaFansNum(String aFansNum) {
        this.aFansNum = aFansNum;
    }

    public String getFocuseNum() {
        return focuseNum;
    }

    public void setFocuseNum(String focuseNum) {
        this.focuseNum = focuseNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
    }

    @Override
    public String toString() {
        return "BlogChinaAuthorEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", allArticleUrl='" + allArticleUrl + '\'' +
                ", articleNum='" + articleNum + '\'' +
                ", authorBlogName='" + authorBlogName + '\'' +
                ", bImage='" + bImage + '\'' +
                ", aFansNum='" + aFansNum + '\'' +
                ", focuseNum='" + focuseNum + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", introduce='" + introduce + '\'' +
                ", readNum='" + readNum + '\'' +
                '}';
    }
}
