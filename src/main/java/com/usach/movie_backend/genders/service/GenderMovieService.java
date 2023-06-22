package com.usach.movie_backend.genders.service;

import com.usach.movie_backend.genders.domain.GenderMovie;
import com.usach.movie_backend.genders.repository.IGenderMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GenderMovieService implements IGenderMovieService{
    @Autowired
    private IGenderMovieRepository genderMovieRepository;

    @Override
    public List<GenderMovie> findAll() {
        return genderMovieRepository.findAll();
    }

    @Override
    public Optional<GenderMovie> findByGenderMovie(Integer idGenderMovie) {
        return genderMovieRepository.findById(idGenderMovie);
    }

    @Transactional(readOnly = true)
    public List<GenderMovie> findByIdGender(Integer idGender) {
        return genderMovieRepository.findGenderMovieByIdGender(idGender);
    }

    @Override
    public GenderMovie create(GenderMovie genderMovie) {
        return genderMovieRepository.save(genderMovie);
    }

    @Override
    public GenderMovie update(GenderMovie genderMovie) {
        return genderMovieRepository.save(genderMovie);
    }

    @Override
    public void delete(Integer idGenderMovie) {

        genderMovieRepository.deleteById(idGenderMovie);
    }
}
