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
//// Create a user based on the submitted information
//        User newUser = new User(
//                request.getParameter("username"),
//                request.getParameter("email"),
//                request.getParameter("password")
//        );
//        // create and save a new user
        String hashpass = Password.hash(password);
        User user = new User(first_name, last_name, email, username, hashpass);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");

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
//        User oldUser = DaoFactory.getUsersDao().findByUsername(username);
        // validate input
//        boolean inputHasErrors = username.isEmpty()
//            || first_name.isEmpty()
//            || last_name.isEmpty()
//            || email.isEmpty()
//            || password.isEmpty();
//        boolean passwordConfirmationError = ! password.equals(password);
//
//        if (inputHasErrors) {
//            JOptionPane.showMessageDialog(null, "Check to see if you have entered all of the required feilds.");
//        }
//        else if(passwordConfirmationError) {
//            JOptionPane.showMessageDialog(null, "Please confirm your Password");
//        }


//        boolean create = true;
//        boolean usernameError = username.isEmpty();
//        boolean firstNameError = first_name.isEmpty();
//        boolean lastNameError = last_name.isEmpty();
//        boolean emailError = email.isEmpty();
//        boolean passwordError = password.isEmpty();
//        boolean passwordConfirmationError = ! password.equals(password);
//        if (usernameError) {
//            JOptionPane.showMessageDialog(null, "Please enter a Username.");
//            create = false;
//        }
//        if(usernameError && firstNameError) {
//            JOptionPane.showMessageDialog(null, "Please enter a Username and First Name.");
//            create = false;
//        }
//        if(usernameError && lastNameError) {
//            JOptionPane.showMessageDialog(null, "Please enter a Username and Last Name.");
//            create = false;
//        }
//        if(usernameError && emailError) {
//            JOptionPane.showMessageDialog(null, "Please enter a Username and Email.");
//            create = false;
//        }
//        if (firstNameError) {
//            JOptionPane.showMessageDialog(null, "Please enter a First Name");
//            create = false;
//        }
//        if (lastNameError) {
//            JOptionPane.showMessageDialog(null, "Please enter a Last Name");
//            create = false;
//        }
//        if (emailError) {
//            JOptionPane.showMessageDialog(null, "Please enter an Email");
//            create = false;
//        }
//        if (passwordError) {
//            JOptionPane.showMessageDialog(null, "Please enter a Passoword");
//            create = false;
//        }
//        if (passwordConfirmationError) {
//            JOptionPane.showMessageDialog(null, "Please confirm your Password");
//            create = false;
//        }
//        if(DaoFactory.getUsersDao().findByUsername(username)!=null) {
//            JOptionPane.showMessageDialog(null, "This username is already taken, please choose another.");
//            create = false;
//        }
//
//    if (create == true) {
//
//    }else {
//            response.sendRedirect("/register");
//    }

    }
}
