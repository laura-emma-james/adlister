package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SingleAdServlet", urlPatterns = "/specificad")

public class SingleAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ad", DaoFactory.getAdsDao().allByUsername());
//        NEED TO REPLACE ALLBYUSERNAME() METHOD WITH A METHOD I NEED TO WRITE AND ADD IN THE
        request.getRequestDispatcher("/WEB-INF/ads/singleAd.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
