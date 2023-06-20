package com.usach.movie_backend.profile.service;

import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.profile.service.dto.ProfileCreate;
import com.usach.movie_backend.profile.service.dto.ProfileUpdate;


import java.util.List;

public interface IProfileService {
    List<Profile>findAll();

    Profile find(String username, String userEmail);

    Profile create(ProfileCreate profileCreate, String userEmail );

    Profile update(ProfileUpdate profileUpdate, String userEmail);

    void delete(String username, String userEmail);
}
