package com.usach.movie_backend.chapters.service;


import com.usach.movie_backend.chapters.domain.Chapter;
import com.usach.movie_backend.chapters.service.dto.ChapterCreate;
import com.usach.movie_backend.chapters.service.dto.ChapterDelete;

import java.util.List;
import java.util.Optional;

public interface IChapterService<T> {
    List<Chapter> findAll();

    Optional<Chapter> findByChapter(Integer idChapter);

    Chapter create(ChapterCreate chapterCreate);

    Chapter update(Chapter chapter);

    void delete(ChapterDelete chapterDelete);
}
