package com.sheaprewett.javalfg.persistence;

import com.sheaprewett.javalfg.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 4/25/17.
 */
public class UserDAO {

    final Logger logger = Logger.getLogger(this.getClass());

    /** Return a list of all posts
     *
     * @return All posts
     */
    public List<User> getAllLFGPosts() {

        List<User> users = new ArrayList<User>();

        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        users = session.createCriteria(User.class).addOrder(Order.desc("id")).list();

        return users;
    }

}
