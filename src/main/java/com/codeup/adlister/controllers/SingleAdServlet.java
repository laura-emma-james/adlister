package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SingleAdServlet", urlPatterns = "/specificad")

public class SingleAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        Ad ad = DaoFactory.getAdsDao().findOne(id);
        request.setAttribute("ad", ad);

//        this line of code set a variable to get the userID connected to the sepcific Ad
        long user_id = ad.getUserId();
//        the line of code gets the user who posted the ad
        User user = DaoFactory.getUsersDao().findByUserId(user_id);
        request.setAttribute("user", user);


        request.getRequestDispatcher("/WEB-INF/ads/singleAd.jsp").forward(request, response);
    }
}
