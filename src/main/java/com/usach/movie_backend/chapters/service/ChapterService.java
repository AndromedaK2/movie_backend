package com.usach.movie_backend.chapters.service;

import com.usach.movie_backend.chapters.domain.Chapter;
import com.usach.movie_backend.chapters.repository.IChapterRepository;
import com.usach.movie_backend.chapters.service.dto.ChapterCreate;
import com.usach.movie_backend.chapters.service.dto.ChapterDelete;
import com.usach.movie_backend.seasons.domain.Season;
import com.usach.movie_backend.seasons.service.ISeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class ChapterService implements IChapterService {
    @Autowired
    private IChapterRepository chapterRepository;

    @Autowired
    private ISeasonService seasonService;

    @Transactional(readOnly = true)
    public List<Chapter> findAll() {
        return chapterRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Chapter> findByChapter(Integer idChapter) {
        return chapterRepository.findById(idChapter);
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public Chapter create(ChapterCreate chapterCreate) {
        Chapter chapter = new Chapter();

        Season season = seasonService.findByTitle(chapterCreate.nameSeason());
        chapter.setIdSeason(season.getIdSeason());
        chapter.setDuration(chapterCreate.duration());
        chapter.setSynopsis(chapterCreate.sinopsys());
        chapter.setUrlVideo(chapterCreate.video());
        chapter.setReleaseDate(chapterCreate.date());
        chapter.setChapterNumber(chapterCreate.chapterNumber());

        return chapterRepository.save(chapter);
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public Chapter update(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Transactional(noRollbackFor = {ResponseStatusException.class})
    public void delete(ChapterDelete chapterDelete) {
        Season season = seasonService.findByTitle(chapterDelete.title());
        chapterRepository.deleteByChapterNumber(chapterDelete.chapterNumber());
    }
}
