package com.example.connecttomysql.controllers;

import com.example.connecttomysql.repositories.ToDoRepository;
import com.example.connecttomysql.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/todo")
public class ToDoController {

    private ToDoService service;

    @Autowired
    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @GetMapping (value = {"/","/list"})
    public String list (Model model, @RequestParam (required = false, defaultValue = "false") Boolean isActive){
        if (isActive){
            model.addAttribute("todos",service.filterByActive());
        } else {
            model.addAttribute("todos",service.getToDoList());
        }
        return "todolist";
    }
}

