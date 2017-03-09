package com.sheaprewett.javalfg.controller.persistence;

import com.sheaprewett.javalfg.controller.entity.LFGPost;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.hibernate.Transaction;

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
        logger.log(Priority.INFO, "Created List");
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        logger.log(Priority.INFO, "Opened session");
        lfgPosts = session.createCriteria(LFGPost.class).list();
        logger.log(Priority.INFO, "Created criteria");
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
