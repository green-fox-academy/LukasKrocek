package com.example.demo.repository;

import com.example.demo.models.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository <ToDo, Long> {
}
