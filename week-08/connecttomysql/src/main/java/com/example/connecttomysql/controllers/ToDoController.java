package com.example.connecttomysql.controllers;

import com.example.connecttomysql.models.ToDo;
import com.example.connecttomysql.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    private ToDoService service;

    @Autowired
    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @GetMapping(value = {"", "/", "/list"})
    public String list(Model model, @RequestParam(required = false, defaultValue = "false") Boolean isActive) {
        if (isActive) {
            model.addAttribute("todos", service.filterByActive());
        } else {
            model.addAttribute("todos", service.getToDoList());
        }
        return "todolist";
    }

    @GetMapping("/addNew")
    public String displayAddForm(Model model) {
        model.addAttribute("newToDo", new ToDo());
        return "addToDo";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable long id) {
        service.delete(id);
        return "redirect:/todo/";
    }

    @PostMapping("/addNew")
    public String addTask(@ModelAttribute ToDo toDo) {
        service.add(toDo);
        return "redirect:/todo/";
    }
}

