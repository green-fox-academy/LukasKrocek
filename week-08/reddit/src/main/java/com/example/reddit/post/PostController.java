package com.example.reddit.post;

import com.example.reddit.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/posts")
public class PostController {

    private PostRepo posts;
    private PostService postService;
    private UserRepo users;

    @Autowired
    public PostController(PostRepo posts, PostService postService, UserRepo users) {
        this.posts = posts;
        this.postService = postService;
        this.users = users;
    }

    @GetMapping(value = {"", "{numberOfPage}/show"})
    public String showPosts(Model model, @PathVariable(required = false) Integer numberOfPage) {
        if (numberOfPage == null) {
            numberOfPage = 1;
        }
        model.addAttribute("pageNumbers", postService.getPageNumberList());
        model.addAttribute("posts", postService.getPage(numberOfPage));
        return "postList";
    }

    @GetMapping("/addPost")
    public String showAddPost(Model model,@CookieValue(required = false) String session) {
        if(session==null){
            return "redirect:/notLoggedIn";
        }
        model.addAttribute("post", new Post());
        return "addPost";
    }

    @PostMapping("/addPost")
    public String addPost(@ModelAttribute Post newPost,@CookieValue String session) {
        if(users.findFirstByCookie(session).isPresent()) {
            newPost.setUser(users.findFirstByCookie(session).get());
            posts.save(newPost);
            return "redirect:/posts";
        }
        return "redirect:/invalidSessionCookie";
    }

    @PostMapping(value = {"","{numberOfPage}/show"})
    public String vote(@RequestParam String vote, @RequestParam Long id,@PathVariable(required = false) Integer numberOfPage) {
        Post temporary = posts.findFirstByPostID(id);
        temporary.changeVotes(vote);
        posts.save(temporary);
        if(numberOfPage==null) {
            return "redirect:/posts";
        }
        return "redirect:/posts/"+numberOfPage+"/show";
    }
}
