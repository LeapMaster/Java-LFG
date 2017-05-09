package com.sheaprewett.javalfg.persistence;

import com.sheaprewett.javalfg.controller.PropertiesFileLoader;
import com.sheaprewett.javalfg.entity.LFGPost;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.*;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Created by student on 2/6/17.
 */
public class LFGPostDAO {

    Properties properties = new PropertiesFileLoader().loadProperties();

    final Logger logger = Logger.getLogger(this.getClass());
    /** Return a list of all posts
     *
     * @return All posts
     */
    public List<LFGPost> getAllLFGPosts() {

        List<LFGPost> lfgPosts = new ArrayList<LFGPost>();

        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        lfgPosts = session.createCriteria(LFGPost.class).addOrder(Order.desc("id")).list();

        return lfgPosts;
    }

    /** Get a single post for the given id
     *
     * @param id post's id
     * @return LFGPost
     */
    public LFGPost getLFGPost(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        LFGPost lfgPost = (LFGPost) session.get(LFGPost.class, id);
        return lfgPost;
    }

    /** Get a list of posts for the given search parameters
     *
     * @param parameters post's id
     * @return LFGPost
     */
    public List<LFGPost> filteredSearch(HashMap<String, String> parameters) {
        List<LFGPost> lfgPosts = new ArrayList<LFGPost>();

        logger.log(Priority.INFO, "Reached DAO!");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria filter = session.createCriteria(LFGPost.class);

        // Loop through the map of fields and values
        Iterator iterator = parameters.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)iterator.next();
            String key = String.valueOf(pair.getKey());
            String value = String.valueOf(pair.getValue());
            logger.debug(key + " = " + value);
            if (key.equals("level") || key.equals("gearRating")) {
                logger.debug("+" + value + "+");
                Criterion currentCriterion = Restrictions.ge(key, Integer.parseInt(value));
                filter.add(currentCriterion);
            } else if (key.equals("haveMic")) {
                Criterion currentCriterion = Restrictions.ge(key, true);
                filter.add(currentCriterion);
            } else {
                Criterion currentCriterion = Restrictions.eq(key, value);
                filter.add(currentCriterion);
            }


            iterator.remove(); // avoids a ConcurrentModificationException
        }
        lfgPosts = filter.addOrder(Order.desc("id")).list();
        logger.debug(lfgPosts);
        return lfgPosts;
    }

    /** save or update post
     * @param lfgPost
     * @return id of the inserted lfg post
     */
    public void save(LFGPost lfgPost) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(lfgPost);
        transaction.commit();
        trimMessages();
    }

    /**
     * trim LFG posts to fit max, called on new post insert
     */
    public void trimMessages() {
        int MAX_MESSAGES_COUNT = Integer.parseInt(properties.getProperty("posts.max"));

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Long postCountLong = (Long) session.createCriteria(LFGPost.class).setProjection(Projections.rowCount()).uniqueResult();
        int postCount = postCountLong.intValue();
        if (postCount > MAX_MESSAGES_COUNT) {
            // Calculate the difference between the correct and current amount of messages
            int difference = postCount - MAX_MESSAGES_COUNT;
            List<LFGPost> lfgPosts;
            // Order by ascending to make sure we get the oldest messages, only select as many messages as we're over
            lfgPosts = session.createCriteria(LFGPost.class).setMaxResults(difference).addOrder(Order.asc("postID")).list();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                for (LFGPost lfgPost : lfgPosts) {
                    session.delete(lfgPost);
                }
            }  catch(RuntimeException e) {
                // Check if null to prevent null-pointer exceptions on rollback
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {
                //Make sure to commit any changes, then close the session
                transaction.commit();
                session.flush();
                session.close();
            }
        }
    }

}
