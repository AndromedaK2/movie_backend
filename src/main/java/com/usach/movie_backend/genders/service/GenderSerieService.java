package com.usach.movie_backend.genders.service;


import com.usach.movie_backend.genders.domain.GenderSerie;
import com.usach.movie_backend.genders.repository.IGenderSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GenderSerieService implements IGenderSerieService<GenderSerie> {

    @Autowired
    protected IGenderSerieRepository iGenderSerieRepository;
    @Override
    public List<GenderSerie> findAll() {
        return iGenderSerieRepository.findAll();
    }

    @Override
    public Optional<GenderSerie> findByGenderSerie(Integer idGenderSerie) {
        return iGenderSerieRepository.findById(idGenderSerie);
    }

    @Override
    public GenderSerie create(GenderSerie genderMovie) {
        return iGenderSerieRepository.save(genderMovie);
    }

    @Override
    public GenderSerie update(GenderSerie genderMovie) {
        return iGenderSerieRepository.save(genderMovie);
    }

    @Override
    public void delete(Integer idGenderSerie) {

        iGenderSerieRepository.deleteById(idGenderSerie);
    }
}
