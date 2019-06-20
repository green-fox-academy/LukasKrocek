package com.example.reddit.comment;

import com.example.reddit.user.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepo extends CrudRepository<Comment, Long> {

    List<Comment> findAllByPostPostID(Long postID);
    List<Comment> findAllByUser(User user);

}
