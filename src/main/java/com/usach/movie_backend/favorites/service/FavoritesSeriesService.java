package com.usach.movie_backend.favorites.service;

import com.usach.movie_backend.favorites.domain.Favorite;
import com.usach.movie_backend.favorites.domain.FavoritesSerie;
import com.usach.movie_backend.favorites.repository.IFavoritesSeriesRepository;
import com.usach.movie_backend.favorites.service.dto.FavoriteSerieCreate;
import com.usach.movie_backend.favorites.service.dto.FavoriteSerieDelete;
import com.usach.movie_backend.profiles.domain.Profile;
import com.usach.movie_backend.profiles.service.IProfileService;
import com.usach.movie_backend.series.domain.Serie;
import com.usach.movie_backend.series.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesSeriesService implements IFavoritesSeriesService{
    @Autowired
    private IFavoritesSeriesRepository favoritesSeriesRepository;
    @Autowired
    private IFavoritesService favoritesService;

    @Autowired
    private IProfileService profileService;

    @Autowired
    private ISerieService serieService;

    @Transactional(readOnly = true)
    public List<FavoritesSerie> findAll() {
        return favoritesSeriesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public FavoritesSerie findByIdFavoriteAndIdSerie(Integer idFavorite, Integer idSerie){
        Optional<FavoritesSerie> favoritesSerie= favoritesSeriesRepository
                .findFavoritesMovieByIdFavoriteAndIdSerie(idFavorite,idSerie);
        if(favoritesSerie.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Favorite Serie not found");
        return favoritesSerie.get();
    }
    @Transactional(rollbackFor = {ResponseStatusException.class})
    public FavoritesSerie create(FavoriteSerieCreate favoriteSerieCreate) {
        Profile profile   = profileService.find(favoriteSerieCreate.username(),favoriteSerieCreate.userEmail());
        Favorite favorite = favoritesService.findByNameAndIdProfile(favoriteSerieCreate.name(), profile.getIdProfile());
        Serie serie       = serieService.findByName(favoriteSerieCreate.serieName());

        if(favoritesSeriesRepository.findFavoritesMovieByIdFavoriteAndIdSerie(favorite.getIdFavorite(), serie.getIdSerie()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Favorite serie already exists");

        FavoritesSerie favoritesSerie = new FavoritesSerie();
        favoritesSerie.setIdFavorite(favorite.getIdFavorite());
        favoritesSerie.setIdSerie(serie.getIdSerie());

        return favoritesSeriesRepository.save(favoritesSerie);
    }


    @Transactional(rollbackFor = {ResponseStatusException.class})
    public void delete(FavoriteSerieDelete favoriteSerieDelete) {
        Profile profile   = profileService.find(favoriteSerieDelete.username(),favoriteSerieDelete.userEmail());
        Favorite favorite = favoritesService.findByNameAndIdProfile(favoriteSerieDelete.name(), profile.getIdProfile());
        Serie serie       = serieService.findByName(favoriteSerieDelete.serieName());
        FavoritesSerie favoritesSerie = findByIdFavoriteAndIdSerie(favorite.getIdFavorite(), serie.getIdSerie());
        favoritesSeriesRepository.deleteById(favoritesSerie.getIdFavorite());
    }
}
