package com.example.reddit.post;


import com.example.reddit.user.User;
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
