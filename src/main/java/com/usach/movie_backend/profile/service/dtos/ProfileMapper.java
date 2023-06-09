package com.usach.movie_backend.profile.service.dtos;

import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.user.domain.User;
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
