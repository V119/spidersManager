package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_sohu_fans\"")
public class BBSSohuFansEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="fans")
    private String fans;

    @Property(value="follow")
    private String follow;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }

    @Override
    public String toString() {
        return "BBSSohuFansEntity{" +
                "pk='" + pk + '\'' +
                ", fans='" + fans + '\'' +
                ", follow='" + follow + '\'' +
                '}';
    }
}
