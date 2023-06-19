package com.usach.movie_backend.profile.service;

import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.profile.repository.IProfileRepository;

import com.usach.movie_backend.profile.service.dtos.ProfileCreate;
import com.usach.movie_backend.profile.service.dtos.ProfileMapper;
import com.usach.movie_backend.profile.service.dtos.ProfileUpdate;
import com.usach.movie_backend.suscription.domain.Subscription;
import com.usach.movie_backend.user.domain.User;
import com.usach.movie_backend.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
    public Profile find(String username, String userEmail){
        User user = userService.findByEmail(userEmail);
        Optional<Profile> profile = user.getProfiles().stream().filter(p->p.getUsername().equals(username)).findFirst();
        if (profile.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The requested username It does not exist");
        return profile.get();
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public Profile create(ProfileCreate profileCreate, String userEmail) {
        User user = userService.findByEmail(userEmail);
        Subscription subscription = user.getSubscription();

        if(!subscription.isActive())
            throw new ResponseStatusException( HttpStatus.CONFLICT,"Subscription is not active");

        if(user.getQuantityProfilesCreated() >= subscription.getSubscriptionType().getQuantityProfiles())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "You can not create more profiles");

        user.setQuantityProfilesCreated(user.getQuantityProfilesCreated()+1);
        Profile profile = profileMapper.createProfileMapping(profileCreate,user);
        return profileRepository.save(profile);
    }

    @Transactional(noRollbackFor = {RuntimeException.class})
    public Profile update(ProfileUpdate profileUpdate, String userEmail) {
        Profile profile = find(profileUpdate.username(),userEmail);
        profile.setUsername(profileUpdate.username());
        profile.setUrlPhoto(profileUpdate.urlPhoto());
        return profileRepository.save(profile);
    }

    @Transactional
    public void delete(String username, String userEmail) {
        Profile profile = find(username,userEmail);
        profileRepository.deleteById(profile.getIdProfile());
    }
}
