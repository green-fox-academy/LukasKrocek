package com.example.connecttomysql.repositories;

import com.example.connecttomysql.models.ToDo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    List<ToDo> findAllByTitleContaining(String search);

    ToDo findFirstById(long id);

    List<ToDo> findAll();
    //List <ToDo> findAllByAssignee_AssigneeID();
}

