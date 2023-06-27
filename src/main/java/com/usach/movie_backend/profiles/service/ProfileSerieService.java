package com.usach.movie_backend.profiles.service;

import com.usach.movie_backend.configuration.exceptions.BusinessException;
import com.usach.movie_backend.profiles.domain.Profile;
import com.usach.movie_backend.profiles.domain.ProfileSerie;
import com.usach.movie_backend.profiles.repository.IProfileSerieRepository;
import com.usach.movie_backend.profiles.service.dto.ViewLaterSerie;
import com.usach.movie_backend.series.domain.Serie;
import com.usach.movie_backend.series.repository.ISerieRepository;
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
    @Autowired
    private ISerieRepository serieRepository;

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

        ProfileSerie profileSerieUpdated = profileSerieRepository.save(profileSerie);

        serie.setViews(serie.getViews()+1);
        serieRepository.save(serie);
        return profileSerieUpdated;
    }

    @Transactional(noRollbackFor = {BusinessException.class, RuntimeException.class})
    public void delete(ViewLaterSerie viewLaterSerie) {
        Serie serie =  serieService.findByName(viewLaterSerie.serieName());
        Profile profile = profileService.find(viewLaterSerie.username(), viewLaterSerie.userEmail());

        Integer serieId = serie.getIdSerie();
        Integer profileId = profile.getIdProfile();

        Optional<ProfileSerie> profileSerieBy = profileSerieRepository
                .findProfileSerieByIdProfileAndIdMovie(profileId,serieId);

        if(profileSerieBy.isEmpty())
            throw  new ResponseStatusException(HttpStatus.CONFLICT,"You have not marked movie later");

        profileSerieRepository.deleteById(profileSerieBy.get().getIdProfileSerie());

        Integer views = serie.getViews();
        if(views>0){
            serie.setViews(views-1);
            serieRepository.save(serie);
        }

    }
}
