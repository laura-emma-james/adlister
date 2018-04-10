package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

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

        boolean usernameError = username.isEmpty();
        boolean firstNameError = first_name.isEmpty();
        boolean lastNameError = last_name.isEmpty();
        boolean emailError = email.isEmpty();
        boolean passwordError = password.isEmpty();
        boolean passwordConfirmationError = ! password.equals(password);
        if (usernameError) {
            JOptionPane.showMessageDialog(null, "Please enter a Username.");
        }
        if(usernameError && firstNameError) {
            JOptionPane.showMessageDialog(null, "Please enter a Username and First Name.");
        }
        if(usernameError && lastNameError) {
            JOptionPane.showMessageDialog(null, "Please enter a Username and Last Name.");
        }
        if(usernameError && emailError) {
            JOptionPane.showMessageDialog(null, "Please enter a Username and Email.");
        }
        if (firstNameError) {
            JOptionPane.showMessageDialog(null, "Please enter a First Name");
        }
        if (lastNameError) {
            JOptionPane.showMessageDialog(null, "Please enter a Last Name");
        }
        if (emailError) {
            JOptionPane.showMessageDialog(null, "Please enter an Email");
        }
        if (passwordError) {
            JOptionPane.showMessageDialog(null, "Please enter a Passoword");
        }
        if (passwordConfirmationError) {
            JOptionPane.showMessageDialog(null, "Please confirm your Password");
        }
        if(username.equals()) {
            JOptionPane.showMessageDialog(null, "This username is already taken, please choose another.");
        }

        // create and save a new user
        String hashpass = Password.hash(password);
        User user = new User(first_name, last_name, username, email, hashpass);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
