package com.sheaprewett.javalfg.persistence;

import com.sheaprewett.javalfg.entity.LFGPost;
import com.sheaprewett.javalfg.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 2/7/17.
 */
public class LFGPostDAOTest {

    LFGPostDAO dao;

    @Before
    public void setup() {
        dao = new LFGPostDAO();
    }

    @Test
    public void getAllLFGPosts() throws Exception {
        List<LFGPost> posts = dao.getAllLFGPosts();
        assertTrue(posts.size() > 0);
    }

    @Test
    public void getLFGPost() throws Exception {
        LFGPost post = dao.getLFGPost(1);
        assertEquals(post.getPostID(), 1);
    }

    @Test
    public void filteredSearch() {
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("activity", "Crystal Tower");
        parameters.put("level", "51");
        parameters.put("haveMic", "true");

        LFGPostDAO dao = new LFGPostDAO();

        List<LFGPost> allPosts = dao.getAllLFGPosts();
        List<LFGPost> filteredPosts = dao.filteredSearch(parameters);

        assert(allPosts.size() > filteredPosts.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void save() throws Exception {
        LFGPostDAO dao = new LFGPostDAO();

        LFGPost lfgPost = new LFGPost();
        lfgPost.setUsername("testusername");

        int previousSize = dao.getAllLFGPosts().size();
        //Rollback is not working. Will insert and commit every time.
        dao.save(lfgPost);
        int newSize = dao.getAllLFGPosts().size();

        assert(newSize - previousSize == 1);
    }
}