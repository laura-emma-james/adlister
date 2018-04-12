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

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/profile/delete")
public class DeleteUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        System.out.println(id);

        Users usersDao = DaoFactory.getUsersDao();
//        System.out.println(id);
//        System.out.println(usersDao);
        usersDao.delete(id);
        System.out.println("test1");
        resp.sendRedirect("/logout");
    }
}
