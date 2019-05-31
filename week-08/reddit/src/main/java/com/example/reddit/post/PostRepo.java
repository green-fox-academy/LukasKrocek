package com.example.reddit.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {

    Post findFirstByPostID (Long id);
    @Query(
            value = "SELECT * FROM post ORDER BY votes DESC",
            nativeQuery = true)
    List<Post> findAllOnPage(Pageable pageable);
    List<Post> findAll();


}
