package com.example.foxes.controllers;

import com.example.foxes.models.Fox;
import com.example.foxes.services.FoxStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller //redirections, fox, login/create
public class MainController {

    FoxStateService foxState;

    @Autowired
    public MainController (FoxStateService foxState){
        this.foxState = foxState;
    }

    public Fox findFoxByName(String name) {
        return foxState.getFoxes().stream()
                .filter(f -> f.getName().equals(name))
                .findAny()
                .get();
    }

    @RequestMapping(value = "/")
    public String MainPageHandler(@RequestParam(required = false) String name, Model model) {
        if (name != null && foxState.foxExists(name)) {
            model.addAttribute("fox", findFoxByName(name));
            model.addAttribute("allFoxes",foxState.getFoxes());
            return "index";
        } else return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String returnLoginPage(Model model) {
        model.addAttribute("info", "Login");
        model.addAttribute("allFoxes",foxState.getFoxes());
        return "login";
    }

    @PostMapping(value = "/login")
    public String loginHandler(@RequestParam String name) {
        if (foxState.foxExists(name)) {
            return "redirect:?name=" + name;
        }
        return "redirect:/CreateFox";
    }

    @GetMapping(value = "/CreateFox")
    public String returnCreateFoxPage(Model model) {
        model.addAttribute("info", "This fox doesn't exists.");
        model.addAttribute("allFoxes",foxState.getFoxes());
        return "login";
    }

    @PostMapping(value = "/CreateFox")
    public String createFox(@RequestParam String name) {
        if (!foxState.foxExists(name)) {
            foxState.addFox(name);
        }
        return "redirect:?name=" + name;
    }

    @PostMapping(value = "/")
    public String navigationHandler(@RequestParam String endpoint, @RequestParam String name) {
        return "redirect:/" + endpoint + "?name=" + name;
    }

}
