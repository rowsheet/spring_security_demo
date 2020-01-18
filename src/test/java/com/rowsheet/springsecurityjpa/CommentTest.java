package com.rowsheet.springsecurityjpa;

import com.rowsheet.springsecurityjpa.models.Comment;
import com.rowsheet.springsecurityjpa.models.CommentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class CommentTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void commentTest() throws Exception {

        final String author = "unit test AUTHOR";
        final String content = "unit test CONTENT";

        Comment comment = new Comment();

        comment.setAuthor(author);
        comment.setContent(content);

        commentRepository.save(comment);

        Comment _comment = commentRepository.getOne(comment.getId());

        Assert.assertNotNull(_comment);
        Assert.assertEquals(author, _comment.getAuthor());
        Assert.assertEquals(content, _comment.getContent());

        System.out.println("AUTHOR: " + _comment.getAuthor());
        System.out.println("CONTENT: " + _comment.getContent());
    }
}
