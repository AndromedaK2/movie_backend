package com.usach.movie_backend.profile.repository;


import com.usach.movie_backend.profile.domain.ProfileChapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfileChapterRepository extends JpaRepository<ProfileChapter,Integer> {
    List<ProfileChapter> findAll();

}
