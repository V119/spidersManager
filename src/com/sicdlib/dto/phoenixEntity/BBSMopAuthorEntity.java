package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_mop_author\"")
public class BBSMopAuthorEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="author_id")
    private String authorID;

    @Property(value="author_name")
    private String authorName;

    @Property(value="age")
    private String age;

    @Property(value="birthday")
    private String birthday;

    @Property(value="career")
    private String career;

    @Property(value="contact_way")
    private String contactWay;

    @Property(value="education")
    private String education;

    @Property(value="fans_num")
    private String fansNum;

    @Property(value="friends_num")
    private String friends_num;

    @Property(value="hits")
    private String hits;

    @Property(value="introduce")
    private String introduce;

    @Property(value="league")
    private String league;

    @Property(value="level")
    private String level;

    @Property(value="level_nick")
    private String levelNick;

    @Property(value="login_num")
    private String loginNum;

    @Property(value="post_num")
    private String postNum;

    @Property(value="register_date")
    private String registerDate;

    @Property(value="reply_num")
    private String replyNum;

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

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorId) {
        this.authorID = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFansNum() {
        return fansNum;
    }

    public void setFansNum(String fansNum) {
        this.fansNum = fansNum;
    }

    public String getFriends_num() {
        return friends_num;
    }

    public void setFriends_num(String friends_num) {
        this.friends_num = friends_num;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelNick() {
        return levelNick;
    }

    public void setLevelNick(String levelNick) {
        this.levelNick = levelNick;
    }

    public String getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(String loginNum) {
        this.loginNum = loginNum;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(String replyNum) {
        this.replyNum = replyNum;
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
        return "BBSMopAuthorEntity{" +
                "pk='" + pk + '\'' +
                ", authorId='" + authorID + '\'' +
                ", authorName='" + authorName + '\'' +
                ", age='" + age + '\'' +
                ", birthday='" + birthday + '\'' +
                ", career='" + career + '\'' +
                ", contactWay='" + contactWay + '\'' +
                ", education='" + education + '\'' +
                ", fansNum='" + fansNum + '\'' +
                ", friends_num='" + friends_num + '\'' +
                ", hits='" + hits + '\'' +
                ", introduce='" + introduce + '\'' +
                ", league='" + league + '\'' +
                ", level='" + level + '\'' +
                ", levelNick='" + levelNick + '\'' +
                ", loginNum='" + loginNum + '\'' +
                ", postNum='" + postNum + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", replyNum='" + replyNum + '\'' +
                ", sex='" + sex + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
