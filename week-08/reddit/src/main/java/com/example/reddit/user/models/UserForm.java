package com.example.reddit.user.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserForm {

    private String userName;
    private String password;
    private String passwordCheck;
    private List<String> errors;

    public UserForm() {
        errors = new ArrayList<>();
    }

    public UserForm(String userName) {
        this.userName = userName;
        errors = new ArrayList<>();
    }


    public boolean validLogin() {
        if (this.userName == null || this.userName.isEmpty()) {
            addError("Please fill the User Name");
        }
        if (this.password == null || this.password.isEmpty()) {
            addError("Please fill the Password");
        }
        return errors.size() == 0;
    }

    public boolean validRegistration() {
        validLogin();
        validPassword();
        if (!this.password.equals(this.passwordCheck)) {
            addError("Passwords are not matching");
        }
        return errors.size() == 0;
    }

    public boolean validPassword() {
        if (password.length() < 8) {
            errors.add("Password needs to be at Least 8 characters long");
        }
        containsNumber();
        containsUpperCase();
        return true;
    }

    private boolean containsNumber() {
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        errors.add("Password must contain at Least one Number");
        return false;
    }

    private boolean containsUpperCase() {
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if ((ch >= 'A' && ch <= 'Z')) {
                return true;
            }
        }
        errors.add("Password must contain at Least one Upper Case Letter");
        return false;
    }

    public void addError(String error) {
        errors.add(error);
    }
}
