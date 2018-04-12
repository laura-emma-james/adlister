package com.codeup.adlister.controllers;

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

@WebServlet(name = "SellerProfileServlet", urlPatterns = "/sellerprofile")
public class SellerProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
//        //        int id = Integer.parseInt(request.getParameter("id"));
//        Ad ad = (Ad) DaoFactory.getAdsDao().all();
//        request.setAttribute("ad", ad);
        int id = Integer.parseInt(request.getParameter("id"));
        Ad ad = DaoFactory.getAdsDao().all().get(id-1);
        request.setAttribute("ad", ad);
////        this line of code set a variable to get the userID connected to the sepcific Ad
//        long user_id = ad.getUserId();
////        the line of code gets the user who posted the ad
        long user_id = ad.getUserId();
        User user = DaoFactory.getUsersDao().findByUserId(user_id);
        request.setAttribute("user", user);

        request.setAttribute("ads", DaoFactory.getAdsDao().allByUsername());
        request.getRequestDispatcher("/WEB-INF/sellerprofile.jsp").forward(request, response);






    }
}
//ADS interface reference method

// MYSQLUSERSDAO
//    @Override
//    public List<Ad> all(long id) {
//        PreparedStatement stmt = null;
//        try {
//            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ? LIMIT 1");
//            ResultSet rs = stmt.executeQuery();
//            return createAdsFromResults(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving all ads.", e);
//        }
//    }