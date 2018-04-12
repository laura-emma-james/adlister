package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
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

@WebServlet(name = "SellerProfileServlet", urlPatterns = "/sellerprofile")
public class SellerProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        long id = Long.parseLong(request.getParameter("id"));
        User user = DaoFactory.getUsersDao().findByUserId(id);
        List<Ad> ads = DaoFactory.getAdsDao().findAdsByUserId(id);

        request.setAttribute("user", user);
        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/WEB-INF/sellerprofile.jsp").forward(request, response);


    }
}
