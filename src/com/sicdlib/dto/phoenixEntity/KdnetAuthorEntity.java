package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"kdnet_author\"")
public class KdnetAuthorEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="fans_num")
    private String fansNum;

    @Property(value="friends_num")
    private String friendsNum;

    @Property(value="hits")
    private String hits;

    @Property(value="influence")
    private String influence;

    @Property(value="level")
    private String level;

    @Property(value="login_num")
    private String loginNum;

    @Property(value="nick")
    private String nick;

    @Property(value="parse_time")
    private String parseTime;

    @Property(value="post_num")
    private String postNum;

    @Property(value="register_num")
    private String registerNum;

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

    public String getFansNum() {
        return fansNum;
    }

    public void setFansNum(String fansNum) {
        this.fansNum = fansNum;
    }

    public String getFriendsNum() {
        return friendsNum;
    }

    public void setFriendsNum(String friendsNum) {
        this.friendsNum = friendsNum;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getInfluence() {
        return influence;
    }

    public void setInfluence(String influence) {
        this.influence = influence;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(String loginNum) {
        this.loginNum = loginNum;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getParseTime() {
        return parseTime;
    }

    public void setParseTime(String parseTime) {
        this.parseTime = parseTime;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getRegisterNum() {
        return registerNum;
    }

    public void setRegisterNum(String registerNum) {
        this.registerNum = registerNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "KdnetAuthorEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", fansNum='" + fansNum + '\'' +
                ", friendsNum='" + friendsNum + '\'' +
                ", hits='" + hits + '\'' +
                ", influence='" + influence + '\'' +
                ", level='" + level + '\'' +
                ", loginNum='" + loginNum + '\'' +
                ", nick='" + nick + '\'' +
                ", parseTime='" + parseTime + '\'' +
                ", postNum='" + postNum + '\'' +
                ", registerNum='" + registerNum + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
