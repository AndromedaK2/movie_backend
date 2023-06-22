package com.usach.movie_backend.profiles.service;



import com.usach.movie_backend.profiles.domain.ProfileChapter;

import java.util.List;
import java.util.Optional;

public interface IProfileChapterService{
    List<ProfileChapter> findAll();

    Optional<ProfileChapter> findByProfileChapter(Integer idProfileChapter);

    ProfileChapter create(ProfileChapter profileChapter);

    ProfileChapter update(ProfileChapter profileChapter);

    void delete(Integer idProfileChapter);

}
