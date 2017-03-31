package com.sheaprewett.javalfg.persistence;

import com.sheaprewett.javalfg.entity.LFGPost;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * Created by student on 2/6/17.
 */
public class LFGPostDAO {

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


        Iterator iterator = parameters.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)iterator.next();
            String key = String.valueOf(pair.getKey());
            String value = String.valueOf(pair.getValue());
            logger.log(Priority.INFO, key + " = " + value);
            if (key.equals("level") || key.equals("gearRating")) {
                logger.log(Priority.INFO, "+" + value + "+");
//                Integer minimum = Integer.parseInt("70");
                Criterion currentCriterion = Restrictions.ge(key, Integer.parseInt(value));
                filter.add(currentCriterion);
            } else {
                Criterion currentCriterion = Restrictions.eq(key, value);
                filter.add(currentCriterion);
            }


            iterator.remove(); // avoids a ConcurrentModificationException
        }
        lfgPosts = filter.addOrder(Order.desc("id")).list();
        logger.log(Priority.INFO, lfgPosts);
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

    }

}
