package com.sicdlib.dto.phoenixEntity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"douban_group_group\"")
public class DoubanGroupGroupEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="content")
    private String content;

    @Property(value="create_time")
    private String create_time;

    @Property(value="group_id")
    private String group_id;

    @Property(value="group_name")
    private String group_name;

    @Property(value="group_tags")
    private String group_tags;

    @Property(value="leader_href")
    private String leader_href;

    @Property(value="leader_name")
    private String leader_name;

    @Property(value="url")
    private String url;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_tags() {
        return group_tags;
    }

    public void setGroup_tags(String group_tags) {
        this.group_tags = group_tags;
    }

    public String getLeader_href() {
        return leader_href;
    }

    public void setLeader_href(String leader_href) {
        this.leader_href = leader_href;
    }

    public String getLeader_name() {
        return leader_name;
    }

    public void setLeader_name(String leader_name) {
        this.leader_name = leader_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
