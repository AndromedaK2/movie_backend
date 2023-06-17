package com.usach.movie_backend.profile.service;



import com.usach.movie_backend.profile.domain.ProfileChapter;

import java.util.List;
import java.util.Optional;

public interface IProfileChapterService<T>{
    List<ProfileChapter> findAll();

    Optional<ProfileChapter> findByProfileChapter(Integer idProfileChapter);

    ProfileChapter create(ProfileChapter profileChapter);

    ProfileChapter update(ProfileChapter profileChapter);

    void delete(Integer idProfileChapter);

}
