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
@RequestMapping("/pages")
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
}
