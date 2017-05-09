package com.sheaprewett.javalfg.persistence;

import com.sheaprewett.javalfg.entity.User;
import org.junit.Test;

import java.util.List;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
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
        assertEquals(user.getUsername(), "11");

    }

    @Test
    public void getUserByID() {
        UserDAO dao = new UserDAO();
        User user = dao.getUserByID(1);
        assert(user != null);
        assertEquals(user.getUserID(), 1);

    }


    @Test
    @Transactional
    @Rollback(true)
    public void registerUser() throws Exception {
        UserDAO dao = new UserDAO();
        //Rollback is not working. Will insert and commit every time.
//        dao.registerUser("testusername", "testpassword");
//
//        User user = dao.getUserByName("testusername");
//        assert(user != null);
    }

    @Test
    public void editUser() throws Exception {
        UserDAO dao = new UserDAO();

        User oldUser = dao.getUserByName("11");
        String wowUser = oldUser.getWowUser();
        System.out.println("old wow " + wowUser);

        oldUser.setUsername("11");
        oldUser.setPassword("11");
        oldUser.setWowUser("Trizand");
        oldUser.setWowRealm("Kil'Jaeden");
        oldUser.setCharacterLevel(110);
        oldUser.setItemLevel(721);

        System.out.println("User to insert: " + oldUser);

        dao.editUser(oldUser);

        User newUser = dao.getUserByName("11");
        assert(newUser != oldUser);

        oldUser.setWowUser("Salsten");
        dao.editUser(oldUser);
        assertEquals(wowUser, oldUser.getWowUser());

    }






}