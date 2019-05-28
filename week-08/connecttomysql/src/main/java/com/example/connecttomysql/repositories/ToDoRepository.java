package com.example.connecttomysql.repositories;

import com.example.connecttomysql.models.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository <ToDo, Long> {


}

