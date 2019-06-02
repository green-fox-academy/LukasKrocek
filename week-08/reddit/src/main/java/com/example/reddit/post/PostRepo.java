package com.example.reddit.post;

import com.example.reddit.user.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends CrudRepository<Post, Long> {

    Optional <Post> findFirstByPostID(Long id);

    @Query(
            value = "SELECT * FROM post ORDER BY votes DESC",
            nativeQuery = true)
    List<Post> findAllOnPage(Pageable pageable);

    List<Post> findAll();

    Optional <Post> findAllByUser_UserName(String userName);

}
