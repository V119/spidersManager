package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_tianya_author\"")
public class BBSTianyaAuthorEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="fans_num")
    private String fansNum;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="friends_num")
    private String friendsNum;

    @Property(value="level")
    private String level;

    @Property(value="location")
    private String location;

    @Property(value="login_num")
    private String loginNum;

    @Property(value="point")
    private String point;

    @Property(value="register_date")
    private String registerDate;

    @Property(value="url")
    private String url;

    @Property(value="online_time")
    private String onlineTime;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getFansNum() {
        return fansNum;
    }

    public void setFansNum(String fansNum) {
        this.fansNum = fansNum;
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

    public String getFriendsNum() {
        return friendsNum;
    }

    public void setFriendsNum(String friendsNum) {
        this.friendsNum = friendsNum;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(String loginNum) {
        this.loginNum = loginNum;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    @Override
    public String toString() {
        return "BBSTianyaAuthorEntity{" +
                "pk='" + pk + '\'' +
                ", fansNum='" + fansNum + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", friendsNum='" + friendsNum + '\'' +
                ", level='" + level + '\'' +
                ", location='" + location + '\'' +
                ", loginNum='" + loginNum + '\'' +
                ", point='" + point + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", url='" + url + '\'' +
                ", onlineTime='" + onlineTime + '\'' +
                '}';
    }
}
