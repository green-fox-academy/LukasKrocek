package com.example.reddit.comment;

import com.example.reddit.post.PostRepo;
import com.example.reddit.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {

    CommentService commentService;
    PostRepo posts;
    UserService userService;
    CommentRepo comments;

    @Autowired
    public CommentController(CommentService commentService, PostRepo posts, UserService userService, CommentRepo comments) {
        this.commentService = commentService;
        this.posts = posts;
        this.userService = userService;
        this.comments = comments;
    }

    @PostMapping("posts/{postID}/comments/{commentID}/delete")
    public String deleteComment(@PathVariable Long postID, @PathVariable Long commentID) {
        comments.deleteById(commentID);
        return "redirect:/posts/" + postID + "/comments";
    }

    @PostMapping("posts/{postID}/comments")
    public String addNewComment(@PathVariable Long postID, @CookieValue String session, @ModelAttribute Comment comment) {
        commentService.saveAndSetComment(comment, session, postID);
        return "redirect:/posts/" + postID + "/comments";
    }

    @GetMapping("posts/{postID}/comments")
    public String getComments(Model model, @CookieValue(required = false) String session, @PathVariable Long postID) {
        if (posts.findFirstByPostID(postID).isPresent()) {
            model.addAttribute("loggedUser", userService.getLoggedUserUserName(session));
            model.addAttribute("post", posts.findFirstByPostID(postID).get());
            model.addAttribute("newComment", new Comment());
            model.addAttribute("comments", comments.findAllByPostPostID(postID));
            return "comments";
        }
        return "redirect:/invalidPostID";
    }
}
