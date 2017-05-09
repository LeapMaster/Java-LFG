package com.sheaprewett.javalfg.persistence;

import com.sheaprewett.javalfg.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).addOrder(Order.desc("id")).list();

        return users;
    }

    /** Get a list of posts for the given id
     *
     * @param username user's username
     * @return LFGPost
     */
    public User getUserByName(String username) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<User> users = session.createCriteria(User.class).add(Restrictions.eq("username", username)).list();
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;


    }


    /** Get a single user for the given id
     *
     * @param id user's id
     * @return User
     */
    public User getUserByID(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    /** Insert a new registered user
     * @param username user's selected username
     * @param password user's selected password
     * @return String message of error or success
     */
    public String registerUser(String username, String password) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;

        Integer newID;
        try {
            transaction = session.beginTransaction();
            newID = (Integer)session.save(newUser);
            return newID.toString();
        } catch(RuntimeException e) {
            // Check if null to prevent null-pointer exceptions on rollback
            if (transaction != null) {
                transaction.rollback();
            }
            newID = -1;
        } finally {
            //Make sure to commit any changes, then close the session
            transaction.commit();
            session.flush();
            session.close();

        }


        return "";
    }

    /** Edit user with character data
     * @param user the edited User object
     * @return String message of error or success
     */
    public String editUser(User user) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
        } catch(RuntimeException e) {
            // Check if null to prevent null-pointer exceptions on rollback
            if (transaction != null) {
                transaction.rollback();
                System.out.println("FAILED");
            }
        } finally {
            //Make sure to commit any changes, then close the session
            transaction.commit();
            session.flush();
            session.close();

        }


        return "";
    }
}
