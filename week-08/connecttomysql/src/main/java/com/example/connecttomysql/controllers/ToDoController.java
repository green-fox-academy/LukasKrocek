package com.example.connecttomysql.controllers;

import com.example.connecttomysql.models.ToDo;
import com.example.connecttomysql.repositories.AssigneeRepository;
import com.example.connecttomysql.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = {"/todo","{assigneeID}/todo"})
public class ToDoController {

    private ToDoRepository toDoRepo;
    private AssigneeRepository assigneeRepository;

    @Autowired
    public ToDoController(ToDoRepository toDoRepo, AssigneeRepository assigneeRepository) {
        this.toDoRepo = toDoRepo;
        this.assigneeRepository = assigneeRepository;
    }

    //we should be able to search by the title or content or description in one field
    @GetMapping(value = {"", "/", "/list", "{taskID}/edit", "/search"})
    public String listToDoes(Model model, @PathVariable Optional<Long> taskID, @RequestParam(required = false) String search) {
        if (taskID.isPresent()) {
            model.addAttribute("id", taskID.get());
            model.addAttribute("toDo", toDoRepo.findFirstById(taskID.get()));
        } else {
            model.addAttribute("id", -1L);
        }
        if (search == null) {
            model.addAttribute("todos", toDoRepo.findAll());
        } else {
            model.addAttribute("todos", toDoRepo.findAllByTitleContaining(search));
        }
        model.addAttribute("newToDo", new ToDo());
        return "todolist";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable long id) {
        toDoRepo.deleteById(id);
        //service.delete(id);
        return "redirect:/todo/";
    }

    @PostMapping("/edit")
    public String editTask(@ModelAttribute ToDo toDo, @PathVariable long assigneeID) {
        toDo.setAssignee(assigneeRepository.findFirstByAssigneeID(assigneeID));
        toDoRepo.save(toDo);
        return "redirect:/todo/";
    }

    @PostMapping("/addNew")
    public String addTask(@ModelAttribute ToDo toDo,@PathVariable Long assigneeID) {
        toDo.setAssignee(assigneeRepository.findFirstByAssigneeID(assigneeID));
        toDoRepo.save(toDo);
        return "redirect:";
    }
}

