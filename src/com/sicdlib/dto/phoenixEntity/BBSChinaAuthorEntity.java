package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_china_author\"")
public class BBSChinaAuthorEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="address")
    private String address;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="birthday")
    private String birthday;

    @Property(value="fans_num")
    private String fansNum;

    @Property(value="focuse_num")
    private String focuseNum;

    @Property(value="name")
    private String name;

    @Property(value="parse_time")
    private String parseTime;

    @Property(value="sex")
    private String sex;

    @Property(value="url")
    private String url;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFansNum() {
        return fansNum;
    }

    public void setFansNum(String fansNum) {
        this.fansNum = fansNum;
    }

    public String getFocuseNum() {
        return focuseNum;
    }

    public void setFocuseNum(String focuseNum) {
        this.focuseNum = focuseNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParseTime() {
        return parseTime;
    }

    public void setParseTime(String parseTime) {
        this.parseTime = parseTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BBSChinaAuthorEntity{" +
                "pk='" + pk + '\'' +
                ", address='" + address + '\'' +
                ", authorID='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", fansNum='" + fansNum + '\'' +
                ", focuseNum='" + focuseNum + '\'' +
                ", name='" + name + '\'' +
                ", parseTime='" + parseTime + '\'' +
                ", sex='" + sex + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
