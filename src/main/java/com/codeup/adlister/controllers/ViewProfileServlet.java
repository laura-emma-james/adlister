package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.setAttribute("ads", DaoFactory.getAdsDao().allByUsername());
//        WORK IN PROGRESS
//        Users userDao = DaoFactory.getUsersDao();
//        Ads adsDao = DaoFactory.getAdsDao();
//
//        String id = request.getParameter("id");
//        User user = userDao.findByUserId(Long.parseLong(id));
//
//        List<Ad> ads = adsDao.findAdsByUserId(id);
//
//        request.setAttribute("user", user);
//        request.setAttribute("ads", ads);

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
