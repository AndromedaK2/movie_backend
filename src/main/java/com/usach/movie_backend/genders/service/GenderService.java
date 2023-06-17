package com.usach.movie_backend.genders.service;

import com.usach.movie_backend.genders.domain.Gender;
import com.usach.movie_backend.genders.repository.IGenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GenderService implements IGenderService<Gender> {
    @Autowired
    private IGenderRepository iGenderRepository;

    @Override
    public List<Gender> findAll() {
        return iGenderRepository.findAll();
    }

    @Override
    public Optional<Gender> findByGender(Integer idGender) {
        return iGenderRepository.findById(idGender);
    }

    @Override
    public Gender create(Gender gender) {
        return iGenderRepository.save(gender);
    }

    @Override
    public Gender update(Gender gender) {
        return iGenderRepository.save(gender);
    }

    @Override
    public void delete(Integer idGender) {
        iGenderRepository.deleteById(idGender);
    }
}
