package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"blog_sina_author\"")
public class BlogSinaAuthorEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="certification")
    private String certification;

    @Property(value="get_golden")
    private String getGolden;

    @Property(value="give_golden")
    private String giveGolden;

    @Property(value="info")
    private String info;

    @Property(value="introduction")
    private String introduction;

    @Property(value="level")
    private String level;

    @Property(value="picture_head_local")
    private String pictureHeadLocal;

    @Property(value="picture_head_url")
    private String pictureHeadUrl;

    @Property(value="point")
    private String point;

    @Property(value="popularity")
    private String popularity;

    @Property(value="url")
    private String url;

    @Property(value="visit_num")
    private String visitNum;

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

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getGetGolden() {
        return getGolden;
    }

    public void setGetGolden(String getGolden) {
        this.getGolden = getGolden;
    }

    public String getGiveGolden() {
        return giveGolden;
    }

    public void setGiveGolden(String giveGolden) {
        this.giveGolden = giveGolden;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPictureHeadLocal() {
        return pictureHeadLocal;
    }

    public void setPictureHeadLocal(String pictureHeadLocal) {
        this.pictureHeadLocal = pictureHeadLocal;
    }

    public String getPictureHeadUrl() {
        return pictureHeadUrl;
    }

    public void setPictureHeadUrl(String pictureHeadUrl) {
        this.pictureHeadUrl = pictureHeadUrl;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(String visitNum) {
        this.visitNum = visitNum;
    }

    @Override
    public String toString() {
        return "BlogSinaAuthorEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", certification='" + certification + '\'' +
                ", getGolden='" + getGolden + '\'' +
                ", giveGolden='" + giveGolden + '\'' +
                ", info='" + info + '\'' +
                ", introduction='" + introduction + '\'' +
                ", level='" + level + '\'' +
                ", pictureHeadLocal='" + pictureHeadLocal + '\'' +
                ", pictureHeadUrl='" + pictureHeadUrl + '\'' +
                ", point='" + point + '\'' +
                ", popularity='" + popularity + '\'' +
                ", url='" + url + '\'' +
                ", visitNum='" + visitNum + '\'' +
                '}';
    }
}
