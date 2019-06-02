package com.example.reddit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {


    private UserRepo users;

    @Autowired
    public UserService(UserRepo users) {
        this.users = users;
    }

    public String getLoggedUser(String session) {
        if (session == null) {
            return "none";
        } else if (users.findFirstByCookie(session).isPresent()) {
            return users.findFirstByCookie(session).get().getUserName();
        }
        return "none";
    }

    public boolean userNameExists(String userName) {
        Optional<User> user = users.findUserByUserName(userName);
        return user.isPresent();
    }

    public boolean passwordExists(String password) {
        return users.findFirstByPassword(password).isPresent();
    }

    public void setCookieForUser(User user, HttpServletResponse response, String cookieName) {
        Cookie sessionCookie = new Cookie(cookieName, UUID.randomUUID().toString());
        user.setCookie(sessionCookie.getValue());
        response.addCookie(sessionCookie);
        users.save(user);
    }

    public void addCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        response.addCookie(new Cookie(cookieName, cookieValue));
    }
}
