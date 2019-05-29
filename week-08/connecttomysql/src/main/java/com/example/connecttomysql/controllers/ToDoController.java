package com.example.connecttomysql.controllers;

import com.example.connecttomysql.models.ToDo;
import com.example.connecttomysql.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    private ToDoService service;

    @Autowired
    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @GetMapping(value = {"", "/", "/list","{id}/newEdit"})
    public String list(Model model,@PathVariable Optional <Long> id) {
        if (id.isPresent()){
            model.addAttribute("id", id.get());
            model.addAttribute("toDo", service.getToDoById(id.get()));
        } else {
            model.addAttribute("id", -1L);
        }
        model.addAttribute("newToDo", new ToDo());
        model.addAttribute("todos", service.getToDoList());
        return "todolist";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable long id) {
        service.delete(id);
        return "redirect:/todo/";
    }

    @PostMapping("/edit")
    public String editTask(@ModelAttribute ToDo toDo) {

        service.add(toDo);
        return "redirect:/todo/";
    }

    @PostMapping("/addNew")
    public String addTask(@ModelAttribute ToDo toDo) {
        service.add(toDo);
        return "redirect:/todo/";
    }
}

