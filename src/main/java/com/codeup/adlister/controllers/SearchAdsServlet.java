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
import java.util.List;

@WebServlet(name = "SearchAdsServlet", urlPatterns = "/search-ads")
public class SearchAdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println(" Do get " );
//        TODO: ON Sellers-buyers profile page set the username for seller or whereever that needs to be to search only sellers ads on that page
        String title = request.getParameter("search");
//        request.setAttribute("username", DaoFactory.getUsersDao().findByUsername("username"));
//        System.out.println("title = " + title);
        List<Ad> ads = DaoFactory.getAdsDao().searchAds(title);
        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}

