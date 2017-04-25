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

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int postID;

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

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }




}
