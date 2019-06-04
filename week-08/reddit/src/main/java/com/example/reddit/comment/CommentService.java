package com.example.reddit.comment;

import com.example.reddit.post.Post;
import com.example.reddit.post.PostRepo;
import com.example.reddit.user.UserRepo;
import com.example.reddit.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

@Service
public class CommentService {

    private PostRepo posts;
    private UserRepo users;
    private CommentRepo comments;

    @Autowired
    public CommentService(PostRepo posts, UserRepo users, CommentRepo comments) {
        this.posts = posts;
        this.users = users;
        this.comments = comments;
    }

    public void saveAndSetComment (@ModelAttribute Comment comment, String userCookie, Long postID){
        if (users.findFirstByCookie(userCookie).isPresent()&& posts.findFirstByPostID(postID).isPresent()) {
            User author = users.findFirstByCookie(userCookie).get();
            Post relatedPost = posts.findFirstByPostID(postID).get();
            comment.setUser(author);
            comment.setPost(relatedPost);
            comments.save(comment);
        }
    }
}
