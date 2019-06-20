package com.example.reddit.post;


import com.example.reddit.comment.Comment;
import com.example.reddit.user.models.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class Post {

    @Id
    @GeneratedValue
    private Long postID;
    private String title;
    private String url;
    private int votes;
    private String date;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    List<Comment> comments;

    public Post() {
        date = LocalDate.now().toString();
    }

    private void incrementVotes() {
        votes++;
    }

    private void decrementVotes() {
        votes--;
    }

    public void changeVotes(String vote) {
        if (vote.equals("up")) {
            incrementVotes();
        } else {
            decrementVotes();
        }
    }
}
