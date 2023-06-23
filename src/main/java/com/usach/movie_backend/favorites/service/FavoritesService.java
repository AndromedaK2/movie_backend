package com.usach.movie_backend.favorites.service;

import com.usach.movie_backend.favorites.domain.Favorite;
import com.usach.movie_backend.favorites.repository.IFavoritesRepository;
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
public class FavoritesService implements IFavoritesService {
    @Autowired
    private IFavoritesRepository favoritesRepository;

    @Autowired
    private IProfileService profileService;

    @Transactional(readOnly = true)
    public List<Favorite> findAll() {
        return favoritesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Favorite> findByFavorites(Integer idFavorites) {
        return favoritesRepository.findById(idFavorites);
    }

    @Transactional(readOnly = true)
    public Favorite findByNameAndIdProfile(String name, Integer idProfile){
        Optional<Favorite> favorite = favoritesRepository.findByNameAndIdProfile(name, idProfile);
        if(favorite.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Favorite list not found");
       return favorite.get();
    }

    @Transactional(rollbackFor = {ResponseStatusException.class})
    public Favorite create(Favorite favorites) {
        return favoritesRepository.save(favorites);
    }

    @Transactional(rollbackFor = {ResponseStatusException.class})
    public Favorite update(Favorite favorites) {
        return favoritesRepository.save(favorites);
    }

    @Transactional(rollbackFor = {ResponseStatusException.class})
    public void delete(Integer idFavorites) {
        favoritesRepository.deleteById(idFavorites);
    }

    @Transactional(rollbackFor = {ResponseStatusException.class})
    public void deleteByName(String name, String username, String userEmail) {
        Profile profile = profileService.find(username,userEmail);
        Favorite favorite = findByNameAndIdProfile(name, profile.getIdProfile());
        favoritesRepository.deleteById(favorite.getIdFavorite());
    }


}
