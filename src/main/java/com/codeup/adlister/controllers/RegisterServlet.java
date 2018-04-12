package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import com.codeup.adlister.dao.MySQLUsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

       Users usersDao = DaoFactory.getUsersDao();
//        // create and save a new user
        String hashpass = Password.hash(password);
        User user = new User(first_name, last_name, email, username, hashpass);

// Create a list to hold any validation error messages we encounter
        List<String> errors = new ArrayList<>();

// Next we'll have a handful of if statements to check all of our validation constraints

        if (DaoFactory.getUsersDao().findByUsername(username)!=null) {
            errors.add("That username is already taken.");
        }

        boolean passwordsMatch = request.getParameter("password").equals(request.getParameter("confirm_password"));
        if (! passwordsMatch) {
            errors.add("Password and confirm password must match");
        }

        if (user.getUsername().length() == 0) {
            errors.add("You must enter a password");
        }

        if (user.getEmail().length() == 0 || !user.getEmail().contains("@")) {
            errors.add("Please enter a valid email address");
        }

        if (user.getPassword().length() == 0) {
            errors.add("You must choose a password");
        }

// once we're done with all the validation checking...

        if (errors.isEmpty()) {
            // no errors
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        } else {
            // we have at least one validation error, go back to the register form
            request.getSession().setAttribute("errors", errors);
            response.sendRedirect("/register");
        }
    }
}
