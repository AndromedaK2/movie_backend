package com.usach.movie_backend.profiles.service;


import com.usach.movie_backend.profiles.domain.ProfileChapter;
import com.usach.movie_backend.profiles.repository.IProfileChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfileChapterService implements IProfileChapterService{
    @Autowired
    private IProfileChapterRepository iProfileChapterRepository;
    @Override
    public List<ProfileChapter> findAll() {
        return iProfileChapterRepository.findAll();
    }

    @Override
    public Optional<ProfileChapter> findByProfileChapter(Integer idProfileChapter) {
        return iProfileChapterRepository.findById(idProfileChapter);
    }

    @Override
    public ProfileChapter create(ProfileChapter profileChapter) {
        return iProfileChapterRepository.save(profileChapter);
    }

    @Override
    public ProfileChapter update(ProfileChapter profileChapter) {
        return iProfileChapterRepository.save(profileChapter);
    }

    @Override
    public void delete(Integer idProfileChapter) {
        iProfileChapterRepository.deleteById(idProfileChapter);
    }
}
