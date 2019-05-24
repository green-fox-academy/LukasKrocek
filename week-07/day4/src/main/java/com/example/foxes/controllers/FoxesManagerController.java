package com.example.foxes.controllers;

import com.example.foxes.services.FoxesManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FoxesManagerController { //Create, Delete, Filter foxes

    private FoxesManagerService foxManager;

    @Autowired
    public FoxesManagerController(FoxesManagerService foxManager) {
        this.foxManager = foxManager;
    }

    @PostMapping(value = "/CreateFox")
    public String createFox(@RequestParam String name) {
        if (!foxManager.foxExists(name)) {
            foxManager.addFox(name);
        }
        return "redirect:?name=" + name;
    }
}
