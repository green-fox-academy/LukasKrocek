package com.example.reddit.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.validation.Valid;

@Controller
public class CommentController {

    CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("posts/getPost/{postID}/createComment")
    public String addNewComment(@PathVariable Long postID, @CookieValue String session, @ModelAttribute Comment comment) {
        commentService.saveAndSetComment(comment, session, postID);
        return "redirect:/posts/getPost/" + postID;
    }
}
