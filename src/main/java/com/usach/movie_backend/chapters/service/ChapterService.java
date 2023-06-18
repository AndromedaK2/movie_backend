package com.usach.movie_backend.chapters.service;

import com.usach.movie_backend.chapters.domain.Chapter;
import com.usach.movie_backend.chapters.repository.IChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ChapterService implements IChapterService<Chapter> {
    @Autowired
    private IChapterRepository iChapterRepository;
    @Override
    public List<Chapter> findAll() {
        return iChapterRepository.findAll();
    }

    @Override
    public Optional<Chapter> findByChapter(Integer idChapter) {
        return iChapterRepository.findById(idChapter);
    }

    @Override
    public Chapter create(Chapter chapter) {
        return iChapterRepository.save(chapter);
    }

    @Override
    public Chapter update(Chapter chapter) {
        return iChapterRepository.save(chapter);
    }

    @Override
    public void delete(Integer idChapter) {

        iChapterRepository.deleteById(idChapter);

    }
}
