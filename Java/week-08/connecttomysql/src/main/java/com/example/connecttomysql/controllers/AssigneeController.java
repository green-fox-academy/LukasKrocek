package com.example.connecttomysql.controllers;

import com.example.connecttomysql.models.Assignee;
import com.example.connecttomysql.repositories.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/assignee")
public class AssigneeController {

    AssigneeRepository repository;

    @Autowired
    public AssigneeController(AssigneeRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = {"", "/", "/list", "{id}/edit", "/search"})
    public String listAssignees(Model model, @PathVariable Optional<Long> id, @RequestParam(required = false) String search) {
        if (id.isPresent()) {
            model.addAttribute("id", id.get());
            model.addAttribute("assignee", repository.findFirstByAssigneeID(id.get()));
        } else {
            model.addAttribute("id", -1L);
        }
        if (search == null) {
            model.addAttribute("assignees", repository.findAll());
        } else {
            model.addAttribute("assignees", repository.findAllByNameContaining(search));
        }
        model.addAttribute("newAssignee", new Assignee());
        return "assigneeList";
    }

    @PostMapping("/edit")
    public String editAssignee(@ModelAttribute Assignee assignee) {
        repository.save(assignee);
        return "redirect:/assignee/";
    }

    @GetMapping("/{id}/delete")
    public String deleteAssignee(@PathVariable long id) {
        repository.deleteById(id);
        return "redirect:/assignee/";
    }

    @PostMapping("/addNew")
    public String addAssignee(@ModelAttribute Assignee assignee) {
        repository.save(assignee);
        return "redirect:/assignee/";
    }
}