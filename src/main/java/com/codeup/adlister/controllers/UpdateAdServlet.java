package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateAdServlet", urlPatterns = "/ads/update")
public class UpdateAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        Ad ad = (Ad) DaoFactory.getAdsDao().findAdById(id);

        ad.setTitle(title);
        ad.setDescription(description);
        ad.setPrice(price);

        DaoFactory.getAdsDao().updateAd(ad);
        request.getSession().setAttribute("ad", ad);
        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
    }
}
