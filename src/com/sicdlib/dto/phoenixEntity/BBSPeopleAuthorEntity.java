package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_people_author\"")
public class BBSPeopleAuthorEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="elite_num")
    private String eliteNum;

    @Property(value="level")
    private String level;

    @Property(value="post_num")
    private String postNum;

    @Property(value="reply_num")
    private String replyNum;

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

    public String getEliteNum() {
        return eliteNum;
    }

    public void setEliteNum(String eliteNum) {
        this.eliteNum = eliteNum;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(String replyNum) {
        this.replyNum = replyNum;
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
        return "BBSPeopleAuthorEntity{" +
                "pk='" + pk + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", eliteNum='" + eliteNum + '\'' +
                ", level='" + level + '\'' +
                ", postNum='" + postNum + '\'' +
                ", replyNum='" + replyNum + '\'' +
                ", url='" + url + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
