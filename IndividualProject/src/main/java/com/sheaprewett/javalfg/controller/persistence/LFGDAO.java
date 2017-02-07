package com.sheaprewett.javalfg.controller.persistence;

import com.sheaprewett.javalfg.controller.entity.LFGPost;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2/6/17.
 */
public class LFGDAO {

    /** Return a list of all posts
     *
     * @return All posts
     */
    public List<LFGPost> getAllLFGPosts() {
        List<LFGPost> lfgPosts = new ArrayList<LFGPost>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        lfgPosts = session.createCriteria(LFGPost.class).list();
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

//    public int save(LFGPost lfgPost) {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        int id = (int)session.save(lfgPost);
//        transaction.commit();
//        return id;
//    }

}
