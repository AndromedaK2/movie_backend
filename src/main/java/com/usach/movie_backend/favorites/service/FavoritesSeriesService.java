package com.usach.movie_backend.favorites.service;

import com.usach.movie_backend.favorites.domain.FavoritesSeries;
import com.usach.movie_backend.favorites.repository.IFavoritesSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesSeriesService implements IFavoritesSeriesService<FavoritesSeries> {
    @Autowired
    private IFavoritesSeriesRepository iFavoritesSeriesRepository;
    @Override
    public List<FavoritesSeries> findAll() {
        return iFavoritesSeriesRepository.findAll();
    }

    @Override
    public Optional<FavoritesSeries> findByFavoritesSeries(Integer idFavoritesSeries) {
        return iFavoritesSeriesRepository.findById(idFavoritesSeries);
    }

    @Override
    public FavoritesSeries create(FavoritesSeries favoritesSeries) {
        return iFavoritesSeriesRepository.save(favoritesSeries);
    }

    @Override
    public FavoritesSeries update(FavoritesSeries favoritesSeries) {
        return iFavoritesSeriesRepository.save(favoritesSeries);
    }

    @Override
    public void delete(Integer idFavoritesMovies) {

        iFavoritesSeriesRepository.deleteById(idFavoritesMovies);
    }
}
