package com.usach.movie_backend.genders.service;

import com.usach.movie_backend.genders.domain.GenderMovie;
import com.usach.movie_backend.genders.domain.GenderSerie;
import com.usach.movie_backend.genders.repository.IGenderMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderMovieService implements IGenderMovieService<GenderMovie> {
    @Autowired
    private IGenderMovieRepository iGenderMovieRepository;

    @Override
    public List<GenderMovie> findAll() {
        return iGenderMovieRepository.findAll();
    }

    @Override
    public Optional<GenderMovie> findByGenderMovie(Integer idGenderMovie) {
        return iGenderMovieRepository.findById(idGenderMovie);
    }

    @Override
    public GenderMovie create(GenderMovie genderMovie) {
        return iGenderMovieRepository.save(genderMovie);
    }

    @Override
    public GenderMovie update(GenderMovie genderMovie) {
        return iGenderMovieRepository.save(genderMovie);
    }

    @Override
    public void delete(Integer idGenderMovie) {

        iGenderMovieRepository.deleteById(idGenderMovie);
    }
}
