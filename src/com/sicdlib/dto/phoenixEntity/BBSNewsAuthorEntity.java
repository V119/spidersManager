package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_news_author\"")
public class BBSNewsAuthorEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="level")
    private String level;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="login_num")
    private String loginNum;

    @Property(value="parse_time")
    private String parseTime;

    @Property(value="post_num")
    private String postNum;

    @Property(value="register_time")
    private String registerTime;

    @Property(value="url")
    private String url;

    @Property(value="age")
    private String age;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(String loginNum) {
        this.loginNum = loginNum;
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

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BBSNewsAuthorEntity{" +
                "pk='" + pk + '\'' +
                ", level='" + level + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", loginNum='" + loginNum + '\'' +
                ", parseTime='" + parseTime + '\'' +
                ", postNum='" + postNum + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", url='" + url + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
