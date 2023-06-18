package com.usach.movie_backend.favorites.service;

import com.usach.movie_backend.favorites.domain.FavoritesMovies;
import com.usach.movie_backend.favorites.repository.IFavoritesMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesMoviesService implements IFavoritesMoviesService<FavoritesMovies>{
    @Autowired
    private IFavoritesMoviesRepository iFavoritesMoviesRepository;
    @Override
    public List<FavoritesMovies> findAll() {
        return iFavoritesMoviesRepository.findAll();
    }

    @Override
    public Optional<FavoritesMovies> findByFavoritesMovies(Integer idFavoritesMovies) {
        return iFavoritesMoviesRepository.findById(idFavoritesMovies);
    }

    @Override
    public FavoritesMovies create(FavoritesMovies favoritesMovies) {
        return iFavoritesMoviesRepository.save(favoritesMovies);
    }

    @Override
    public FavoritesMovies update(FavoritesMovies favoritesMovies) {
        return iFavoritesMoviesRepository.save(favoritesMovies);
    }

    @Override
    public void delete(Integer idFavoritesMovies) {

        iFavoritesMoviesRepository.deleteById(idFavoritesMovies);
    }
}
