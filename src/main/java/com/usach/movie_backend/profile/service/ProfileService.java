package com.usach.movie_backend.profile.service;

import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.profile.repository.IProfileRepository;

import com.usach.movie_backend.profile.service.dtos.ProfileCreate;
import com.usach.movie_backend.profile.service.dtos.ProfileMapper;
import com.usach.movie_backend.suscription.domain.Subscription;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService implements IProfileService{
    @Autowired
    private IProfileRepository profileRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private ProfileMapper profileMapper;

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

        User user = userService.findByEmail(userEmail);
        Subscription subscription = user.getSubscription();

        if(!subscription.isActive()){
            throw new ResponseStatusException( HttpStatus.CONFLICT,"Subscription is not active");
        }
        if(user.getQuantityProfilesCreated() >= subscription.getSubscriptionType().getQuantityProfiles() ) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "You can not create more profiles");
        }

        user.setQuantityProfilesCreated(user.getQuantityProfilesCreated()+1);
        Profile profile = profileMapper.createProfileMapping(profileCreate,user);
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
