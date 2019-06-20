package com.example.trialexam.controllers;

import com.example.trialexam.models.Link;
import com.example.trialexam.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LinkController {

    private LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/")
    public String getIndex(@RequestParam(required = false) String error,
                           @RequestParam(required = false) String alias,
                           @RequestParam(required = false) String secretCode,
                           Model model) {
        if (!(error == null || error.isEmpty())) {
            model.addAttribute("error", "Your alias is already in use!");
        } else {
            model.addAttribute("error", null);
        }
        model.addAttribute("alias", alias);
        model.addAttribute("secretCode", secretCode);

        return "index";
    }

    @PostMapping("/save-link")
    public String saveNewLink(@RequestParam String url, @RequestParam String alias) {
        if (linkService.aliasExists(alias)) {
            return "redirect:/?error=takenAlias";
        } else {
            Link newLink = new Link(url, alias);
            linkService.saveLink(newLink);
            return "redirect:/?alias=" + alias + "&secretCode=" + newLink.getSecretCode();
        }
    }

    @GetMapping("/a/{alias}")
    public String getLink(@PathVariable String alias) {
        Link link = linkService.findLinkByAlias(alias);
        if (link == null) {
            throw new ResourceNotFoundException();
        }
        return "redirect:" + link.getUrl();
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {
    }
}
