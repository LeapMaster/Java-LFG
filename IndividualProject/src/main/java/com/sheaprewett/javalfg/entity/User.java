package com.sheaprewett.javalfg.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by student on 4/24/17.
 */
@Entity
@Table(name = "users")
public class User {

    @Column(name="user_name")
    private String username;

    @Column(name="user_pass")
    private String password;

    @Column(name="wow_user")
    private String wowUser;

    @Column(name="wow_realm")
    private String wowRealm;

    @Column(name="char_level", nullable = true)
    private Integer characterLevel;

    @Column(name="item_level", nullable = true)
    private Integer itemLevel;

    @Column(name="player_class")
    private String playerClass;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int userID;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getWowUser() {
        return wowUser;
    }

    public void setWowUser(String wowUser) {
        this.wowUser = wowUser;
    }

    public String getWowRealm() {
        return wowRealm;
    }

    public void setWowRealm(String wowRealm) {
        this.wowRealm = wowRealm;
    }

    public Integer getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(Integer characterLevel) {
        this.characterLevel = characterLevel;
    }

    public Integer getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(Integer itemLevel) {
        this.itemLevel = itemLevel;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String toString() {
        return "User: {username: " + username
                + ", userID: " + userID
                + ", wowUser: " + wowUser
                + ", wowRealm: " + wowRealm
                + ", characterLevel: " + characterLevel
                + ", itemLevel: " + itemLevel + "}";
    }


}
