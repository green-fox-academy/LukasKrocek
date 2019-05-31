package com.example.reddit.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    PostRepo posts;

    @Autowired
    public PostController(PostRepo posts) {
        this.posts = posts;
    }

    @GetMapping("")
    public String showPosts(Model model) {
        model.addAttribute("posts", posts.findAllPostsWithPagination());
        return "postList";
    }

    @GetMapping("/addPost")
    public String showAddPost(Model model) {
        model.addAttribute("post", new Post());
        return "addPost";
    }

    @PostMapping("/addPost")
    public String addPost(@ModelAttribute Post newPost) {
        posts.save(newPost);
        return "redirect:/";
    }

    @PostMapping("")
    public String vote(@RequestParam String vote, @RequestParam Long id) {
        Post temporary = posts.findFirstById(id);
        temporary.changeVotes(vote);
        posts.save(temporary);
        return "redirect:/";
    }
}
