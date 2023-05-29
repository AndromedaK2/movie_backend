package com.usach.movie_backend.profile.service;

import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.profile.repository.IProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService implements IProfileService<Profile> {
    @Autowired
    private IProfileRepository profileRepository;
    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> findByProfile(Integer idProfile) {
        return profileRepository.findById(idProfile);
    }

    @Override
    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile update(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void delete(Integer id) {
        profileRepository.deleteById(id);
    }
}
