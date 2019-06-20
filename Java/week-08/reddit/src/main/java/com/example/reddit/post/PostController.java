package com.example.reddit.post;

import com.example.reddit.comment.CommentRepo;
import com.example.reddit.user.UserRepo;
import com.example.reddit.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/posts")
public class PostController {

    private PostRepo posts;
    private UserRepo users;
    private CommentRepo comments;
    private PostService postService;
    private UserService userService;


    @Autowired
    public PostController(PostRepo posts, PostService postService, UserRepo users, UserService userService, CommentRepo comments) {
        this.posts = posts;
        this.postService = postService;
        this.users = users;
        this.userService = userService;
        this.comments = comments;
    }

    @GetMapping(value = {"", "{numberOfPage}/show"})
    public String showPosts(Model model, @PathVariable(required = false) Integer numberOfPage, @CookieValue(required = false) String session) {
        model.addAttribute("loggedUser", userService.getLoggedUserUserName(session));
        model.addAttribute("pageNumbers", postService.getPageNumberList());
        model.addAttribute("posts", postService.getPage(numberOfPage));
        return "posts";
    }

    @DeleteMapping(value = {"", "{numberOfPage}/show"})
    public String deletePost(@RequestParam Long postID, @PathVariable(required = false) String numberOfPage) {
        posts.deleteById(postID);
        if (numberOfPage == null) {
            return "redirect:/posts";
        }
        return "redirect:/posts/" + numberOfPage + "/show";
    }


    @GetMapping("/addPost")
    public String showEditPost(Model model, @CookieValue(required = false) String session) {
        if (session == null) {
            return "redirect:/notLoggedIn";
        }
        model.addAttribute("loggedUser", userService.getLoggedUserUserName(session));
        model.addAttribute("post", new Post());
        model.addAttribute("current","create");
        return "postManagement";
    }

    @PostMapping("/addPost")
    public String addPost(@ModelAttribute Post newPost, @CookieValue String session) {
        if (users.findFirstByCookie(session).isPresent()) {
            newPost.setUser(users.findFirstByCookie(session).get());
            posts.save(newPost);
            return "redirect:/posts";
        }
        return "redirect:/invalidSessionCookie";
    }

    @PostMapping(value = {"", "{numberOfPage}/show"})
    public String vote(@RequestParam String vote, @RequestParam Long id, @PathVariable(required = false) Integer numberOfPage) {
        Post temporary = posts.findFirstByPostID(id).get();
        temporary.changeVotes(vote);
        posts.save(temporary);
        if (numberOfPage == null) {
            return "redirect:/posts";
        }
        return "redirect:/posts/" + numberOfPage + "/show";
    }

    @GetMapping("/edit")
    public String showEditPost(Model model, @CookieValue String session, @RequestParam(defaultValue = "-1") Long postID) {
        if (posts.findFirstByPostID(postID).isPresent() && users.findFirstByCookie(session).isPresent()) {
            if (posts.findFirstByPostID(postID).get().getUser().getCookie().equals(users.findFirstByCookie(session).get().getCookie())) {
                model.addAttribute("current","edit");
                model.addAttribute("loggedUser", userService.getLoggedUserUserName(session));
                model.addAttribute("post", posts.findFirstByPostID(postID));
                return "postManagement";
            }
        }
        return "redirect: /notYourPost";
    }

    @PostMapping("/edit")
    public String editPost(@CookieValue String session, @RequestParam(defaultValue = "-1") Long postID, @ModelAttribute Post post) {
        if (posts.findFirstByPostID(postID).isPresent() && users.findFirstByCookie(session).isPresent()) {
            if (posts.findFirstByPostID(postID).get().getUser().getCookie() == users.findFirstByCookie(session).get().getCookie()) {
                post.setUser(users.findFirstByCookie(session).get());
                posts.save(post);
                return "redirect:/posts";
            }
        }
        return "redirect: /notYourPost";
    }
}