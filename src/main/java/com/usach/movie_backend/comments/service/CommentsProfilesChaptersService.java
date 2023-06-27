package com.usach.movie_backend.comments.service;

import com.usach.movie_backend.comments.domain.CommentsProfilesChapters;
import com.usach.movie_backend.comments.repository.ICommentsProfilesChaptersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsProfilesChaptersService implements ICommentsProfilesChaptersService {
    @Autowired
    private ICommentsProfilesChaptersRepository commentsProfilesChaptersRepository;

    @Override
    public List<CommentsProfilesChapters> findAll() {
        return commentsProfilesChaptersRepository.findAll();
    }

    @Override
    public Optional<CommentsProfilesChapters> findByCommentsCommentsProfilesChapters(Integer idCommentsProfilesChapters) {
        return commentsProfilesChaptersRepository.findById(idCommentsProfilesChapters);
    }

    @Override
    public CommentsProfilesChapters create(CommentsProfilesChapters commentsProfilesChapters) {
        return commentsProfilesChaptersRepository.save(commentsProfilesChapters);
    }

    @Override
    public CommentsProfilesChapters update(CommentsProfilesChapters commentsProfilesChapters) {
        return commentsProfilesChaptersRepository.save(commentsProfilesChapters);
    }

    @Override
    public void delete(Integer idCommentsProfilesChapters) {

        commentsProfilesChaptersRepository.deleteById(idCommentsProfilesChapters);
    }
}
