package com.rowsheet.springsecurityjpa;

import com.rowsheet.springsecurityjpa.models.Comment;
import com.rowsheet.springsecurityjpa.models.CommentRepository;
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

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void postTest() throws Exception {

        // Create post.

        final String title = "unit test TITLE";
        final String content = "unit test CONTENT";

        Post post = new Post();

        post.setTitle(title);
        post.setContent(content);

        // Crate comments.

        final String author1 = "unit test AUTHOR 1";
        final String content1 = "unit test CONTENT 1";
        final String author2 = "unit test AUTHOR 2";
        final String content2 = "unit test CONTENT 2";

        Comment comment1 = new Comment();
        Comment comment2 = new Comment();

        comment1.setAuthor(author1);
        comment1.setContent(content1);
        comment2.setAuthor(author2);
        comment2.setContent(content2);

        // Add comments to post

        post.getComments().add(comment1);
        post.getComments().add(comment2);

        // Save posts.

        postRepository.save(post);

        // Load post.

        Post _post = postRepository.getOne(post.getId());

        // Assert post vars.

        Assert.assertNotNull(_post);
        Assert.assertEquals(title, _post.getTitle());
        Assert.assertEquals(content, _post.getContent());
        Assert.assertEquals(2, _post.getComments().size());

        // Assert comments vars.

        Assert.assertTrue(_post.getComments().contains(comment1));
        Assert.assertTrue(_post.getComments().contains(comment2));

        // Print for the hell of it.

        System.out.println("TITLE: " + _post.getTitle());
        System.out.println("CONTENT: " + _post.getContent());
        System.out.println("COMMENT 1: " + _post.getComments().get(0));
        System.out.println("COMMENT 2: " + _post.getComments().get(1));
    }
}
