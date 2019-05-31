package com.example.reddit.user;

import com.example.reddit.post.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.UUID;

@Controller
public class UserController {

    UserRepo users;
    PostRepo posts;

    @Autowired
    public UserController(UserRepo users, PostRepo posts) {
        this.users = users;
        this.posts = posts;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("form", new UserForm());
        model.addAttribute("current", "login");
        return "userForm";
    }

    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {
        model.addAttribute("form", new UserForm());
        model.addAttribute("current", "registration");

        return "userForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserForm form, Model model, HttpServletResponse response) {
        if (form.validLogin()) {
            Optional<User> user = users.findUserByUserName(form.getUserName());
            if (user.isPresent()) {
                if (users.findFirstByPassword(form.getPassword()).isPresent()) {
                    Cookie sessionCookie = new Cookie("session", UUID.randomUUID().toString());
                    user.get().setCookie(sessionCookie.getValue());
                    response.addCookie(sessionCookie);
                    users.save(user.get());
                    return "redirect:/posts";
                }
                form.addError("Incorrect password");
            } else {
                form.addError("User not found");
            }
        }
        model.addAttribute("current", "login");
        model.addAttribute("form", new UserForm());
        model.addAttribute("errors", form.getErrors());
        return "userForm";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute UserForm form, Model model) {
        if (form.validRegistration()) {
            Optional<User> user = users.findUserByUserName(form.getUserName());
            if (!user.isPresent()) {
                users.save(new User(form.getUserName(), form.getPassword()));//register
                return "redirect:/login";
            }
            form.addError("This user already exists");
        }
        model.addAttribute("current", "registration");
        model.addAttribute("form", new UserForm());
        model.addAttribute("errors", form.getErrors());
        return "userForm";
    }

    @GetMapping("/logout")
    public String logout(@CookieValue(required = false) Cookie session, HttpServletResponse response) {
        if (session == null) {
            return "redirect:/notLoggedIn";
        }
        session.setMaxAge(0);
        response.addCookie(session);
        return "redirect:/posts";
    }

    @GetMapping("/accountInfo")
    public String accountInfo(@CookieValue(required = false) Cookie session,Model model) {
        if (session == null) {
            return "redirect:/notLoggedIn";
        }
        if (users.findFirstByCookie(session.getValue()).isPresent()) {
            User user = users.findFirstByCookie(session.getValue()).get();
            model.addAttribute("userPosts",posts.findAllByUser_UserName(user.getUserName()));
            return "accountInfo";
        }
        return "redirect:/invalidSessionCookie";
    }
}
