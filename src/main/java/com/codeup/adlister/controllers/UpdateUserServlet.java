package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/profile/update")
public class UpdateUserServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/updateUser.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String email = req.getParameter("email");
        String bio = req.getParameter("bio");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        List<String> errors = new ArrayList<>();
      
        User existingUser = DaoFactory.getUsersDao().findByUserId(id);

//        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
//        Matcher match = pattern.matcher(email);

        boolean passwordEmpty = password.isEmpty();
        boolean emailEmpty = email.isEmpty();
        boolean firstnameEmpty = first_name.isEmpty();
        boolean lastnameEmpty = last_name.isEmpty();

        if(firstnameEmpty) {
            errors.add("Please enter a first name");
        }

        if(lastnameEmpty) {
            errors.add("Please enter a last name");
        }

        if(emailEmpty) {
            errors.add("Email can't be empty");
        }

        if(!email.contains("@")) {
            errors.add("Please enter a valid email address");
        }

        if(username.isEmpty()) {
            errors.add("You must enter a username");
        }

        if(passwordEmpty) {
            errors.add("Please enter a password");
        }

        if(!existingUser.getUsername().equals(username)) {

            User updatedUser = DaoFactory.getUsersDao().findByUsername(username);

            if(updatedUser != null) {
                errors.add("That username is already taken.");
//                doGet(req, resp);
//                return;
            }
        }

        if (errors.isEmpty()) {
            // no errors
            User user = DaoFactory.getUsersDao().findByUserId(id);
        user.setId(id);
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setBio(bio);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
            DaoFactory.getUsersDao().update(existingUser);
            resp.sendRedirect("/profile");
        }
        else {
            // we have at least one validation error, go back to the Update form
            req.getSession().setAttribute("errors", errors);
            doGet(req, resp);
        }

//        DaoFactory.getUsersDao().update(user);
//
//        req.getSession().setAttribute("user", user);
//        resp.sendRedirect("/profile");
    }
}
