package com.usach.movie_backend.profiles.service;

import com.usach.movie_backend.profiles.domain.Profile;
import com.usach.movie_backend.profiles.service.dto.ProfileCreate;
import com.usach.movie_backend.profiles.service.dto.ProfileUpdate;


import java.util.List;

public interface IProfileService {
    List<Profile>findAll();

    Profile find(String username, String userEmail);

    Profile create(ProfileCreate profileCreate, String userEmail );

    Profile update(ProfileUpdate profileUpdate, String userEmail);

    void delete(String username, String userEmail);
}
