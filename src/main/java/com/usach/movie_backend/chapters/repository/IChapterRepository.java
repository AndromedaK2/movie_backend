package com.usach.movie_backend.chapters.repository;

import com.usach.movie_backend.chapters.domain.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IChapterRepository extends JpaRepository<Chapter,Integer> {
    List<Chapter> findAll();
}
