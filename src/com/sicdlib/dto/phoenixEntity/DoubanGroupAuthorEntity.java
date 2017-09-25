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
