package com.example.dependencies.controllers;

import com.example.dependencies.services.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/gfa")
public class GreenfoxAppController {


    StudentServiceInterface service;
    StudentServiceInterface serviceWithSave;


    @Autowired
    public GreenfoxAppController(@Qualifier("super") StudentServiceInterface service) {
        this.service = service;
        this.serviceWithSave = serviceWithSave;
    }

    @RequestMapping
    public String displayMainPage(Model model) {
        model.addAttribute("studentCount", service.countStudents());

        return "gfaindex";
    }


    @RequestMapping(value = "/list")
    public String displayList(Model model) {
        model.addAttribute("students", service.findAll());
        return "list";
    }

    @RequestMapping(value = "/add")
    public String displayAdder() {
        return "add";
    }

    @RequestMapping(value = "/check")
    public String displayChecker() {
        return "check";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String saveNewStudent(@RequestParam String name) {
        service.save(name);
        return name + " Was added";
    }

    @RequestMapping(value = "/checkifpresent")
    @ResponseBody
    public String checkIfPresent(@RequestParam String name) {
        if (service.findAll().contains(name)) {
            return name + " is in the list.";
        }
        return name + " is not in the list.";
    }


}
