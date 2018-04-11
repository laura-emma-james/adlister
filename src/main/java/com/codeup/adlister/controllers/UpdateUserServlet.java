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

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/profile/update")
public class UpdateUserServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/updateUser.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String bio = req.getParameter("bio");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = DaoFactory.getUsersDao().findByUserId(id);

        user.setId(id);
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setBio(bio);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        DaoFactory.getUsersDao().update(user);
        req.getSession().setAttribute("user", user);
        resp.sendRedirect("/profile");
    }
}
