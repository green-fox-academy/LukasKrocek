package com.example.reddit.user;

import com.example.reddit.post.Post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.servlet.http.Cookie;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    private String userName;
    private String password;
    private String cookie;

    @OneToMany(mappedBy = "user")
    List<Post> posts;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
