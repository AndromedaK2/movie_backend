package com.usach.movie_backend.chapters.service;


import com.usach.movie_backend.chapters.domain.Chapter;

import java.util.List;
import java.util.Optional;

public interface IChapterService<T> {
    List<Chapter> findAll();

    Optional<Chapter> findByChapter(Integer idChapter);

    Chapter create(Chapter chapter);

    Chapter update(Chapter chapter);

    void delete(Integer idChapter);
}
