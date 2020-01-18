package com.rowsheet.springsecurityjpa;

import com.rowsheet.springsecurityjpa.models.Post;
import com.rowsheet.springsecurityjpa.models.PostRepository;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PostTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void postTest() throws Exception {

        final String title = "unit test TITLE";
        final String content = "unit test CONTENT";

        Post post = new Post();

        post.setTitle(title);
        post.setContent(content);

        postRepository.save(post);

        Post _post = postRepository.getOne(post.getId());

        Assert.assertNotNull(_post);
        Assert.assertEquals(title, _post.getTitle());
        Assert.assertEquals(content, _post.getContent());

        System.out.println("TITLE: " + _post.getTitle());
        System.out.println("CONTENT: " + _post.getContent());
    }
}
