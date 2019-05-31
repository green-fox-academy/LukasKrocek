package com.example.reddit.user;

import com.example.reddit.post.Post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    String userName;
    String password;

    @OneToMany(mappedBy = "user")
    List<Post> posts;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }
}
