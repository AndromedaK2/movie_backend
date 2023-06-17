package com.usach.movie_backend.profile.service;


import com.usach.movie_backend.profile.domain.ProfileSerie;
import com.usach.movie_backend.profile.repository.IProfileSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfileSerieService implements IProfileSerieService<ProfileSerie> {
    @Autowired
    private IProfileSerieRepository iProfileSerieRepository;
    @Override
    public List<ProfileSerie> findAll() {
        return iProfileSerieRepository.findAll();
    }

    @Override
    public Optional<ProfileSerie> findByProfileSerie(Integer idProfileSerie) {
        return iProfileSerieRepository.findById(idProfileSerie);
    }

    @Override
    public ProfileSerie create(ProfileSerie profileSerie) {
        return iProfileSerieRepository.save(profileSerie);
    }

    @Override
    public ProfileSerie update(ProfileSerie profileSerie) {
        return iProfileSerieRepository.save(profileSerie);
    }

    @Override
    public void delete(Integer idProfileSerie) {
        iProfileSerieRepository.deleteById(idProfileSerie);
    }
}
