package com.usach.movie_backend.favorites.service;

import com.usach.movie_backend.favorites.domain.Favorites;
import com.usach.movie_backend.favorites.repository.IFavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesService implements IFavoritesService<Favorites> {
    @Autowired
    private IFavoritesRepository iFavoritesRepository;
    @Override
    public List<Favorites> findAll() {
        return iFavoritesRepository.findAll();
    }

    @Override
    public Optional<Favorites> findByFavorites(Integer idFavorites) {
        return iFavoritesRepository.findById(idFavorites);
    }

    @Override
    public Favorites create(Favorites favorites) {
        return iFavoritesRepository.save(favorites);
    }

    @Override
    public Favorites update(Favorites favorites) {
        return iFavoritesRepository.save(favorites);
    }

    @Override
    public void delete(Integer idFavorites) {

        iFavoritesRepository.deleteById(idFavorites);
    }
}
