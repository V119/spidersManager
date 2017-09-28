package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_sohu_author\"")
public class BBSSohuAuthorEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="fans_num")
    private String fansNum;

    @Property(value="author_id")
    private String authorID;

    @Property(value="friends_num")
    private String friendsNum;

    @Property(value="introduction")
    private String introduction;

    @Property(value="nick_name")
    private String nickName;

    @Property(value="parse_time")
    private String parseTime;

    @Property(value="sex")
    private String sex;

    @Property(value="birthday")
    private String birthday;

    @Property(value="level")
    private String level;

    @Property(value="post_num")
    private String postNum;

    @Property(value="login_num")
    private String loginNum;

    @Property(value="education")
    private String education;

    @Property(value="title")
    private String title;

    @Property(value="duty")
    private String duty;

    @Property(value="elite_num")
    private String eliteNum;

    @Property(value="point")
    private String point;

    @Property(value="online_time")
    private String onlineTime;

    @Property(value="reputation")
    private String reputation;

    @Property(value="last_login")
    private String lastLogin;

    @Property(value="sport")
    private String sport;

    @Property(value="movie")
    private String movie;

    @Property(value="music")
    private String music;

    @Property(value="food")
    private String food;

    @Property(value="book")
    private String book;

    @Property(value="person")
    private String person;

    @Property(value="profession")
    private String profession;

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

    public String getFriendsNum() {
        return friendsNum;
    }

    public void setFriendsNum(String friendsNum) {
        this.friendsNum = friendsNum;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(String loginNum) {
        this.loginNum = loginNum;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getEliteNum() {
        return eliteNum;
    }

    public void setEliteNum(String eliteNum) {
        this.eliteNum = eliteNum;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "BBSSohuAuthorEntity{" +
                "pk='" + pk + '\'' +
                ", fansNum='" + fansNum + '\'' +
                ", authorID='" + authorID + '\'' +
                ", friendsNum='" + friendsNum + '\'' +
                ", introduction='" + introduction + '\'' +
                ", nickName='" + nickName + '\'' +
                ", parseTime='" + parseTime + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", level='" + level + '\'' +
                ", postNum='" + postNum + '\'' +
                ", loginNum='" + loginNum + '\'' +
                ", education='" + education + '\'' +
                ", title='" + title + '\'' +
                ", duty='" + duty + '\'' +
                ", eliteNum='" + eliteNum + '\'' +
                ", point='" + point + '\'' +
                ", onlineTime='" + onlineTime + '\'' +
                ", reputation='" + reputation + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", sport='" + sport + '\'' +
                ", movie='" + movie + '\'' +
                ", music='" + music + '\'' +
                ", food='" + food + '\'' +
                ", book='" + book + '\'' +
                ", person='" + person + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
