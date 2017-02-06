package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.Enumeration;

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
    //private Enumeration lookingFor;

    @Column(name = "player_class")
    private String playerClass;

    @Column(name = "level")
    private int level;

    @Column(name = "gear_rating")
    private int gearRating;

    @Column(name = "activity")
    private String activity;
    //private Enumeration experience;

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

//    public Enumeration getLookingFor() {
//        return lookingFor;
//    }
//
//    public void setLookingFor(Enumeration lookingFor) {
//        this.lookingFor = lookingFor;
//    }

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

//    public Enumeration getExperience() {
//        return experience;
//    }
//
//    public void setExperience(Enumeration experience) {
//        this.experience = experience;
//    }

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
}
