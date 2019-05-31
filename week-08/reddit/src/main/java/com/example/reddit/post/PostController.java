package com.example.reddit.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostRepo posts;
    private PostService postService;

    @Autowired
    public PostController(PostRepo posts, PostService postService) {
        this.posts = posts;
        this.postService = postService;
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
    public String showAddPost(Model model) {
        model.addAttribute("post", new Post());
        return "addPost";
    }

    @PostMapping("/addPost")
    public String addPost(@ModelAttribute Post newPost) {
        posts.save(newPost);
        return "redirect:/";
    }

    @PostMapping(value = {"","{numberOfPage}/show"})
    public String vote(@RequestParam String vote, @RequestParam Long id,@PathVariable(required = false) Integer numberOfPage) {
        Post temporary = posts.findFirstById(id);
        temporary.changeVotes(vote);
        posts.save(temporary);
        if(numberOfPage==null) {
            return "redirect:";
        }
        return "redirect:/"+numberOfPage+"/show";
    }
}
