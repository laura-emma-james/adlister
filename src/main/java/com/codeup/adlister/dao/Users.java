package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    User findByUserId(long user_id);
    Long insert(User user);
    boolean delete(long id);
    boolean update(User user);
}
