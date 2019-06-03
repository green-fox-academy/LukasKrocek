package com.example.foxes.controllers;

import com.example.foxes.services.FoxesManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {  //Redirections and Model Views only

    private FoxesManagerService foxManager;

    @Autowired
    public MainController(FoxesManagerService foxManager) {
        this.foxManager = foxManager;
    }

    @RequestMapping(value = "/")
    public String MainPageHandler(@RequestParam(required = false) String name, Model model) {
        if (name != null && foxManager.foxExists(name)) {
            model.addAttribute("fox", foxManager.getFoxByName(name));
            model.addAttribute("allFoxes", foxManager.getFoxes());
            return "index";
        } else return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String returnLoginPage(Model model) {
        model.addAttribute("info", "Login");
        model.addAttribute("allFoxes", foxManager.getFoxes());
        return "login";
    }

    @PostMapping(value = "/login")
    public String loginHandler(@RequestParam String name) {
        if (foxManager.foxExists(name)) {
            return "redirect:?name=" + name; //redirects to home page with logged fox
        }
        return "redirect:/CreateFox";
    }

    @GetMapping(value = "/CreateFox")
    public String returnCreateFoxPage(Model model) {
        model.addAttribute("info", "This fox doesn't exists.");
        model.addAttribute("allFoxes", foxManager.getFoxes());
        return "login";
    }

    //change to PathVariable
    @PostMapping(value = "/")
    public String navigationHandler(@RequestParam String endpoint, @RequestParam String name) {
        return "redirect:/" + endpoint + "?name=" + name;
    }

    @GetMapping("/ShowChanges")
    public String showChanges(@RequestParam String name, Model model) {
        model.addAttribute("changes", foxManager.getFoxByName(name).getChanges());
        return "listOfChanges";
    }

    //change to PathVariable - post to get
    @PostMapping(value = "/ShowChanges")
    public String goHome(@RequestParam String name) {
        return "redirect:/" + "?name=" + name;
    }
}
