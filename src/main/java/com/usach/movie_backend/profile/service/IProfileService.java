package com.usach.movie_backend.profile.service;

import com.usach.movie_backend.profile.domain.Profile;
import com.usach.movie_backend.profile.service.dtos.ProfileCreate;


import java.util.List;
import java.util.Optional;

public interface IProfileService {
    List<Profile>findAll();

    Optional<Profile> findByProfile(Integer idProfile);

    Profile create(ProfileCreate profileCreate, String userEmail );

    Profile update(Profile profile);

    void delete(Integer id);
}
