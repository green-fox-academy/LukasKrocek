package com.example.reddit.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long> {

    Post findFirstById (Long id);

    @Query(value ="SELECT u FROM Post u ORDER BY votes")
    Page<Post> findAllPostsWithPagination(Pageable pageable);

}
