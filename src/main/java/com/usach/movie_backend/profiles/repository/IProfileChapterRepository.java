package com.usach.movie_backend.profiles.repository;


import com.usach.movie_backend.profiles.domain.ProfileChapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfileChapterRepository extends JpaRepository<ProfileChapter,Integer> {
    List<ProfileChapter> findAll();

}
