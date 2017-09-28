package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"douban_group_author\"")
public class DoubanGroupAuthorEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="introduction")
    private String introduction;

    @Property(value="join_time")
    private String joinTime;

    @Property(value="location")
    private String location;

    @Property(value="logff_time")
    private String logffTime;

    @Property(value="signature")
    private String signature;

    @Property(value="url")
    private String url;

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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLogffTime() {
        return logffTime;
    }

    public void setLogffTime(String logffTime) {
        this.logffTime = logffTime;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "DoubanGroupAuthorEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", joinTime='" + joinTime + '\'' +
                ", location='" + location + '\'' +
                ", logffTime='" + logffTime + '\'' +
                ", signature='" + signature + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
