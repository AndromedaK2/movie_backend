package com.usach.movie_backend.favorites.service;

import com.usach.movie_backend.favorites.domain.FavoritesSerie;
import com.usach.movie_backend.favorites.repository.IFavoritesSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesSeriesService implements IFavoritesSeriesService<FavoritesSerie> {
    @Autowired
    private IFavoritesSeriesRepository iFavoritesSeriesRepository;
    @Override
    public List<FavoritesSerie> findAll() {
        return iFavoritesSeriesRepository.findAll();
    }

    @Override
    public Optional<FavoritesSerie> findByFavoritesSeries(Integer idFavoritesSeries) {
        return iFavoritesSeriesRepository.findById(idFavoritesSeries);
    }

    @Override
    public FavoritesSerie create(FavoritesSerie favoritesSeries) {
        return iFavoritesSeriesRepository.save(favoritesSeries);
    }

    @Override
    public FavoritesSerie update(FavoritesSerie favoritesSeries) {
        return iFavoritesSeriesRepository.save(favoritesSeries);
    }

    @Override
    public void delete(Integer idFavoritesMovies) {

        iFavoritesSeriesRepository.deleteById(idFavoritesMovies);
    }
}
