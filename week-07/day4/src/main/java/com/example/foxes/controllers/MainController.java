package com.example.foxes.controllers;

import com.example.foxes.services.ManageFoxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller //redirections, fox, login/create
public class MainController {

    private ManageFoxesService foxManager;

    @Autowired
    public MainController(ManageFoxesService foxManager) {
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
            return "redirect:?name=" + name;
        }
        return "redirect:/CreateFox";
    }

    @GetMapping(value = "/CreateFox")
    public String returnCreateFoxPage(Model model) {
        model.addAttribute("info", "This fox doesn't exists.");
        model.addAttribute("allFoxes", foxManager.getFoxes());
        return "login";
    }

    @PostMapping(value = "/CreateFox")
    public String createFox(@RequestParam String name) {
        if (!foxManager.foxExists(name)) {
            foxManager.addFox(name);
        }
        return "redirect:?name=" + name;
    }

    @PostMapping(value = "/")
    public String navigationHandler(@RequestParam String endpoint, @RequestParam String name) {
        return "redirect:/" + endpoint + "?name=" + name;
    }

    @GetMapping("/ShowChanges")
    public String showChanges (@RequestParam String name, Model model){
        model.addAttribute("changes", foxManager.getFoxByName(name).getChanges());
        return "listOfChanges";
    }

    @PostMapping(value = "/ShowChanges")
    public String goHome(@RequestParam String name) {
        return "redirect:/" + "?name="+ name;
    }
}
