package com.sheaprewett.javalfg.controller.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import org.ocpsoft.prettytime.PrettyTime;

/**
 * Created by student on 2/1/17.
 */
@Entity
@Table(name = "lfg_posts")
public class LFGPost {

    @Column(name = "platform")
    private String platform;

    @Column(name = "username")
    private String username;

    @Column(name = "region")
    private String region;

    @Column(name = "player_class")
    private String playerClass;

    @Column(name = "level")
    private int level;

    @Column(name = "gear_rating")
    private int gearRating;

    @Column(name = "activity")
    private String activity;



    @Column(name = "experience")
    private String experience;

    @Column(name = "looking_for")
    private String lookingFor;

    @Column(name = "description")
    private String description;

    @Column(name = "have_mic")
    private boolean haveMic;

    @Column(name = "time_posted")
    private Date timePosted;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int postID;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGearRating() {
        return gearRating;
    }

    public void setGearRating(int gearRating) {
        this.gearRating = gearRating;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHaveMic() {
        return haveMic;
    }

    public void setHaveMic(boolean haveMic) {
        this.haveMic = haveMic;
    }

    public Date getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(Date timePosted) {
        this.timePosted = timePosted;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }


    @Override
    public String toString() {
        return "LFGPost{" +
                "platform='" + platform + '\'' +
                ", username='" + username + '\'' +
                ", region='" + region + '\'' +
                ", playerClass='" + playerClass + '\'' +
                ", level=" + level +
                ", gearRating=" + gearRating +
                ", activity='" + activity + '\'' +
                ", description='" + description + '\'' +
                ", haveMic=" + haveMic +
                ", timePosted=" + timePosted +
                ", postID=" + postID +
                '}';
    }

    public String getMinutesAgo() {
        if (timePosted != null) {
            PrettyTime p = new PrettyTime();
            return p.format(timePosted);
        } else {
            return "No timestamp available";
        }
    }

}
