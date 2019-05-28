package com.example.connecttomysql.services;

import com.example.connecttomysql.models.ToDo;
import com.example.connecttomysql.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    private ToDoRepository repository;

    @Autowired
    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public List <ToDo> getToDoList (){
        List <ToDo> allToDoes = new ArrayList<>();
        repository.findAll().forEach(allToDoes:: add);
        return allToDoes;
    }

    public List <ToDo> filterByActive(){
        return getToDoList().stream()
                .filter(toDo -> !toDo.isDone())
                .collect(Collectors.toList());
    }
}
