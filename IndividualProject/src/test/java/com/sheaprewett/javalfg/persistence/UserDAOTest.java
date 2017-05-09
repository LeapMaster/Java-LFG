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
    public void getAllUsers() throws Exception {
        UserDAO dao = new UserDAO();
        List<User> users = dao.getAllUsers();
        assert(users.size() > 0);
    }

    @Test
    public void getUserByUsername() throws Exception {
        UserDAO dao = new UserDAO();
        User user = dao.getUserByName("11");
        assert(user != null);

    }

    @Test
    public void editUser() throws Exception {
        UserDAO dao = new UserDAO();

        User oldUser = dao.getUserByName("11");
        System.out.println(oldUser);
        String wowUser = oldUser.getWowUser();
        System.out.println("old wow " + wowUser);

        oldUser.setUsername("11");
        oldUser.setPassword("11");
        oldUser.setWowUser("Salsten");
        oldUser.setWowRealm("Kil'Jaeden");
        oldUser.setCharacterLevel(110);
        oldUser.setItemLevel(721);

        System.out.println("User to insert: " + oldUser);

        dao.editUser(oldUser);

        User newUser = dao.getUserByName("11");
        System.out.println("new wow " + newUser);

    }


}