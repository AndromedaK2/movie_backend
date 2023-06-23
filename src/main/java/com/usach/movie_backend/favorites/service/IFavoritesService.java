package com.usach.movie_backend.favorites.service;

import com.usach.movie_backend.favorites.domain.Favorite;

import java.util.List;

public interface IFavoritesService {
    List<Favorite> findAll();
    Favorite findByNameAndIdProfile(String name, Integer idProfile);
    Favorite create(String name, String username, String userEmail);
    Favorite update(String name, String username, String userEmail,String newName);
    void deleteByName(String name, String username, String userEmail);
    void delete(Integer idFavorite);
}
