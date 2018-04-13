package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }
//    Function added my LLP, used for narrowing ads listed on jsp by title
    public List<Ad> searchAds(String title) {
        String query = "SELECT * FROM ads WHERE title LIKE ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+title+"%");
            ResultSet rs = ps.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error searching ads.", e);
        }
    }

    public List<Ad> allByUsername() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> findAdsByUserId(long user_id) {
        String query = "SELECT * FROM ads WHERE user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, user_id);
            ResultSet rs = ps.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ads by user_id", e);
        }
    }

     @Override
    public List<Ad> findAdById(long id) {
        String query = "SELECT * FROM ads WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ads by ads id", e);
        }
    }

    @Override
    public Ad findOne(Long id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (! rs.next()) {
                throw new RuntimeException(String.format("No ad found for the id: %s", id));
            }
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an individual ad", e);
        }
    }

    public void updateAd(Ad ad) {
        String query = "UPDATE ads SET title = ?, description = ?, price = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ad.getTitle());
            ps.setString(2, ad.getDescription());
            ps.setString(3, ad.getPrice());
            ps.setLong(4, ad.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR - can't update ad!");
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, price) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setString(4, ad.getPrice());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("price")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            System.out.println(rs.getString("title"));
            ads.add(extractAd(rs));
        }
        return ads;
    }

    public void deleteAd(long id) {
        String query = "DELETE FROM ads WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR - can't delete Ad!");
        }
    }

}
