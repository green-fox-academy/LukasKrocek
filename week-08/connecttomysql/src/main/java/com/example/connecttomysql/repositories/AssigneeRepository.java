package com.example.connecttomysql.repositories;

import com.example.connecttomysql.models.Assignee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
    List<Assignee> findAll();

    List<Assignee> findAllByNameContaining(String search);
    Assignee findFirstByNameEquals(String name);
    Assignee findFirstByAssigneeID(long id);

}
