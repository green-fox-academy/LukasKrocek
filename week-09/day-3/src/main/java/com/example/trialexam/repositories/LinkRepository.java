package com.example.trialexam.repositories;

import com.example.trialexam.models.Link;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LinkRepository extends CrudRepository<Link, String> {
    Optional<Link> findFirstByAlias(String alias);
    Optional<Link> findFirstById(Long id);
    List<Link> findAll();
}
