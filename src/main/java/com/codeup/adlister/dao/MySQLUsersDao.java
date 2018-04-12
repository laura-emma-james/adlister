package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
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
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public User findByUserId(long id) {
        String query = "SELECT * FROM users WHERE id = ? LIMIT 1";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            return extractUser(ps.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(first_name, last_name, email, username, password) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getFirst_name());
            stmt.setString(2, user.getLast_name());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getUsername());
            stmt.setString(5, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }
    @Override
    public void delete(long id) {
        String query = "DELETE FROM users WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR - can't delete user!");
        }
    }

    @Override
    public void update(User user) {
        String query = "UPDATE users SET first_name = ?, last_name = ?, email = ?, username = ?, password = ?, bio = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirst_name());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getBio());
            ps.setLong(7, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR - can't update user!");
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("email"),
            rs.getString("username"),
            rs.getString("password")
        );
    }
}
