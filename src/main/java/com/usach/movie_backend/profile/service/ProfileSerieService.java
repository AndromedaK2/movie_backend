package com.usach.movie_backend.profile.service;

import com.usach.movie_backend.configuration.exceptions.BusinessException;
import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.profile.domain.ProfileSerie;
import com.usach.movie_backend.profile.repository.IProfileSerieRepository;
import com.usach.movie_backend.profile.service.dto.ViewLaterSerie;
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
public class ProfileSerieService implements IProfileSerieService{
    @Autowired
    private IProfileSerieRepository profileSerieRepository;
    @Autowired
    private ISerieService serieService;
    @Autowired
    private  IProfileService profileService;

    @Transactional(readOnly = true)
    public List<ProfileSerie> findAll() {
        return profileSerieRepository.findAll();
    }

    @Transactional(noRollbackFor = {BusinessException.class, RuntimeException.class})
    public ProfileSerie create(ViewLaterSerie viewLaterSerie) {
        Serie serie =  serieService.findByName(viewLaterSerie.serieName());
        Profile profile = profileService.find(viewLaterSerie.username(), viewLaterSerie.userEmail());

        Integer serieId = serie.getIdSerie();
        Integer profileId = profile.getIdProfile();

        Optional<ProfileSerie> profileSerieBy = profileSerieRepository
                .findProfileSerieByIdProfileAndIdMovie(profileId,serieId);

        if(profileSerieBy.isPresent())
            throw  new ResponseStatusException(HttpStatus.CONFLICT,"You have already marked as view later");

        ProfileSerie profileSerie = new ProfileSerie();
        profileSerie.setIdProfile(profileId);
        profileSerie.setIdSerie(serieId);
        profileSerie.setViewLater(true);

        return profileSerieRepository.save(profileSerie);
    }

    @Transactional(noRollbackFor = {BusinessException.class, RuntimeException.class})
    public void delete(ViewLaterSerie viewLaterSerie) {
        Serie serie =  serieService.findByName(viewLaterSerie.serieName());
        Profile profile = profileService.find(viewLaterSerie.username(), viewLaterSerie.userEmail());

        Integer serieId = serie.getIdSerie();
        Integer profileId = profile.getIdProfile();

        Optional<ProfileSerie> profileSerieBy = profileSerieRepository
                .findProfileSerieByIdProfileAndIdMovie(profileId,serieId);

        if(profileSerieBy.isPresent())
            throw  new ResponseStatusException(HttpStatus.CONFLICT,"You have already marked as view later");

        profileSerieRepository.deleteById(profileSerieBy.get().getIdProfileSerie());
    }
}
