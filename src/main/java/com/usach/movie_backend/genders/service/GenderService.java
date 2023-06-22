package com.usach.movie_backend.genders.service;

import com.usach.movie_backend.genders.domain.Gender;
import com.usach.movie_backend.genders.repository.IGenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class GenderService implements IGenderService{
    @Autowired
    private IGenderRepository genderRepository;

    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    public Optional<Gender> findByGender(Integer idGender) {
        return genderRepository.findById(idGender);
    }

    @Transactional(readOnly = true)
    public Gender findByName(String name) {
        Optional<Gender> gender = genderRepository.findByNameGender(name);
        if(gender.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Gender not found");
        return  gender.get();
    }
    @Override
    public Gender create(Gender gender) {
        return genderRepository.save(gender);
    }

    @Override
    public Gender update(Gender gender) {
        return genderRepository.save(gender);
    }

    @Override
    public void delete(Integer idGender) {
        genderRepository.deleteById(idGender);
    }



}
