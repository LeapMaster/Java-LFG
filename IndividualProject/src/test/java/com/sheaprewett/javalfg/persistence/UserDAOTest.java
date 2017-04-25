package com.sheaprewett.javalfg.persistence;

import com.sheaprewett.javalfg.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 4/25/17.
 */
public class UserDAOTest {
    @Test
    public void getAllLFGPosts() throws Exception {
        UserDAO dao = new UserDAO();
        List<User> users = dao.getAllLFGPosts();
        assert(users.size() > 0);
    }

}