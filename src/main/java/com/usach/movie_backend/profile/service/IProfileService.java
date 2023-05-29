package com.usach.movie_backend.profile.service;

import com.usach.movie_backend.profile.domain.Profile;


import java.util.List;
import java.util.Optional;

public interface IProfileService<T> {
    List<Profile>findAll();

    Optional<Profile> findByProfile(Integer idProfile);

    Profile create(Profile profile);

    Profile update(Profile profile);

    void delete(Integer id);
}
