package com.usach.movie_backend.profile.service;

import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.profile.repository.IProfileRepository;

import com.usach.movie_backend.profile.service.dtos.ProfileCreate;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService implements IProfileService{
    @Autowired
    private IProfileRepository profileRepository;
    @Autowired
    private IUserService userService;

    @Transactional(readOnly = true)
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Profile> findByProfile(Integer idProfile) {
        return profileRepository.findById(idProfile);
    }

    @Transactional
    public Profile create(ProfileCreate profileCreate, String userEmail) {
        Optional<User> user = userService.findByEmail(userEmail);
        Profile profile = new Profile();
        profile.setUsername(profileCreate.username());
        profile.setUrlPhoto(profileCreate.urlPhoto());
        profile.setCreationDate(new Date());
        profile.setUser(user.get());
        return profileRepository.save(profile);
    }

    @Transactional
    public Profile update(Profile profile) {
        return profileRepository.save(profile);
    }

    @Transactional
    public void delete(Integer id) {
        profileRepository.deleteById(id);
    }
}
