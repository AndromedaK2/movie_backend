package com.usach.movie_backend.chapters.service;

import com.usach.movie_backend.chapters.domain.Chapter;
import com.usach.movie_backend.chapters.repository.IChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class ChapterService implements IChapterService<Chapter> {
    @Autowired
    private IChapterRepository chapterRepository;

    @Transactional(readOnly = true)
    public List<Chapter> findAll() {
        return chapterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Chapter> findByChapter(Integer idChapter) {
        return chapterRepository.findById(idChapter);
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public Chapter create(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public Chapter update(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public void delete(Integer idChapter) {

        chapterRepository.deleteById(idChapter);

    }
}
