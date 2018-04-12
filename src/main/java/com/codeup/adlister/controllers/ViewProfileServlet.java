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

        User user = (User) request.getSession().getAttribute("user");
//        System.out.println(user.getId());
        long loginUser = user.getId();

        User userId = DaoFactory.getUsersDao().findByUserId((loginUser));
        List<Ad> ads = DaoFactory.getAdsDao().findAdsByUserId(loginUser);
        System.out.println(ads);

        request.setAttribute("user", userId);
        request.setAttribute("ads", ads);

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
