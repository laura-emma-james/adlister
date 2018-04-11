package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// /searchAds urlPatter is wired to the search form found on the navbar-logout.jsp

@WebServlet(name = "SearchAdsServlet", urlPatterns = "/searchAds")
public class SearchAdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("search", DaoFactory.getAdsDao().searchAds());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}
//TODO:Add search method to MySQLAdsDao.java File and call method from the Ads.java file both searching sellers ad's profile and ads index
//TODO: Will reference this method for searching that particular JSP.
