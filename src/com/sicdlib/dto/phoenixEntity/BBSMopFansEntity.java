package com.sicdlib.dto.phoenixEntity;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value="\"bbs_mop_fans\"")
public class BBSMopFansEntity {

    @Property(value="PK")
    private String pk;

    @Property(value="fans_id")
    private String fansID;

    @Property(value="friends_id")
    private String friendsID;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getFansID() {
        return fansID;
    }

    public void setFansID(String fansID) {
        this.fansID = fansID;
    }

    public String getFriendsID() {
        return friendsID;
    }

    public void setFriendsID(String friendsID) {
        this.friendsID = friendsID;
    }
}
