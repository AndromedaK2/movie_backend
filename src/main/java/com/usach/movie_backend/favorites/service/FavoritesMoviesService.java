package com.usach.movie_backend.favorites.service;

import com.usach.movie_backend.favorites.domain.Favorite;
import com.usach.movie_backend.favorites.domain.FavoritesMovie;
import com.usach.movie_backend.favorites.repository.IFavoritesMoviesRepository;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieCreate;
import com.usach.movie_backend.favorites.service.dto.FavoriteMovieDelete;
import com.usach.movie_backend.movies.domain.Movie;
import com.usach.movie_backend.movies.service.IMoviesService;
import com.usach.movie_backend.profiles.domain.Profile;
import com.usach.movie_backend.profiles.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesMoviesService implements IFavoritesMoviesService{
    @Autowired
    private IFavoritesMoviesRepository favoritesMoviesRepository;

    @Autowired
    private IFavoritesService favoritesService;

    @Autowired
    private IProfileService profileService;

    @Autowired
    private IMoviesService moviesService;

    @Transactional(readOnly = true)
    public List<FavoritesMovie> findAll() {
        return favoritesMoviesRepository.findAll();
    }


    @Transactional(readOnly = true)
    public FavoritesMovie findByIdFavoriteAndIdMovie(Integer idFavorite, Integer idMovie){
        Optional<FavoritesMovie> favoritesMovie = favoritesMoviesRepository
                .findFavoritesMovieByIdFavoriteAndIdMovie(idFavorite,idMovie);
        if(favoritesMovie.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Favorite Movie not found");
        return favoritesMovie.get();
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public FavoritesMovie create(FavoriteMovieCreate favoritesMovieCreate) {
        Profile profile   = profileService.find(favoritesMovieCreate.username(),favoritesMovieCreate.userEmail());
        Favorite favorite = favoritesService.findByNameAndIdProfile(favoritesMovieCreate.name(), profile.getIdProfile());
        Movie movie       = moviesService.findByTitle(favoritesMovieCreate.movieTitle());

        if(favoritesMoviesRepository.findFavoritesMovieByIdFavoriteAndIdMovie(favorite.getIdFavorite(), movie.getIdMovie()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Favorite movie already exists");

        FavoritesMovie favoritesMovie = new FavoritesMovie();
        favoritesMovie.setIdFavorite(favorite.getIdFavorite());
        favoritesMovie.setIdMovie(movie.getIdMovie());

        return favoritesMoviesRepository.save(favoritesMovie);
    }


    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public void delete(FavoriteMovieDelete favoriteMovieDelete) {
        Profile profile   = profileService.find(favoriteMovieDelete.username(),favoriteMovieDelete.userEmail());
        Favorite favorite = favoritesService.findByNameAndIdProfile(favoriteMovieDelete.name(), profile.getIdProfile());
        Movie movie       = moviesService.findByTitle(favoriteMovieDelete.movieTitle());
        FavoritesMovie favoritesMovie = findByIdFavoriteAndIdMovie(favorite.getIdFavorite(), movie.getIdMovie());
        favoritesMoviesRepository.deleteById(favoritesMovie.getIdFavoriteMovie());
    }
}
