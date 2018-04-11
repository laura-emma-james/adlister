package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchSellersAdsServlet", urlPatterns = "/search-sellers-ads")
public class SearchSellersAdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        TODO: ON Sellers-buyers profile page set the username for seller or whereever that needs to be to search only sellers ads on that page
        request.setAttribute("username", DaoFactory.getUsersDao().findByUsername("username"));
        request.setAttribute("search", DaoFactory.getAdsDao().searchAds());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}

