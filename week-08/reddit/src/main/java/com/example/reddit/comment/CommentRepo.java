package com.example.reddit.comment;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepo extends CrudRepository <Comment, Long> {

    List<Comment> findAllByPostPostID (Long postID);
}
