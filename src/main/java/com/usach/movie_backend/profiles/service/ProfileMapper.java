package com.usach.movie_backend.profiles.service;

import com.usach.movie_backend.profiles.domain.Profile;
import com.usach.movie_backend.profiles.service.dto.ProfileCreate;
import com.usach.movie_backend.users.domain.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ProfileMapper {

    public Profile createProfileMapping(ProfileCreate profileCreate, User user){
        Profile profile = new Profile();
        profile.setUsername(profileCreate.username());
        profile.setUrlPhoto(profileCreate.urlPhoto());
        profile.setCreationDate(new Date());
        profile.setUser(user);
        return profile;
    }
}
