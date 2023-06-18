package com.usach.movie_backend.comments.service;

import com.usach.movie_backend.comments.domain.CommentsProfilesChapters;
import com.usach.movie_backend.comments.repository.ICommentsProfilesChaptersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsProfilesChaptersService implements ICommentsProfilesChaptersService<CommentsProfilesChapters> {
    @Autowired
    private ICommentsProfilesChaptersRepository iCommentsProfilesChaptersRepository;

    @Override
    public List<CommentsProfilesChapters> findAll() {
        return iCommentsProfilesChaptersRepository.findAll();
    }

    @Override
    public Optional<CommentsProfilesChapters> findByCommentsCommentsProfilesChapters(Integer idCommentsProfilesChapters) {
        return iCommentsProfilesChaptersRepository.findById(idCommentsProfilesChapters);
    }

    @Override
    public CommentsProfilesChapters create(CommentsProfilesChapters commentsProfilesChapters) {
        return iCommentsProfilesChaptersRepository.save(commentsProfilesChapters);
    }

    @Override
    public CommentsProfilesChapters update(CommentsProfilesChapters commentsProfilesChapters) {
        return iCommentsProfilesChaptersRepository.save(commentsProfilesChapters);
    }

    @Override
    public void delete(Integer idCommentsProfilesChapters) {

        iCommentsProfilesChaptersRepository.deleteById(idCommentsProfilesChapters);
    }
}
