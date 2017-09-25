package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"blog_163_author\"")
public class Blog163AuthorEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="apartment")
    private String apartment;

    @Property(value="birthday")
    private String birthday;

    @Property(value="circle")
    private String circle;

    @Property(value="contact")
    private String contact;

    @Property(value="experience")
    private String experience;

    @Property(value="hometown")
    private String hometown;

    @Property(value="id")
    private String id;

    @Property(value="information")
    private String information;

    @Property(value="introduce")
    private String introduce;

    @Property(value="nick")
    private String nick;

    @Property(value="real_time")
    private String realTime;

    @Property(value="sex")
    private String sex;

    @Property(value="url")
    private String url;

    @Property(value="wish")
    private String wish;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRealTime() {
        return realTime;
    }

    public void setRealTime(String realTime) {
        this.realTime = realTime;
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

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    @Override
    public String toString() {
        return "Blog163AuthorEntity{" +
                "pk='" + pk + '\'' +
                ", apartment='" + apartment + '\'' +
                ", birthday='" + birthday + '\'' +
                ", circle='" + circle + '\'' +
                ", contact='" + contact + '\'' +
                ", experience='" + experience + '\'' +
                ", hometown='" + hometown + '\'' +
                ", id='" + id + '\'' +
                ", information='" + information + '\'' +
                ", introduce='" + introduce + '\'' +
                ", nick='" + nick + '\'' +
                ", realTime='" + realTime + '\'' +
                ", sex='" + sex + '\'' +
                ", url='" + url + '\'' +
                ", wish='" + wish + '\'' +
                '}';
    }
}
