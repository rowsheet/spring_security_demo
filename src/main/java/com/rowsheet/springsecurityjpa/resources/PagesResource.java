package com.rowsheet.springsecurityjpa.resources;

import com.rowsheet.springsecurityjpa.models.Comment;
import com.rowsheet.springsecurityjpa.models.CommentRepository;
import com.rowsheet.springsecurityjpa.models.Post;
import com.rowsheet.springsecurityjpa.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PagesResource {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }

    /**
     * Example create route because unit test wasn't working. Turns out a sequence named 'hibernate_seqeuence'
     * needs to exist for Hibernate to work with PostgreSQL.
     */
    @GetMapping("/post/create/{title}/{content}")
    public Post createPost(
            @PathVariable(name = "title") final String title,
            @PathVariable(name = "content") final String content
    ) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        postRepository.save(post);
        return post;
    }

    /**
     * Example create route because unit test wasn't working. Turns out a sequence named 'hibernate_seqeuence'
     * needs to exist for Hibernate to work with PostgreSQL.
     */
    @GetMapping("/comment/create/{author}/{content}")
    public Comment createComment(
            @PathVariable(name = "author") final String author,
            @PathVariable(name = "content") final String content
    ) {
        Comment comment = new Comment();
        comment.setAuthor(author);
        comment.setContent(content);
        commentRepository.save(comment);
        return comment;
    }

    /**
     * @TODO This does not work as the generated id for comments is the same for both entities.
     */
    @GetMapping("/temp")
    public String temp() {
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

        return "TEMP";
    }
}
