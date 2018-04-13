package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<String> errors = new ArrayList<>();

        User user = DaoFactory.getUsersDao().findByUsername(username);

        boolean usernameEmpty = username.isEmpty();
        boolean passwordEmpty = password.isEmpty();

        if (usernameEmpty) {
           errors.add("Please enter a username");
        }
        if(passwordEmpty) {
            errors.add("Please enter a password");
        }
        if(user == null && !usernameEmpty) {
            errors.add("User does not exist");
        }

        if(!usernameEmpty && !passwordEmpty && user != null) {
            boolean passwordsMatch = Password.check(password, user.getPassword()); {
                if(!passwordsMatch) {
                    errors.add("Incorrect Password");
                }
            }
        }

        boolean validAttempt = (user != null) && Password.check(password, user.getPassword());

        if (validAttempt) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        } else {
            request.getSession().setAttribute("errors", errors);
//            response.sendRedirect("/login");
            doGet(request, response);
        }
    }
}