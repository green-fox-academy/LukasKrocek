package com.example.reddit.comment;

import com.example.reddit.post.Post;
import com.example.reddit.user.models.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String content;
    private String date;

    @ManyToOne
    User user;

    @ManyToOne
    Post post;

    public Comment() {
        date = LocalDate.now().toString();
    }

}
