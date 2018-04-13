package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    List<Ad> findAdsByUserId(long user_id);

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    Object allByUsername();

    List<Ad> searchAds(String title);

    void deleteAd(long id);

    List<Ad> findAdById(long id);

    void updateAd(Ad ad);

    Ad findOne(Long id);
}
