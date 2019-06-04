package com.example.reddit.user;

import com.example.reddit.comment.CommentRepo;
import com.example.reddit.post.PostRepo;
import com.example.reddit.user.models.User;
import com.example.reddit.user.models.UserForm;
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

@Controller
public class UserController {

    private UserRepo users;
    private PostRepo posts;
    private CommentRepo comments;
    private UserService userService;


    @Autowired
    public UserController(UserRepo users, PostRepo posts, UserService userService, CommentRepo comments) {
        this.users = users;
        this.posts = posts;
        this.userService = userService;
        this.comments = comments;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model, @CookieValue(required = false) String session, @CookieValue(required = false) Cookie registered, HttpServletResponse response) {
        if (registered != null) {
            UserForm temporaryForm = new UserForm(registered.getValue());
            temporaryForm.addError("Account registered, you can login now");
            model.addAttribute("form", temporaryForm);
            model.addAttribute("errors", temporaryForm.getErrors());
            registered.setMaxAge(0);
            response.addCookie(registered);
        } else {
            model.addAttribute("form", new UserForm());
        }
        model.addAttribute("loggedUser", userService.getLoggedUserUserName(session));
        model.addAttribute("current", "login");
        return "userForm";
    }

    @GetMapping("/registration")
    public String showRegistrationPage(Model model, @CookieValue(required = false) String session) {
        model.addAttribute("loggedUser", userService.getLoggedUserUserName(session));
        model.addAttribute("form", new UserForm());
        model.addAttribute("current", "registration");

        return "userForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserForm form, Model model, HttpServletResponse response, @CookieValue(required = false) String session) {
        if (form.validLogin()) {
            Optional<User> user = users.findUserByUserName(form.getUserName());
            if (userService.userNameExists(form.getUserName())) {
                if (userService.passwordExists(form.getPassword())) {
                    userService.setCookieForUser(user.get(), response, "session");
                    return "redirect:/posts";
                }
                form.addError("Incorrect password");
            } else {
                form.addError("User not found");
            }

        }

        model.addAttribute("form", new UserForm());
        model.addAttribute("loggedUser", userService.getLoggedUserUserName(session));
        model.addAttribute("current", "login");
        model.addAttribute("errors", form.getErrors());
        return "userForm";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute UserForm form, Model model, @CookieValue(required = false) String session, HttpServletResponse response) {
        if (form.validRegistration()) {
            Optional<User> user = users.findUserByUserName(form.getUserName());
            if (!user.isPresent()) {
                users.save(new User(form.getUserName(), form.getPassword()));//register
                response.addCookie(new Cookie("registered", form.getUserName()));
                model.addAttribute("errors", form.getErrors());
                return "redirect:/login";
            }
            form.addError("This user already exists");
        }
        model.addAttribute("loggedUser", userService.getLoggedUserUserName(session));
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

    @GetMapping("/myProfile")
    public String accountInfo(@CookieValue(required = false) Cookie session, Model model) {
        if (session == null) {
            return "redirect:/login";
        }
        User user = users.findFirstByCookie(session.getValue()).get();
        model.addAttribute("loggedUser", userService.getLoggedUserUserName(session.getValue()));
        model.addAttribute("userPosts", user.getPosts());
        model.addAttribute("userComments", user.getComments());
        return "users";
    }
}
